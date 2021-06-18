package tech.luochan.multi_application.impl;

import android.util.Log;

import tech.luochan.multi_application.BaseApplicationLogic;

public class ApplicationLogicImpl extends BaseApplicationLogic {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("ApplicationLogicImpl", "onCreate Impl ...");
    }
}
