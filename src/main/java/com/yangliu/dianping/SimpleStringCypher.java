package com.yangliu.dianping;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;


public class SimpleStringCypher {
    private byte[] linebreak = {};
    private String secret;
    private SecretKey key;
    private Cipher cipher;
    private Base64 coder;

    public SimpleStringCypher(String secret) {
        try {
            coder = new Base64(32, linebreak, true);
            byte[] secrets = coder.decode(secret);
            key = new SecretKeySpec(secrets, "AES");
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding", "SunJCE");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    //对推送消息中content进行加密
    public synchronized String encrypt(String plainText) throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherText = cipher.doFinal(plainText.getBytes());
        return new String(coder.encode(cipherText));
    }

    //对返回结果的content进行解密
    public synchronized String decrypt(String codedText) throws Exception {
        byte[] encypted = coder.decode(codedText.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(encypted);
        return new String(decrypted, "UTF-8");
    }

    public static void main(String[] args) {
        String appKey = "xvAgiGt96AUlNREjeGp6Tw";
        SimpleStringCypher cypher = new SimpleStringCypher(appKey);
        try {
            System.out.println(cypher.decrypt(" dZvtxaSeFWP7KKHyhg1pEs6oBD-gnMMVECjeizqnwG6mTGbPWy3qrOapDzw6pgzcXi9_q9OmBHdAaCpNooQz_5RIbwIUrwM3B0C0gEFEbi570ObzR_-QhirXhFA02w-rL-lFjh7Z5STkSF5elFabtoWYxOMHi5iR-k3SbUmokAhS3gvEg4GHxal4WpjpVANe8pOkGYYR_lHeBYSqyXPTlZR5l2jJw6jPBs4QY_SP0d7q3GxxB_Otnn5rWMMkhtk5KujIOe4ZtCV76omcvPoZK-gNlSaz111kWWlCnnw1f1j7vqW8fG6fXLLxy2QV6jiXun3ZiF3wP6Ba0aWLSQ3TUkFWXg9jjccMNRNNeUAkv20SzdhVD6v_VowTdAfBndEt"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
