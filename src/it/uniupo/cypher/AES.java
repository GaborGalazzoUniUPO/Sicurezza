package it.uniupo.cypher;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AES {

    public static SecretKey generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        return  keyGenerator.generateKey();
    }

    public static SecretKey generateKey(byte[] key) {
        return  new SecretKeySpec(key, "AES");
    }

    public static void aesCtr(String inFilePath, String outFilePath, boolean mode, SecretKey key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, BadPaddingException, ShortBufferException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
        cipher.init(mode?Cipher.ENCRYPT_MODE:Cipher.DECRYPT_MODE, key);

        RandomAccessFile inFile = new RandomAccessFile(
                inFilePath,"r");
        FileChannel inChannel = inFile.getChannel();
        ByteBuffer inBuffer = ByteBuffer.allocate((int) inChannel.size());
        inChannel.read(inBuffer);

        RandomAccessFile outFile = new RandomAccessFile(
                outFilePath,"rw");
        FileChannel outChannel = outFile.getChannel();
        ByteBuffer outBuffer = ByteBuffer.allocate((int) outChannel.size());
        outChannel.write(outBuffer);

        cipher.doFinal(inBuffer, outBuffer);
    }
}
