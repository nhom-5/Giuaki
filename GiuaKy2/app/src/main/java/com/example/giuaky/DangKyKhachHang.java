package com.example.giuaky;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DangKyKhachHang extends AppCompatActivity {

    Button tieptuc;
    EditText tenkh, sdt;
    SQLite data;
    int sdtedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky_khach_hang);

        tieptuc = findViewById(R.id.tieptuc);
        tenkh = findViewById(R.id.tenkh);
        sdt = findViewById(R.id.sdt);

        data = new SQLite(DangKyKhachHang.this, "Demo.sqlite", null, 1);
        data.TruyVanKhongTraVe("Create Table If not exists KhachHang(maKH Integer Primary Key Autoincrement , tenKH Varchar , sdt Integer)");

        tieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(tenkh.getText().toString().trim().equals("")) || sdt.getText().toString().trim().equals("")) {
                    sdtedit = Integer.parseInt(sdt.getText().toString());

                    data.TruyVanKhongTraVe("Insert into KhachHang values (null, '" + tenkh.getText().toString().trim() + "', " + sdtedit + ")");
                    Toast.makeText(DangKyKhachHang.this, "Thêm thành công Khách Hàng " + tenkh.getText().toString(), Toast.LENGTH_SHORT).show();
                    Intent activitymoi =new Intent(DangKyKhachHang.this,DangKyHopDong.class);
                    startActivity(activitymoi);
                } else {
                    Toast.makeText(DangKyKhachHang.this, "Hãy nhập tên Khách Hàng!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
