package br.com.tuning.phone.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	
	@Id
	@Column
	@SequenceGenerator(name = "pk_client_sequence", sequenceName="client_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_client_sequence")
	private Integer id;
	
	@Column(length=50)
	private String name;
	
	@Column(length=25)
	private String nick_name;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Document document;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Address billing_address;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Address delivery_address;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Contact contact;
	
	public Client() {

	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Address getBilling_address() {
		return billing_address;
	}

	public void setBilling_address(Address billing_address) {
		this.billing_address = billing_address;
	}

	public Address getDelivery_address() {
		return delivery_address;
	}

	public void setDelivery_address(Address delivery_address) {
		this.delivery_address = delivery_address;
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
		builder.append("Client {id:").append(id).append(", name:").append(name).append(", nick_name:").append(nick_name)
				.append(", document:").append(document).append(", billing_address:").append(billing_address)
				.append(", delivery_address:").append(delivery_address).append(", contact:").append(contact)
				.append("}");
		return builder.toString();
	}

	
}
