package com.example.juegodel21;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ganadoresAdapter extends RecyclerView.Adapter<ganadoresAdapter.viewHolder> {

    private final List<data> I;

    public ganadoresAdapter(List<data>I){this.I = I;}

    @NonNull
    @Override
    public ganadoresAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)  {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.design,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.setData(I.get(position));
    }

    @Override
    public int getItemCount() {
        return I.size();
    }


    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView nombre;
        TextView cantida;
        ImageView image;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imagen);
            nombre = itemView.findViewById(R.id.nombre);
            cantida = itemView.findViewById(R.id.cantidad);
        }
        public void setData(data intent) {
            nombre.setText("" + intent.getNombre());
            cantida.setText("" + intent.getCantidad());
            Picasso.get().load("" + intent.getUrlImg()).into(image);
        }
    }
}

