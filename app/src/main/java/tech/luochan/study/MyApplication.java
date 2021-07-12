package tech.luochan.study;

import tech.luochan.base.BaseApplication;
import tech.luochan.study.adapter.OkBluetoothAdapter;

public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        OkBluetoothAdapter.onAppReady(this);
    }
}
