package com.difr.sqlaplicada;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InsertActivity extends AppCompatActivity {

    String concepto="", fecha="", monto="",tipo="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_insert);

        RadioButton radioButton1 = (RadioButton) findViewById(R.id.rb_ingreso2);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.rb_egreso2);

        Button button = (Button) findViewById(R.id.bt_borrar);

        EditText Econcepto = (EditText) findViewById(R.id.et_concepto2);
        EditText Efecha = (EditText) findViewById(R.id.et_fecha2);
        EditText Emonto = (EditText) findViewById(R.id.et_monto2);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLHelper dbHelper = new SQLHelper(getApplicationContext());
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                if (radioButton1.isChecked()){
                    tipo = "Ingreso";
                }
                if (radioButton2.isChecked()){
                    tipo = "Egreso";
                }


                concepto = Econcepto.getText().toString();
                fecha = Efecha.getText().toString();
                monto = Emonto.getText().toString();


                if (db!=null){
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("concepto",concepto);
                    contentValues.put("fecha",fecha);
                    contentValues.put("tipo", tipo);
                    contentValues.put("monto",monto);
                    db.insert("informe",null,contentValues);
                    Toast.makeText(getApplicationContext(),"INGRESO CORRECTO",Toast.LENGTH_LONG).show();
                }

                Econcepto.setText("");
                Efecha.setText("");
                Emonto.setText("");

                Log.e("C", concepto);
                Log.e("F", fecha);
                Log.e("T", tipo);
                Log.e("M", monto);

            }
        });

    }
}
