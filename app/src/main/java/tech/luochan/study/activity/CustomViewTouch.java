package tech.luochan.study.activity;

import butterknife.BindView;
import tech.luochan.base.activity.BaseActivity;
import tech.luochan.study.R;
import tech.luochan.study.view.PieImageView;

public class CustomViewTouch extends BaseActivity {

    @BindView(R.id.v_pie)
    PieImageView pieImageView;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_custom_view_touch;
    }

    @Override
    protected void initData() {
        pieImageView.setProcess(45);
    }
}