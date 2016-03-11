package com.christianquintero.app2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class modulo2 extends AppCompatActivity {
    private TextView t1;
    private EditText n1, n2;
    private RadioButton sum, res, mul, div;
    DecimalFormat df = new DecimalFormat("0.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo2);



        t1 = (TextView)findViewById(R.id.result);
        n1 = (EditText)findViewById(R.id.n1);
        n2 = (EditText)findViewById(R.id.n2);
        sum = (RadioButton)findViewById(R.id.su);
        res = (RadioButton)findViewById(R.id.re);
        mul = (RadioButton)findViewById(R.id.mu);
        div = (RadioButton)findViewById(R.id.di);




    }

    public void calculo(View view){

        if(n1.getText().toString().isEmpty() || n2.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingrese los numeros a operar", Toast.LENGTH_LONG).show();
        }
        else{
            int uno, dos;
            uno = Integer.parseInt(n1.getText().toString());
            dos = Integer.parseInt(n2.getText().toString());

            if(sum.isChecked()){
                t1.setText(String.valueOf(uno + dos));
            }
            else if(res.isChecked()){
                t1.setText(String.valueOf(uno - dos));
            }
            else if(mul.isChecked()){
                t1.setText(String.valueOf(uno * dos));
            }
            else if(div.isChecked()){

                t1.setText(String.valueOf(df.format(Float.valueOf(uno )/ Float.valueOf(dos))));
            }
            else{
                Toast.makeText(modulo2.this, "Seleccione una opción", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
