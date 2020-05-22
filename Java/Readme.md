# Zuppy Secure Algorithm
 * Current Version 1.0
 * Platform: Java Implementation
 * For data Hashing, Encryption, Decryption, Signature Signing and Verification
 * No! more stress coding, easy to use and time saving.
 + Developed by Abel Akponine
    * Github: [Abel Akponine](https://github.com/abelakponine)
    * Instagram: [Kingabel.a](https://www.instagram.com/kingabel.a)
 
 ## Class Instance
 
 <b>ZuppySecure zuppy = new ZuppySecure();</b>
 
 ## Main Features
 1. KeyPair Generator
 
        Constructor: ZuppySecure(); // generates a new KeyPair and resets all field properties;
        Method: generateKeyPair(); // generates new KeyPair() without reseting field values;
    
 2. Cryptographic hashing
        
        /* This uses the MessageDigest class to generation hash strings */
        Method: zuppy.hash(String algo, String data); // algo represents the algorithm to be used for hashing, while data is the content to be hashed
        Supported Algorithms: All algorithms in "java.security.MessageDigest" is supporteed such as SHA-256, SHA-512, MD5, SHA1 etc.
    
 3. Data encryption & decryption
    Algorithms: AES-CBC, SHA-256
    
        /* It generates 256 bits hash for SecretKeySpec, using MessageDigest */
        /* Iv is generated from a concatinated key+salt, the key is generated and defined in the class library and can be modified from the source java file. replace the key value "9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08" in the class file */
        /* Encryption done by Cipher AES-CBC */
        /* Finally converts the returned encrypted data to Base64String */
        
        Method: zuppy.encrypt(String data, String salt); // this method returns a string, it is used for encrypting Strings.
        Method: zuppy.encrypt(byte[] data, String salt); // this method returns a string, it is used for encrypting byte[] arrays.
        Method: zuppy.decrypt(String data, String salt); // this method decrypts encrypted Base64String data and the supplied salt must be thesame as that used for encryption.
        method: zuppy.decrypt(String data, String salt, boolean convertToString); // this is an advance method for decryption, it allows us to choose whether the method should return String if (true) or return byte[] if (false)
    
 4. Signature signing and verification
 
        Method: zuppy.sign(String data, PrivateKey); // this is used to sign the input data and it returns an encrypted String of the signature
        Method: zuppy.verify(String data, String signature, PublicKey); // this method decrypts the encryption of the signature then verifies it, it returns a boolean (true|false)

5. Get PublicKey
       
       Method: zuppy.getKeyPair().getPublic(); // this method is used to retrieve publicKey from keyPair
    
