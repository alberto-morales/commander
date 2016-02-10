package com.hpe.commander.util.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hpe.commander.util.EncDecrypter;

import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.*;

public class EncDecrypterImpl implements EncDecrypter {

	/* (non-Javadoc)
	 * @see com.hpe.commander.util.EncDecrypter#decrypt(java.lang.String)
	 */
	@Override
	public String decrypt(String source) {
		String decryptedValue = null;
		try {
	        Key key = generateKey();
	        Cipher c = Cipher.getInstance(algorithm);
	        c.init(Cipher.DECRYPT_MODE, key);
	        byte[] decordedValue = new BASE64Decoder().decodeBuffer(source);
	        byte[] decValue = c.doFinal(decordedValue);
	        decryptedValue = new String(decValue);
		} catch (Exception e) {
			log.error("Error decrypting data", e);
			throw new RuntimeException(e);
		}
        return decryptedValue;
    }

	/* (non-Javadoc)
	 * @see com.hpe.commander.util.EncDecrypter#encrypt(java.lang.String)
	 */
	@Override
	public String  encrypt(String source) {
		String encryptedValue = null;
		try {
	        Key key = generateKey();
	        Cipher c = Cipher.getInstance(algorithm);
	        c.init(Cipher.ENCRYPT_MODE, key);
	        byte[] encVal = c.doFinal(source.getBytes());
	        encryptedValue = new BASE64Encoder().encode(encVal);
		} catch (Exception e) {
			log.error("Error encrypting data", e);
			throw new RuntimeException(e);
		}
        return encryptedValue;
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

	private static final byte[] keyValue =  new byte[] { 'F', 'I', 'F', 'T', 'Y', 'F', 'U',	'C', 'K', 'I', 'N','G', 'T', 'I', 'M', 'E', 'S' };
	private static final String algorithm = "AES" ;

	private static Log log = LogFactory.getLog(EncDecrypterImpl.class);

}
