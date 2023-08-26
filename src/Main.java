import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();
        String userInput = scanner.nextLine();
        int key = scanner.nextInt();
        switch (userChoice) {
            case "enc":
                System.out.println(encode(userInput, key));
            case "dec":
                System.out.println(decode(userInput, key));
        }
    }
    public static StringBuilder encode(String text, int shift) {
        StringBuilder encodedMessage = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char base = Character.isLowerCase(c) ? 'a' : 'A';
            if (Character.isLetter(c)) {
                c = (char) ((c - base + shift + 26) % 26 + base);
            }
            encodedMessage.append(c);
        }
        return encodedMessage;
    }

    public static StringBuilder decode(String text, int shift) {
        StringBuilder decodedMessage = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char base = Character.isLowerCase(c) ? 'a' : 'A';
            if (Character.isLetter(c)) {
                c = (char) ((c - base - shift + 26) % 26 + base);
            }
            decodedMessage.append(c);
        }
        return decodedMessage;
    }
}