public class HelloWorld 
{
	public static String hello(String name) 
	{
		if(name == null || "".equals(name)) 
		{
			name = "World";
		}
		return "Hello, " + name + "!";
	}
}
