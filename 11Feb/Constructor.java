class Student{
    private int rollno;
    private String name;
    Student(){
        this.rollno = 0;
        this.name = "Student";
    }
    
    Student(int rollno){
        this.rollno = rollno;
        this.name = "Student";
        
    }
    Student(String name){
        this.name = name;
        this.rollno = 0;
    }
    Student(int rollno,String name){
        this.rollno = rollno;
        this.name = name;                                
    }
    public void display(){
        System.out.println("Roll no. :"+rollno);
        System.out.println("Name: "+name);
    }
    public int getRollno(){
        return rollno;
    }
    public String getName(){
        return name;
    }
    public void setRollno(int rollno){
        this.rollno = rollno;
    }
    public void setName(String name){
        this.name = name;
    }

}
class Constructor{

    public static void main(String[] args) {
        Student s1,s2,s3,s4;
         s1=new Student();
         s2=new Student(101,"Preeti");
         s3=new Student(102);
         s4=new Student("Rahul");
         s3.setName("Ankita");
         s4.setRollno(104);
         s1.getName();     
         s1.getRollno();
         s2.display();
         
    }
}

