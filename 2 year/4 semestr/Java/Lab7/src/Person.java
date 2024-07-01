import java.util.Optional;

public class Person {
    private String name;
    private int age;
    private Optional<String> email;

    public Person(String name, int age, Optional<String> email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public Optional<String> getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", email=" + email + '}';
    }
}
