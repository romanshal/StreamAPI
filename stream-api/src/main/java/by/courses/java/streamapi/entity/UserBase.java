package by.courses.java.streamapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor(staticName = "of")
public class UserBase {

    private String name;

    private int age;

    public UserBase(String name,int age) {
        this.name = name;
        this.age=age;
    }

    public static UserBase of(String name, int age) {
        UserBase user=new UserBase(name,age);
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}