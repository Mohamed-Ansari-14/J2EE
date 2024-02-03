package constructorInjection;

public class Mobile 
{
	private int id;
	private String name;
	private String color;
	
	public Mobile(int id, String name, String color) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
	}
	@Override
	public String toString() {
		return "Mobile [id=" + id + ", name=" + name + ", color=" + color + "]";
	}
}
