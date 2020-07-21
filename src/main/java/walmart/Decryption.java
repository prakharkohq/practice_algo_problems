package walmart;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Base64;

public class Decryption
{
    private static final String ALGO = "AES";
    private static final byte[] KEYVALUE = new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't',
            'K', 'e', 'y' };

    public static void main(String[] args) throws GeneralSecurityException {
        System.out.println( decrypt());
    }
    private static String decrypt() throws GeneralSecurityException {
        String encryptedData = "2t_9XPmkyrC-GF9hiKl28Q";
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);

        Base64.Decoder urlDecoder = Base64.getUrlDecoder();
        byte[] decodedValue = urlDecoder.decode(encryptedData);
        System.out.println(new String(decodedValue));
        byte[] decryptedValueInBytes = c.doFinal(decodedValue);
        String decryptedValue = new String(decryptedValueInBytes);
        return decryptedValue;
    }

    private static Key generateKey() {
        Key key = new SecretKeySpec(KEYVALUE, ALGO);
        return key;
    }
}
