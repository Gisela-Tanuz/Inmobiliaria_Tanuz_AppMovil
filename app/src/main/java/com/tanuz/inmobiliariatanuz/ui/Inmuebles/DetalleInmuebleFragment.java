package com.tanuz.inmobiliariatanuz.ui.Inmuebles;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tanuz.inmobiliariatanuz.databinding.DetalleInmuebleFragmentBinding;
import com.tanuz.inmobiliariatanuz.modelo.Inmueble;


public class DetalleInmuebleFragment extends Fragment {

    private DetalleInmuebleViewModel mViewModel;
    private DetalleInmuebleFragmentBinding binding;
public static DetalleInmuebleFragment newInstance() {
        return new DetalleInmuebleFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(DetalleInmuebleViewModel.class);
        binding = DetalleInmuebleFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mViewModel.getInmueble().observe(getViewLifecycleOwner(), new Observer<Inmueble>() {
            @Override
            public void onChanged(Inmueble inmuebles) {
                binding.tvCodigo.setText(inmuebles.getIdInmueble()+"");
                binding.tvAmbientes.setText(inmuebles.getAmbientes()+"");
                binding.tvDirecciones.setText(inmuebles.getDireccion());
                binding.tvUso.setText(inmuebles.getUso());
                binding.tvPrecios.setText(inmuebles.getPrecio()+"");
                binding.tvTipo.setText(inmuebles.getTipo());
                binding.cbDisponible.setChecked(inmuebles.isEstado());
                Glide.with(getContext())
                        .load(inmuebles.getUrlImagen())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(binding.ivFoto);
                binding.cbDisponible.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewModel.guardarCambios(getArguments());
                    }
                });
            }
        });
          mViewModel.obtenerInmuebles(getArguments());
        return root;

    }




}