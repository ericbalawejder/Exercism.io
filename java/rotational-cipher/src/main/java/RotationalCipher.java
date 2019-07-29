import java.util.stream.Collectors;

class RotationalCipher {

    private final int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        return data.chars()
                .mapToObj(this::rotateCharacter)
                .collect(Collectors.joining());
    }

    private String rotateCharacter(int character) {
        if (!Character.isAlphabetic((int) character)) {
            return Character.toString(character);
        } else {
            int letterCase = Character.isUpperCase(character) ? 'A' : 'a';
            return Character.toString((((int) character + shiftKey - letterCase) % 26 + letterCase));
        }
    }

}
