package br.com.tuning.phone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="taxes")
public class Taxes {
	
	@Id
	@Column
	@SequenceGenerator(name = "pk_taxes_sequence", sequenceName="taxes_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_taxes_sequence")
	private Integer id;
	
	@Column(precision=4, scale=2)
	private Number icms_base_calculation;
	
	@Column(precision=4, scale=2)
	private Number value_icms;
	
	@Column(precision=4, scale=2)
	private Number icms_subst_base_calculation;

	@Column(precision=4, scale=2)
	private Number value_icms_subst;
	
	@Column(precision=4, scale=2)
	private Number total_value_of_the_products;
	
	@Column(precision=4, scale=2)
	private Number cost_of_freight;
	
	@Column(precision=4, scale=2)
	private Number safe_price;
	
	@Column(precision=4, scale=2)
	private Number discount;

	@Column(precision=4, scale=2)
	private Number other_expenses;

	@Column(precision=4, scale=2)
	private Number value_ipi;
	
	@Column(precision=4, scale=2)
	private Number total_note_value;

	public Taxes() {
		
	}

	public Number getIcms_base_calculation() {
		return icms_base_calculation;
	}

	public void setIcms_base_calculation(Number icms_base_calculation) {
		this.icms_base_calculation = icms_base_calculation;
	}

	public Number getValue_icms() {
		return value_icms;
	}

	public void setValue_icms(Number value_icms) {
		this.value_icms = value_icms;
	}

	public Number getIcms_subst_base_calculation() {
		return icms_subst_base_calculation;
	}

	public void setIcms_subst_base_calculation(Number icms_subst_base_calculation) {
		this.icms_subst_base_calculation = icms_subst_base_calculation;
	}

	public Number getValue_icms_subst() {
		return value_icms_subst;
	}

	public void setValue_icms_subst(Number value_icms_subst) {
		this.value_icms_subst = value_icms_subst;
	}

	public Number getTotal_value_of_the_products() {
		return total_value_of_the_products;
	}

	public void setTotal_value_of_the_products(Number total_value_of_the_products) {
		this.total_value_of_the_products = total_value_of_the_products;
	}

	public Number getCost_of_freight() {
		return cost_of_freight;
	}

	public void setCost_of_freight(Number cost_of_freight) {
		this.cost_of_freight = cost_of_freight;
	}

	public Number getSafe_price() {
		return safe_price;
	}

	public void setSafe_price(Number safe_price) {
		this.safe_price = safe_price;
	}

	public Number getDiscount() {
		return discount;
	}

	public void setDiscount(Number discount) {
		this.discount = discount;
	}

	public Number getOther_expenses() {
		return other_expenses;
	}

	public void setOther_expenses(Number other_expenses) {
		this.other_expenses = other_expenses;
	}

	public Number getValue_ipi() {
		return value_ipi;
	}

	public void setValue_ipi(Number value_ipi) {
		this.value_ipi = value_ipi;
	}

	public Number getTotal_note_value() {
		return total_note_value;
	}

	public void setTotal_note_value(Number total_note_value) {
		this.total_note_value = total_note_value;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Taxes {id:").append(id).append(", icms_base_calculation:").append(icms_base_calculation)
				.append(", value_icms:").append(value_icms).append(", icms_subst_base_calculation:")
				.append(icms_subst_base_calculation).append(", value_icms_subst:").append(value_icms_subst)
				.append(", total_value_of_the_products:").append(total_value_of_the_products)
				.append(", cost_of_freight:").append(cost_of_freight).append(", safe_price:").append(safe_price)
				.append(", discount:").append(discount).append(", other_expenses:").append(other_expenses)
				.append(", value_ipi:").append(value_ipi).append(", total_note_value:").append(total_note_value)
				.append("}");
		return builder.toString();
	}
	
	
}
