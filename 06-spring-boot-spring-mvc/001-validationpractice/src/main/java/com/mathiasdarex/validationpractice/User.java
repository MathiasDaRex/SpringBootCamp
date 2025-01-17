package com.mathiasdarex.validationpractice;

// Felhasználónév: Minimum 5 és maximum 15 karakter hosszúságú lehet.
//
//Jelszó: Minimum 8 karakter hosszúságú, amely tartalmaz legalább egy számot, egy kisbetűt,
// egy nagybetűt és egy speciális karaktert (@#$%^&+=).
//
//Életkor: Minimum 18 és maximum 100 év közötti érték lehet.


import jakarta.validation.constraints.*;

public class User {

    @Size(min = 5, message = "must be longer than 5 characters")
    @Size(max = 15, message = "must be shorter than 15 characters")
    @NotNull(message = "is required")
    private String userName;

    @NotNull(message = "is required")
    @Size(min = 8, message = "minimum 8 characters")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=.-_/])(?=\\S+$).{8,}$")
    private String password;

    @NotNull(message = "is required")
    @Min(value = 18, message = "You must be 18 years old or older")
    @Max(value = 100, message = "if you are over 100 years old, you have nothing to do here.")
    private Integer age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
