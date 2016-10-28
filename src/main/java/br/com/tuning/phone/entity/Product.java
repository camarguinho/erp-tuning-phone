package br.com.tuning.phone.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Supplier supplier;
	
	@OneToOne
	private ProductType product_type;
	
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

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public ProductType getProductType() {
		return product_type;
	}

	public void setProductType(ProductType productType) {
		this.product_type = productType;
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
		builder.append(", creation_date=");
		builder.append(creation_date);
		builder.append(", supplier=");
		builder.append(supplier);
		builder.append(", productType=");
		builder.append(product_type);
		builder.append("]");
		return builder.toString();
	}

}
