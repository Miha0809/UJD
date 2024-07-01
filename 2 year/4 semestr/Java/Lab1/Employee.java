package Lab1;

public class Employee implements Measurable {

  private String firstName;
  private double salary;

  public Employee() {
    super();
  }

  public Employee(double salary) {
    super();
    this.salary = salary;
  }

  public Employee(double salary, String firstName) {
    super();
    this.salary = salary;
    this.firstName = firstName;
  }

  @Override
  public double getMeasure() {
    return this.salary;
  }

  @Override
  public String toString() {
    return "FirstName: " + this.firstName + "\n" +
        "Salary: " + this.salary + "\n";
  }
}
