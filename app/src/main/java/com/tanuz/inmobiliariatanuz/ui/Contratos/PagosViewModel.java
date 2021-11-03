package com.tanuz.inmobiliariatanuz.ui.Contratos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.tanuz.inmobiliariatanuz.modelo.Contrato;
import com.tanuz.inmobiliariatanuz.modelo.Pago;
import com.tanuz.inmobiliariatanuz.request.ApiRetroFit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PagosViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<List<Pago>> pagos;
    private MutableLiveData<Integer>tvNoPagos;
    private Context context;

    public PagosViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }


   public LiveData<List<Pago>> getPagos(){
        if(pagos == null){
            pagos= new MutableLiveData<>();
        }
        return pagos;
    }
    public LiveData<Integer> getTvNoPagos(){
        if(tvNoPagos == null){
            tvNoPagos= new MutableLiveData<>();
        }
        return tvNoPagos;
    }

  public void ObtenerPagos(Bundle bundle) {
      Contrato contrato = (Contrato) bundle.getSerializable("pagos");
      Call<List<Pago>> lista = ApiRetroFit.getMyApiClient().listaDePagos(ApiRetroFit.recuperarToken(context),contrato.getIdContrato());
      Log.d("salida9",contrato.getIdContrato()+"pasa??");
      lista.enqueue(new Callback<List<Pago>>() {
          @Override
          public void onResponse(Call<List<Pago>> call, Response<List<Pago>> response) {
              if(response.isSuccessful()){

                  if(response.body().size()>0){
                      pagos.postValue(response.body());
                      tvNoPagos.postValue(View.INVISIBLE);
                  }else{
                      tvNoPagos.postValue(View.VISIBLE);
                  }
              }else{
                  Toast.makeText(context, "No hay pagos", Toast.LENGTH_SHORT).show();
              }
          }

          @Override
          public void onFailure(Call<List<Pago>> call, Throwable t) {
              Toast.makeText(context, "Error "+t.getMessage(), Toast.LENGTH_SHORT).show();
          }
      });
  }
}