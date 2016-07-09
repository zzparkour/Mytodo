package com.hiar.mytodo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hiar.mytodo.R;
import com.hiar.mytodo.contract.ToDoContract;

import butterknife.ButterKnife;

/**
 * Created by qq923 on 2016-7-8.
 */

public class ToDoFragment extends Fragment implements ToDoContract.View, SearchView.OnQueryTextListener, SearchView.OnCloseListener {
    private SearchView searchView;

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

        return root;
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

//    @OnClick(R.id.floatingActionButton2)
//    public void onClick() {
//        //new popwindow
//        Resources resources = getResources();
//        String new_task = resources.getString(R.string.new_root_task);
//        //creat popView
//        LayoutInflater inflater = getActivity().getLayoutInflater();
//        View alertView = inflater.inflate(R.layout.new_task_pop_window, null);
//
//
//        AlertDialog dialog = new AlertDialog.Builder(getContext())
//                .setCancelable(true)
//                .setTitle(new_task)
//                .setView(alertView)
//                .create();
//
//        dialog.show();
//    }
}
