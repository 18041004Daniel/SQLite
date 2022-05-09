package com.difr.sqlaplicada;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DeleteActivity extends AppCompatActivity {

    String concepto="", fecha="", monto="",tipo="";
    RecyclerView recyclerView;
    ArrayList<ArrayList<String>> listDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_delete);



        RadioButton radioButton1 = (RadioButton) findViewById(R.id.rb_ingreso2);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.rb_egreso2);

        Button button = (Button) findViewById(R.id.bt_borrar);

        mostrar();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLHelper dbHelper = new SQLHelper(getApplicationContext());
                SQLiteDatabase db = dbHelper.getWritableDatabase();


                EditText id2 = (EditText)findViewById(R.id.et_id2);
                String ind = id2.getText().toString();



                if (db!=null){
                    db.execSQL("DELETE FROM informe WHERE id="+ind+";");
                    Toast.makeText(getApplicationContext(),"ELIMINACIÓN CORRECTA",Toast.LENGTH_LONG).show();
                }

                mostrar();

            }
        });

    }

    public void mostrar(){
        SQLHelper dbHelper = new SQLHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        recyclerView =(RecyclerView) findViewById(R.id.recycler_id_3);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));

        if (db!=null) {

            EditText id2 = (EditText)findViewById(R.id.et_id2);
            String ind = id2.getText().toString();

            Log.e("ID",ind);

            Cursor cursor = db.rawQuery("SELECT * FROM informe",null);
            listDatos = new ArrayList<ArrayList<String>>();

            String id,concepto,fecha,tipo,monto;

            if (cursor.moveToFirst()){
                do {
                    id = cursor.getInt(0)+"";
                    concepto = cursor.getString(1);
                    fecha = cursor.getString(2);
                    tipo = cursor.getString(3);
                    monto = cursor.getInt(4)+"";

                    ArrayList<String> al;
                    al = new ArrayList<>();

                    al.add(id);al.add(concepto);al.add(fecha);al.add(tipo);al.add(monto);
                    listDatos.add(al);


                } while (cursor.moveToNext());
            }

            AdaptadorView adaptador = new AdaptadorView(listDatos);
            recyclerView.setAdapter(adaptador);

        }
    }
}
