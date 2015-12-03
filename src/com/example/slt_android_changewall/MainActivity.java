package com.example.slt_android_changewall;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button btn_start;
	private Button btn_stop;
	AlarmManager aManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_start = (Button) findViewById(R.id.button1);
		btn_stop = (Button) findViewById(R.id.button2);
		//在系统服务里得到闹钟
		aManager = (AlarmManager)getSystemService(Service.ALARM_SERVICE);
			
		btn_start.setOnClickListener(this);
		btn_stop.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		//设置服务意图
		Intent mIntent  = new Intent(MainActivity.this,ChangeService.class);
		//设置延时意图
		PendingIntent pi = PendingIntent.getService(MainActivity.this, 0, mIntent, 0);
		switch (v.getId()) {
		case R.id.button1:
		//五秒一换
			aManager.setRepeating(AlarmManager.RTC_WAKEUP, 0, 5000, pi);//setRepeating设置重复闹钟：闹钟类型，执行时间点（0代表立即执行），间隔周期，执行的动作
			Toast.makeText(MainActivity.this, "设置成功", Toast.LENGTH_LONG).show();
			break;
		case R.id.button2:
			aManager.cancel(pi);
			break;

		default:
			break;
		}

	}
}
