package com.demo.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.metamodel.binding.CascadeType;

@Entity
public class Teacher {

	private Integer id;
	private String name;
	private Set<Student> students = new HashSet<Student>();

	public Teacher(String name) {
		super();
		this.name = name;
	}

	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 10, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(cascade=CascadeType.REFRESH,mappedBy="teachers")
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
