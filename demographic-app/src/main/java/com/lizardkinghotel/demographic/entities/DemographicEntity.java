package com.lizardkinghotel.demographic.entities;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;


@Entity(name = "demographics")
public class DemographicEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//this will auto increment
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "timestamp")
	private Date timestamp;

	private String age;
	private String gender;
	private int guestAmount;
	private String city;
	private String country;
	private String education;
	private String maritalStatus;
	private int children;
	private String employment;
	private String reasonsChosen;
	private String hearAbout;
	private String mostImportantOne;
	private String mostImportantTwo;
	private String mostImportantThree;
	private String likedMost;
	private String likedLeast;
	private String roomType;
	
	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Date getLastTouched() {
//		return lastTouched;
//	}
//
//	public void setLastTouched(Date lastTouched) {
//		this.lastTouched = lastTouched;
//	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getGuestAmount() {
		return guestAmount;
	}

	public void setGuestAmount(int i) {
		this.guestAmount = i;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int i) {
		this.children = i;
	}

	public String getEmployment() {
		return employment;
	}

	public void setEmployment(String employment) {
		this.employment = employment;
	}

	public String getReasonsChosen() {
		return reasonsChosen;
	}

	public void setReasonsChosen(String reasonsChosen) {
		this.reasonsChosen = reasonsChosen;
	}

	public String getHearAbout() {
		return hearAbout;
	}

	public void setHearAbout(String hearAbout) {
		this.hearAbout = hearAbout;
	}

	public String getMostImportantOne() {
		return mostImportantOne;
	}

	public void setMostImportantOne(String mostImportantOne) {
		this.mostImportantOne = mostImportantOne;
	}

	public String getMostImportantTwo() {
		return mostImportantTwo;
	}

	public void setMostImportantTwo(String mostImportantTwo) {
		this.mostImportantTwo = mostImportantTwo;
	}

	public String getMostImportantThree() {
		return mostImportantThree;
	}

	public void setMostImportantThree(String mostImportantThree) {
		this.mostImportantThree = mostImportantThree;
	}

	public String getLikedMost() {
		return likedMost;
	}

	public void setLikedMost(String likedMost) {
		this.likedMost = likedMost;
	}

	public String getLikedLeast() {
		return likedLeast;
	}

	public void setLikedLeast(String likedLeast) {
		this.likedLeast = likedLeast;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Demographic [id=" + id + ", timestamp=" + timestamp + ", age=" + age + ", gender=" + gender
				+ ", guestAmount=" + guestAmount + ", city=" + city + ", country=" + country + ", education="
				+ education + ", maritalStatus=" + maritalStatus + ", children=" + children + ", employment="
				+ employment + ", reasonsChosen=" + reasonsChosen + ", hearAbout=" + hearAbout + ", mostImportantOne="
				+ mostImportantOne + ", mostImportantTwo=" + mostImportantTwo + ", mostImportantThree="
				+ mostImportantThree + ", likedMost=" + likedMost + ", likedLeast=" + likedLeast + ", email=" + email
				+ "]";
	}

	
	
}
