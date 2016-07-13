package com.hiar.mytodo;

import android.app.Application;

import org.xutils.x;

/**
 * Created by qq923 on 2016-7-11.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化xutils3
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);

    }
}
