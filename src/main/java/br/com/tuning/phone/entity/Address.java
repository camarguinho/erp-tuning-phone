package br.com.tuning.phone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@Column
	@SequenceGenerator(name = "pk_address_sequence", sequenceName="address_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_address_sequence")
	private Integer id;
	
	@Column(length=8)
	private Integer zip_code;
	
	@Column(length=50)
	private String address;
	
	@Column(length=8)
	private String number;
	
	@Column(length=25)
	private String complement;
	
	@Column(length=25)
	private String neighborhood;
	
	@Column(length=7)
	private Integer ibge_code;
	
	@Column(length=50)
	private String city;
	
	@Column(length=25)
	private String state;
	
	@Column(length=25)
	private String contry;
	
	public Address() {

	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getZip_code() {
		return zip_code;
	}

	public void setZip_code(Integer zip_code) {
		this.zip_code = zip_code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public Integer getIbge_code() {
		return ibge_code;
	}

	public void setIbge_code(Integer ibge_code) {
		this.ibge_code = ibge_code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getContry() {
		return contry;
	}

	public void setContry(String contry) {
		this.contry = contry;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address {id:").append(id).append(", zip_code:").append(zip_code).append(", address:")
				.append(address).append(", number:").append(number).append(", complement:").append(complement)
				.append(", neighborhood:").append(neighborhood).append(", ibge_code:").append(ibge_code)
				.append(", city:").append(city).append(", state:").append(state).append(", contry:").append(contry)
				.append("}");
		return builder.toString();
	}


	
}
