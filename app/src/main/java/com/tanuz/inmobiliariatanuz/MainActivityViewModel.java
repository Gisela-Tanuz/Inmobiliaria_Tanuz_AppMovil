package com.tanuz.inmobiliariatanuz;



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


import com.tanuz.inmobiliariatanuz.modelo.Propietario;

import com.tanuz.inmobiliariatanuz.request.ApiRetroFit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData<Integer> ok;
    private MutableLiveData<Boolean> login;
    private MutableLiveData<Propietario> propietario;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.context= application.getApplicationContext();
   ;


    }

    public LiveData<Integer> getOk(){
        if(ok == null){
            ok= new MutableLiveData<>();
        }
        return ok;
    }
    public LiveData<Boolean> getLogin(){
        if(login == null){
            login = new MutableLiveData<>();
        }
        return  login;
    }
    public LiveData<Propietario> getPropietario(){
        if(propietario == null){
            propietario= new MutableLiveData<>();
        }
        return propietario;
    }

    public void Ingresar(String email, String clave){
        if (email != null && clave != null && email.length() > 0 && clave.length() > 0) {


            Call<String> callToken = ApiRetroFit.getMyApiClient().login(email,clave);
            callToken.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if(response.isSuccessful()){

                        SharedPreferences sharedPreferences = context.getSharedPreferences("dato.dat",0);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("token","Bearer " + response.body());
                        editor.commit();
                        login.postValue(true);
                        Log.d("salida",response.body()+"");
                        ok.postValue(View.INVISIBLE);
                    }
                    else{
                        ok.postValue(View.VISIBLE);
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(context, "Error "+t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}




