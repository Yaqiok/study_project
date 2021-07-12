package tech.luochan.study.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;

import com.devyok.bluetooth.OkBluetooth;
import com.devyok.bluetooth.debug.DebugUIConsoleActivity;

import butterknife.OnClick;
import tech.luochan.android_advanced.activity.TaskFirstActivity;
import tech.luochan.base.activity.BaseActivity;
import tech.luochan.study.R;
import tech.luochan.study.R2;
import timber.log.Timber;

public class MainActivity extends BaseActivity {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        Timber.d("....initData....");
       /* findViewById(R.id.bt_hfp).setOnClickListener(v -> {
            Timber.d("bt_hfp onclick......");
            Intent impl = new Intent(OkBluetooth.getContext(), DebugUIConsoleActivity.class);
            impl.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            OkBluetooth.getContext().startActivity(impl);
        });*/
    }

    @OnClick({R.id.bt_testAffinity, R.id.bt_viewtouch, R.id.bt_bitmap, R.id.bt_download, R.id.bt_hfp})
    public void onClick(View v) {
        Timber.d("onClick %s", v.getId());
        if (v.getId() == R.id.bt_testAffinity) {
            startActivity(new Intent(MainActivity.this, TaskFirstActivity.class));
        }
        if (v.getId() == R.id.bt_viewtouch) {
            startActivity(new Intent(MainActivity.this, CustomViewTouch.class));
        }
        if (v.getId() == R.id.bt_bitmap) {
            startActivity(new Intent(MainActivity.this, ShowBitmapActivity.class));
        }
        if (v.getId() == R.id.bt_download) {
            startActivity(new Intent(MainActivity.this, RKUpgradeDownloadActivity.class));
        }
        if (v.getId() == R.id.bt_hfp) {
            Intent impl = new Intent(OkBluetooth.getContext(), DebugUIConsoleActivity.class);
            impl.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            OkBluetooth.getContext().startActivity(impl);
        }
    }
}