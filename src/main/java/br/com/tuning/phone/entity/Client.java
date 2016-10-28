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
	
	@OneToOne
	private Document document;
	
	@OneToOne
	private Address address;
	
	@OneToOne
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
		builder.append("Client [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", nick_name=");
		builder.append(nick_name);
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
