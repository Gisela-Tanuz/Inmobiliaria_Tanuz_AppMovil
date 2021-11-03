package com.tanuz.inmobiliariatanuz.ui.Inicio;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InicioViewModel extends AndroidViewModel {

    private MutableLiveData<String> mText;
    private Context context;
    public InicioViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }


    public LiveData<String> getText() {
        return mText;
    }
}