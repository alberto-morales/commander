package com.hpe.commander.util;

public interface EncDecrypter {

	/**
	 * Encrypts a string
	 *
	 * @param source
	 *
	 * @return encrypted data
	 */
	public String encrypt(String source);

	/**
	 * Decrypts a string
	 *
	 * @param source
	 *
	 * @return decrypted data
	 */
	public String decrypt(String source);

}
