package service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordGenerator {
	
	public PasswordGenerator() {
		// TODO Auto-generated constructor stub
	}
	
	public String getSaltedHashedPassword(String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		String saltedPassword = "salt" + password;
		md.update(saltedPassword.getBytes(StandardCharsets.UTF_8));

		return String.format("%064x", new BigInteger(1, md.digest()));

	}
}
