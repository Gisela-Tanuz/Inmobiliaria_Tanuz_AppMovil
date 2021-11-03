package com.tanuz.inmobiliariatanuz.ui.Perfil;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tanuz.inmobiliariatanuz.R;
import com.tanuz.inmobiliariatanuz.databinding.FragmentPerfilBinding;
import com.tanuz.inmobiliariatanuz.modelo.Propietario;


public class PerfilFragment extends Fragment {

    private PerfilViewModel perfilViewModel;
    private FragmentPerfilBinding binding;
    private EditText id,dni,nombre, apellido, email, clave, telefono, usuario;
    private ImageView foto;
    private Button editar ,guardar;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        perfilViewModel =
                new ViewModelProvider(this).get(PerfilViewModel.class);

        binding = FragmentPerfilBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        inicializar(root);
        perfilViewModel.getPropietario().observe(getViewLifecycleOwner(), new Observer<Propietario>() {

            @Override
            public void onChanged(Propietario propietarios) {
                id.setText(propietarios.getIdPropietario()+"");
                dni.setText(propietarios.getDni());
                nombre.setText(propietarios.getNombre());
                apellido.setText(propietarios.getApellido());
                email.setText(propietarios.getEmail());
                clave.setText(propietarios.getContraseña());
                telefono.setText(propietarios.getTelefono());
                usuario.setText(propietarios.getUsuario());
                //foto.setImageResource(Integer.parseInt(propietarios.getAvatarProp()));
                Glide.with(getActivity().getApplicationContext())
                        .load(propietarios.getUrlFotoProp())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)       // Llama la imagen remota y la carga en el cache,
                        .into(binding.ivAvatar);
            }
        });
        perfilViewModel.getEstadoEditable().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {

                dni.setEnabled(aBoolean);
                nombre.setEnabled(aBoolean);
                apellido.setEnabled(aBoolean);
                email.setEnabled(aBoolean);
                clave.setEnabled(false);
                telefono.setEnabled(aBoolean);
                usuario.setEnabled(aBoolean);


            }
        });
        perfilViewModel.getVisibleEditar().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                editar.setVisibility(integer);
            }
        });
        perfilViewModel.getVisibleGuardar().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                guardar.setVisibility(integer);
            }
        });
        perfilViewModel.ObtenerUsusario();


        return root;
    }
    private void inicializar(View v){

        id= v.findViewById(R.id.etId);
        dni=v.findViewById(R.id.etDni);
        nombre=v.findViewById(R.id.etNombre);
        apellido=v.findViewById(R.id.etApellido);
        email=v.findViewById(R.id.etMail);
        clave=v.findViewById(R.id.etPass);
        telefono= v.findViewById(R.id.etTelefono);
        foto= v.findViewById(R.id.ivAvatar);
        usuario = v.findViewById(R.id.etUsuarios);
        editar= v.findViewById(R.id.btEditar);
        guardar= v.findViewById(R.id.btGuardar);
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfilViewModel.cambiarEstado();
            }
        });
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Propietario p = new Propietario();
                p.setIdPropietario(Integer.parseInt(id.getText().toString()));
                p.setDni(dni.getText().toString());
                p.setNombre(nombre.getText().toString());
                p.setApellido(apellido.getText().toString());
                p.setEmail(email.getText().toString());
                p.setContraseña(clave.getText().toString());
                p.setTelefono(telefono.getText().toString());
                p.setUsuario(usuario.getText().toString());


                perfilViewModel.modificarDatos(p);


            }
        });


    }

   /* @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }*/
}