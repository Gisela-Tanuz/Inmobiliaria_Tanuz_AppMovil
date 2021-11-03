package com.tanuz.inmobiliariatanuz.ui.Contratos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.tanuz.inmobiliariatanuz.databinding.PagosFragmentBinding;
import com.tanuz.inmobiliariatanuz.modelo.Pago;

import java.util.List;


public class PagosFragment extends Fragment {

    private PagosViewModel mViewModel;
    private PagosFragmentBinding binding;
    private RecyclerView rv;
    private PagosAdapter pa;


    public static PagosFragment newInstance() {
        return new PagosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        mViewModel = new ViewModelProvider(this).get(PagosViewModel.class);
        binding = PagosFragmentBinding.inflate(inflater,container,false);
      View root = binding.getRoot();
      rv= binding.rvListaPagos;
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);
        rv.setLayoutManager(gridLayoutManager);
        mViewModel.getPagos().observe(getViewLifecycleOwner(), new Observer<List<Pago>>() {
            @Override
            public void onChanged(List<Pago> pagos) {
                Log.d("salida8","pasa por aca?");
                pa = new PagosAdapter(pagos,getContext(),inflater);
                rv.setAdapter(pa);
            }
        });
        mViewModel.getTvNoPagos().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.tvNoPagos.setVisibility(integer);
            }
        });
      mViewModel.ObtenerPagos(getArguments());
                return root;
    }



}