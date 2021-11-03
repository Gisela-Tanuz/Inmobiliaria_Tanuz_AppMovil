package com.tanuz.inmobiliariatanuz.ui.Contratos;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.tanuz.inmobiliariatanuz.R;

import com.tanuz.inmobiliariatanuz.modelo.Pago;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PagosAdapter extends RecyclerView.Adapter<PagosAdapter.ViewHolder> {
   private List<Pago> lista;
   private Context context;
   private LayoutInflater inflater;

    public PagosAdapter(List<Pago> lista, Context context, LayoutInflater inflater ) {
        Log.d("salida7","pase por aca");
        this.lista = lista;
        this.context = context;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_pagos,parent,false);

        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull PagosAdapter.ViewHolder holder, int position) {
         Pago items = lista.get(position);
        holder.tvCodigoPago.setText("Codigo de pago: "+items.getIdPago());
        holder.tvNumero.setText("Numero de pago: "+items.getNroDePago());
        holder.tvCodigoContrato.setText("Cogido de contrato: "+ items.getContratoId());
        holder.tvImporte.setText("Importe: "+items.getImporte());
        DateTimeFormatter dt= DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDate ldF=LocalDate.parse(items.getFecha(), dt);
        holder.tvFechaPago.setText("Fecha de Pago: "+ldF);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCodigoPago, tvNumero,tvCodigoContrato,tvImporte,tvFechaPago;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCodigoPago = itemView.findViewById(R.id.tvCodigoPago);
            tvNumero = itemView.findViewById(R.id.tvNumero);
            tvCodigoContrato= itemView.findViewById(R.id.tvCodigoContrato);
            tvImporte= itemView.findViewById(R.id.tvImporte);
            tvFechaPago= itemView.findViewById(R.id.tvFechaPago);
        }
    }
}
