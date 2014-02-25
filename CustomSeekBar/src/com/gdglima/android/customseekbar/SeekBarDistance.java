package com.gdglima.android.customseekbar;


import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class SeekBarDistance extends LinearLayout {

	private TextView txtMin, txtMax,txtDistance;
	private SeekBar barDistance;
	private int mProgress,sbMin,sbMax;
	private int distance=0;
	private double p=0;
	
	public SeekBarDistance(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init();
	}
	public SeekBarDistance(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		TypedArray a= getContext().obtainStyledAttributes(attrs,
				R.styleable.CustomSeekBar);
		sbMax=a.getInt(R.styleable.CustomSeekBar_sbMax, 0);
		sbMin=a.getInt(R.styleable.CustomSeekBar_sbMin, 0);
		a.recycle();
		
		init();
	}
	
	private void init()
	{
		//sbMin=0;
		//sbMax=100;
		p=0;
		distance=sbMax-sbMin;
		
	    LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(
	            Context.LAYOUT_INFLATER_SERVICE);
	    inflater.inflate(R.layout.seekbar_merge, this);
	    
	    txtDistance=(TextView)findViewById(R.id.txt_distance);
	    txtMin=(TextView)findViewById(R.id.txt_min);
	    txtMax=(TextView)findViewById(R.id.txt_max);
	    barDistance=(SeekBar)findViewById(R.id.barDistance);

	    barDistance.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar arg0, int progress, boolean fromUser) {
				// TODO Auto-generated method stub
				p=progress;
				double aux= sbMin+ distance*(p/100);
				txtDistance.setText(String.valueOf(Math.round(aux))+" Kilómetros");
				mProgress=progress;
			}
		});
	    txtMin.setText(sbMin+" Kilómetros");
	    txtMax.setText(sbMax+" Kilómetros");
	    txtDistance.setText(String.valueOf(sbMin+ " Kilómetros"));
	}
	
	public int getCurrentProgress()
	{
		return mProgress;
	}
	
	public void setProgress(int _progress)
	{
		barDistance.setProgress(_progress);
	}
	
	public int getSbMin() {
		return sbMin;
	}
	public void setSbMin(int sbMin) {
		this.sbMin = sbMin;
	}
	public int getSbMax() {
		return sbMax;
	}
	public void setSbMax(int sbMax) {
		this.sbMax = sbMax;
	}

	


}
