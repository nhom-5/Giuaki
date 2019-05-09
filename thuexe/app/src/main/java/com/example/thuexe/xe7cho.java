package com.example.thuexe;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class xe7cho extends Activity {
    private ListView listView1;
    ArrayList<Xe> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danhsachxe7cho);
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

        data.add(new Xe(R.drawable.toyota7, "Tên xe: TOYOTA","Xuất xứ: Nhật Bản","Giá thuê: 350$" ));
        data.add(new Xe(R.drawable.xe7cho3, "Tên xe: MAZDA","Xuất xứ: Nhật Bản","Giá thuê: 300$" ));
        data.add(new Xe(R.drawable.kia7, "Tên xe: KIA MORNING","Xuát xứ: Hàn Quốc","Giá thuê: 300" ));
        data.add(new Xe(R.drawable.che7, "Tên xe: CHEVROLET","Xuất xứ: Mỹ","Giá thuê: 320$" ));


    }
}