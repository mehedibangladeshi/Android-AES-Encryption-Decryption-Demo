package com.mehedihasanbangladeshi.encryptdecryptdemo1;

import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    AES aes;

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
