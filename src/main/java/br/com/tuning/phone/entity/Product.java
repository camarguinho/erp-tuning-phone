package br.com.tuning.phone.entity;

import java.util.Date;

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
@Table(name="product")
public class Product {

	@Id
	@Column
	@SequenceGenerator(name = "pk_product_sequence", sequenceName="product_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_product_sequence")
	private Integer id;
	
	@Column(length=50)
	private String name;
	
	@Column(length=8)
	private Long ncm;
	
	@Column(precision=4, scale=2)
	private Float value_purchase;
	
	@Column(precision=4, scale=2)
	private Float value_sale;
	
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
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Supplier supplier;
	
	@OneToOne(cascade = CascadeType.PERSIST)
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

	public Long getNcm() {
		return ncm;
	}

	public void setNcm(Long ncm) {
		this.ncm = ncm;
	}

	public Float getValue_purchase() {
		return value_purchase;
	}

	public void setValue_purchase(Float value_purchase) {
		this.value_purchase = value_purchase;
	}

	public Float getValue_sale() {
		return value_sale;
	}

	public void setValue_sale(Float value_sale) {
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

	public ProductType getProduct_type() {
		return product_type;
	}

	public void setProduct_type(ProductType product_type) {
		this.product_type = product_type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product {id:").append(id).append(", name:").append(name).append(", ncm:").append(ncm)
				.append(", value_purchase:").append(value_purchase).append(", value_sale:").append(value_sale)
				.append(", specifications:").append(specifications).append(", color:").append(color)
				.append(", available_quantity:").append(available_quantity).append(", status:").append(status)
				.append(", creation_date:").append(creation_date).append(", supplier:").append(supplier)
				.append(", product_type:").append(product_type).append("}");
		return builder.toString();
	}
	
	
	

}
