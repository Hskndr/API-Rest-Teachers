package com.educacionit.api.teachers.entities;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

public class Teacher implements Serializable {
    @Id
    private String id;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 20)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 20)
    private String lastName;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 20)
    private String profession;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 20)
    private String collegeLevel;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 20)
    private String cuit;

    @NotNull
    @NotEmpty
    @Email
    @Size(max = 30)
    private String email;

    @NotNull
    @NotEmpty
    @Size(max = 20)
    private String mobile;

    private LocalDate birthDate;

    public Teacher() {
    }

    public Teacher(String id, String name, String lastName, String profession, String collegeLevel, String cuit, String email, String mobile, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.profession = profession;
        this.collegeLevel = collegeLevel;
        this.cuit = cuit;
        this.email = email;
        this.mobile = mobile;
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCollegeLevel() {
        return collegeLevel;
    }

    public void setCollegeLevel(String collegeLevel) {
        this.collegeLevel = collegeLevel;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
