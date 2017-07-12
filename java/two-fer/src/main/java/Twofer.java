// If the given name is "Alice", the result should be "One for Alice, one for me."
// If no name is given, the result should be "One for you, one for me."
public class Twofer 
{
    public String twofer(String name) 
    {
        return String.format("One for %s, one for me.", name == null ? "you" : name);
    }
}
