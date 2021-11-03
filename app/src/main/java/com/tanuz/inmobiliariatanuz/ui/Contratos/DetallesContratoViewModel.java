package com.tanuz.inmobiliariatanuz.ui.Contratos;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.tanuz.inmobiliariatanuz.modelo.Contrato;
import com.tanuz.inmobiliariatanuz.request.ApiRetroFit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


//import com.tanuz.inmobiliariatanuz.request.ApiClient;


public class DetallesContratoViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel
     private MutableLiveData<Contrato> contrato;
     private Context context;

    public DetallesContratoViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }




   public LiveData<Contrato> getContrato() {
        if (contrato == null) {
            contrato = new MutableLiveData<>();
        }
        return contrato;
    }


    public void ObtenerContrato(Bundle bundle) {

        Contrato c = (Contrato) bundle.getSerializable("Contrato");
        contrato.setValue(c);
    }

}