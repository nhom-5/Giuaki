package com.example.thuexe;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class xe24cho extends Activity {
    private ListView listView1;
    ArrayList<Xe> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danhsachxe24cho);
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
        data.add(new Xe(R.drawable.trang, "Tên xe: FORD TRANSIT","Xuất xứ: MỸ","Giá thuê: 300$" ));
        data.add(new Xe(R.drawable.hyundai24, "Tên xe: HYUNDAI","Xuất xứ: HÀN QUỐC","Giá thuê: 250$" ));

    }
}
