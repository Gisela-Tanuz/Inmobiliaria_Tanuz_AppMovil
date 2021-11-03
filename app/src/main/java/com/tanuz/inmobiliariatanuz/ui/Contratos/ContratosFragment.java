package com.tanuz.inmobiliariatanuz.ui.Contratos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tanuz.inmobiliariatanuz.databinding.ContratosFragmentBinding;

import com.tanuz.inmobiliariatanuz.modelo.Contrato;

import java.util.List;

public class ContratosFragment extends Fragment {

    private ContratosViewModel mViewModel;
    private ContratosFragmentBinding binding;
    private RecyclerView rv;
    private ContratoAdapter ca;
    public static ContratosFragment newInstance() {
        return new ContratosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(ContratosViewModel.class);
        binding = ContratosFragmentBinding.inflate(inflater,container,false);
        View root = binding.getRoot();
        rv = binding.rvListaContratos;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        mViewModel.getContrato().observe(getViewLifecycleOwner(), new Observer<List<Contrato>>() {
            @Override
            public void onChanged(List<Contrato> contratos) {
                rv.setLayoutManager(gridLayoutManager);
                ca = new ContratoAdapter(contratos,getContext(),getLayoutInflater());
                rv.setAdapter(ca);
            }
        });
        mViewModel.getNoContrato().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.tvNoContratos.setVisibility(integer);
            }
        });
        mViewModel.ObtenerInmPorContrato();


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ContratosViewModel.class);
        // TODO: Use the ViewModel
    }

}