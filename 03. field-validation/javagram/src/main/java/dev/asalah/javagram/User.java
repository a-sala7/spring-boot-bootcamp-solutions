package dev.asalah.javagram;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

public class User {
    @NotBlank(message = "First Name cannot be blank")
    @Size(min = 2, message = "First Name is too short")
    private String firstName;

    @NotBlank(message = "Last Name cannot be blank")
    @Size(min = 2, message = "Last Name is too short")
    private String lastName;

    @NotBlank(message = "Username cannot be blank")
    @Size(min = 7, message = "Username must be at least 7 characters")
    private String username;

    @Email(message = "Please enter a valid email address")
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Date of Birth must be in the past")
    private Date dateOfBirth;

    public User() {}
    
    public User(String firstName, String lastName, String username, String email, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
