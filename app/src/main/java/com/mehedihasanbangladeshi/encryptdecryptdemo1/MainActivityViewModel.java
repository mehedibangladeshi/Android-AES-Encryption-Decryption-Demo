package com.mehedihasanbangladeshi.encryptdecryptdemo1;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends AndroidViewModel {

    DataRepository dataRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        dataRepository = new DataRepository(application);
    }

    public String encrypt(String s, String pass){
        return dataRepository.encryptData(s, pass);
    }

    public String decrypt(String s, String pass){
        return dataRepository.decryptData(s, pass);
    }




}
