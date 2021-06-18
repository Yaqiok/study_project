package tech.luochan.android_advanced.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

import tech.luochan.android_advanced.R;
import tech.luochan.base.activity.BaseActivity;

public class TaskFirstActivity extends BaseActivity {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_task_first;
    }

    @Override
    protected void initData() {
        super.initData();

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            runOnUiThread(() -> {
                startActivity(new Intent(TaskFirstActivity.this, TaskSecondActivity.class));
            });
        }, 3_000);
    }
}