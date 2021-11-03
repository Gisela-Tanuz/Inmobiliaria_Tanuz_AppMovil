package com.tanuz.inmobiliariatanuz.ui.Contratos;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import com.tanuz.inmobiliariatanuz.R;
import com.tanuz.inmobiliariatanuz.databinding.DetallesContratoFragmentBinding;
import com.tanuz.inmobiliariatanuz.modelo.Contrato;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DetallesContratoFragment extends Fragment {

    private DetallesContratoViewModel mViewModel;
    private DetallesContratoFragmentBinding binding;
    private PagosAdapter pa;


    @NonNull

    public static DetallesContratoFragment newInstance() {
        return new DetallesContratoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(DetallesContratoViewModel.class);
        binding = DetallesContratoFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mViewModel.getContrato().observe(getViewLifecycleOwner(), new Observer<Contrato>() {

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onChanged(Contrato contrato) {

                binding.tvCodigoCont.setText("Codigo: "+ contrato.getIdContrato());
                DateTimeFormatter dt= DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
                LocalDate ldI=LocalDate.parse(contrato.getFechaInicio(), dt);
                binding.tvFechInicio.setText("Fecha de inicial: "+ ldI.toString() );
                LocalDate ldF=LocalDate.parse(contrato.getFechaFin(), dt);
                binding.tvFechFin.setText("Fecha final: "+ ldF);
                binding.tvPrecioAlq.setText("Precio: "+ contrato.getInmueble().getPrecio());
                binding.tvInmueble.setText("Dirección: "+ contrato.getInmueble().getDireccion());
                binding.tvInquilino.setText("Nombre: "+ contrato.getInquilino().getNombre()+" "+contrato.getInquilino().getApellido() );
                binding.btPagos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("pagos",contrato);
                        Navigation.findNavController((Activity) getContext(), R.id.nav_host_fragment_content_menu_navegable).navigate(R.id.pagosFragment,bundle);
                    }

                });
            }
        });


        mViewModel.ObtenerContrato(getArguments());

        return root;

    }






}