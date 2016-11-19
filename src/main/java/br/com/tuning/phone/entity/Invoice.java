package br.com.tuning.phone.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="invoice")
public class Invoice {

	@Id
	@Column
	@SequenceGenerator(name = "pk_invoice_sequence", sequenceName="invoice_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_invoice_sequence")
	private Integer id;
	
	@Column(length=7)
	private String type;
	
	@Column(length=10)
	private Integer number;
	
	@Column(length=2)
	private Short serie;
	
	@Column(length=2)
	private Short sheet;
	
	@Column(length=75)
	private String access_key;
	
	@Column(length=6)
	private String operation_type;
	
	@Column(length=15)
	private Number use_auth_protocol;
	
	@Column(length=8)
	private Number cfop;
	
	private Date date_of_issue;
	
	private Date input_output_date;
	
	public Invoice(){
		
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

	public Short getSerie() {
		return serie;
	}

	public void setSerie(Short serie) {
		this.serie = serie;
	}

	public Short getSheet() {
		return sheet;
	}

	public void setSheet(Short sheet) {
		this.sheet = sheet;
	}

	public String getAccess_key() {
		return access_key;
	}

	public void setAccess_key(String access_key) {
		this.access_key = access_key;
	}

	public String getOperation_type() {
		return operation_type;
	}

	public void setOperation_type(String operation_type) {
		this.operation_type = operation_type;
	}

	public Number getUse_auth_protocol() {
		return use_auth_protocol;
	}

	public void setUse_auth_protocol(Number use_auth_protocol) {
		this.use_auth_protocol = use_auth_protocol;
	}

	public Number getCfop() {
		return cfop;
	}

	public void setCfop(Number cfop) {
		this.cfop = cfop;
	}

	public Date getDate_of_issue() {
		return date_of_issue;
	}

	public void setDate_of_issue(Date date_of_issue) {
		this.date_of_issue = date_of_issue;
	}

	public Date getInput_output_date() {
		return input_output_date;
	}

	public void setInput_output_date(Date input_output_date) {
		this.input_output_date = input_output_date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Invoice {id:").append(id).append(", type:").append(type).append(", number:").append(number)
				.append(", serie:").append(serie).append(", sheet:").append(sheet).append(", access_key:")
				.append(access_key).append(", operation_type:").append(operation_type).append(", use_auth_protocol:")
				.append(use_auth_protocol).append(", cfop:").append(cfop).append(", date_of_issue:")
				.append(date_of_issue).append(", input_output_date:").append(input_output_date).append("}");
		return builder.toString();
	}

	
}
