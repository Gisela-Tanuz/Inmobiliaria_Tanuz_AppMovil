package com.tanuz.inmobiliariatanuz.ui.Contratos;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.tanuz.inmobiliariatanuz.modelo.Contrato;
import com.tanuz.inmobiliariatanuz.modelo.Inmueble;

import com.tanuz.inmobiliariatanuz.request.ApiRetroFit;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContratosViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<List<Contrato>> contrato;
    private MutableLiveData<Integer>tvNoContrato;
    private Context context;
    public ContratosViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }


    public LiveData<List<Contrato>> getContrato(){
        if(contrato == null){
            contrato = new MutableLiveData<>();
        }
        return contrato;
    }
    public LiveData<Integer> getNoContrato(){
        if(tvNoContrato == null){
            tvNoContrato = new MutableLiveData<>();
        }
        return tvNoContrato;
    }
    public void  ObtenerInmPorContrato() {

        Call<List<Contrato>> datos = ApiRetroFit.getMyApiClient().InmueblePorContratos(ApiRetroFit.recuperarToken(context));
        datos.enqueue(new Callback<List<Contrato>>() {
            @Override
            public void onResponse(Call<List<Contrato>> call, Response<List<Contrato>> response) {
                if(response.isSuccessful()) {
                    if(response.body().size()>0){
                        contrato.postValue(response.body());
                        tvNoContrato.postValue(View.INVISIBLE);
                    }else{
                        tvNoContrato.postValue(View.VISIBLE);

                }
            }else {
                    Toast.makeText(context, "NO se enconto un contrato", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Contrato>> call, Throwable t) {
                Toast.makeText(context, "Error "+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}