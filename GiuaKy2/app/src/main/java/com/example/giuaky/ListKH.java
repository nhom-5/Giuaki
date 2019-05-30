package com.example.giuaky;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListKH extends AppCompatActivity {
    SQLite data;
    ListView list;
    EditText sdt;
    Button btnSua, btnXoa, btnTimKiem, btnLoad;

    ArrayList<khachhang> arrayDataKH;
    int position;

    Cursor cursor;

//    final hopdong hd = this.arrayDataHD.get(1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_kh);

        list = (ListView) findViewById(R.id.list1);
        sdt = findViewById(R.id.sdt);
        btnSua = findViewById(R.id.btnSua);
        btnTimKiem = findViewById(R.id.btnTimkiem);
        btnLoad = findViewById(R.id.btnLoad);

        data = new SQLite(ListKH.this, "Demo.sqlite", null, 1);
        LoadDataKH();
        Event();
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sdt.getText().toString().trim().equals("")) {
                    data.TruyVanKhongTraVe("Update KhachHang set tenKH='" + sdt.getText().toString().trim() + "' where maKH=" + arrayDataKH.get(position).makh + "");
                    Toast.makeText(ListKH.this, "Sửa thành công" + sdt.getText(), Toast.LENGTH_SHORT).show();
                    LoadDataKH();
                } else {
                    Toast.makeText(ListKH.this, "Hãy chọn Khách Hàng cần sửa!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnTimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sdt.getText().toString().trim().equals("")) {
                    arrayDataKH = new ArrayList<>();
                    Cursor cursor = data.TruyVanTraVe("Select * from KhachHang where tenKH like '%" + sdt.getText().toString().trim() + "%'");
                    while (cursor.moveToNext()) {
                        arrayDataKH.add(new khachhang(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
                    }
                    KHAdapter adapter = new KHAdapter(ListKH.this, R.layout.itemkh, arrayDataKH);
                    list.setAdapter(adapter);
                } else {
                    LoadDataKH();
                }
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadDataKH();
            }
        });

//        cursor.moveToFirst();
//        Toast.makeText(this,String.valueOf(cursor.getInt(0)), Toast.LENGTH_SHORT).show();
    }

    private void Event() {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, final int i, long id) {
//                Toast.makeText(TimHopDong.this, "update database" + position, Toast.LENGTH_SHORT).show();
                sdt.setText(arrayDataKH.get(i).tenkh);
                position = i;
//                data.TruyVanKhongTraVe("Delete from HopDong where soHD=" + cursor.getInt(0));
//                Toast.makeText(TimHopDong.this, "Xóa thành công sinh viên ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void LoadDataKH() {
        arrayDataKH = new ArrayList<>();
        cursor = data.TruyVanTraVe("Select * From KhachHang");
        while (cursor.moveToNext()) {
            arrayDataKH.add(new khachhang(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
        }
        KHAdapter adapter = new KHAdapter(ListKH.this, R.layout.itemkh, arrayDataKH);
        adapter.setNotifyOnChange(true);
        list.setAdapter(adapter);
    }
}
