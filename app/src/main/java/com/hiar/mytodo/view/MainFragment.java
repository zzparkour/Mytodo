package com.hiar.mytodo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hiar.mytodo.R;
import com.hiar.mytodo.activity.ToDoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by qq923 on 2016-7-9.
 */
public class MainFragment extends Fragment {
    @BindView(R.id.button6)
    Button button6;
    @BindView(R.id.button7)
    Button button7;

    public static MainFragment newInstance() {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.main_fragment, container, false);

        ButterKnife.bind(this, root);
        return root;
    }

    @OnClick({R.id.button6, R.id.button7})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button6:
                startActivity(new Intent(getContext(), ToDoActivity.class));
                break;
            case R.id.button7:
                break;
        }
    }
}
