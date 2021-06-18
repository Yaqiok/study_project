package tech.luochan.study.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;
import tech.luochan.android_advanced.activity.TaskFirstActivity;
import tech.luochan.base.activity.BaseActivity;
import tech.luochan.study.R;
import timber.log.Timber;

public class MainActivity extends BaseActivity {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }


    @OnClick({R.id.bt_testAffinity, R.id.bt_viewtouch})
    public void onClick(View v) {
        Timber.d("onClick " + v.getId());
        if (v.getId() == R.id.bt_testAffinity) {
            startActivity(new Intent(MainActivity.this, TaskFirstActivity.class));
        }
        if (v.getId() == R.id.bt_viewtouch) {
            startActivity(new Intent(MainActivity.this, CustomViewTouch.class));
        }
    }
}