package it.uniupo.cypher;

import it.uniupo.byteLib.Tools;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

import static org.junit.Assert.*;

public class RSATest {

    @Test
    public void testRSA() throws IOException, InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchProviderException, NoSuchPaddingException {
        String plain = "thequickbrownfoxjumpsoverthelazydog";
        PublicKey publicKey = ReadKey.readPublicKey("/home/20024195/workspace/sicurezza/res/test/rsa/chiavePub.der");
        PrivateKey privateKey = ReadKey.readPrivateKey("/home/20024195/workspace/sicurezza/res/test/rsa/chiavePri.der");

        RSA rsa = new RSA();
        byte[] cifText = rsa.encryptRSA(publicKey, plain.getBytes());
        byte[] plainText = rsa.decryptRSA(privateKey, cifText);
        assertArrayEquals(plain.getBytes(), plainText);
        assertEquals(plain, new String(plainText));
    }

    @Test
    public void bfRSANoPadding() throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchProviderException, NoSuchPaddingException {
        RSA rsa = new RSA();
        PublicKey publicKey = ReadKey.readPublicKey("/home/20024195/workspace/sicurezza/res/test/rsa/attaccoRSAnopadding/pubkey.der");
        byte[] msg = Tools.readByteFlow("/home/20024195/workspace/sicurezza/res/test/rsa/attaccoRSAnopadding/messaggio");
        for(byte[] c: Tools.readFileToArrayListOfBytes("/home/20024195/workspace/sicurezza/res/test/rsa/attaccoRSAnopadding/ftsemib.txt")){
            if(Arrays.equals(rsa.encryptRSA(publicKey, c), msg)){
                System.out.println(new String(c));
                assertTrue(true);
                return;
            }
        }
        fail();
    }

}