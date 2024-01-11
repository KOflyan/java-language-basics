package lesson6.classwork.crypto;

import lesson6.classwork.crypto.encryptor.CaesarEncryptor;
import lesson6.classwork.crypto.encryptor.RSAEncryptor;

import java.io.IOException;
import java.security.KeyPair;

public class Main {
    public static void main(String[] args) {
        printMessage();
        System.out.println("//////////////");
        caesarCypherOutput();
        System.out.println("//////////////");
        rsaEncryptedOutput();
        System.out.println("//////////////");
        fileMessageProviderOutput();
    }

    private static void printMessage() {
        System.out.println("Why is the sky blue? Because the violet light waves are the longest. Why isn't it violet then? Hm...");
    }

    private static void caesarCypherOutput() {
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
        ); // --> "Why is the sky blue? Because the violet light waves are the longest. Why isn't it violet then? Hm...";

    }

    private static void rsaEncryptedOutput() {
        RSAEncryptor encryptor = new RSAEncryptor();

        KeyPair keyPair = encryptor.generateKeyPair();

        String message = encryptor.encrypt(
                "Why is the sky blue? Because the violet light waves are the longest. Why isn't it violet then? Hm...",
                keyPair.getPublic()
        );

        System.out.println(message); // --> "a90hlkPtTFaccAvKVhCzJPWuyTOrIZOios/u0vtOFRdobxfEj8L/MP4FetjNmskMx4ppyrky <rest of string>"
        System.out.println(encryptor.decrypt(message, keyPair.getPrivate())); // --> "Why is the sky blue? Because the violet light waves are the longest. Why isn't it violet then? Hm..."
    }
    private static void fileMessageProviderOutput()  {
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
    }
}
