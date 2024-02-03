package student.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentDto 
{
	@Id
	private int stuId;
	private String name;
	private String address;
	
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "StudentDto [stuId=" + stuId + ", name=" + name + ", address=" + address + "]";
	}
}
