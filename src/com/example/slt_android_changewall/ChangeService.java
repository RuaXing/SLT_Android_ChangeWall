package com.example.slt_android_changewall;

import java.io.IOException;

import android.app.Service;
import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.IBinder;

public class ChangeService extends Service{

	//壁纸资源
	int[] Wallpaper = new int[]{R.drawable.lijiang,R.drawable.qiao,R.drawable.shuangta,R.drawable.shui};
	//壁纸管理器
	WallpaperManager mwallpaper;
	int currenindex = 0;
	
	@Override
	public void onCreate() {
		
		super.onCreate();
		
		mwallpaper = WallpaperManager.getInstance(this);
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if (currenindex >= Wallpaper.length) {
			currenindex = 0;
		}
		try {
			mwallpaper.setResource(Wallpaper[currenindex++]);//设置壁纸
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return START_STICKY;//粘性
		
		
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
