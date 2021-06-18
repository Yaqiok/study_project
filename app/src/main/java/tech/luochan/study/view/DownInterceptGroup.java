package tech.luochan.study.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import timber.log.Timber;

public class DownInterceptGroup extends FrameLayout {

    public DownInterceptGroup(@NonNull Context context) {
        super(context);
    }

    public DownInterceptGroup(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Timber.d("onInterceptTouchEvent " + ev);
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Timber.d("dispatchTouchEvent " + ev);
        boolean result =  super.dispatchTouchEvent(ev);
        Timber.d("dispatchTouchEvent result " + result);
        return result;
    }
}
