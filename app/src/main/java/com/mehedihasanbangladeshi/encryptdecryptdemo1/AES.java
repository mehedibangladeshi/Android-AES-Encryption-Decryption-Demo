package com.mehedihasanbangladeshi.encryptdecryptdemo1;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    private final String AES = "AES";
    private final String SHA_256 = "SHA-256";

    public SecretKeySpec generateKey(String password) throws Exception{
        final MessageDigest digest = MessageDigest.getInstance(SHA_256);
        byte[] bytes = password.getBytes(StandardCharsets.UTF_8);
        digest.update(bytes, 0, bytes.length);
        byte[] key = digest.digest();
        return new SecretKeySpec(key, AES);

    }

    public String encrypt(String toBeEncriptedText, String password) throws Exception {

        SecretKeySpec keySpec = generateKey(password);
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encValue = cipher.doFinal(toBeEncriptedText.getBytes());
        return new String(Base64.encodeToString(encValue, Base64.DEFAULT));



    }

    public String decrypt(String toBeDectriptedText, String password) throws Exception {

        SecretKeySpec keySpec = generateKey(password);
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decBytes = Base64.decode(toBeDectriptedText, Base64.DEFAULT);
        byte[] decodedValue = cipher.doFinal(decBytes);

        return new String(decodedValue);

/*
*
*   Advance Encryption Standard
*
* */
    }



}
