package com.tanuz.inmobiliariatanuz.ui.Inquilinos;

import android.app.Application;
import android.content.Context;

import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tanuz.inmobiliariatanuz.modelo.Contrato;


import com.tanuz.inmobiliariatanuz.request.ApiRetroFit;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InquilinosViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel
private MutableLiveData<List<Contrato>> contrato;
private MutableLiveData<Integer>tvNoInmueble;
private Context context;

    public InquilinosViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }

    public LiveData<List<Contrato>> getContrato(){
    if(contrato == null){
        contrato = new MutableLiveData<>();
    }
    return contrato;
}
    public LiveData<Integer> getNoInmueble(){
        if(tvNoInmueble == null){
            tvNoInmueble = new MutableLiveData<>();
        }
        return tvNoInmueble;
    }

public void obtenerPropAlquilada(){


    Call<List<Contrato>> inqPorProp = ApiRetroFit.getMyApiClient().InmueblePorContratos(ApiRetroFit.recuperarToken(context));
    inqPorProp.enqueue(new Callback<List<Contrato>>() {
        @Override
        public void onResponse(Call<List<Contrato>> call, Response<List<Contrato>> response) {
            if(response.isSuccessful()) {
                List<Contrato> list =  response.body();
                if (list.size() != 0) {
                    contrato.postValue(list);
                    tvNoInmueble.setValue(View.INVISIBLE);
                } else {
                    tvNoInmueble.setValue(View.VISIBLE);
                }
            }else{
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<List<Contrato>> call, Throwable t) {
            Toast.makeText(context, "Error "+t.getMessage(), Toast.LENGTH_LONG).show();
        }
    });
}


}