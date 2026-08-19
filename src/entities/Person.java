package entities;

import interfaces.Displayable;
import utils.HelperUtils;

import java.util.Date;
import java.util.Objects;

public class Person implements Displayable {


     // methods
    private long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
    private String nationalId;
    private Integer age;
    private boolean active_status;


    public Person(boolean active_status, String address, Integer age, Date dateOfBirth, String email, String firstName, String gender, long id, String lastName, String nationalId, String phoneNumber) {
        this.active_status = active_status;
        this.address = address;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.firstName = firstName;
        this.gender = gender;
        this.id = id;
        this.lastName = lastName;
        this.nationalId = nationalId;
        this.phoneNumber = phoneNumber;
    }


    //overload
    public Person(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    // setter getter

    public boolean isActive_status() {
        return active_status;
    }

    public void setActive_status(boolean active_status) {
        this.active_status = active_status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
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
        }
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(HelperUtils.isEmptyString(gender)){
            System.out.println("First gender is required");
        }
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        if(HelperUtils.isValidId(id)) {
            System.out.println("Invalid Id");
        }
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
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
        if (!(o instanceof Person person)) return false;
        return id == person.id;
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
