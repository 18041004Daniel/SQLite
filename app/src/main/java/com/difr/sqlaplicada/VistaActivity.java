package com.difr.sqlaplicada;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VistaActivity extends AppCompatActivity {

    ArrayList<ArrayList<String>> listDatos;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_recycler);

        SQLHelper dbHelper = new SQLHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        recyclerView =(RecyclerView) findViewById(R.id.recycler_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));

        if (db!=null) {

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
