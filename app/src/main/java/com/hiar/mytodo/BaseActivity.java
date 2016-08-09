package com.hiar.mytodo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by qq923 on 2016-7-8.
 */

public class BaseActivity extends SupportActivity {
    @BindView(R.id.toolbar_base)
    public Toolbar toolbar_base;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar_base);
    }
}
