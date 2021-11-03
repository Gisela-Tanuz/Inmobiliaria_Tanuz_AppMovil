package com.tanuz.inmobiliariatanuz.ui.CerrarSesion;

import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tanuz.inmobiliariatanuz.R;
import com.tanuz.inmobiliariatanuz.databinding.CerrarSesionFragmentBinding;
import com.tanuz.inmobiliariatanuz.databinding.ContratosFragmentBinding;

public class CerrarSesionFragment extends Fragment {



    private CerrarSesionFragmentBinding binding;

    public static CerrarSesionFragment newInstance() {
        return new CerrarSesionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

    binding = CerrarSesionFragmentBinding.inflate(inflater,container,false);
    View root = binding.getRoot();

    cerrarSesion();

    return root;
    }

    private void cerrarSesion(){
        new AlertDialog.Builder(getContext())
                .setTitle("Cerrar Sesión")
                .setMessage("¿ Desea salir de la aplicación ?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Navigation.findNavController((Activity) getContext(),R.id.nav_host_fragment_content_menu_navegable).navigate(R.id.nav_inicio);
                    }
                }).show();


    }




}