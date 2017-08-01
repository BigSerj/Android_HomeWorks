package com.android.bigserj.homeWork4;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.android.bigserj.R;

import java.util.Calendar;
import java.util.Date;


public class AnalogClocksView extends View {

    private Paint mPaint;
    private Paint numbers;
    private Paint hourLine;
    private Paint minuteLine;
    private Paint secondLine;


    public AnalogClocksView(Context context) {
        super(context);
        initialize();
    }

    public AnalogClocksView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public AnalogClocksView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    public AnalogClocksView(Context context, @Nullable AttributeSet attrs,
                            int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize();
    }


    private void initialize() {

        hourLine = new Paint();
        hourLine.setStrokeWidth(10);
        minuteLine = new Paint();
        minuteLine.setStrokeWidth(7);
        secondLine = new Paint();
        secondLine.setStrokeWidth(3);

        numbers = new Paint();
        numbers.setTextSize(50);
        numbers.setStrokeWidth(10);

        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(5);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // стиль Заливка
        mPaint.setStyle(Paint.Style.FILL);
        // закрашиваем холст белым цветом
        mPaint.setColor(Color.WHITE);
        canvas.drawPaint(mPaint);

        int x = getWidth() / 2;
        int y = getHeight() / 2;

        int radius = Math.min(getWidth(), getHeight()) / 3;
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(x, y, radius, mPaint);

        mPaint.setColor(Color.WHITE);
        mPaint.setColor(ContextCompat.getColor(getContext(), R.color.colorWhite));
        canvas.drawCircle(x, y,
                (float) (Math.min(getWidth(), getHeight()) / 3.05), mPaint);


        mPaint.setColor(Color.BLACK);
        canvas.save();

        int yy = y - radius;

        for (int i = 0; i < 12; i++) {

            // Рисуем черточку
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawLine(x, yy - yy / 20, x, yy + yy / 20, mPaint);

            switch (i) {
                case 0:
                    canvas.drawText("12", x-x/23, yy - yy / 15, numbers);
                    break;
                case 3:
                    canvas.drawText("3", x-x/35, yy - yy / 15, numbers);
                    break;
                case 6:
                    canvas.drawText("6", x-x/35, yy - yy / 15, numbers);
                    break;
                case 9:
                    canvas.drawText("9", x-x/35, yy - yy / 15, numbers);
                    break;
            }

            // поворачиваем холст по центру текста
            canvas.rotate(30,x,y);
        }


        // вычисляем текущее время часы минуты
        Calendar calendarThis = Calendar.getInstance();
        calendarThis.setTime(new Date());

        int hourThis = calendarThis.get(Calendar.HOUR);
        int minThis = calendarThis.get(Calendar.MINUTE);
        int secThis = calendarThis.get(Calendar.SECOND);


        // ищем минуты на циферблате
        canvas.save();
        for(int i=0;i<60;i++){
            if (i==secThis) {
                canvas.drawLine(x, y, x, yy + yy / 7, secondLine);
                break;
            }
            canvas.rotate(6,x,y);
        }
        canvas.restore();
        // ищем минуты на циферблате
        canvas.save();
        for(int i=0;i<60;i++){
            if (i==minThis) {
                canvas.drawLine(x, y, x, yy + yy / 5, minuteLine);
                break;
            }
            canvas.rotate(6,x,y);
        }
        canvas.restore();

        // ищем часы на циферблате
        canvas.save();
        for(int i=0;i<360;i++){
            if (i==hourThis*30+minThis/2) {
                canvas.drawLine(x, y, x, yy + yy / 2.5f, hourLine);
                break;
            }
            canvas.rotate(1,x,y);
        }
        canvas.restore();



    }


}