package br.com.tuning.phone.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id
	@Column
	@SequenceGenerator(name = "pk_product_sequence", sequenceName="product_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_product_sequence")
	private Integer id;
	
	@Column(length=50)
	private String name;
	
	@Column(precision=4, scale=2)
	private Number value_purchase;
	
	@Column(precision=4, scale=2)
	private Number value_sale;
	
	@Column(length=100)
	private String specifications;
	
	@Column(length=20)
	private String color;
	
	@Column(length=4)
	private Integer available_quantity; 
	
	@Column
	private Boolean status;
	
	@Column
	private Date creation_date;
	
	@OneToOne
	private Supplier provider;
	
	public Product() {

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

	public Number getValue_purchase() {
		return value_purchase;
	}

	public void setValue_purchase(Number value_purchase) {
		this.value_purchase = value_purchase;
	}

	public Number getValue_sale() {
		return value_sale;
	}

	public void setValue_sale(Number value_sale) {
		this.value_sale = value_sale;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getAvailable_quantity() {
		return available_quantity;
	}

	public void setAvailable_quantity(Integer available_quantity) {
		this.available_quantity = available_quantity;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Supplier getProvider() {
		return provider;
	}

	public void setProvider(Supplier provider) {
		this.provider = provider;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", value_purchase=");
		builder.append(value_purchase);
		builder.append(", value_sale=");
		builder.append(value_sale);
		builder.append(", specifications=");
		builder.append(specifications);
		builder.append(", color=");
		builder.append(color);
		builder.append(", available_quantity=");
		builder.append(available_quantity);
		builder.append(", status=");
		builder.append(status);
		builder.append(", provider=");
		builder.append(provider);
		builder.append("]");
		return builder.toString();
	}

}
