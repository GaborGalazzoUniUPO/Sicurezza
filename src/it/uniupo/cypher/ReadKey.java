package it.uniupo.cypher;

import it.uniupo.byteLib.Tools;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class ReadKey {
    /*queste linee di codice leggono la chiave pubblica da un file in formato DER e la usano per generare una PublicKey*/

    public static PublicKey readPublicKey(String filename) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] encodedKey = Tools.readByteFlow(filename);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(new X509EncodedKeySpec(encodedKey));
    }

    /*queste linee di codice leggono la chiave privata da un file in formato DER e la usano per generare una PrivateKey*/

    public static PrivateKey readPrivateKey(String filename) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] encodedKey = Tools.readByteFlow(filename);//chiave.der
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
    }
}
