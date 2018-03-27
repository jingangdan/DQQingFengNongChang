package com.dq.qingfengnc.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by jingang on 16/7/1.
 */
public class DoubleWaveView extends View {

    private Paint mPaint;
    private Path mPath;
    private int width, height;

    private int dx;

    private String color = "";

    public DoubleWaveView(Context context, int width, int height, String color) {
        super(context);
        this.width = width;
        this.height = height;
        this.color = color;
        init();
    }

    public DoubleWaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DoubleWaveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        mPath = new Path();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPath.reset();
//        mPaint.setColor(Color.parseColor("#65ff0000"));
        mPaint.setColor(Color.parseColor(color));
        mPath.moveTo(-width + dx, height / 5 * 4);
        for (int i = 0; i < 3; i++) {
            mPath.rQuadTo(width / 4, -70, width / 2, 0);
            mPath.rQuadTo(width / 4, 70, width / 2, 0);
        }
        mPath.lineTo(width, height);
        mPath.lineTo(0, height);
        mPath.close();
        canvas.drawPath(mPath, mPaint);

//        mPath.reset();
//        mPaint.setColor(Color.parseColor("#6500ff00"));
//        mPath.moveTo(-width + dx, height / 5 * 4);
//        for (int i = 0; i < 3; i++) {
//            mPath.rQuadTo(width / 4, 70, width / 2, 0);
//            mPath.rQuadTo(width / 4, -70, width / 2, 0);
//        }
//        mPath.lineTo(width, height);
//        mPath.lineTo(0, height);
//        mPath.close();
//        canvas.drawPath(mPath, mPaint);

//        mPath.reset();
//        mPaint.setColor(Color.parseColor("#650000ff"));
//        mPath.moveTo(-width + dx, height / 5 * 4);
//        for (int i = 0; i < 3; i++) {
//            mPath.rQuadTo(width / 4, 70, width / 2, 0);
//            mPath.rQuadTo(width / 4, -70, width / 2, 0);
//        }
//        mPath.lineTo(width, height);
//        mPath.lineTo(0, height);
//        mPath.close();
//        canvas.drawPath(mPath, mPaint);

    }

    public void startAnimation(int time) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, width);
        valueAnimator.setDuration(time);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dx = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.start();
    }
}
