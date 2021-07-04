import java.security.Key;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Aes {
	private static final String ALGO = "AES";
	private byte[] keyvalue;
	
	private Aes(String key) {
		keyvalue = key.getBytes();
	}
	
	private Aes(String key) {
		keyvalue = key.getBytes();
	}
	
	public String decrypt (String encrypteddata) throws Exception {
		Key key = generatekey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.DECRYPT_MODE, key);
		byte[] decodedvalue = new BASE64Decoder().decodeBuffer(encrypteddata);
		byte[] decvalue = c.doFinal(decodedvalue);
		String decryptedvalue = new String(decvalue);
		return decryptedvalue;
	}
	
	public String encrypt (String Data) throws Exception {
		Key key = generatekey();
		Cipher c = Cipher.getInstance(ALGO);