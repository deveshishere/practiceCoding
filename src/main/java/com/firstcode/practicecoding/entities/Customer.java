package com.firstcode.practicecoding.entities;
import javax.persistence.*;

@Entity
@Table(name="Customer_1")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String code;
	private String name;
	private String type;

	public Customer(long id, String code, String name, String type) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.type = type;
	}
	public Customer(){

	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
