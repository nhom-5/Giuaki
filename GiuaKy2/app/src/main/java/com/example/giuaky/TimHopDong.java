package com.example.giuaky;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TimHopDong extends AppCompatActivity {
    SQLite data;
    ListView list;
    TextView soHD, maXE;
    EditText tenKH, songaythue, gia, ngayHD;
    Button btnSua, btnXoa, btnTimKiem, btnLoad;

    ArrayList<chitiethopdongClass> arrayDataHD;
    int position;

    Cursor cursor;

//    final hopdong hd = this.arrayDataHD.get(1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_hop_dong);

        list = (ListView) findViewById(R.id.list);
        ngayHD = findViewById(R.id.ngayHD);
        soHD = findViewById(R.id.soHD);
        maXE = findViewById(R.id.maXE);
        tenKH = findViewById(R.id.tenKH);
        songaythue = findViewById(R.id.songaythue);
        gia = findViewById(R.id.gia);
        btnSua = findViewById(R.id.btnSua);
        btnXoa = findViewById(R.id.btnXoa);
        btnTimKiem = findViewById(R.id.btnTimkiem);
        btnLoad = findViewById(R.id.btnLoad);

        data = new SQLite(TimHopDong.this, "Demo.sqlite", null, 1);
        LoadDataHD();
        Event();
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!soHD.getText().toString().trim().equals("")) {
//                    data.TruyVanKhongTraVe("Update ChiTietHopDong,KhachHang,HopDong set KhachHang.tenKH='" + tenKH.getText().toString().trim() + "', HopDong.ngayHD='" + ngayHD.getText().toString().trim() + "', ChiTietHopDong.songaythue='" + songaythue.getText().toString().trim() + "', ChiTietHopDong.gia='" + gia.getText().toString().trim() + "' where soHD=" + arrayDataHD.get(position).soHD + "AND HopDong.makh=KhachHang.maKH AND HopDong.soHD=ChiTietHopDong.soHD");
                    data.TruyVanKhongTraVe("Update ChiTietHopDong set songaythue='" + songaythue.getText().toString().trim() + "', gia='" + gia.getText().toString().trim() + "' where soHD=" + arrayDataHD.get(position).soHD + "");
                    Toast.makeText(TimHopDong.this, "Sửa thành công" + soHD.getText(), Toast.LENGTH_SHORT).show();
                    LoadDataHD();
                } else {
                    Toast.makeText(TimHopDong.this, "Hãy chọn hợp đồng cần sửa!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!soHD.getText().toString().trim().equals("")) {
                    data.TruyVanKhongTraVe("Delete from ChiTietHopDong where soHD=" + arrayDataHD.get(position).soHD + "");
                    Toast.makeText(TimHopDong.this, "Xóa thành công " + soHD.getText(), Toast.LENGTH_SHORT).show();
                    soHD.setText("");
                    LoadDataHD();
                } else {
                    Toast.makeText(TimHopDong.this, "Hãy chọn hợp đồng muốn xóa!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnTimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!soHD.getText().toString().trim().equals("")) {
                    arrayDataHD = new ArrayList<>();
                    Cursor cursor = data.TruyVanTraVe("Select * from ChiTietHopDong where songaythue like '%" + songaythue.getText().toString().trim() + "%'");
                    while (cursor.moveToNext()) {
                        arrayDataHD.add(new chitiethopdongClass(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2), cursor.getInt(3)));
                    }
                    HDAdapter adapter = new HDAdapter(TimHopDong.this, R.layout.itemhd, arrayDataHD);
                    list.setAdapter(adapter);
                } else {
                    LoadDataHD();
                }
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadDataHD();
            }
        });

//        cursor.moveToFirst();
//        Toast.makeText(this,String.valueOf(cursor.getInt(0)), Toast.LENGTH_SHORT).show();
    }

    private void Event() {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, final int i, long id) {
//                Toast.makeText(TimHopDong.this, "update database" + position, Toast.LENGTH_SHORT).show();
                soHD.setText(String.valueOf(arrayDataHD.get(i).soHD));
                maXE.setText(String.valueOf(arrayDataHD.get(i).maXe));
                songaythue.setText(String.valueOf(arrayDataHD.get(i).songaythue));
                gia.setText(String.valueOf(arrayDataHD.get(i).gia));
                position = i;

//                data.TruyVanKhongTraVe("Delete from HopDong where soHD=" + cursor.getInt(0));
//                Toast.makeText(TimHopDong.this, "Xóa thành công sinh viên ", Toast.LENGTH_SHORT).show();


            }
        });
    }

    private void LoadDataHD() {
        arrayDataHD = new ArrayList<>();
        cursor = data.TruyVanTraVe("Select * From ChiTietHopDong");
        while (cursor.moveToNext()) {
            arrayDataHD.add(new chitiethopdongClass(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2), cursor.getInt(3)));
        }
        HDAdapter adapter = new HDAdapter(TimHopDong.this, R.layout.itemhd, arrayDataHD);
        adapter.setNotifyOnChange(true);
        list.setAdapter(adapter);
    }
}
