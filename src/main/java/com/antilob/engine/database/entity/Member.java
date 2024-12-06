package com.antilob.engine.database.entity;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


import java.util.List;

@Builder
@AllArgsConstructor
@JsonPOJOBuilder
@Entity
@Table(name="membre")
public class Member {

    @jakarta.persistence.Id
    @org.springframework.data.annotation.Id
    private long id;

    @Column(name="prenom")
    private String firstname;

    @Column(name="nom")
    private String lastname;

    @Column(name="mail")
    private String email;

    @Column(name="adresse")
    private String address;

    @Column(name="cp")
    private String zipcode;

    @Column(name="localite")
    private String city;

    @Column(name="dnaiss")
    private String dateOfBirth;

    @Column(name="sexe")
    private String gender;

    @Column(name="telephone")
    private String phoneNumber;

    @Column(name="gsm")
    private String mobileNumber;

    public Member() {
    }

    public Member(long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Result> resultList;


    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
