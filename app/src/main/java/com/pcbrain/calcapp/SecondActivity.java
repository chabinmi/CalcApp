package com.pcbrain.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView textView;
    Double et_dbl1 = 0.0;
    Double et_dbl2 = 0.0;
    Integer enzanshi = 0;
    Double kotae = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        et_dbl1 = getIntent().getDoubleExtra("editText1", 0.0);
        et_dbl2 = getIntent().getDoubleExtra("editText2", 0.0);
        enzanshi = getIntent().getIntExtra("4soku", 0);

        kotae = 0.0;
        textView = (TextView) findViewById(R.id.textView);
        if ( enzanshi == 1 ) {
            // 足し算
            kotae = et_dbl1 + et_dbl2;
        } else if ( enzanshi == 2 ) {
            // 引き算
            kotae = et_dbl1 - et_dbl2;
        } else if ( enzanshi == 3 ) {
            // 掛け算
            kotae = et_dbl1 * et_dbl2;
        } else if ( enzanshi == 4 ) {
            // 割り算
            kotae = et_dbl1 / et_dbl2;
        } else {
            kotae = 0.0;
            Log.d("4soku(Error)", String.valueOf(et_dbl1) + " : " + String.valueOf(et_dbl2) + " = " + String.valueOf(kotae));
        }
        textView.setText(kotae.toString());

        Button btn_modoru = (Button) findViewById(R.id.btn_modoru);
            btn_modoru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MainActivityに戻る
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}