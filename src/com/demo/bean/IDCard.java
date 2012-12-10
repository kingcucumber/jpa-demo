package com.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.metamodel.binding.CascadeType;

@Entity
public class IDCard {
	private Integer id;
	private String cardno;
	private Person person;

	
	public IDCard() {
		
	}
	

	public IDCard(String cardno) {
		super();
		this.cardno = cardno;
	}


	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToOne(mappedBy = "idcard", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REFRESH }, optional = false)
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Column(length = 18, nullable = false)
	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

}
