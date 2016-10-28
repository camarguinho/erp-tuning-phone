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
	
	@Column(precision=4, scale=2)
	private Number amount;
	
	@Column(length=4)
	private Integer quantity;
	
	@Column(length=100)
	private String buyer_message;
	
	@Column
	private Date sale_date;
	
	@Column(length=20)
	private String status;
	
	@Column(length=30)
	private String tracking_code;
	
	@Column(length=25)
	private String form_of_payment;

	@Column(length=100)
	private String observations;
	
	@Column
	private String sales_channel;
	
	@Column(precision=4, scale=2)	
	private Number value_of_shipment;
	
	@OneToOne
	private Address delivery_address;
	
	@OneToOne
	private Address billing_address;
	
	@OneToMany
	private List<Product> products;
	
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

	public String getSales_channel() {
		return sales_channel;
	}

	public void setSales_channel(String sales_channel) {
		this.sales_channel = sales_channel;
	}

	public Number getValue_of_shipment() {
		return value_of_shipment;
	}

	public void setValue_of_shipment(Number value_of_shipment) {
		this.value_of_shipment = value_of_shipment;
	}

	public Address getDelivery_address() {
		return delivery_address;
	}

	public void setDelivery_address(Address delivery_address) {
		this.delivery_address = delivery_address;
	}

	public Address getBilling_address() {
		return billing_address;
	}

	public void setBilling_address(Address billing_address) {
		this.billing_address = billing_address;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sale [id=");
		builder.append(id);
		builder.append(", buyer=");
		builder.append(buyer);
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
		builder.append(", sales_channel=");
		builder.append(sales_channel);
		builder.append(", value_of_shipment=");
		builder.append(value_of_shipment);
		builder.append(", delivery_address=");
		builder.append(delivery_address);
		builder.append(", billing_address=");
		builder.append(billing_address);
		builder.append(", products=");
		builder.append(products);
		builder.append("]");
		return builder.toString();
	}


}
