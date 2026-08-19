package entities;

import interfaces.Displayable;
import utils.HelperUtils;

import java.util.Date;
import java.util.Objects;

public class Person implements Displayable {


     // methods
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
    private String nationalId;
    private Integer age;
    private Boolean active_status;


    public Person(Boolean active_status, String address, Integer age,
                  Date dateOfBirth, String email, String firstName,
                  String gender, Long id, String lastName,
                  String nationalId, String phoneNumber) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setEmail(email);
        setAge(age);
        setGender(gender);
        setNationalId(nationalId);
        setPhoneNumber(phoneNumber);
        this.active_status = true;
        setAddress(address);
    }



    //overload
    public Person(Long id, String firstName, String lastName) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
    }


    // setter getter

    public Boolean isActive_status() {
        return active_status;
    }

    public void setActive_status(Boolean active_status) {
        this.active_status = active_status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(HelperUtils.isEmptyString(address)){
            System.out.println("address  is required");
            return;
        }
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
       if(!HelperUtils.isValidAge(age)) {
           System.out.println("Invalid Age");
           return;
       }

        this.age = age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        if(!HelperUtils.isValidBirth(dateOfBirth)) {
            System.out.println("Invalid birth date");
            return;
        }
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(!HelperUtils.isValidEmail(email)){
            System.out.println("Invalid email");
            return;
        }
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(HelperUtils.isEmptyString(firstName)){
            System.out.println("First name is required");
            return;
        }
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(HelperUtils.isEmptyString(gender)){
            System.out.println("First gender is required");
            return;
        }
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if(!HelperUtils.isValidId(id)) {
            System.out.println("Invalid Id");
            return;
        }
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (HelperUtils.isEmptyString(lastName)) {
            System.out.println("Last name is required");
            return;
        }

        this.lastName = lastName;
    }


    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        if(!HelperUtils.isValidNationalId(nationalId)){
            System.out.println("Invalid national id");
            return;
        }
        this.nationalId = nationalId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(!HelperUtils.isValidPhone(phoneNumber)){
            System.out.println("Invalid Phone Number");
            return;
        }
        this.phoneNumber = phoneNumber;
    }


    @Override
    public void displayInfo() {
        System.out.println("Person{" +
                "active_status=" + active_status +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", nationalId='" + nationalId + '\'' +
                ", age=" + age );
    }


    @Override
    public String displaySummary() {
        return id + " " + firstName + " " +  lastName;
    }

     // get full name
    public String getFullName(){
        return firstName + " " + lastName;
    }



    // to String

    @Override
    public String toString() {
        return "Person{" +
                "active_status=" + active_status +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", nationalId='" + nationalId + '\'' +
                ", age=" + age +
                '}';
    }


    // comparing id if already in list or not
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) {
            return false;
        }

        return Objects.equals(id, person.id);
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


    //check if is Adult
    public boolean isAdult(){
        if(age >= 18){
            System.out.println("Adult");
            return true;
        }else {
            System.out.println("child");
            return false;
        }

    }



}
