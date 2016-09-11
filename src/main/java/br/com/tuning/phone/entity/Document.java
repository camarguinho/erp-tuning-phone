package br.com.tuning.phone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="document")
public class Document {

	@Id
	@Column
	@SequenceGenerator(name = "pk_document_sequence", sequenceName="document_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_document_sequence")
	private Integer id;
	
	@Column
	private String type;
	
	@Column(length=14)
	private Integer number;
	
	public Document() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Document [id=");
		builder.append(id);
		builder.append(", type=");
		builder.append(type);
		builder.append(", number=");
		builder.append(number);
		builder.append("]");
		return builder.toString();
	}
	
}
