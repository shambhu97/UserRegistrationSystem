package com.example.UserRegistration.dto;

import com.sun.istack.NotNull;

import java.util.Date;


public class UserRegistrationDto {

        @NotNull
        private String firstName;

        @NotNull
        private String lastName;

        @NotNull
        private String password;

        @NotNull
        private String confirmPassword;

        @NotNull
        private String email;

        @NotNull
        private String confirmEmail;

        @NotNull
        private Date birthday;

        private Boolean terms;


        public UserRegistrationDto(String firstName, String lastName,String password, String email, Date birthday){
            this.firstName = firstName;
            this.lastName = lastName;
            this.password = password;
            this.email = email;
            this.birthday = birthday;
        }

       public UserRegistrationDto(){

        }



        public Date getBirthday() {
        return birthday;
        }

        public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getConfirmPassword() {
            return confirmPassword;
        }

        public void setConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getConfirmEmail() {
            return confirmEmail;
        }

        public void setConfirmEmail(String confirmEmail) {
            this.confirmEmail = confirmEmail;
        }

        public Boolean getTerms() {
            return terms;
        }

        public void setTerms(Boolean terms) {
            this.terms = terms;
        }
    }

