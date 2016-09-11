package br.com.tuning.phone.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="sale")
public class Sale {

	@Id
	@Column
	@SequenceGenerator(name = "pk_sale_sequence", sequenceName="sale_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_sale_sequence")
	private Integer id;
	
	@OneToOne
	private Client buyer;
	
	@OneToMany
	private List<Product> products;
	
	@Column
	private Number amount;
	
	@Column
	private Integer quantity;
	
	@Column
	private String buyer_message;
	
	@Column
	private Date sale_date;
	
	@Column
	private String status;
	
	@Column
	private String tracking_code;
	
	@Column
	private String form_of_payment;

	@Column
	private String observations;
	
	@OneToOne
	private Address delivery_address;
	
	public Sale() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Client getBuyer() {
		return buyer;
	}

	public void setBuyer(Client buyer) {
		this.buyer = buyer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Number getAmount() {
		return amount;
	}

	public void setAmount(Number amount) {
		this.amount = amount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getBuyer_message() {
		return buyer_message;
	}

	public void setBuyer_message(String buyer_message) {
		this.buyer_message = buyer_message;
	}

	public Date getSale_date() {
		return sale_date;
	}

	public void setSale_date(Date sale_date) {
		this.sale_date = sale_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTracking_code() {
		return tracking_code;
	}

	public void setTracking_code(String tracking_code) {
		this.tracking_code = tracking_code;
	}

	public String getForm_of_payment() {
		return form_of_payment;
	}

	public void setForm_of_payment(String form_of_payment) {
		this.form_of_payment = form_of_payment;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public Address getDelivery_address() {
		return delivery_address;
	}

	public void setDelivery_address(Address delivery_address) {
		this.delivery_address = delivery_address;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sale [id=");
		builder.append(id);
		builder.append(", buyer=");
		builder.append(buyer);
		builder.append(", products=");
		builder.append(products);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", buyer_message=");
		builder.append(buyer_message);
		builder.append(", sale_date=");
		builder.append(sale_date);
		builder.append(", status=");
		builder.append(status);
		builder.append(", tracking_code=");
		builder.append(tracking_code);
		builder.append(", form_of_payment=");
		builder.append(form_of_payment);
		builder.append(", observations=");
		builder.append(observations);
		builder.append(", delivery_address=");
		builder.append(delivery_address);
		builder.append("]");
		return builder.toString();
	}
	
}
