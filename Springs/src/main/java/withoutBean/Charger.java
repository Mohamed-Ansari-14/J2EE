package withoutBean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Charger
{
	@Value("1")
	private int id;
	@Value("Micro USB-Type")
	private String name;
	
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
	@Override
	public String toString() {
		return "Charger [id=" + id + ", name=" + name + "]";
	}
}
