package io.pivotal.demo.dbencrypt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

@Component
public class EncryptorConfiguration {

    private static final String AES = "AES";

    private static String secret;

    public EncryptorConfiguration(@Value("${dbencrypt.encryption-secret}") String secret) {
        this.secret = secret;
    }

    public static Cipher getEncryptionCipher() throws RuntimeException {

        try {
            Key key = new SecretKeySpec(secret.getBytes(), AES);
            Cipher cipher = Cipher.getInstance(AES);
            cipher.init(Cipher.ENCRYPT_MODE, key);

            return cipher;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Cipher getDecryptionCipher() throws RuntimeException {

        try {
            Key key = new SecretKeySpec(secret.getBytes(), AES);
            Cipher cipher = Cipher.getInstance(AES);
            cipher.init(Cipher.DECRYPT_MODE, key);

            return cipher;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}

