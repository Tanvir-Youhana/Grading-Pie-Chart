package sample;

import java.util.Random;

public class Student {
    String firstName, lastName, sex,email;
    int studentID;

    public Student(String first, String last, String E_mail,String sex){
        this.firstName = first;
        this.lastName = last;
        this.sex = sex;
        this.studentID = generateID();
        this.email=E_mail;
    }

    public static int generateID(){
        Random random = new Random();
         return Integer.parseInt(String.format("%04d", 1000+random.nextInt(999)));

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSex() {
        return sex;
    }

    public String getEmail() { return email;}

    public int getStudentID() {
        return studentID;
    }
}
