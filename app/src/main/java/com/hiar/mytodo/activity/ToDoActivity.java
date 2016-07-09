package com.hiar.mytodo.activity;


import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.hiar.mytodo.BaseActivity;
import com.hiar.mytodo.R;
import com.hiar.mytodo.utils.ActivityUtils;
import com.hiar.mytodo.view.ToDoFragment;

/**
 * Created by qq923 on 2016-7-8.
 */

public class ToDoActivity extends BaseActivity implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {
    private SearchView sv;

    @Override
    protected void onResume() {
        super.onResume();

        //创建fragment填充frameLayout
        ToDoFragment toDoFragment = (ToDoFragment) getSupportFragmentManager().
                findFragmentById(R.id.base_activity_frame);
        if (toDoFragment == null) {
            toDoFragment = ToDoFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    toDoFragment,
                    R.id.base_activity_frame);
        }
        setSupportActionBar(toolbar_base);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_view_in_menu, menu);

        setupSearchView(menu);

        return super.onCreateOptionsMenu(menu);
    }

    private void setupSearchView(Menu menu) {
        MenuItem itemSearch = menu.findItem(R.id.action_search);
        sv = ((SearchView) MenuItemCompat.getActionView(itemSearch));
        if (sv != null) {
            sv.setOnQueryTextListener(this);
            sv.setOnCloseListener(this);
            sv.setSubmitButtonEnabled(false);
            sv.setIconifiedByDefault(true);
        }
        MenuItemCompat.setOnActionExpandListener(itemSearch, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                Toast.makeText(ToDoActivity.this, "onExpand", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                Toast.makeText(ToDoActivity.this, "onCollapse", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
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
}
