package com.example.thuexe;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class xe4cho extends Activity {
    private ListView listView1;
    ArrayList<Xe> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danhsachxe4cho);
        setControl();
        setEvent();
    }
    private void setControl(){
        listView1 = (ListView) findViewById(R.id.listView1);

    }
    private void setEvent(){
        KhoiTao();
        XeAdapter adapter = new XeAdapter(this, R.layout.listview_row, data);
        listView1.setAdapter(adapter);
    }
    void KhoiTao(){

        data.add(new Xe(R.drawable.bmwi8, "Tên xe: BMW","Xuất xứ: Đức","Giá thuê: 200$" ));
        data.add(new Xe(R.drawable.audi, "Tên xe: AUDI","Xuất xứ: Đức","Giá thuê: 500$" ));
        data.add(new Xe(R.drawable.mazda, "Tên xe: MAZDA","Xuát xứ: Nhật Bản","Giá thuê: 150$" ));
        data.add(new Xe(R.drawable.hondacivic, "Tên xe: HONDA","Xuất xứ: Nhật Bản","Giá thuê: 140$" ));
        data.add(new Xe(R.drawable.toyota, "Tên xe: Honda","Xuất xứ: Nhật Bản","Giá thuê: 150$" ));
        data.add(new Xe(R.drawable.kia, "Tên xe: KIA MORNING","Xuát xứ: Hàn Quốc","Giá thuê: 130$" ));


    }
}