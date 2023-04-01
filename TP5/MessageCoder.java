package TP5;

public class MessageCoder {
    private String encodedMessage;

    public MessageCoder(String message) {
        this.encodedMessage = encode(message);
    }

    public String getEncodedMessage() {
        return encodedMessage;
    }

    public String decode() {
        String[] parts = encodedMessage.split("_");
        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            int charCode = Integer.parseInt(part);
            char c = (char) charCode;
            sb.append(c);
        }
        return sb.toString();
    }

    private String encode(String message) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            int charCode = (int) message.charAt(i);
            sb.append(charCode).append("_");
        }
        return sb.toString();
    }
}
