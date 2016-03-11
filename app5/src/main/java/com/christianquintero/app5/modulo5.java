package com.christianquintero.app5;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class modulo5 extends AppCompatActivity {
    private Spinner cColom;
    private EditText log, pas, pas2, ema, contr;
    private RadioGroup grupo;
    private RadioButton fem, mas;
    private DatePicker fNac;
    private CheckBox vi, de, mu, dor;
    private TextView info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo5);

        //enlazo mi spinner al creado en xml, y lo inicializo con los items para que se muestren
        cColom = (Spinner) findViewById(R.id.ciudades);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.ciud, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        cColom.setAdapter(adapter);

        //enlazo de EditTexts
        log = (EditText) findViewById(R.id.loggin);
        pas = (EditText) findViewById(R.id.password);
        pas2 = (EditText) findViewById(R.id.password2);
        ema = (EditText) findViewById(R.id.email);
        contr = (EditText)findViewById(R.id.contrasena);
        info = (TextView)findViewById(R.id.informacion);

        //enlazo de radioButton y radiogroup
        grupo = (RadioGroup)findViewById(R.id.grupo);
        fem = (RadioButton)findViewById(R.id.femenino);
        mas = (RadioButton)findViewById(R.id.masculino);

        //enlazo mi calendario
        fNac = (DatePicker)findViewById(R.id.fNacimiento);

        //enlazo con los checkbox
        vi = (CheckBox)findViewById(R.id.videojuegos);
        de = (CheckBox)findViewById(R.id.deportes);
        mu = (CheckBox)findViewById(R.id.musica);
        dor = (CheckBox)findViewById(R.id.dormir);

        Typeface tf = Typeface.createFromAsset(getAssets(), "Corona 4 Typewriter.ttf");
        TextView t = (TextView)findViewById(R.id.tit);
        t.setTypeface(tf);
        info.setTypeface(tf);

    }

    public void registrar(View objeto){
        String dato = obtenerDatos(info);

        if(log.getText().toString().isEmpty() || pas.getText().toString().isEmpty() || pas2.getText().toString().isEmpty() || ema.getText().toString().isEmpty() || contr.getText().toString().isEmpty()){
            Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_LONG).show();
        }
        else if(contrasenas(pas, pas2)){
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
        }
        else if(mas.isChecked()==false && fem.isChecked()==false){
            Toast.makeText(this, "Seleccione un sexo", Toast.LENGTH_LONG).show();
        }
        else if(vi.isChecked()==false && de.isChecked()==false && mu.isChecked()==false && dor.isChecked()==false){
            Toast.makeText(this, "No ha seleccionado ningun hobbye", Toast.LENGTH_LONG).show();
        }
        else{
            info.setText(dato + "/////////////////////////////////\nNombre: "+log.getText().toString()+"\nEmal: "+ema.getText().toString()+"\nSexo: "
           +sexo(fem)+"\nFecha de nacimiento: "+fecha(fNac)+"\nLugar de nacimiento: "+cColom.getSelectedItem().toString()+"\nHobbyes: "+ gustos(vi, de, mu, dor)+"\n\n");
            limpiar();
        }


    }

    public String obtenerDatos(TextView texto){
        return texto.getText().toString();
    }

    public String sexo(RadioButton sex){
        return sex.isChecked() ? "Femenino" : "Masculino";
    }

    public String fecha(DatePicker f){
        return f.getDayOfMonth()+"/"+f.getMonth()+"/"+f.getYear();
    }

    boolean contrasenas(EditText p, EditText p2){
        int con, con2;
        con = Integer.valueOf(p.getText().toString());
        con2 = Integer.valueOf(p2.getText().toString());

        if(con == con2){
            return false;
        }
        else{
            return true;
        }

    }

    public String gustos(CheckBox v, CheckBox d, CheckBox m, CheckBox d2){
        String gus = "";
        if(v.isChecked()) {
            gus += v.getText().toString() + ".\t";
        }else{}

        if(m.isChecked()){
            gus += m.getText().toString() + ".\t";
        }else{}

        if(de.isChecked()){
            gus += de.getText().toString() + ".\t";
        }else{}

        if(dor.isChecked()){
            gus += dor.getText().toString() + ".\t";
        }

        return gus;
    }

    public void limpiar(){
        contr.setText("");
        ema.setText("");
        pas2.setText("");
        pas.setText("");
        log.setText("");
        Toast.makeText(this, "Puede ingresar un nuevo usuario", Toast.LENGTH_LONG).show();
    }


}
