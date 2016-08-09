package com.hiar.mytodo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hiar.mytodo.R;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by rubing on 2016/8/9.
 * 任务详情页
 */

public class TaskDetialFragment extends SupportFragment {

    public static TaskDetialFragment newInstance() {

        Bundle args = new Bundle();

        TaskDetialFragment fragment = new TaskDetialFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.task_detial_fragment, container, false);

        return root;
    }
}
