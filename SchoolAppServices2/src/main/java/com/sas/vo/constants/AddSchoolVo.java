package com.sas.vo.constants;

import com.sas.general.vo.RoleIdsVo;

public class AddSchoolVo {

	private String schoolName;
	private int schoolId;
	private long dateFrom;
	private long dateTill;
	private String educationFrom;
	private String educationTill;
	private long establishedYear;

	private ContactInfo contactInfo;

	private AddressInfo addressInfo;

	private RoleIdsVo roleIdsVo;

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public long getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(long dateFrom) {
		this.dateFrom = dateFrom;
	}

	public long getDateTill() {
		return dateTill;
	}

	public void setDateTill(long dateTill) {
		this.dateTill = dateTill;
	}

	public String getEducationFrom() {
		return educationFrom;
	}

	public void setEducationFrom(String educationFrom) {
		this.educationFrom = educationFrom;
	}

	public String getEducationTill() {
		return educationTill;
	}

	public void setEducationTill(String educationTill) {
		this.educationTill = educationTill;
	}

	public long getEstablishedYear() {
		return establishedYear;
	}

	public void setEstablishedYear(long establishedYear) {
		this.establishedYear = establishedYear;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public AddressInfo getAddressInfo() {
		return addressInfo;
	}

	public void setAddressInfo(AddressInfo addressInfo) {
		this.addressInfo = addressInfo;
	}

	public RoleIdsVo getRoleIdsVo() {
		return roleIdsVo;
	}

	public void setRoleIdsVo(RoleIdsVo roleIdsVo) {
		this.roleIdsVo = roleIdsVo;
	}


}
