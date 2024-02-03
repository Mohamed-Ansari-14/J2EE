package manyToOne.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company
{
	@Id
	private int id;
	private String name;
	private String gst;
	
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
	public String getGst() {
		return gst;
	}
	public void setGst(String gst) {
		this.gst = gst;
	}
	
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", gst=" + gst + "]";
	}
}
