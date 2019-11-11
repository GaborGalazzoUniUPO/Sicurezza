package it.uniupo.cypher;

import org.junit.Test;

import javax.crypto.*;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;

public class AESTest {

    @Test
    public void aesCtr() throws NoSuchPaddingException, ShortBufferException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKey key = AES.generateKey();
        byte[] iv = AES.aesCtr("/home/20024195/workspace/sicurezza/res/test/aes/input.txt", "/home/20024195/workspace/sicurezza/res/test/aes/out.txt", true, key, null);
        assertTrue(new File("/home/20024195/workspace/sicurezza/res/test/aes/out.txt").exists());
        AES.aesCtr("/home/20024195/workspace/sicurezza/res/test/aes/out.txt", "/home/20024195/workspace/sicurezza/res/test/aes/scif.txt",false, key, iv);
        assertTrue(new File("/home/20024195/workspace/sicurezza/res/test/aes/scif.txt").exists());
    }
}