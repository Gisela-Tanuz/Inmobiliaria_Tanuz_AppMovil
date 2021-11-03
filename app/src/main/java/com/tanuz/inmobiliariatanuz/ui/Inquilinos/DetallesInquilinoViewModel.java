package com.tanuz.inmobiliariatanuz.ui.Inquilinos;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;



import com.tanuz.inmobiliariatanuz.modelo.Inquilino;



public class DetallesInquilinoViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<Inquilino> inquilino;
    private Context context;

    public DetallesInquilinoViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<Inquilino> getInquilino(){
        if(inquilino == null){
            inquilino = new MutableLiveData<>();
        }
        return inquilino;
    }
    public void obtenerInquilino(Bundle bundle){

    Inquilino i = (Inquilino) bundle.getSerializable("inquilino");
    inquilino.setValue(i);

        }

}
