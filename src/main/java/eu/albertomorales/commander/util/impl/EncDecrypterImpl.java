package eu.albertomorales.commander.util.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import eu.albertomorales.commander.util.EncDecrypter;

import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.*;

public class EncDecrypterImpl implements EncDecrypter {

	/* (non-Javadoc)
	 * @see eu.albertomorales.commander.util.EncDecrypter#decrypt(java.lang.String)
	 */
	@Override
	public String decrypt(String source) {
		String decryptedValue = null;
		try {
	        Key key = generateKey();
	        Cipher c = Cipher.getInstance(algorithm);
	        c.init(Cipher.DECRYPT_MODE, key);
	        byte[] decodedValue = new BASE64Decoder().decodeBuffer(source);
	        byte[] decryptedData = c.doFinal(decodedValue);
	        decryptedValue = new String(decryptedData);
		} catch (Exception e) {
			log.error("Error decrypting data", e);
			throw new RuntimeException(e);
		}
        return decryptedValue;
    }

	/* (non-Javadoc)
	 * @see eu.albertomorales.commander.util.EncDecrypter#encrypt(java.lang.String)
	 */
	@Override
	public String  encrypt(String source) {
		String encodedValue = null;
		try {
	        Key key = generateKey();
	        Cipher c = Cipher.getInstance(algorithm);
	        c.init(Cipher.ENCRYPT_MODE, key);
	        byte[] encryptedData = c.doFinal(source.getBytes());
	        encodedValue = new BASE64Encoder().encode(encryptedData);
		} catch (Exception e) {
			log.error("Error encrypting data", e);
			throw new RuntimeException(e);
		}
        return encodedValue;
	}

    private static Key generateKey() throws Exception {
    	Key key =  null;
    	try {
    		key = new SecretKeySpec(keyValue, algorithm);
		} catch (Exception e) {
			log.error("Error generating key", e);
			throw new RuntimeException(e);
		}
        return key;
    }

	private static final byte[] keyValue =  new byte[] { 'F', 'o', 'u', 'r',
														 'F', 'u',	'c', 'k', 'i', 'n','g',
														 'T', 'i', 'm', 'e', 's' };
	private static final String algorithm = "AES" ;

	private static Log log = LogFactory.getLog(EncDecrypterImpl.class);

}
