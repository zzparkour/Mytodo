package com.hiar.mytodo.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;


/**
 * Created by qq923 on 2016-7-8.
 */
public class ActivityUtils {
    private static final String TAG = "null";

    public static void addFragmentToActivity(FragmentManager fragmentManager, Fragment fragment, int frameId) {

        if (fragment == null) {
            Log.e(TAG, "addFragmentToActivity: fragment is null");
        }else {
            if (fragmentManager == null) {
                Log.e(TAG, "addFragmentToActivity: fragmentManager is null");
            } else {
                FragmentTransaction transcation = fragmentManager.beginTransaction();
                transcation.add(frameId, fragment);
                transcation.commit();
            }
        }
    }
}
