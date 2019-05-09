package com.example.thuexe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
public class giaodien1 extends Activity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giaodien1);
        Thread bamgio=new Thread(){
            public void run()
            {
                try {
                    sleep(5000);
                } catch (Exception e) {

                }
                finally
                {
                    Intent activitymoi =new Intent(giaodien1.this,giaodien2.class);
                    startActivity(activitymoi);
                }
            }
        };
        bamgio.start();
    }
    protected void onPause(){
        super.onPause();
        finish();
    }
}
