package com.christianquintero.app3;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class modulo3 extends AppCompatActivity {
    protected TextView customFont; //Creo una variable tipo TextView
    private EditText q, e, l, p;
    private TextView nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo3);

        q = (EditText)findViewById(R.id.quiz);
        e = (EditText)findViewById(R.id.expo);
        l = (EditText)findViewById(R.id.laboratorio);
        p = (EditText)findViewById(R.id.fin);
        nota = (TextView)findViewById(R.id.outNota);
        //Paso de la fuente
        customFont = (TextView)findViewById(R.id.tv1);
        Typeface font = Typeface.createFromAsset(getAssets(), "Cute Cartoon.ttf"); //Creo la variable tipo TypeFont y le asigno el metodo create el cual tiene el nombre del archivo .ttf
        customFont.setTypeface(font); //le asigno el tipo de fuente a mi enlace con mi textView
    }

    public void notaFinal(View objeto){
        if(q.getText().toString().isEmpty() || e.getText().toString().isEmpty() || l.getText().toString().isEmpty() || p.getText().toString().isEmpty()){
            Toast.makeText(this, "Faltan notas", Toast.LENGTH_LONG).show();
        }
        else if(eval()){
            Toast.makeText(this, "La nota no puede ser mayor a 5.0", Toast.LENGTH_LONG).show();
        }
        else{
            float quiz, ex, lab, pro, resultado;
            quiz = Float.valueOf(q.getText().toString());
            ex = Float.valueOf(e.getText().toString());
            lab = Float.valueOf(l.getText().toString());
            pro = Float.valueOf(p.getText().toString());



            resultado = (float)((quiz * 0.15) + (ex * 0.10) + (lab * 0.40) + (pro * 0.35));
            nota.setText(String.valueOf(resultado));

            if(resultado < 3.0){
                Toast.makeText(modulo3.this, "No te rindas, mejor para la proxima", Toast.LENGTH_SHORT).show();
            }
            else if(resultado > 3.0 && resultado < 3.5){
                Toast.makeText(modulo3.this, "Por poco, tienes que mejorar", Toast.LENGTH_SHORT).show();
            }
            else if(resultado > 4.0){
                Toast.makeText(modulo3.this, "Muy bien, sigue así", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean eval(){
        float n1, n2, n3, n4;
        n1 = Float.valueOf(q.getText().toString());
        n2 = Float.valueOf(e.getText().toString());
        n3 = Float.valueOf(l.getText().toString());
        n4 = Float.valueOf(p.getText().toString());

        if(n1 > 5.0){
            return true;
        }
        else if(n2 > 5.0){
            return true;
        }
        else if(n3 > 5.0){
            return true;
        }
        else if(n4 > 5.0){
            return true;
        }
        else{
            return false;
        }
    }


}
