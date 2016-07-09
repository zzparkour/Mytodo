package com.hiar.mytodo.activity;

import com.hiar.mytodo.BaseActivity;
import com.hiar.mytodo.R;
import com.hiar.mytodo.utils.ActivityUtils;
import com.hiar.mytodo.view.MainFragment;

public class MainActivity extends BaseActivity {
    @Override
    protected void onResume() {
        super.onResume();

        MainFragment mainFragment = (MainFragment) getSupportFragmentManager()
                .findFragmentById(R.id.base_activity_frame);

        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(),
                    mainFragment,
                    R.id.base_activity_frame
            );
        }
        setSupportActionBar(toolbar_base);

    }
}
