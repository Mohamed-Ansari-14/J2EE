package propertyInjection;

public class Mobile 
{
//	public void used()
//	{
//		System.out.println("I am in User Method !!!");
//	}
	
	private int id;
	private String name;
	private String color;
	
	@Override
	public String toString() {
		return "Mobile [id=" + id + ", name=" + name + ", color=" + color + "]";
	}
}
