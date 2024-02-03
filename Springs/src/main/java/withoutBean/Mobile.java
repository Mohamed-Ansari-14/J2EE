package withoutBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Mobile 
{
	@Value("1")
	private int id;
	@Value("Vivo")
	private String name;
	
	@Autowired //-->it will inject other class object to this class object
	private Charger charger;

//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public Charger getCharger() {
//		return charger;
//	}
//	public void setCharger(Charger charger) {
//		this.charger = charger;
//	}
	@Override
	public String toString() {
		return "Mobile [id=" + id + ", name=" + name + ", charger=" + charger + "]";
	}
}
