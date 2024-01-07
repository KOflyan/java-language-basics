Lesson 6
========

EX 1
----

1. Create an exception class called `IncorrectTimeException`. 
2. Create a class `Bus`. Create a method called `getDepartureTime()`, which asks user for an input and then returns
the next time from the file `data/bus_times.txt`. User input must match the format `hh:mm` and if it does not match it,
an exception should be thrown (`IncorrectTimeException` with message `Incorrect time: "{time}"!`).
Example:
* user input: `10:00`, expected output: `10:04`
* user input: `23.27`, expected output: `23:42`
* user input: `00:00`, expected output: `05:27`

The solution should work correctly with all bus_times files in `data` folder!

EX 2*
----

1. Your goal is to create different encryptors, which would be able to encrypt/decrypt the given message and save it to a file.
Check out the folder `crypto` and the interfaces there. In total, you will need to add 3 classes:
`RSAEncryptor`, `CaesarEncryptor` and `FileMessageProvider`, which implement the corresponding interfaces.
2. Add a `CaesarEncryptor` class which implements `IEncryptor` interface and uses [Caesar cipher](https://en.wikipedia.org/wiki/Caesar_cipher)
to encrypt and decrypt the message. You should only change letters, symbols must remain untouched! Examples:

```
CaesarEncryptor encryptor = new CaesarEncryptor();
System.out.println(
    encryptor.encrypt(
        "Why is the sky blue? Because the violet light waves are the longest. Why isn't it violet then? Hm...",
        7
    )
); // --> "Dof pz aol zrf isbl? Iljhbzl aol cpvsla spnoa dhclz hyl aol svunlza. Dof pzu'a pa cpvsla aolu? Ot..."

System.out.println(
    encryptor.decrypt(
        "Dof pz aol zrf isbl? Iljhbzl aol cpvsla spnoa dhclz hyl aol svunlza. Dof pzu'a pa cpvsla aolu? Ot...",
        7
    )
) // --> "Why is the sky blue? Because the violet light waves are the longest. Why isn't it violet then? Hm...";

```

3. Inspect existing `RSAEncryptor` class which implements [RSA encryption](https://en.wikipedia.org/wiki/RSA_(cryptosystem)). Fill in encrypt/decrypt methods.

Hint: Use Base64 encoding after encrypting, and base64 decoding before decrypting.

Hint: Good article with examples: https://www.baeldung.com/java-rsa

```
RSAEncryptor encryptor = new RSAEncryptor();

KeyPair keyPair = encryptor.generateKeyPair();

String message = encryptor.encrypt(
        "Why is the sky blue? Because the violet light waves are the longest. Why isn't it violet then? Hm...",
        keyPair.getPublic()
);

System.out.println(message); // --> "a90hlkPtTFaccAvKVhCzJPWuyTOrIZOios/u0vtOFRdobxfEj8L/MP4FetjNmskMx4ppyrky <rest of string>"
System.out.println(encryptor.decrypt(message, keyPair.getPrivate())); // --> "Why is the sky blue? Because the violet light waves are the longest. Why isn't it violet then? Hm..."
```

4. Create a class `FileMessageProvider` which implements the corresponding interface.
Depending on the method called, it should either encrypt or decrypt the message and write the result to a file.

```
FileMessageProvider p = new FileMessageProvider();

CaesarEncryptor caesarEncryptor = new CaesarEncryptor();

p.writeEncryptedMessage(
        new Message<>(
                "It's pretty cold outside.",
                25
        ),
        caesarEncryptor
); // --> Should create a file "encrypted.txt" with the following content: "Hs r oqdssx bnkc ntsrhcd."

p.writeDecryptedMessage(
        new Message<>(
                "Hs'r oqdssx bnkc ntsrhcd.",
                25
        ),
        caesarEncryptor
); // --> Should create a file "decrypted.txt" with the following content: "It s pretty cold outside."
```
