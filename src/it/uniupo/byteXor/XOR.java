package it.uniupo.byteXor;

public class XOR {
    public static byte[] xorCipher(byte[] chiaro, byte[] chiave) {
        byte[] c = new byte[chiaro.length];
        for(int i = 0; i<chiaro.length; i++){
            c[i] = (byte) (chiaro[i] ^ chiave[i%chiave.length]);
        }
        return c;
    }
}
