package com.hiar.mytodo.view;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hiar.mytodo.R;
import com.hiar.mytodo.adapter.TaskAdapter;
import com.hiar.mytodo.adapter.ToDoAdapter;
import com.hiar.mytodo.contract.ToDoContract;
import com.hiar.mytodo.db.TaskDb;
import com.hiar.mytodo.utils.RecyclerItemClickListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.xutils.DbManager;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by qq923 on 2016-7-8.
 */

public class ToDoFragment extends Fragment implements ToDoContract.View, SearchView.OnQueryTextListener, SearchView.OnCloseListener {
    private static final String TAG = "ToDoFragment";
    @BindView(R.id.floatingActionButton)
    FloatingActionButton floatingActionButton;
    @BindView(R.id.todo_fragment_rec_view)
    RecyclerView todoFragmentRecView;
    private SearchView searchView;
    private ToDoContract.Presenter presenter;
    DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
            .setDbName("mytodo.db")
            .setDbVersion(1)
            .setDbOpenListener(new DbManager.DbOpenListener() {
                @Override
                public void onDbOpened(DbManager db) {
                    //加速写入
                    db.getDatabase().enableWriteAheadLogging();
                }
            })
            .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                @Override
                public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                }
            });

    private DbManager dbManager;

    public static ToDoFragment newInstance() {

        Bundle args = new Bundle();

        ToDoFragment fragment = new ToDoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.todo_fragment, container, false);
        ButterKnife.bind(this, root);

        initEvent();
        initView();//加载recycle的数据

        return root;
    }

    private void initEvent() {
        dbManager = x.getDb(daoConfig);
    }

    private void initView() {
        todoFragmentRecView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));

        TaskDb taskDb = new TaskDb();
        taskDb.setTaskName("hello");
        taskDb.setTaskTime(new Date(23001020));

        TaskDb taskDb1 = new TaskDb();
        taskDb1.setTaskName("hello1");
        taskDb1.setTaskTime(new Date(23001020));

        List<TaskDb> task = new ArrayList<>();
        task.add(taskDb);
        task.add(taskDb1);


        try {
            TaskAdapter adapter = new TaskAdapter(getContext(), task);
            todoFragmentRecView.setAdapter(adapter);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //ToDoAdapter adapter = new ToDoAdapter(task);
        //todoFragmentRecView.setAdapter(adapter);

        todoFragmentRecView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), todoFragmentRecView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onItemLongClick(final View view, int position) {
                View viewAlert = getActivity().getLayoutInflater().inflate(R.layout.long_press_layout, null, false);
                Button add_subtask = (Button) viewAlert.findViewById(R.id.btn_add_subtask);
                Button btn_delete = (Button) viewAlert.findViewById(R.id.btn_delete_task);
                AlertDialog dialog = new AlertDialog.Builder(getContext())
                        .setView(viewAlert)
                        .create();
                dialog.show();

                add_subtask.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int parentTaskId = (int) view.getTag(1);
                        presenter.createSubTask(dbManager, parentTaskId);
                    }
                });
                btn_delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
        }));
        // TODO: 2016/8/8
        //presenter.findAll(dbManager);//子线程


    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_view_in_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        setupSearchView();
    }

    private void setupSearchView() {
        searchView.setIconifiedByDefault(true);


        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);
    }

    @Override
    public void setPresenter(ToDoContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public boolean onClose() {
        return false;
    }

    @OnClick(R.id.floatingActionButton)
    public void onClick() {
        //new popwindow
        Resources resources = getResources();
        String new_task = resources.getString(R.string.new_root_task);
        //creat popView
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View alertView = inflater.inflate(R.layout.new_task_pop_window, null);


        AlertDialog dialog = new AlertDialog.Builder(getContext())
                .setCancelable(true)
                .setTitle(new_task)
                .setView(alertView)
                .setPositiveButton(R.string.positive_text, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MaterialEditText et_newtask = (MaterialEditText) alertView.findViewById(R.id.new_task_pop_et_newtask);
                        Editable task_name = et_newtask.getText();
                        //数据库里插入数据
                        TaskDb taskDb = new TaskDb();
                        taskDb.setTaskName(String.valueOf(task_name));
                        presenter.createNewTask(taskDb, dbManager);

                    }
                })
                .setNegativeButton(R.string.negative_text, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create();

        dialog.show();
    }

    @Override
    public void createAdapter(List all) {
        Log.e(TAG, "createAdapter: " + all);
        ToDoAdapter adapter = new ToDoAdapter(all);
        todoFragmentRecView.setAdapter(adapter);
    }
}
