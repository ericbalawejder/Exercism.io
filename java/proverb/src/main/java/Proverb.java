// Proverb
class Proverb
{
    private final String[] words;

    Proverb(String[] words)
    {
        this.words = words;
    }

    String recite()
    {
        StringBuilder proverb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--)
        {
            if (i == 0)
            {
                String endLine = "And all for the want of a " + words[i] + ".";
                proverb.append(endLine);
                break;
            }
            String line = "For want of a " + words[i - 1] + " the " + words[i] + " was lost.\n";
            proverb.insert(0, line);
        }
        return proverb.toString();
    }
}
