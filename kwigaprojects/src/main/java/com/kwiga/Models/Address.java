package com.kwiga.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
    //@NotEmpty
	private int addressId;
	
	@Column(name="country")
	//@NotEmpty 
	//@Size(min=6, max=25, message="{country.error}")
	private String country;
	
	@Column(name="province")
	//@NotEmpty 
	//@Size(min=6, max=25, message="{province.error}")
	private String province;
	
	@Column(name="district")
	//@NotEmpty 
	//@Size(min=6, max=25, message="{district.error}")
	private String district;
	
	@Column(name="sector")
	//@NotEmpty 
	//@Size(min=6, max=25, message="{sector.error}")
	private String sector;
	
	@Column(name="cel")
	//@NotEmpty 
	//@Size(min=6, max=25, message="{cel.error}")
	private String cel;
	/*
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			},
			mappedBy = "address")
	private Set<User>user=new HashSet<>();
	*/
	/*
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable
	private Set<User> user;
	*/
	//private List<User> users = new ArrayList<>();
	
	//@ManyToMany(cascade = CascadeType.ALL)
    //@JoinTable
    //private Set<User> users;
	//private User user;
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getCel() {
		return cel;
	}
	public void setCel(String cel) {
		this.cel = cel;
	}
	
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", country=" + country + ", province=" + province + ", district="
				+ district + ", sector=" + sector + ", cel=" + cel + "]";
	}
}
