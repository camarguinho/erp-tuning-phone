package br.com.tuning.phone.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Client buyer;
	
	@Column(precision=4, scale=2)
	private Number amount;
	
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
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Product> products;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Taxes taxes;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Invoice invoice;
	
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Taxes getTaxes() {
		return taxes;
	}

	public void setTaxes(Taxes taxes) {
		this.taxes = taxes;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sale {id:").append(id).append(", buyer:").append(buyer).append(", amount:").append(amount)
				.append(", buyer_message:").append(buyer_message).append(", sale_date:").append(sale_date)
				.append(", status:").append(status).append(", tracking_code:").append(tracking_code)
				.append(", form_of_payment:").append(form_of_payment).append(", observations:").append(observations)
				.append(", sales_channel:").append(sales_channel).append(", value_of_shipment:")
				.append(value_of_shipment).append(", products:").append(products).append(", taxes:").append(taxes)
				.append(", invoice:").append(invoice).append("}");
		return builder.toString();
	}
	
}
