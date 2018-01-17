class Proverb
{
    public static void main(String[] args)
    {
        String[] poem  = new String[]{"nail", "shoe", "horse", "rider", "message", "battle", "kingdom"};
        Proverb proverb = new Proverb(poem);
        System.out.println(proverb.recite());
    }
    
    private final String[] words;

    Proverb(String[] words)
    {
        this.words = words;
    }

    String recite()
    {
        StringBuilder poem = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--)
        {
            if (i == 0)
            {
                String endLine = "And all for the want of a " + words[i] + ".";
                poem.append(endLine);
                break;
            }
            String line = "For want of a " + words[i - 1] + " the " + words[i] + " was lost.\n";
            poem.insert(0, line);
        }
        return poem.toString();
    }
}
