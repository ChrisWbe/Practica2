package com.christianquintero.app4;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class modulo4 extends AppCompatActivity {

    private RadioButton rCua, rTri, rRec, rCir;
    private EditText eLa, eAl, eBa, eRa, eRes;
    private TextView tCua, tTri, tRec, tCir;
    private RadioGroup gru;
    DecimalFormat dF = new DecimalFormat("0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo4);

        gru = (RadioGroup)findViewById(R.id.grupo);

        //Radio Buttons enlace
        rCua = (RadioButton)findViewById(R.id.cua);
        rTri = (RadioButton)findViewById(R.id.tri);
        rRec = (RadioButton)findViewById(R.id.rec);
        rCir = (RadioButton)findViewById(R.id.cir);

        //EditText enlace, altura y base son para un mismo calculo
        eLa = (EditText)findViewById(R.id.et1);
        eBa = (EditText)findViewById(R.id.et3);
        eAl = (EditText)findViewById(R.id.et3_1);
        eRa = (EditText)findViewById(R.id.et4);
        eRes = (EditText)findViewById(R.id.resul);

        //TextView Enlace, triangulo y rectangulo se muestran por aparte
        tCua = (TextView)findViewById(R.id.tv1);
        tTri = (TextView)findViewById(R.id.tv2);
        tRec = (TextView)findViewById(R.id.tv3);
        tCir = (TextView)findViewById(R.id.tv4);

       gru.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {

               if(rCua.isChecked()){
                   tTri.setVisibility(View.GONE);
                   eAl.setVisibility(View.GONE);
                   eBa.setVisibility(View.GONE);
                   tRec.setVisibility(View.GONE);
                   tCir.setVisibility(View.GONE);
                   eRa.setVisibility(View.GONE);

                   tCua.setVisibility(View.VISIBLE);
                   eLa.setVisibility(View.VISIBLE);
                   eRes.setText("");
                   eAl.setText("");
                   eBa.setText("");
                   eRa.setText("");
               }
               else if(rTri.isChecked()){
                   tCua.setVisibility(View.GONE);
                   eLa.setVisibility(View.GONE);
                   tRec.setVisibility(View.GONE);
                   tCir.setVisibility(View.GONE);
                   eRa.setVisibility(View.GONE);

                   tTri.setVisibility(View.VISIBLE);
                   eAl.setVisibility(View.VISIBLE);
                   eBa.setVisibility(View.VISIBLE);
                   eRes.setText("");
                   eLa.setText("");
                   eAl.setText("");
                   eBa.setText("");
                   eRa.setText("");
               }
               else if(rRec.isChecked()){
                   tCua.setVisibility(View.GONE);
                   tTri.setVisibility(View.GONE);
                   eLa.setVisibility(View.GONE);
                   tCir.setVisibility(View.GONE);
                   eRa.setVisibility(View.GONE);
                   eAl.setVisibility(View.GONE);
                   eBa.setVisibility(View.GONE);

                   tRec.setVisibility(View.VISIBLE);
                   eAl.setVisibility(View.VISIBLE);
                   eBa.setVisibility(View.VISIBLE);
                   eRes.setText("");
                   eLa.setText("");
                   eAl.setText("");
                   eBa.setText("");
                   eRa.setText("");
               }
               else if(rCir.isChecked()){
                   tCua.setVisibility(View.GONE);
                   tTri.setVisibility(View.GONE);
                   eLa.setVisibility(View.GONE);
                   eAl.setVisibility(View.GONE);
                   eBa.setVisibility(View.GONE);
                   tRec.setVisibility(View.GONE);

                   tCir.setVisibility(View.VISIBLE);
                   eRa.setVisibility(View.VISIBLE);
                   eRes.setText("");
                   eLa.setText("");
                   eAl.setText("");
                   eBa.setText("");
               }

           }
       });

    }

    public void calculo(View objeto){
        if(eLa.getText().toString().isEmpty() && eAl.getText().toString().isEmpty() && eBa.getText().toString().isEmpty() && eRa.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingrese los datos segun el caso", Toast.LENGTH_LONG).show();
        }
        else{
            if(rCua.isChecked()){
                double lado;
                lado = Double.valueOf(eLa.getText().toString());
                eRes.setText("Area = " + String.valueOf(dF.format(Math.pow(lado, 2)))+ "cm^2");
            }
            else if(rTri.isChecked()){
                double alto, base;
                alto = Double.valueOf(eAl.getText().toString());
                base = Double.valueOf(eBa.getText().toString());
                eRes.setText("Area = " + String.valueOf(dF.format((alto * base) / 2))+ "cm^2");
            }

            else if(rRec.isChecked()){
                double alto, base;
                alto = Double.valueOf(eAl.getText().toString());
                base = Double.valueOf(eBa.getText().toString());
                eRes.setText("Area = " + String.valueOf(dF.format(base * alto))+ "cm^2");
            }

            else if(rCir.isChecked()){
                double radio;
                radio = Double.valueOf(eRa.getText().toString());
                eRes.setText("Area = " + String.valueOf(dF.format(3.1416 * (Math.pow(radio, 2)))) + "cm^2");
            }
            else{
                Toast.makeText(modulo4.this, "No se ha seleccionado ninguna opcion", Toast.LENGTH_SHORT).show();
            }
        }
    }
}