package br.com.tuning.phone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="contact")
public class Contact {
	
	@Id
	@Column
	@SequenceGenerator(name = "pk_contact_sequence", sequenceName="contact_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_contact_sequence")
	private Integer id;
	
	@Column(length=50)
	private String email_1;
	
	@Column(length=50)
	private String email_2;
	
	@Column(length=13)
	private Long phone_1;
	
	@Column(length=13)
	private Long phone_2;	
	
	@Column(length=150)
	private String observations;
	
	public Contact() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail_1() {
		return email_1;
	}

	public void setEmail_1(String email_1) {
		this.email_1 = email_1;
	}

	public String getEmail_2() {
		return email_2;
	}

	public void setEmail_2(String email_2) {
		this.email_2 = email_2;
	}

	public Long getPhone_1() {
		return phone_1;
	}

	public void setPhone_1(Long phone_1) {
		this.phone_1 = phone_1;
	}

	public Long getPhone_2() {
		return phone_2;
	}

	public void setPhone_2(Long phone_2) {
		this.phone_2 = phone_2;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contact {id:").append(id).append(", email_1:").append(email_1).append(", email_2:")
				.append(email_2).append(", phone_1:").append(phone_1).append(", phone_2:").append(phone_2)
				.append(", observations:").append(observations).append("}");
		return builder.toString();
	}

}
