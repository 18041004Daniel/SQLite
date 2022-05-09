package com.difr.sqlaplicada;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLHelper dbHelper = new SQLHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if(db!=null){
            Toast.makeText(this,"BD INICIADA",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.item_insert:
                intent= new Intent(this,InsertActivity.class);
                startActivity(intent);
                return true;
            case R.id.item_update:
                intent= new Intent(this,UpdateActivity.class);
                startActivity(intent);
                return true;
            case R.id.item_delete:
                intent= new Intent(this,DeleteActivity.class);
                startActivity(intent);
                return true;
            case R.id.item_select:
                intent= new Intent(this,VistaActivity.class);
                startActivity(intent);
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    public void cargar(){

    }
}