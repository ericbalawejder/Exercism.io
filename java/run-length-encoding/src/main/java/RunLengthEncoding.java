import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RunLengthEncoding {

    String encode(String string) {
        StringBuilder encoding = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            int characterRunLength = 1;
            while (i + 1 < string.length() && string.charAt(i) == string.charAt(i + 1)) {
                characterRunLength++;
                i++;
            }
            if (characterRunLength > 1) {
                encoding.append(characterRunLength);
            }
            encoding.append(string.charAt(i));
        }
        return encoding.toString();
    }

    String decode(String string) {
        StringBuilder decoding = new StringBuilder();
        Pattern pattern = Pattern.compile("[0-9]+|[\\s+a-zA-Z]");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            try {
                int number = Integer.parseInt(matcher.group());
                matcher.find();
                while (number != 0) {
                    decoding.append(matcher.group());
                    number--;
                }
            } catch (NumberFormatException e) {
                decoding.append(matcher.group());
            }
        }
        return decoding.toString();
    }

}
