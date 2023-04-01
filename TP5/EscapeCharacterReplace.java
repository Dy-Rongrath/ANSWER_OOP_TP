package TP5;

import java.util.Scanner;

public class EscapeCharacterReplace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a sentence: ");
        String input = scanner.nextLine();

        MessageCoder coder = new MessageCoder(input);
        String encodedMessage = coder.getEncodedMessage();

        String output = replaceEscapeCharacters(encodedMessage);
        System.out.println(output);

        String decodedMessage = coder.decode();

        System.out.println("Encoded message: " + encodedMessage);
        System.out.println("Output message: " + output);
        System.out.println("Decoded message: " + decodedMessage);
    }

    public static String replaceEscapeCharacters(String str) {
        str = str.replace("\\n", "(new_line)");
        str = str.replace("\\t", "(tab)");
        str = str.replace("\\\\", "(slash)");
        str = str.replace("//", "(comment_line)");
        str = str.replace(":)", "(smile)");
        return str;
    }
}
