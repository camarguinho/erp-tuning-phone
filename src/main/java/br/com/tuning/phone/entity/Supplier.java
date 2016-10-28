package br.com.tuning.phone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="supplier")
public class Supplier {
	
	@Id
	@Column
	@SequenceGenerator(name = "pk_supplier_sequence", sequenceName="supplier_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_supplier_sequence")
	private Integer id;
	
	@Column(length=100)
	private String company_name;
	
	@Column(length=50)
	private String fantasy_name;

	@Column(length=15)
	private Integer municipal_registration;
	
	@Column(length=15)
	private Integer state_registration;
	
	@Column(precision=8, scale=2)
	private Number capital_social;
	
	@OneToOne
	private Document document;
	
	@OneToOne
	private Address address;
	
	@OneToOne
	private Contact contact;
	
	public Supplier() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getFantasy_name() {
		return fantasy_name;
	}

	public void setFantasy_name(String fantasy_name) {
		this.fantasy_name = fantasy_name;
	}

	public Integer getMunicipal_registration() {
		return municipal_registration;
	}

	public void setMunicipal_registration(Integer municipal_registration) {
		this.municipal_registration = municipal_registration;
	}

	public Integer getState_registration() {
		return state_registration;
	}

	public void setState_registration(Integer state_registration) {
		this.state_registration = state_registration;
	}

	public Number getCapital_social() {
		return capital_social;
	}

	public void setCapital_social(Number capital_social) {
		this.capital_social = capital_social;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Supplier [id=");
		builder.append(id);
		builder.append(", company_name=");
		builder.append(company_name);
		builder.append(", fantasy_name=");
		builder.append(fantasy_name);
		builder.append(", municipal_registration=");
		builder.append(municipal_registration);
		builder.append(", state_registration=");
		builder.append(state_registration);
		builder.append(", capital_social=");
		builder.append(capital_social);
		builder.append(", document=");
		builder.append(document);
		builder.append(", address=");
		builder.append(address);
		builder.append(", contact=");
		builder.append(contact);
		builder.append("]");
		return builder.toString();
	}
	
}
