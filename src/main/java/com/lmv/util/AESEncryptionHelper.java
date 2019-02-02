package com.lmv.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public abstract class AESEncryptionHelper {
    private static String key = "Bar12345Bar12345"; // 128 bit key
    private static String initVector = "RandomInitVector"; // 16 bytes IV
    private static String UTF8 = "UTF-8";

    public static String encrypt(String value) {
        try {
            final IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(UTF8));
            final SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(UTF8), "AES");
            final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            byte[] encrypted = cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static String decrypt(String encrypted) {
        try {
            final IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(UTF8));
            final SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(UTF8), "AES");

            final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

}
