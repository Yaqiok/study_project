package tech.luochan.study.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import butterknife.BindView;
import tech.luochan.base.activity.BaseActivity;
import tech.luochan.study.R;
import timber.log.Timber;

public class ShowBitmapActivity extends BaseActivity {


    @BindView(R.id.iv_show)
    ImageView ivShow;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_show_bitmap;
    }

    @Override
    protected void initData() {


        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inSampleSize = 2;

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.my);

        Timber.e("===>bitmap size is " + bitmap.getAllocationByteCount());
        ivShow.setImageBitmap(bitmap);
    }
}