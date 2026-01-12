package GeoLogisticsProject.staff;

public class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id; this.name = name; this.salary = salary;
    }

    public void raiseSalary(double percent) {
        this.salary += this.salary * (percent / 100);
        System.out.println("New Salary: " + this.salary);
    }

    @Override
    public String toString() { return "Employee [ID=" + id + ", Name=" + name + ", Salary=" + salary + "]"; }
}