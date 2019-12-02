package it.uniupo.cypher;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class HMAC {

    public static byte[] hmac(byte[] key, String hashFun, byte[] message) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(hashFun);
        int n = messageDigest.getDigestLength();
        int b = 0;
        if(hashFun.equals("SHA-384") || hashFun.equals("SHA-512"))
            b = 128;
        else
            b = 64;
        if(key.length > b){
            key = messageDigest.digest(key);
        }
        byte[] pKey = Arrays.copyOf(key, b);

        byte[] iKeyPad = new byte[b];
        byte[] oKeyPad = new byte[b];
        for(int i = 0; i<b; i++){
            iKeyPad[i] = (byte) (pKey[i] ^ 0x36);
            oKeyPad[i] = (byte) (pKey[i] ^ 0x5c);
        }
        messageDigest.update(iKeyPad);
        byte[] digest = messageDigest.digest(message);
        messageDigest.update(oKeyPad);
        return messageDigest.digest(digest);
    }
}
