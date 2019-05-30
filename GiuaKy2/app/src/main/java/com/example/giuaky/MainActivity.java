package com.example.giuaky;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button themhd, timhd, listkh;
    SQLite data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        themhd = findViewById(R.id.themhd);
        timhd = findViewById(R.id.timhd);
        listkh = findViewById(R.id.listkh);

        themhd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activitymoi =new Intent(MainActivity.this,DangKyKhachHang.class);
                startActivity(activitymoi);

                //Xóa bảng
//                data = new SQLite(MainActivity.this, "Demo.sqlite", null, 1);
//                data.TruyVanKhongTraVe("DROP TABLE HopDong");
//                Toast.makeText(MainActivity.this, "Xóa thành công  table HopDong ", Toast.LENGTH_SHORT).show();
            }
        });

        timhd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activitymoi =new Intent(MainActivity.this,TimHopDong.class);
                startActivity(activitymoi);
            }
        });

        listkh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activitymoi =new Intent(MainActivity.this,ListKH.class);
                startActivity(activitymoi);
            }
        });
    }
}
