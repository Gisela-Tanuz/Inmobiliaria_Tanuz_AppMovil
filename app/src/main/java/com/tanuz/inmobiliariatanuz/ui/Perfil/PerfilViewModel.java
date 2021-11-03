package com.tanuz.inmobiliariatanuz.ui.Perfil;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tanuz.inmobiliariatanuz.modelo.Propietario;

import com.tanuz.inmobiliariatanuz.request.ApiRetroFit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PerfilViewModel extends AndroidViewModel {

    private MutableLiveData<Propietario> propietario;
    private MutableLiveData<Integer> visibleEditar;
    private MutableLiveData<Integer> visibleGuardar;
    private MutableLiveData<Boolean> estadoEditable;
    private Context context;

    public PerfilViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }


    public LiveData<Propietario> getPropietario() {

        if(propietario == null){
           propietario = new MutableLiveData<>();
        }

        return propietario;
    }
    public MutableLiveData <Integer> getVisibleEditar(){
        if(visibleEditar == null){
            visibleEditar = new MutableLiveData<>();
        }
        return visibleEditar;
    }
    public MutableLiveData <Integer> getVisibleGuardar(){
        if(visibleGuardar == null){
            visibleGuardar = new MutableLiveData<>();
        }
        return visibleGuardar;
    }
    public MutableLiveData<Boolean> getEstadoEditable(){
        if (estadoEditable == null){
            estadoEditable= new MutableLiveData<>();
        }
        return estadoEditable;
    }
    public void ObtenerUsusario() {

        Call<Propietario> callToken = ApiRetroFit.getMyApiClient().perfil(ApiRetroFit.recuperarToken(context));

        callToken.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                if (response.isSuccessful()) {

                    propietario.postValue(response.body());
                    Log.d("salida3",response.body()+"");
                }else{
                    Toast.makeText(context, "Error al cargar el usuario", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Propietario> call, Throwable t) {
                Toast.makeText(context, "Error "+ t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    public  void modificarDatos(Propietario prop){

        Call<Propietario> datos = ApiRetroFit.getMyApiClient().editarPerfil(ApiRetroFit.recuperarToken(context),prop);

        datos.enqueue(new Callback<Propietario>() {
       @Override

        public void onResponse(Call<Propietario> call, Response<Propietario> response) {
         if(response.isSuccessful()){

            propietario.postValue(response.body());
            visibleEditar.postValue(View.VISIBLE);
            visibleGuardar.postValue(View.INVISIBLE);
            estadoEditable.postValue(false);
            Toast.makeText(context, "Datos editados correctamente", Toast.LENGTH_LONG).show();
         }else {
            Toast.makeText(context, "Error al editar", Toast.LENGTH_SHORT).show();
         }
       }

        @Override
         public void onFailure(Call<Propietario> call, Throwable t) {
          Toast.makeText(context, "Error "+t.getMessage(), Toast.LENGTH_SHORT).show();
         }
       });


    }
    public void cambiarEstado(){
        estadoEditable.setValue(true);
        visibleEditar.setValue(View.INVISIBLE);
        visibleGuardar.setValue(View.VISIBLE);
    }
}