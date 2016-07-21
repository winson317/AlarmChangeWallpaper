package com.example.alarmchangewallpaper;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AlarmChangeWallpaper extends Activity {
	
	AlarmManager alarmManager; //定义AlarmManager对象
	Button start, stop;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        start = (Button)findViewById(R.id.start);
        stop = (Button)findViewById(R.id.stop);
        alarmManager = (AlarmManager)getSystemService(Service.ALARM_SERVICE);
        
        Intent intent = new Intent(AlarmChangeWallpaper.this, ChangeService.class); //指定启动ChangeService组件
        final PendingIntent pendingIntent = PendingIntent.getService(AlarmChangeWallpaper.this, 0, intent, 0);//创建PendingIntent对象
        
        start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, 0, 5000, pendingIntent);//设置每隔5秒执行pendingIntent代表的组件一次
				start.setEnabled(false);
				stop.setEnabled(true);
				Toast.makeText(AlarmChangeWallpaper.this, "壁纸定时更换启动成功！", Toast.LENGTH_LONG).show();
			}
		});
        
        stop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				start.setEnabled(true);
				stop.setEnabled(false);
				alarmManager.cancel(pendingIntent); //取消对pendingIntent的调度
			}
		});
    }
}