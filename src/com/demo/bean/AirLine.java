package com.demo.bean;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class AirLine {
	private AirLinePK id;
	private String name;

	@EmbeddedId
	public AirLinePK getId() {
		return id;
	}

	

	public AirLine() {
		// TODO Auto-generated constructor stub
	}

	public void setId(AirLinePK id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
