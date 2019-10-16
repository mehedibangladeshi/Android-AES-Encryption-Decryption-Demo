package com.mehedihasanbangladeshi.encryptdecryptdemo1;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class DataRepository {

    Application application;

    AES aes;
    MutableLiveData<List<String>> encryptedData;

    public DataRepository(Application application) {
        this.application = application;
    }

    public String encryptData(String data, String password){
        aes = new AES();
        try {
            return aes.encrypt(data, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public String decryptData(String data, String password){
        try {
            return aes.decrypt(data, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


}
