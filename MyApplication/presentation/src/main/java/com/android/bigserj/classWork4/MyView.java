package com.android.bigserj.classWork4;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import com.android.bigserj.R;

public class MyView extends View {

    private Paint myPaint = new Paint();
    private RectF arcRectF = new RectF(); // - область, которую мы ограничиваем. т.е. описываем рамки для объекта.

    int cx;
    int cy;


    public MyView(Context context) {
        super(context);
        initialize();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize();
    }

    private void initialize() {
//        делаем сглаживание
        myPaint.setAntiAlias(true);

        int color = ContextCompat.getColor(getContext(), R.color.colorDarkRed);
//        int color = Color.RED;     // - либо так.
        myPaint.setColor(color);

//        делаем заливку
        myPaint.setStyle(Paint.Style.FILL);

//        ширина оконтовки
        Resources r = getResources();
        float strokeWidthInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                2, r.getDisplayMetrics());
        myPaint.setStrokeWidth(strokeWidthInPx);


    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    // при изменении размеров вызываем
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    // тут будет все рисование. canvas - это лист бумаги
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        int cx = getWidth()/2;
//        int cy = getHeight()/2;
        int radius = Math.min(getWidth(), getHeight()) / 2;
        int color2 = ContextCompat.getColor(getContext(), R.color.colorGreen);
        myPaint.setColor(color2);
        canvas.drawCircle(cx, cy, radius, myPaint);
//
//        int startX = 0;
//        int startY = 0;
//        int stopX = getWidth();
//        int stopY = getHeight();
//        canvas.drawLine(startX, startY,stopX,stopY,myPaint);
//
//
//        arcRectF.left = 0;
//        arcRectF.top = 0;
//        arcRectF.right = getWidth();
//        arcRectF.bottom = getHeight();
//
//        canvas.drawArc(arcRectF,0,-180,true,myPaint);
//
//        canvas.drawRect(50,50,100,100,myPaint);


//        canvas.rotate();
    }

    // лови все клики на экран
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        // палец опущен на экран
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

        }
        // поднял палец с экрана
        else if (event.getAction() == MotionEvent.ACTION_UP) {

        }
        // палец тянется по экрану
        else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            cx = (int) event.getX();
            cy = (int) event.getY();
            invalidate();
        }


        return true;
    }


}