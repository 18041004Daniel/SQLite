package com.difr.sqlaplicada;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorView extends RecyclerView.Adapter<AdaptadorView.ViewHolderDatos>{

    ArrayList<ArrayList<String>> listDatos;

    public AdaptadorView(ArrayList<ArrayList<String>> listDatos) {
        this.listDatos = listDatos;
    }

    @NonNull
    @Override
    public AdaptadorView.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorView.ViewHolderDatos holder, int position) {
        holder.asignacion(listDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView id, concepto, fecha, tipo, monto;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.tv_id);
            concepto = (TextView) itemView.findViewById(R.id.tv_concepto);
            fecha = (TextView) itemView.findViewById(R.id.tv_fecha);
            tipo = (TextView) itemView.findViewById(R.id.tv_tipo);
            monto = (TextView) itemView.findViewById(R.id.tv_monto);

        }

        public void asignacion(ArrayList<String> d1) {
            id.setText(d1.get(0));
            concepto.setText("CONCEPTO: "+d1.get(1));
            fecha.setText("FECHA: "+d1.get(2));
            tipo.setText("TIPO: "+d1.get(3));
            monto.setText("MONTO: "+d1.get(4));
        }
    }
}
