package com.example.thuexe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class giaodien2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giaodien2);
        Button themhd = findViewById(R.id.button4);
        themhd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(giaodien2.this, giaodien3.class);
                startActivity(intent);
            }
        });
    }
}
