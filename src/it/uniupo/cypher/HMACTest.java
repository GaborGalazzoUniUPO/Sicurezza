package it.uniupo.cypher;

import org.junit.Test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;

public class HMACTest {

    @Test
    public void hmac() throws NoSuchAlgorithmException, InvalidKeyException {
        String message = "Super Secret Message so long and so powerfuil like a mountain under the sea of Galahord";
        String sKey = "sdklfhfhjsdffno9e48ri34uhr3e3je3k34mk";
        Key k = new SecretKeySpec(sKey.getBytes(), "SHA-512");
        Mac mac = Mac.getInstance("HmacSHA512");
        mac.init(k);
        byte[] cHmac = mac.doFinal(message.getBytes());
        byte[] myHmac = HMAC.hmac(sKey.getBytes(), "SHA-512", message.getBytes());
        assertArrayEquals(cHmac, myHmac);
    }
}