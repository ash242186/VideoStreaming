package com.example.steaming;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class MyVideoView extends VideoView{

	private int mVideoWidth, mVideoHeight;
	
	public MyVideoView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public MyVideoView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public MyVideoView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		int width = getDefaultSize(mVideoWidth, widthMeasureSpec);
        int height = getDefaultSize(mVideoHeight, heightMeasureSpec);
        
           if (mVideoWidth > 0 && mVideoHeight > 0) {
               if ( mVideoWidth * height  > width * mVideoHeight ) {
                   // video height exceeds screen, shrink it
                   height = width * mVideoHeight / mVideoWidth;
               } else if ( mVideoWidth * height  < width * mVideoHeight ) {
                   // video width exceeds screen, shrink it
                   width = height * mVideoWidth / mVideoHeight;
               } else {
                   // aspect ratio is correct
               }
           }
        
        
        // must set this at the end
        setMeasuredDimension(width, height);
	}

	public void changeVideoSize(int width, int height)
    {
        mVideoWidth = width;       
        mVideoHeight = height;
        // not sure whether it is useful or not but safe to do so
        getHolder().setFixedSize(width, height); 
        requestLayout();
        invalidate();     // very important, so that onMeasure will be triggered
    } 
}
