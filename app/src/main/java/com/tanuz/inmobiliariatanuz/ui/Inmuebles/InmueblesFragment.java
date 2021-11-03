package com.tanuz.inmobiliariatanuz.ui.Inmuebles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tanuz.inmobiliariatanuz.databinding.FragmentInmueblesBinding;
import com.tanuz.inmobiliariatanuz.modelo.Inmueble;

import java.util.List;
import java.util.Objects;


public class InmueblesFragment extends Fragment {

    private InmueblesViewModel inmueblesViewModel;
    private FragmentInmueblesBinding binding;
    private RecyclerView rv;
    private InmueblesAdapter ia;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        inmueblesViewModel =
                new ViewModelProvider(this).get(InmueblesViewModel.class);

        binding = FragmentInmueblesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        rv = binding.rvLista;
        GridLayoutManager gridLayoutManager= new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);

        inmueblesViewModel.getInmueble().observe(getViewLifecycleOwner(), new Observer<List<Inmueble>>() {
          @Override
          public void onChanged(List<Inmueble> inmuebles) {

              rv.setLayoutManager(gridLayoutManager);
              ia = new InmueblesAdapter(inmuebles,getContext(),getLayoutInflater());
              rv.setAdapter(ia);
          }
      });
        inmueblesViewModel.getTvNoInmueble().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.tvNoInmueble.setVisibility(integer);
            }
        });
       inmueblesViewModel.ObtenerListaInmueble();


       

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}