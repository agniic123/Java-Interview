package SatreamAPI;

import java.lang.annotation.Documented;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class Employee {

    private String name;
    private String Dept;
    private Double Salary;

    public Employee(String name, String dept, Double salary) {
        this.name = name;
        Dept = dept;
        Salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return Dept;
    }

    public void setDept(String dept) {
        Dept = dept;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Dept, Salary);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;
        Employee other = (Employee) obj;
        return Objects.equals(this.name, other.name)
                && Objects.equals(this.Dept, other.Dept)
                && Objects.equals(this.Salary, other.Salary);
    }

    public static void main(String[] args) {
        HashSet<Employee> emp = new HashSet<>();
        emp.add(new Employee("Agnic", "dept1", 2000.00));
        emp.add(new Employee("Agnic", "dept1", 2000.00));
        Iterator<Employee> iterator = emp.iterator();
        while (iterator.hasNext()) {
            Employee e = iterator.next();
            System.out.println(e.hashCode());
        }
    }
}
