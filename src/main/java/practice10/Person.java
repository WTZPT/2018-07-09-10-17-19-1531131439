package practice10;

import java.util.Objects;

public class Person {
    private Integer id;
    private String name;
    private Integer age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String introduce() {
        return "My name is "+this.name+". I am "+this.age+" years old.";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        practice09.Person person = (practice09.Person) o;
        return Objects.equals(id, person.getId());
    }
}
