import java.util.Scanner;

public class Encrypt {

    public static String encrypt(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();
        shift = shift % 26; 
        
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                char encryptedChar = (char) ((c - base + shift) % 26 + base);
                encrypted.append(encryptedChar);
            } else {
                encrypted.append(c);  
            }
        }
        return encrypted.toString();
    }

    public static String decrypt(String text, int shift) {
        StringBuilder decrypted = new StringBuilder();
        shift = shift % 26;  
        
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                char decryptedChar = (char) ((c - base - shift + 26) % 26 + base);  
                decrypted.append(decryptedChar);
            } else {
                decrypted.append(c);  
            }
        }
        return decrypted.toString();
    }

    public static String bruteforce(String text) {
        StringBuilder bruteforced = new StringBuilder();
    
        for (int shift = 1; shift <= 25; shift++) {
            StringBuilder decryptedText = new StringBuilder();
            
            for (char c : text.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    char bruteforcedChar = (char) ((c - base - shift + 26) % 26 + base);  
                    decryptedText.append(bruteforcedChar);
                } else {
                    decryptedText.append(c);  
                }
            }
            bruteforced.append("Shift " + shift + ": " + decryptedText.toString() + "\n");
        }
        return bruteforced.toString();
    }

    public static void main(String[] args) {
        Scanner scanz = new Scanner(System.in);

        System.out.println("Welcome to JavEncryptor!");

        System.out.print("Encrypt (E) or Decrypt (D) or Bruteforce Decrypt (B): ");
        char input = scanz.next().charAt(0);

        scanz.nextLine(); 

        if (input == 'E' || input == 'e') {
            System.out.print("Enter word you want to encrypt: ");
            String text = scanz.nextLine();

            System.out.print("Enter custom key number: ");
            int shift = scanz.nextInt();

            String encryptedText = encrypt(text, shift);
            System.out.println("Encrypted Text: " + encryptedText);
        } else if (input == 'D' || input == 'd') {
            System.out.print("Enter word you want to decrypt: ");
            String text = scanz.nextLine();

            System.out.print("Enter key number: ");
            int shift = scanz.nextInt();

            String decryptedText = decrypt(text, shift);
            System.out.println("Decrypted Text: " + decryptedText);
        } else if (input == 'B' || input == 'b') {
            System.out.print("Enter encrypted text you want to bruteforce: ");
            String text = scanz.nextLine();  
            
            String bruteForceResults = bruteforce(text);
            System.out.println("Bruteforce Results: ");
            System.out.println(bruteForceResults);
        } else {
            System.out.println("Invalid option! Please enter 'E' for encryption or 'D' for decryption.");
        }

        scanz.close();
    }
}