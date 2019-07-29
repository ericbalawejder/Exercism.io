import java.util.stream.Collectors;

class RotationalCipher {

    private final int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        return data.chars()
                .mapToObj(x -> (char) x)
                .map(this::rotateCharacter)
                .map(x -> x.toString())
                .collect(Collectors.joining());
    }

    private char rotateCharacter(char character) {
        if (!Character.isAlphabetic((int) character)) {
            return character;
        } else {
            int letterCase = Character.isUpperCase(character) ? 'A' : 'a';
            return (char) (((int) character + shiftKey - letterCase) % 26 + letterCase);
        }
    }

}
