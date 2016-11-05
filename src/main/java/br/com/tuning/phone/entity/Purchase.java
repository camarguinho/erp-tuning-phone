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
@Table(name="purchase")
public class Purchase {
	
	@Id
	@Column
	@SequenceGenerator(name = "pk_purchase_sequence", sequenceName="purchase_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_purchase_sequence")
	private Integer id;
	
	@OneToOne
	private Supplier supplier;
	
	@Column(precision=4, scale=2)
	private Number amount;
		
	@Column
	private Date purchase_date;
	
	@Column(length=20)
	private String status;
	
	@Column(length=30)
	private String tracking_code;
	
	@Column(length=25)
	private String form_of_payment;

	@Column(length=100)
	private String observations;
	
	@Column(precision=4, scale=2)	
	private Number value_of_shipment;
	
	@OneToMany
	private List<Product> products;
	
	@OneToOne
	private Taxes taxes;
	
	@OneToOne
	private Invoice invoice;
	
	public Purchase(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Number getAmount() {
		return amount;
	}

	public void setAmount(Number amount) {
		this.amount = amount;
	}

	public Date getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
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
		
}
