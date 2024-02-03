package dependencyInjection;

public class Laptop 
{
	private int id;
	private String name;
	
	private Charger charger;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Charger getCharger() {
		return charger;
	}
	public void setCharger(Charger charger) {
		this.charger = charger;
	}
	@Override
	public String toString() {
		return "Laptop [id=" + id + ", name=" + name + ", charger=" + charger + "]";
	}
}
