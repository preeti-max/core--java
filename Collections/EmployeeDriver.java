package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee implements Comparable<Employee> {
    protected long employeeId;
    protected String firstName;
    protected String lastName;

    public Employee(long employeeId, String firstName, String lastName) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isEqual(Employee e) {
        if (e == null)
            return false;

        if (this == e)
            return true;
        if (!(e instanceof Employee))
            return false;

        return this.employeeId == e.employeeId && this.firstName == e.firstName;

    }

    public int compareTo(Employee o) {

        if (this.employeeId > o.employeeId)
            return 1;
        if (this.isEqual(o))
            return 0;
        return -1;

    }

    public static void sort(List<Employee> employees) {
        for (int i = 0; i < employees.size(); i++) {
            for (int j = 0; j < employees.size() - 1; j++) {
                if (employees.get(j).compareTo(employees.get(j + 1)) > 0) {
                    Employee temp = employees.get(j);
                    employees.set(j, employees.get(j + 1));
                    employees.set(j + 1, temp);

                }
            }
        }

    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }

}

public class EmployeeDriver {
    public static void main(String[] args) {
        Employee e1 = new Employee(107, "Preeti", "Kumari");
        Employee e2 = new Employee(104, "Diksha", "Badal");
        Employee e3 = new Employee(106, "Satakshi", "Singh");

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.forEach(System.out::println);
        System.out.println(e2.compareTo(e1));
        Collections.sort(employees);
        System.out.println(employees);

    }

}
