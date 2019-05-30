package com.example.giuaky;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ChiTietHopDong extends AppCompatActivity {
    SQLite data;
    Cursor cursor;
    TextView sohd, maxe, tenkh, ngayhd, songaythue, gia;
    Button xuatHD;
    String[] output1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_hop_dong);

        Intent intent = getIntent();
        final String msg = intent.getStringExtra("msg");
        final String msg2 = intent.getStringExtra("msg2");
        final String msg3 = intent.getStringExtra("msg3");
        String GIA = intent.getStringExtra("gia");

        sohd = findViewById(R.id.soHD);
        maxe = findViewById(R.id.maXe);
        tenkh = findViewById(R.id.tenKH);
        ngayhd = findViewById(R.id.ngayhd);
        songaythue = findViewById(R.id.songaythue);
        gia = findViewById(R.id.gia);
        xuatHD = findViewById(R.id.button);

        data=new SQLite(this,"Demo.sqlite",null,1);
//        data.TruyVanKhongTraVe("Create Table If not Exists ChiTietHopDong(soHD Integer, maXe Integer, songaythue Varchar, gia Integer constraint chitiethopdong_pk primary key (soHD, maXe))");
        data.TruyVanKhongTraVe("CREATE TABLE If not Exists ChiTietHopDong\n" +
                " ( soHD INT ,\n" +
                "   maXe INT ,\n" +
                "   songaythue INT ,\n" +
                "   gia INT,\n" +
                "   CONSTRAINT id_CTHD\n" +
                "   PRIMARY KEY (soHD, maXe) ,\n" +
                "   FOREIGN KEY (soHD) REFERENCES HopDong(soHD) ,\n" +
                "   FOREIGN KEY (maXe) REFERENCES Xe(maXe)\n" +
                " )");
        Toast.makeText(this, "Tạo bảng chi tiết hợp đồng thành công", Toast.LENGTH_SHORT).show();

//        cursor = data.TruyVanTraVe("Select soHD.HopDong, maXe.Xe, tenKH.KhachHang, ngayHD.HopDong, songaythue.ChiTietHopDong, gia.ChiTietHopDong From ChiTietHopDong, KhachHang, HopDong, Xe");
//        cursor = data.TruyVanTraVe("Select * From ChiTietHopDong");
//        cursor.moveToFirst();
//        sohd.setText(String.valueOf(cursor.getInt(0)));

        cursor = data.TruyVanTraVe("Select * From KhachHang");
        cursor.moveToLast();

        sohd.setText(String.valueOf(cursor.getInt(0)));
        maxe.setText(msg);
        tenkh.setText(cursor.getString(1));
        ngayhd.setText(msg2);
        songaythue.setText(msg3);

        String[] output = GIA.split(" ");
        output1 = output[2].split("\\$");

        int total = Integer.parseInt(output1[0]) * Integer.parseInt(msg3);
        GIA = String.valueOf(total) + "$";
        gia.setText(GIA);

        xuatHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.TruyVanKhongTraVe("Insert into ChiTietHopDong values (" + cursor.getInt(0)+ "," + Integer.parseInt(msg) + "," + Integer.parseInt(msg3) + "," + Integer.parseInt(output1[0]) + ")");
                Toast.makeText(ChiTietHopDong.this, "Đã lưu hợp đồng", Toast.LENGTH_SHORT).show();

                Intent activitymoi =new Intent(ChiTietHopDong.this,MainActivity.class);
                startActivity(activitymoi);
            }
        });

    }
}
