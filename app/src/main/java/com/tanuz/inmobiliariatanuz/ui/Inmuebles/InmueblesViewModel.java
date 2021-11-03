package com.tanuz.inmobiliariatanuz.ui.Inmuebles;

import android.app.Application;
import android.content.Context;


import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.tanuz.inmobiliariatanuz.modelo.Inmueble;

import com.tanuz.inmobiliariatanuz.request.ApiRetroFit;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InmueblesViewModel extends AndroidViewModel {

    private MutableLiveData<List<Inmueble>> inmueble;
    private MutableLiveData<Integer> tvNoInmueble;
    private Context context;

    public InmueblesViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();

    }

    public LiveData<List<Inmueble>> getInmueble(){
        if(inmueble == null){
            inmueble = new MutableLiveData<>();
        }
        return inmueble;
    }
    public LiveData<Integer> getTvNoInmueble(){
        if(tvNoInmueble == null){
            tvNoInmueble = new MutableLiveData<>();
        }
        return tvNoInmueble;
    }

    public void ObtenerListaInmueble(){

    Call<List<Inmueble>> listInmuebles = ApiRetroFit.getMyApiClient().listaInmuebles(ApiRetroFit.recuperarToken(context));
     listInmuebles.enqueue(new Callback<List<Inmueble>>() {
    @Override
    public void onResponse(Call<List<Inmueble>> call, Response<List<Inmueble>> response) {
        if (response.isSuccessful()) {
            List<Inmueble> list = response.body();
            if(response.body().size()>0){
                inmueble.postValue(response.body());
                tvNoInmueble.postValue(View.INVISIBLE);
            }else{
                tvNoInmueble.postValue(View.VISIBLE);
            }

        } else {
            Toast.makeText(context, "Error no se encontraron inmuebles", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<List<Inmueble>> call, Throwable t) {
        Toast.makeText(context, "Error "+t.getMessage(), Toast.LENGTH_LONG).show();
        Log.d("salida4", t.getMessage()+"");
    }
});

}
}