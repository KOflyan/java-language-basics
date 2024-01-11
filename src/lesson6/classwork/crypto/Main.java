package lesson6.classwork.crypto;

public class Main {
    public static void main(String[] args) {
        System.out.println("Why is the sky blue? Because the violet light waves are the longest. Why isn't it violet then? Hm...");
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
}
