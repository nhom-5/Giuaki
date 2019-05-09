package com.example.thuexe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class giaodien3 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giaodien3);

        Button chonxe =(Button) findViewById(R.id.chonxe);
        chonxe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup radiogroup = (RadioGroup) findViewById(R.id.radiogroup);
                RadioButton xe4cho = (RadioButton) findViewById(R.id.xe4cho);
                RadioButton xe7cho = (RadioButton)findViewById(R.id.xe7cho);
                RadioButton xe24cho = (RadioButton)findViewById(R.id.xe24cho);
                RadioButton xe45cho = (RadioButton)findViewById(R.id.xe45cho);
                int id=radiogroup.getCheckedRadioButtonId();
                switch(id){
                    case R.id.xe4cho:
                                Intent intent = new Intent(giaodien3.this, xe4cho.class);
                                startActivity(intent);
                        break;
                    case R.id.xe7cho:
                                Intent intent1 = new Intent(giaodien3.this, xe7cho.class);
                                startActivity(intent1);
                        break;
                    case R.id.xe24cho:
                                Intent intent2 = new Intent(giaodien3.this, xe24cho.class);
                                startActivity(intent2);
                        break;
                    case R.id.xe45cho:
                                Intent intent3 = new Intent(giaodien3.this, xe45cho.class);
                                startActivity(intent3);
                        break;
                }
            }
        });

    }
}
