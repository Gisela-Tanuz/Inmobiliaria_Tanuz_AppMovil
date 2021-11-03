package com.tanuz.inmobiliariatanuz.ui.Inmuebles;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tanuz.inmobiliariatanuz.modelo.Inmueble;

import com.tanuz.inmobiliariatanuz.request.ApiRetroFit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DetalleInmuebleViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<Inmueble> inmuebles;
    private Context contex;
    public DetalleInmuebleViewModel(@NonNull Application application) {
        super(application);
        contex = application.getApplicationContext();

    }


    public LiveData<Inmueble> getInmueble(){
        if(inmuebles == null){
            inmuebles = new MutableLiveData<>();
        }
        return inmuebles;
    }
    public void obtenerInmuebles(Bundle bundle){
        Inmueble i = (Inmueble) bundle.getSerializable("inmueble");
        inmuebles.setValue(i);

    }

    public void guardarCambios(Bundle bundle){
       Inmueble i = (Inmueble) bundle.getSerializable("inmueble");

        Call<Inmueble> datos = ApiRetroFit.getMyApiClient().modificarEstado(ApiRetroFit.recuperarToken(contex), i.getIdInmueble());
        datos.enqueue(new Callback<Inmueble>() {
            @Override
            public void onResponse(Call<Inmueble> call, Response<Inmueble> response) {
                if (response.isSuccessful()){
                    inmuebles.postValue(response.body());
                    Toast.makeText(contex,"Cambios guardados", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(contex,"No se realizo el cambio", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Inmueble> call, Throwable t) {
                Toast.makeText(contex, "Error "+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}