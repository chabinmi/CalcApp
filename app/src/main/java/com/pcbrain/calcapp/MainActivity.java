package com.pcbrain.calcapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    TextView textView;
    Double et_dbl1 = 0.0;
    Double et_dbl2 = 0.0;
    Integer et_len1 = 0;
    Integer et_len2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText1.requestFocus();

        Button btn_tasu = (Button) findViewById(R.id.btn_tasu);
        btn_tasu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToSecondActivity(1);
            }
        });

        Button btn_hiku = (Button) findViewById(R.id.btn_hiku);
        btn_hiku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToSecondActivity(2);
            }
        });

        Button btn_kakeru = (Button) findViewById(R.id.btn_kakeru);
        btn_kakeru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToSecondActivity(3);
            }
        });

        Button btn_waru = (Button) findViewById(R.id.btn_waru);
        btn_waru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToSecondActivity(4);
            }
        });

    }

    public void ToSecondActivity(Integer enzanshi) {
        String et_str1;
        String et_str2;
        String err_msg;

        textView = (TextView) findViewById(R.id.textView);
        et_len1 = editText1.length();
        et_len2 = editText2.length();
        et_str1 = editText1.getText().toString();
        et_str2 = editText2.getText().toString();
        if ((et_len1 == 0) ||
            (et_len2 == 0) ||
            (et_len1 == 1 && et_str1.equals(".")) ||
            (et_len2 == 1 && et_str2.equals("."))) {
            if (et_len1 == 0) {
                err_msg = "数値は両方とも入力してください。";
                editText1.requestFocus();
            } else if (et_len2 == 0) {
                err_msg = "数値は両方とも入力してください。";
                editText2.requestFocus();
            } else if (et_len1 == 1 && et_str1.equals(".")) {
                err_msg = "数値は正しく入力してください。";
                editText1.requestFocus();
            } else if (et_len2 == 1 && et_str2.equals(".")) {
                err_msg = "数値は正しく入力してください。";
                editText2.requestFocus();
            } else {
                err_msg = null;
                editText1.requestFocus();
            }

            textView.setTextColor(Color.parseColor("#FF0000"));
            textView.setText(err_msg);
        } else {
            textView.setText("");
            et_dbl1 = Double.parseDouble(editText1.getText().toString());
            et_dbl2 = Double.parseDouble(editText2.getText().toString());

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("editText1", et_dbl1);
            intent.putExtra("editText2", et_dbl2);
            intent.putExtra("4soku", enzanshi);
            startActivity(intent);
        }
    }

}
