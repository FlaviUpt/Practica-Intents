package com.example.bepis.sentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    CheckBox a0,a2,a3,a4,a5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a0 = (CheckBox) findViewById(R.id.check1);
        a2 = (CheckBox) findViewById(R.id.check2);
        a3 = (CheckBox) findViewById(R.id.check3);
        a4 = (CheckBox) findViewById(R.id.check4);
        a5 = (CheckBox) findViewById(R.id.check5);


        Button btn_sent =(Button)findViewById(R.id.btn_enviar);
        final EditText edt_msg = (EditText)findViewById(R.id.edt_msj);

        btn_sent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,edt_msg.getText().toString());
                intent.setType("text/plain");

                if (null != intent.resolveActivity(getPackageManager()))
                {
                    startActivity(intent.createChooser(intent,getResources().getString(R.string.send_to)));
                }
            }
        });

    }
}
