package com.example.alarmchangewallpaper;

import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.IBinder;

public class ChangeService extends Service {
	
	//定义定时更换的壁纸资源
	int[] wallpapers = new int[] {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.e}; 
	WallpaperManager wallpaperManager; //定义系统的壁纸管理服务
	int current = 0; //定义当前所显示的壁纸

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		wallpaperManager = WallpaperManager.getInstance(this); //初始化WallpaperManager
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		if (current >= 4)
			current = 0;
		try 
		{
			wallpaperManager.setResource(wallpapers[current++]); //更换壁纸
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		return START_STICKY;
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
