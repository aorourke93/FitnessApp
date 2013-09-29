package myweb.csuchico.edu;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Introduction extends Activity implements OnClickListener {
	String isFirstTime = "myweb.csuchico.edu.firstTime";
	//these need to be accessed from this whole class
	//they are names of the preferences we are saving
	String overallLevelStat = "myweb.csuchico.edu.overallLevel";
	String statLevelUpNum = "myweb.csuchico.edu.statLevelUpNum";
	
	String strengthArmsStatLevel = "myweb.csuchico.edu.strengthArmsLevel";
	String strengthArmsStatExp = "myweb.csuchico.edu.strengthArmsExp";
	
	String strengthLegsStatLevel = "myweb.csuchico.edu.strengthLegsLevel";
	String strengthLegsStatExp = "myweb.csuchico.edu.strengthLegsExp";
	
	String agilityStatLevel = "myweb.csuchico.edu.agilityLevel";
	String agilityStatExp = "myweb.csuchico.edu.agilityExp";
	
	String defenseStatLevel = "myweb.csuchico.edu.defenseLevel";
	String defenseStatExp = "myweb.csuchico.edu.defenseExp";
	
	String staminaStatLevel = "myweb.csuchico.edu.staminaLevel";
	String staminaStatExp = "myweb.csuchico.edu.staminaExp";
	
	String healthStatLevel = "myweb.csuchico.edu.healthLevel";
	String healthStatExp = "myweb.csuchico.edu.healthExp";
	
	private Button start;
	MediaPlayer player;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		SharedPreferences prefs = this.getSharedPreferences("myweb.csuchico.edu", Context.MODE_PRIVATE);
		boolean isFirstTimeCheck = prefs.getBoolean(isFirstTime, true);
		
		if(isFirstTimeCheck == true){
			//it is the first time booting up. Save values default values and change isFirstTime preference to dalse
  			int defaultLevel = 1;
  			int defaultExp = 0;
  			
  			//overall level starts at 1
  			prefs.edit().putInt(overallLevelStat, defaultLevel).commit();
  			prefs.edit().putInt(statLevelUpNum, 0).commit();
  			
  			prefs.edit().putInt(strengthArmsStatLevel, defaultLevel).commit();
  			prefs.edit().putInt(strengthArmsStatExp, defaultExp).commit();
  			
  			prefs.edit().putInt(strengthLegsStatLevel, defaultLevel).commit();
  			prefs.edit().putInt(strengthLegsStatExp, defaultExp).commit();
  			
  			prefs.edit().putInt(agilityStatLevel, defaultLevel).commit();
  			prefs.edit().putInt(agilityStatExp, defaultExp).commit();
  			
  			prefs.edit().putInt(defenseStatLevel, defaultLevel).commit();
  			prefs.edit().putInt(defenseStatExp, defaultExp).commit();
  			
  			prefs.edit().putInt(staminaStatLevel, defaultLevel).commit();
  			prefs.edit().putInt(staminaStatExp, defaultExp).commit();
  			
  			prefs.edit().putInt(healthStatLevel, defaultLevel).commit();
  			prefs.edit().putInt(healthStatExp, defaultExp).commit();
  			
			prefs.edit().putBoolean(isFirstTime, false).commit();
		}else{
			//do nothing here. just for visual
		}
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_introduction);
		
		start=(Button)findViewById(R.id.start);
		start.setOnClickListener(this);
		
		// instantiate a MediaPlayer instance
		player = MediaPlayer.create(getApplicationContext(), R.raw.maya);
		player.setLooping(true);
		player.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.introduction, menu);
		return true;
	}
	
	public void onClick(View v) {
	

		// find out which button was pushed based on its ID
		if (v.getId()== R.id.start) {
			
			// release the MediaPlayer resource
	    	player.release();
	    	player = null;
			
			Intent i = new Intent(this, AndroidTabLayoutActivity.class);
	    	// start the activity based on the Intent
			startActivity(i);
			finish();
			
			
			
		}

		// notify the user which button was clicked
		
	}

}
