package com.basittramboo.squareoncanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyCanvas extends View {

    int mStartX;
    int mStartY;
    int mEndX;
    int mEndY;

    private Paint mPaint = new Paint();

    int mSelectedColor = Color.BLACK;

    public MyCanvas(Context context) {
        this(context,null);
    }

    public MyCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint.setColor(mSelectedColor);
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.STROKE);

        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(mStartX,mStartY,mEndX,mEndY,mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {

            case MotionEvent.ACTION_DOWN:

                mStartX = (int) event.getX();
                mStartY = (int) event.getY();
                break;

            case MotionEvent.ACTION_MOVE:

                mEndX = (int) event.getX();
                mEndY = (int) event.getY();

                invalidate();

                break;

            case MotionEvent.ACTION_UP:


                mEndX = (int) event.getX();
                mEndY = (int) event.getY();
                int l;
                if ((mEndX-mStartX)<(mEndY-mStartY)){
                    l=mEndX-mStartX;
                    mEndX=mStartX+l;
                    mEndY=mStartY+l;
                }else{
                    l=mEndY-mStartY;
                    mEndX=mStartX+l;
                    mEndY=mStartY+l;
                }
                invalidate();

                break;

            default:

                super.onTouchEvent(event);

                break;
        }

        return true;
    }
}
