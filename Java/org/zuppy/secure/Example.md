<h1>Example code</h1>

<code>
	package org.zuppy.secure;

	import java.security.InvalidAlgorithmParameterException;
	import java.security.InvalidKeyException;
	import java.security.NoSuchAlgorithmException;
	import java.security.PublicKey;
	import java.security.SignatureException;
	import javax.crypto.BadPaddingException;
	import javax.crypto.IllegalBlockSizeException;
	import javax.crypto.NoSuchPaddingException;
</code>

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

## Output Result

	Generate KeyPair: java.security.KeyPair@4b6995df
	SHA-256: c208e78751368cef69afa0bcafd8977d92b6504bd31782a329ab706662b05ad4
	Public Key: MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAo3GATKpCd0pLgRHwNUdLPUCNLC6pmLNuHKQBQrioRnvowLT7G6oDq3wCnadYweNDa9iC9kCzYRJlPeQodcEza3sCOCYVhkeCYvc+tf9kYCshDQlaatCazMGCOPfRYqzViHA+8tIFq9/VF7BQdmaHaGwZkoOCyfQqUrjUiLxO3CXk4HmjcE3lmNZZ3/hgbSDTIaHVRJ27/2eVwQhxgTYxOGlRvJHMRS3Nzfo41sIXl2o52Us5r2BwnxWJqg0WcR+8JlFXP5ee9EFrjWeUXGhKwpPCRLz1EeRiUyvmRV9Iy8EB7M5dunMQCwA0NbjzYcXT6U4xddmMdCBd2snzDJUlGQIDAQAB
	Encrypted: NTs4pUe9o4hkAlQbKWKDKA==
	Decrypted: Hello World!
	Signature: Hd+i1WzqdhqwBW7ICedOBOlZuVJygdxQEXH/dM6zrHAZxP4PT7OrW/RjOevVEpkqJrZD6H9rlJb8gcvIfvzo7FaGQ3S6ihnqsobid+WsDg8vIHgDaLVaygCoH6EfO/1QUwN3qLpmRQArn5OjFaakVx6UiE+nkGRenwngu07CtNZtPXnlkFLi4jukpEVj0vOf4IWgMIwgkRZXjAW1QogBdZ2GGT0TkOb51X1tjDyxUOEx91H3f0NBbherN7xrW+BjMnJbfO9X1LaOIPdEjvl04zeKWZCLh3TlFKUNb4wejg0MSPyE5LUxOO4qVf05rVZ1ymz88fFY97Q23mkkBYUNAYM5b5q0PMq2mAw3lC88yIw=
	Verification: true
