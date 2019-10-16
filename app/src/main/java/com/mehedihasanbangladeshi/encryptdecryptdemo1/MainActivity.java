    package com.mehedihasanbangladeshi.encryptdecryptdemo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;

import com.mehedihasanbangladeshi.encryptdecryptdemo1.databinding.ActivityMainBinding;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

    public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MainActivityViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

    binding.btnEncrypt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            try {

                String msg = viewModel.encrypt(binding.text.getText().toString(), binding.pass.getText().toString());

                binding.msg.setText(msg);
                binding.text.getText().clear();
                binding.pass.getText().clear();
            }catch (Exception e){
                e.printStackTrace();
            }


        }
    });

    binding.btnDecrypt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try {

                String msg = viewModel.decrypt(binding.text.getText().toString(), binding.pass.getText().toString());

                if (msg.isEmpty()){

                }
                binding.msg.setText(msg);
                binding.text.getText().clear();
                binding.pass.getText().clear();

            }catch (Exception e){
                e.printStackTrace();
            }

        }
    });

    binding.msg.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (binding.msg.getText().length() != 0){
                binding.text.setText(binding.msg.getText().toString());
            }
        }
    });




    }


//    private SecretKeySpec generateKey(String password) throws Exception{
//        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
//        byte[] bytes = password.getBytes(StandardCharsets.UTF_8);
//        digest.update(bytes, 0, bytes.length);
//        byte[] key = digest.digest();
//        return new SecretKeySpec(key, "AES");
//
//    }
//
//    private String encrypt(String toBeEncriptedText, String password) throws Exception {
//
//        SecretKeySpec keySpec = generateKey(password);
//        Cipher cipher = Cipher.getInstance("AES");
//        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
//        byte[] encValue = cipher.doFinal(toBeEncriptedText.getBytes());
//        return new String(Base64.encodeToString(encValue, Base64.DEFAULT));
//
//
//
//    }
//
//        public String dencrypt(String toBeDectriptedText, String password) throws Exception {
//
//                SecretKeySpec keySpec = generateKey(password);
//                Cipher cipher = Cipher.getInstance("AES");
//                cipher.init(Cipher.DECRYPT_MODE, keySpec);
//                byte[] decBytes = Base64.decode(toBeDectriptedText, Base64.DEFAULT);
//                byte[] decodedValue = cipher.doFinal(decBytes);
//
//                return new String(decodedValue);
//
//
//    }



}
