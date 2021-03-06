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

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String introduce() {
        return "My name is "+this.name+". I am "+this.age+" years old.";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.getId());
    }
}
