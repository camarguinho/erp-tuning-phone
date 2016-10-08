package br.com.tuning.phone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="product_type")
public class ProductType {
	
	@Id
	@Column
	@SequenceGenerator(name = "pk_producttype_sequence", sequenceName="producttype_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_producttype_sequence")
	private Integer id;
	
	@Column(length=50)
	private String description_type;

	public ProductType() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription_type() {
		return description_type;
	}

	public void setDescription_type(String description_type) {
		this.description_type = description_type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductType [id=");
		builder.append(id);
		builder.append(", description_type=");
		builder.append(description_type);
		builder.append("]");
		return builder.toString();
	}
	
}
