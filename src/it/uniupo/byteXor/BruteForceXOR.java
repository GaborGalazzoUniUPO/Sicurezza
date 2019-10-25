package it.uniupo.byteXor;

import it.uniupo.byteLib.BitStringGenerator;
import it.uniupo.byteLib.Tools;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.fail;

public class BruteForceXOR {

    private static final String PATH = "res/xorTest/";

    @Test
    public void bf3chars() throws IOException { // 1 s 542 ms
        byte[] c = Tools.readByteFlow(PATH+"fileLunghi3/OTP-3");

        byte[] key;

        HashMap<String, String> keyText = new HashMap<>();

        BitStringGenerator bitStringGenerator = new BitStringGenerator(3);
        do{
            key = bitStringGenerator.nextVal();
            if (Tools.isUText(XOR.xorCipher(c, key))) {
                keyText.put(Tools.byteToString(key), Tools.byteToString(XOR.xorCipher(c, key)));
            }
        }while(!bitStringGenerator.isMax());

        File outFile = new File(PATH + "fileLunghi3/OTP-3.out");
        FileWriter fw = new FileWriter(outFile);
        for (Map.Entry e :
                keyText.entrySet()) {
            fw.write(e.getKey() + "\t" + e.getValue() + "\n" );
        }
        fw.close();
    }

    @Test
    public void bf3x1chars() throws IOException { // 14 ms

        byte[] c = Tools.readByteFlow(PATH+"fileLunghi3/keystr-1x3");

        byte[] key;

        HashMap<String, String> keyText = new HashMap<>();

        BitStringGenerator bitStringGenerator = new BitStringGenerator(1);
        do{
            key = bitStringGenerator.nextVal();
            if (Tools.isUText(XOR.xorCipher(c, key))) {
                keyText.put(Tools.byteToString(key), Tools.byteToString(XOR.xorCipher(c, key)));
            }
        }while(!bitStringGenerator.isMax());

        File outFile = new File(PATH + "fileLunghi3/keystr-1x3.out");
        FileWriter fw = new FileWriter(outFile);
        for (Map.Entry e :
                keyText.entrySet()) {
            fw.write(e.getKey() + "\t" + e.getValue() + "\n" );
        }
        fw.close();
    }


    @Test
    public void bf4chars() throws IOException { // 3m 13s 187ms
        byte[] c = Tools.readByteFlow(PATH+"fileLunghi4/OTP-4");

        byte[] key;

        HashMap<String, String> keyText = new HashMap<>();

        BitStringGenerator bitStringGenerator = new BitStringGenerator(4);
        do{
            key = bitStringGenerator.nextVal();
            if (Tools.isUText(XOR.xorCipher(c, key))) {
                keyText.put(Tools.byteToString(key), Tools.byteToString(XOR.xorCipher(c, key)));
            }
        }while(!bitStringGenerator.isMax());

        File outFile = new File(PATH + "fileLunghi4/OTP-4.out");
        FileWriter fw = new FileWriter(outFile);
        for (Map.Entry e :
                keyText.entrySet()) {
            fw.write(e.getKey() + "\t" + e.getValue() + "\n" );
        }
        fw.close();
    }

    @Test
    public void bf4x1chars() throws IOException { // 21 ms


        byte[] c = Tools.readByteFlow(PATH+"fileLunghi4/keystr-1x4");

        byte[] key;

        HashMap<String, String> keyText = new HashMap<>();

        BitStringGenerator bitStringGenerator = new BitStringGenerator(1);
        do{
            key = bitStringGenerator.nextVal();
            if (Tools.isUText(XOR.xorCipher(c, key))) {
                keyText.put(Tools.byteToString(key), Tools.byteToString(XOR.xorCipher(c, key)));
            }
        }while(!bitStringGenerator.isMax());

        File outFile = new File(PATH + "fileLunghi4/keystr-1x4.out");
        FileWriter fw = new FileWriter(outFile);
        for (Map.Entry e :
                keyText.entrySet()) {
            fw.write(e.getKey() + "\t" + e.getValue() + "\n" );
        }
        fw.close();
    }
}
