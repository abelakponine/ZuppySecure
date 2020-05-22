package org.zuppy.secure;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SignatureException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Main {
	
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, SignatureException {
		ZuppySecure zuppy = new ZuppySecure();
		String hash = zuppy.hash("sha-256","ZuppySecure");
		String encryption = zuppy.encrypt("Hello World!", "ZuppySecure");
		String signedData = zuppy.sign("Hello World", zuppy.getKeyPair().getPrivate());
		PublicKey publicKey = zuppy.getKeyPair().getPublic();
		// Use case example
		System.out.println("\n"
				+"Generate KeyPair: "+zuppy.generateKeyPair()
				+"\nSHA-256: "+hash
				+"\nPublic Key: "	+zuppy.getPublicKey()
				+"\nEncrypted: "	+encryption
				+"\nDecrypted: "	+zuppy.decrypt(encryption, "ZuppySecure")
				+"\nSignature: "	+signedData
				+"\nVerification: "	+zuppy.verify("Hello World", signedData, publicKey));
	}
}
