package com.hibernate.embedded.dto;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="WHUser_Detail_Total")
public class UserDetailsAll {

	@EmbeddedId   // embeddedid is used to make the 2 or more columns as a primary key
	private LoginName userId;
	private String userName;
	
	@Embedded
	@AttributeOverrides({
			@AttributeOverride (name="street", column = @Column(name="HOME_STREET_NAME")),
			@AttributeOverride (name="city", column = @Column(name="HOME_CITY_NAME")),
			@AttributeOverride (name="state", column = @Column(name="HOME_STATE_NAME")),
			@AttributeOverride (name="pincode", column = @Column(name="HOME_PIN_CODE_NAME"))
			})
	private Address homeAddress;
	
	@Embedded
	private Address officeAddress;

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public LoginName getUserId() {
		return userId;
	}

	public void setUserId(LoginName userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
