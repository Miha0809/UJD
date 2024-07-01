public class Person { 
    private String firstName, lastName;
    private Double salary;

    public Person(String firstName, String lastName, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Double getSalary() {
        return this.salary;
    }

    @Override
    public final String toString() {
        String string = "\nFirstName: " + firstName +
                        "\nLastName: " + lastName +
                        "\nSalary: " + salary;

        return string;
    }
}
