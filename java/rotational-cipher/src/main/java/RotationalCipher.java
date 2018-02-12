// Create an implementation of the Caesar cipher.
class RotationalCipher
{
    private final int shiftKey;

    RotationalCipher(int shiftKey)
    {
        this.shiftKey = shiftKey;
    }

    String rotate(String data)
    {
        StringBuffer cipher = new StringBuffer();
        for (int i = 0; i < data.length(); i++)
        {
            if (Character.isUpperCase(data.charAt(i)))
            {
                char character = (char)(((int)data.charAt(i) + shiftKey - 65) % 26 + 65);
                cipher.append(character);
            }
            else if (Character.isLowerCase(data.charAt(i)))
            {
                char character = (char)(((int)data.charAt(i) + shiftKey - 97) % 26 + 97);
                cipher.append(character);
            }
            else
            {
                cipher.append(data.charAt(i));
            }
        }
        return cipher.toString();
    }
}
