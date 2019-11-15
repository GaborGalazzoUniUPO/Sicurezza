package it.uniupo.cypher;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;

public class RSA {

    static{
        Security.addProvider(new BouncyCastleProvider());
    }

    public byte[] encryptRSA(Key chiave, byte[] clearText) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA/NONE/NoPadding", "BC");
        cipher.init(Cipher.ENCRYPT_MODE, chiave);
        return cipher.doFinal(clearText);

    }

    public byte[] decryptRSA(Key chiave, byte[] cipherText) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA/NONE/NoPadding", "BC");
        cipher.init(Cipher.DECRYPT_MODE, chiave);
        return cipher.doFinal(cipherText);
    }
}
