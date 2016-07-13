package com.hiar.mytodo.presenter;

import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.hiar.mytodo.R;
import com.hiar.mytodo.contract.ToDoContract;
import com.hiar.mytodo.db.TaskDb;
import com.hiar.mytodo.view.ToDoFragment;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.xutils.DbManager;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qq923 on 2016-7-8.
 */

public class ToDoPresenter implements ToDoContract.Presenter {
    private ToDoContract.View view;
    private Handler mainThreadHandler;


    public ToDoPresenter(ToDoContract.View view, Handler mainThreadHandler) {
        this.view = view;
        this.mainThreadHandler = mainThreadHandler;
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void createNewTask(final TaskDb task, final DbManager dbManager) {
        x.task().run(new Runnable() {
            public static final String TAG = "dbMessage";
            @Override
            public void run() {
                try {
                    dbManager.save(task);
                    //刷新数据
                    findAll(dbManager);

                } catch (DbException e) {
                    Log.e(TAG, "run: " + e.getMessage());


                    e.printStackTrace();
                }
            }
        });
    }

    List<TaskDb> all = new ArrayList<>();

    @Override
    public void findAll(final DbManager dbManager) {

        x.task().run(new Runnable() {
            @Override
            public void run() {
                try {
                    all = dbManager.findAll(TaskDb.class);
                } catch (DbException e) {
                    e.printStackTrace();
                }
                mainThreadHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        //主线程
                        view.createAdapter(all);
                    }
                });
            }
        });
    }

    @Override
    public void createSubTask(final DbManager dbManager, final int parentTaskId) {

        LayoutInflater inflater = ((ToDoFragment) view).getActivity().getLayoutInflater();
        final View alertView = inflater.inflate(R.layout.new_task_pop_window, null);

        AlertDialog alertDialog = new AlertDialog.Builder(((ToDoFragment) view).getContext())
                .setTitle(R.string.add_subtask)
                .setPositiveButton(R.string.positive_text, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MaterialEditText et_newtask = (MaterialEditText) alertView.findViewById(R.id.new_task_pop_et_newtask);
                        Editable task_name = et_newtask.getText();
                        //数据库里插入数据
                        //new task
                        TaskDb taskDb = new TaskDb();
                        taskDb.setTaskName(String.valueOf(task_name));
                        taskDb.setParentTaskId(parentTaskId);
                        try {
                            dbManager.save(parentTaskId);
                            //刷新数据
                            findAll(dbManager);
                        } catch (DbException e) {
                            e.printStackTrace();
                        }
                    }
                })
                .setNegativeButton(R.string.negative_text, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setView(alertView)
                .create();
        alertDialog.show();
    }
}
