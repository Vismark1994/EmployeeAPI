package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeePersonalInformation")
public class EmployeePersonalInformation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="birth_date")
	private String birthDate;
	
	@Column(name="birth_city")
	private String birthCity;
	
	@Column(name="age")
	private int age;

	public EmployeePersonalInformation() {

	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthCity() {
		return birthCity;
	}

	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((birthCity == null) ? 0 : birthCity.hashCode());
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = (int) (prime * result + id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeePersonalInformation other = (EmployeePersonalInformation) obj;
		if (age != other.age)
			return false;
		if (birthCity == null) {
			if (other.birthCity != null)
				return false;
		} else if (!birthCity.equals(other.birthCity))
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeePersonalInformation [birthDate=" + birthDate + ", birthCity=" + birthCity + ", id=" + id
				+ ", age=" + age + "]";
	}

}
