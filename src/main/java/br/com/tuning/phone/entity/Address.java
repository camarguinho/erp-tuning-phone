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
	
	@Column(length=25)
	private String complement;
	
	@Column(length=25)
	private String neighborhood;
	
	@Column(length=7)
	private Integer ibge_code;
	
	@Column(length=50)
	private String city;
	
	@Column(length=2)
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
		builder.append("Address [id=");
		builder.append(id);
		builder.append(", zip_code=");
		builder.append(zip_code);
		builder.append(", address=");
		builder.append(address);
		builder.append(", complement=");
		builder.append(complement);
		builder.append(", neighborhood=");
		builder.append(neighborhood);
		builder.append(", ibge_code=");
		builder.append(ibge_code);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", contry=");
		builder.append(contry);
		builder.append("]");
		return builder.toString();
	}

}
