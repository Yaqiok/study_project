package tech.luochan.base.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import timber.log.Timber;

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.d("onCreate.....");
        setContentView(getContentViewId());
        unbinder = ButterKnife.bind(this);
        initData();
    }

    protected abstract int getContentViewId();

    protected void initData() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (Objects.nonNull(unbinder)) unbinder.unbind();
    }


}
