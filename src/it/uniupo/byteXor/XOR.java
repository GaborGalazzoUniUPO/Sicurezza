package it.uniupo.byteXor;

public class XOR {
    public static byte[] xorCipher(byte[] chiaro, byte[] chiave) {
        byte[] c = new byte[chiaro.length];
        for(int i = 0; i<chiaro.length; i++){
            c[i] = (byte) (chiaro[i] ^ chiave[i%chiave.length]);
        }
        return c;
    }

    public static byte[] xor(byte[] arg1, byte[] arg2) {
        int len = Math.min(arg1.length, arg2.length);
        byte[] result = new byte[len];

        for(int i = 0; i < len; ++i) {
            result[i] = (byte)(arg1[i] ^ arg2[i]);
        }

        return result;
    }
}
