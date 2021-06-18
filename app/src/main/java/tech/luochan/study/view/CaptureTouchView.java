package tech.luochan.study.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import timber.log.Timber;

public class CaptureTouchView extends View {

    public CaptureTouchView(Context context) {
        super(context);
    }

    public CaptureTouchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Timber.d("dispatchTouchEvent " + event);
        boolean result = super.dispatchTouchEvent(event);
        Timber.d("dispatchTouchEvent result " + result);
        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Timber.d("onTouchEvent " + event);
        return super.onTouchEvent(event);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(500, 300);
    }
}
