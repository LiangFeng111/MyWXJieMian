package com.example.mywx;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class LetterIndexView extends View {


    public void log(String a,Object b){
        Log.i(a, b+"");
    }
    //右边所有的文字
    private String[] letters  = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z", "#"
    };
    //当前手指滑动到的位置
    private int choosedPosition = -1;

    //画文字的画笔
    private Paint paint;

    //页面正中央的TextView，用来显示手指当前滑动到的位置的文本
    private TextView textViewDialog;

//    接口变量，该接口主要用来实现当手指在右边的滑动控件上滑动时ListView能够跟着滚动
    public static UpdateListView updateListView;

    public TextView getTextViewDialog() {
        return textViewDialog;
    }

    public void setTextViewDialog(TextView textViewDialog) {
        this.textViewDialog = textViewDialog;
    }

    public UpdateListView getUpdateListView() {
        return updateListView;
    }

    public void setUpdateListView(UpdateListView updateListView) {
        LetterIndexView.updateListView = updateListView;
    }

    public LetterIndexView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context,attrs,defStyleAttr);

    }

    public LetterIndexView(Context context){
        super(context);
    }

    public LetterIndexView(Context context, AttributeSet attrs){
        super(context,attrs);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(45);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        int perTextHeight = getHeight() / letters.length;
        for (int i = 0; i < letters.length; i++) {
            if (i == choosedPosition) {
                paint.setColor(Color.RED);
            } else {
                paint.setColor(Color.GRAY);
            }
            canvas.drawText(letters[i], (getWidth() - paint.measureText(letters[i])) / 2, (i + 1) * perTextHeight, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int perTextHeight = getHeight() / letters.length;
        float y = event.getY();
        String letter;
        int currentPosition = (int) (y/perTextHeight);
        log("就只记住",currentPosition);
        if (currentPosition<0 || currentPosition>26){
            if (currentPosition>26){
                letter = letters[26];
            }else {
                letter = letters[0];
            }
        }else {
            letter = letters[currentPosition];
        }

        switch (event.getAction()){
            case MotionEvent.ACTION_UP:
                setBackgroundColor(Color.TRANSPARENT);
                if (textViewDialog != null){
                    textViewDialog.setVisibility(View.GONE);
                }
                break;
            default:
                setBackgroundColor(Color.parseColor("#cccccc"));
                log("chang",letter);
                if (currentPosition > -1 && currentPosition < letters.length) {
                    if (textViewDialog != null) {
                        textViewDialog.setVisibility(View.VISIBLE);
                        textViewDialog.setText(letter);
                        textViewDialog.setBackgroundColor(Color.parseColor("#FFBFC7DD"));
                        textViewDialog.setAlpha((float) 0.5);
                    }
                    if (updateListView != null) {
                        updateListView.updateListView(letter);
                    }
                    choosedPosition = currentPosition;
                }else {
                    if (textViewDialog != null) {
                        textViewDialog.setVisibility(View.VISIBLE);
                        textViewDialog.setText(letter);
                        textViewDialog.setBackgroundColor(Color.parseColor("#FFBFC7DD"));
                        textViewDialog.setAlpha((float) 0.5);
                    }
                    if (updateListView != null) {
                        updateListView.updateListView(letter);
                    }
                    choosedPosition = currentPosition;
                }
                break;
        }
        invalidate();
        return true;
    }

    public void updateLetterIndexView(int currentChar) {
        for (int i = 0; i < letters.length; i++) {
            if (currentChar == letters[i].charAt(0)) {
                choosedPosition = i;
                invalidate();
                break;
            }
        }
    }
    public interface UpdateListView{
        void updateListView(String letter);
    }
}
