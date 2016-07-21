package com.example.alarmchangewallpaper;

import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.IBinder;

public class ChangeService extends Service {
	
	//���嶨ʱ�����ı�ֽ��Դ
	int[] wallpapers = new int[] {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.e}; 
	WallpaperManager wallpaperManager; //����ϵͳ�ı�ֽ�������
	int current = 0; //���嵱ǰ����ʾ�ı�ֽ

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		wallpaperManager = WallpaperManager.getInstance(this); //��ʼ��WallpaperManager
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		if (current >= 4)
			current = 0;
		try 
		{
			wallpaperManager.setResource(wallpapers[current++]); //������ֽ
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
