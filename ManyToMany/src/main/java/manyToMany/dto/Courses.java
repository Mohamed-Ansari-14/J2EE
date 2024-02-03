package manyToMany.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Courses 
{
	@Id
	private int id;
	private String name;
	private double fees;
	
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
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	
	@Override
	public String toString() {
		return "Courses [id=" + id + ", name=" + name + ", fees=" + fees + "]";
	}
}
