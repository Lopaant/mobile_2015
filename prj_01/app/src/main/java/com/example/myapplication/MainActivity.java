package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String fn = "", sn = "", op = "+";

    TextView t;

    void number(View v) {
        String tw = t.getText().toString();
        String n = ( (Button)v ).getText().toString();

        t.setText( String.format("%s%s", tw, n) );
    }

    void sym(View v) {
        fn = t.getText().toString();
        op = ( (Button)v ).getText().toString();
        t.setText("");
    }

    void eq(View v) {
        sn = t.getText().toString();

        if (fn.equals("")) {
            t.setText(sn);
        } else if(sn.equals("")) {
            t.setText(fn);
        } else {
            if (op.equals("+")) {
                t.setText(String.format("%f%f", fn, sn));
            } else if (op.equals("*")) {
                t.setText(String.format("%f", (Double.parseDouble(fn) * Double.parseDouble(sn))));
            } else if (op.equals("/")) {
                if (Double.parseDouble(sn) == 0) {
                    t.setText("0");
                } else {
                    t.setText(String.format("%f", (Double.parseDouble(fn) / Double.parseDouble(sn))));
                }
            } else if (op.equals("-")) {
                t.setText(String.format("%f", (Double.parseDouble(fn) - Double.parseDouble(sn))));
            }
        }

        op = "+";
        fn = "";
        sn = t.getText().toString();

    }
}
