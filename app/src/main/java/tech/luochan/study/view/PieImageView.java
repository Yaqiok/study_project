package tech.luochan.study.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

import java.sql.Timestamp;

import timber.log.Timber;

public class PieImageView extends View {

    final static int MAX_PROCESS = 100;
    int mProcess;

    Paint mArcPaint;
    Paint mCircleP;
    RectF rectF;

    public PieImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void setProcess(@IntRange(from = 0, to = MAX_PROCESS) int mProcess) {
        this.mProcess = mProcess;
        ViewCompat.postInvalidateOnAnimation(this);
    }

    private void init() {
        Timber.e("init......");

        mArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mArcPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mArcPaint.setStrokeWidth(0.1f);
        mArcPaint.setColor(Color.RED);

        mCircleP = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCircleP.setStyle(Paint.Style.FILL_AND_STROKE);
        mCircleP.setStrokeWidth(0.1f);
        mCircleP.setColor(Color.BLUE);

        rectF = new RectF();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Timber.e("onDraw....." + mProcess);
        if (mProcess != MAX_PROCESS && mProcess != 0) {
            float mAngle = mProcess * 360f / MAX_PROCESS;
            canvas.drawArc(rectF, 270, mAngle, true, mArcPaint);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.height() / 2, mCircleP);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if (MeasureSpec.AT_MOST == widthMode || MeasureSpec.AT_MOST == heightMode) {
            int measuredWidth = MeasureSpec.getSize(widthMeasureSpec);
            int measuredHeight = MeasureSpec.getSize(heightMeasureSpec);
            int size = Math.min(measuredWidth, measuredHeight);
            setMeasuredDimension(size, size);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }
}
