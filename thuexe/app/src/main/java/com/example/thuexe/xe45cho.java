package com.example.thuexe;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class xe45cho extends Activity {
    private ListView listView1;
    ArrayList<Xe> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danhsachxe45cho);
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
        data.add(new Xe(R.drawable.kumhosamco45, "Tên xe: KUMHO SAMCO","Xuất xứ: HÀN QUỐC","Giá thuê: 600$" ));
        data.add(new Xe(R.drawable.hyundai45, "Tên xe: HYUNDAI","Xuất xứ: HÀN QUỐC","Giá thuê: 550$" ));


    }
}
