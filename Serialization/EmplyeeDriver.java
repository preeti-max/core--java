package Serialization;

class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee))
            return false;
        Employee obj = (Employee) o;
        return (this.name.equals(obj.name) && (this.id == obj.id));
    }

}

public class EmplyeeDriver {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        Employee obj = new Employee(1, "Preeti");
        Employee obj1 = new Employee(1, "Preeti");
        System.out.println(s1 == s2);
        System.out.println(obj.equals(obj1));

    }

}
