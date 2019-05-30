package com.example.giuaky;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ChonXe extends AppCompatActivity {
    SQLite db;
    ArrayList<xe> arrayDataXe;
    Cursor cursor;
    ListView list;
    int[] arrayHinh = new int[14];
    String[] arrayGia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xe4_cho);

        list = findViewById(R.id.listView1);

        db=new SQLite(this,"Demo.sqlite",null,1);
        db.TruyVanKhongTraVe("Create Table If not Exists Xe(maXe Integer Primary Key Autoincrement, tenXe Varchar, xuatXu Varchar)");

//        db.TruyVanKhongTraVe("Insert into Xe values (null,'Tên xe: BMW','Xuất xứ: Đức')");
//        db.TruyVanKhongTraVe("Insert into Xe values (null,'Tên xe: AUDI','Xuất xứ: Đức')");
//        db.TruyVanKhongTraVe("Insert into Xe values (null,'Tên xe: MAZDA','Xuất xứ: Nhật Bản')");
//        db.TruyVanKhongTraVe("Insert into Xe values (null,'Tên xe: HONDA','Xuất xứ: Nhật Bản')");
//        db.TruyVanKhongTraVe("Insert into Xe values (null,'Tên xe: HONDA','Xuất xứ: Nhật Bản')");
//        db.TruyVanKhongTraVe("Insert into Xe values (null,'Tên xe: KIA MORNING','Xuất xứ: Hàn Quốc')");
//        db.TruyVanKhongTraVe("Insert into Xe values (null,'Tên xe: Toyota','Xuất xứ: Đức')");
//        db.TruyVanKhongTraVe("Insert into Xe values (null,'Tên xe: Ertiga','Xuất xứ: Đức')");
//        db.TruyVanKhongTraVe("Insert into Xe values (null,'Tên xe: Inova','Xuất xứ: Nhật Bản')");
//        db.TruyVanKhongTraVe("Insert into Xe values (null,'Tên xe: Xpander','Xuất xứ: Nhật Bản')");
//        db.TruyVanKhongTraVe("Insert into Xe values (null,'Tên xe: Toyota','Xuất xứ: Nhật')");
//        db.TruyVanKhongTraVe("Insert into Xe values (null,'Tên xe: Hyndai','Xuất xứ: Hàn Quốc')");
//        db.TruyVanKhongTraVe("Insert into Xe values (null,'Tên xe: Hyndai','Xuất xứ: Đức')");

//        data.TruyVanKhongTraVe("Insert into HopDong values (null, '" + ngayhd.getText().toString().trim() + "', " + cursor.getInt(0) + ")");
//        Toast.makeText(ChonXe.this,"Thêm thành công",Toast.LENGTH_SHORT).show();
        LoadDataXe();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int maXe = position + 1;

                Intent activitymoi =new Intent(ChonXe.this,ChiTietHopDong.class);
                activitymoi.putExtra("msg", String.valueOf(maXe));
                Intent intent = getIntent();
                activitymoi.putExtra("msg2", String.valueOf(intent.getStringExtra("msg1")));
                activitymoi.putExtra("msg3", String.valueOf(intent.getStringExtra("msg2")));
                activitymoi.putExtra("gia", String.valueOf(arrayGia[position]));
                Toast.makeText(ChonXe.this, arrayGia[position], Toast.LENGTH_SHORT).show();
                startActivity(activitymoi);
            }
        });
//        Toast.makeText(this, "bên ngoài" + maXe, Toast.LENGTH_SHORT).show();
    }

    private void LoadDataXe() {
        int count = 0;
        arrayHinh[0] = R.drawable.bmwi8;
        arrayHinh[1] = R.drawable.audi;
        arrayHinh[2] = R.drawable.mazda;
        arrayHinh[3] = R.drawable.hondacivic;
        arrayHinh[4] = R.drawable.toyota;
        arrayHinh[5] = R.drawable.kia;
        arrayHinh[6] = R.drawable.toyota7;
        arrayHinh[7] = R.drawable.xe7cho3;
        arrayHinh[8] = R.drawable.kia7;
        arrayHinh[9] = R.drawable.che7;
        arrayHinh[10] = R.drawable.trang;
        arrayHinh[11] = R.drawable.hyundai24;
        arrayHinh[12] = R.drawable.kumhosamco45;
        arrayHinh[13] = R.drawable.hyundai45;
        arrayGia = new String[] {"Giá thuê: 200$", "Giá thuê: 500$", "Giá thuê: 150$", "Giá thuê: 140$", "Giá thuê: 150$", "Giá thuê: 130$", "Giá thuê: 350$", "Giá thuê: 300$", "Giá thuê: 300$", "Giá thuê: 320$", "Giá thuê: 300$", "Giá thuê: 250$", "Giá thuê: 600$", "Giá thuê: 550$"};
        arrayDataXe = new ArrayList<>();
        cursor = db.TruyVanTraVe("Select * From Xe");
        while (cursor.moveToNext() && count<14) {
            arrayDataXe.add(new xe(arrayHinh[count], cursor.getInt(0), cursor.getString(1), cursor.getString(2), arrayGia[count]));
            count++;
        }
//        arrayDataXe.add(new xe(R.drawable.bmwi8, 10, "Tên xe: BMW","Xuất xứ: Đức","Giá thuê: 200$" ));
        XeAdapter adapter = new XeAdapter(ChonXe.this, R.layout.itemxe, arrayDataXe);
        adapter.setNotifyOnChange(true);
        list.setAdapter(adapter);
    }
}
