package com.example.giuaky;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DangKyHopDong extends AppCompatActivity {

    Button tieptuc, update;
    EditText ngayhd, songaythue;
    TextView makh;
    SQLite data;
    ArrayList<khachhang> arrayDataKH;
    ArrayList<hopdong> arrayDataHD;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky_hop_dong);

        ngayhd = findViewById(R.id.ngayhd);
        tieptuc = findViewById(R.id.tieptuc);
        makh = findViewById(R.id.maKH);
        update = findViewById(R.id.update);
        songaythue = findViewById(R.id.songaythue);

        data = new SQLite(DangKyHopDong.this, "Demo.sqlite", null, 1);
        data.TruyVanKhongTraVe("Create Table If not exists HopDong(soHD Integer Primary Key Autoincrement , ngayHD Varchar, maKH Integer, CONSTRAINT makh FOREIGN KEY (maKH) REFERENCES KhachHang (maKH))");

        arrayDataKH = new ArrayList<>();
        cursor = data.TruyVanTraVe("Select * From KhachHang");
        cursor.moveToLast();
        Toast.makeText(this, String.valueOf(cursor.getInt(0)), Toast.LENGTH_SHORT).show();
        makh.setText(String.valueOf(cursor.getInt(0)));

        tieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(ngayhd.getText().toString().trim().equals(""))) {
                    data.TruyVanKhongTraVe("Insert into HopDong values (null, '" + ngayhd.getText().toString().trim() + "', " + cursor.getInt(0) + ")");
                    Toast.makeText(DangKyHopDong.this, "Thêm thành công hợp đồng " + ngayhd.getText().toString(), Toast.LENGTH_SHORT).show();
                    Intent activitymoi =new Intent(DangKyHopDong.this,ChonXe.class);
                    activitymoi.putExtra("msg1", ngayhd.getText().toString());
                    activitymoi.putExtra("msg2", songaythue.getText().toString());
                    startActivity(activitymoi);
                } else {
                    Toast.makeText(DangKyHopDong.this, "Hãy nhập tên sinh viên!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
