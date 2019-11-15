package it.uniupo.cypher;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AES {

    public static SecretKey generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        return  keyGenerator.generateKey();
    }

    public static SecretKey generateKey(byte[] key) {
        return  new SecretKeySpec(key, "AES");
    }

    public static byte[] aesCtr(String inFilePath, String outFilePath, boolean mode, SecretKey key, byte[] iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, BadPaddingException, ShortBufferException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
        if(mode) {
            cipher.init(Cipher.ENCRYPT_MODE, key);
        }else{
            cipher.init( Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
        }


        Files.write(new File(outFilePath).toPath(),cipher.doFinal(Files.readAllBytes(new File(inFilePath).toPath())));
        return cipher.getIV();
    }
}
