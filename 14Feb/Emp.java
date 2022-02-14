class Person{
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + "]";
    }
    

}
class Employee extends Person{
    double salary;
    int year;
    String uan;
    public Employee(String name, double salary, int year, String uan) {
        super(name);
        this.salary = salary;
        this.year = year;
        this.uan = uan;
    }
    @Override
    public String toString() {
        return "Employee [name= "+name +" salary=" + salary + ", uan=" + uan + ", year=" + year + "]";
    }
    

    

}
public class Emp{
    public static void main(String[] args) {
        Employee employee1 = new Employee("Preeti",70000,2020,"AP100067");
        Employee employee2 = new Employee("Rahul",100000,2018,"AP100045");
        Person employee= new Person("Shristi");
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee);


        if(employee1.name==employee2.name && employee1.salary==employee2.salary && employee1.year==employee2.year && employee1.uan==employee2.uan){
            System.out.println("Both objects of Employeeec class are equal");
        }
        else{
            System.out.println("Both objects of Employeee class are not equal");
        }
        if(employee.name==employee2.name){
            System.out.println("Both objects  are equal");
        }
        else{
            System.out.println("Both objects  are not equal");
        }

        
    }
}
