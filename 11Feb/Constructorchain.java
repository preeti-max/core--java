class Student1{
    static int count=1;
    private int rollno;
    private String name;
    private String hometown;
    static final String UNIVERSITY="TIT";

    Student1(){
        this.rollno = count++;
        this.name = "Student";
        this.hometown="XYZ";
    }
    
    
    Student1(String name){
        this();
        this.name = name;
    
    }
    Student1(String name,String hometown){
        this(name);
        this.hometown =hometown;                               
    }
    
    public int getRollno(){
        return rollno;
    }
    public String getName(){
        return name;
    }
    public String getHometown(){
        return hometown;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public void setHometown(String hometown){
        this.hometown = hometown;
    }
    public void display(){
        System.out.println("Roll no. :"+rollno);
        System.out.println("Name: "+name);
        System.out.println("City: "+hometown);
        System.out.println("UNIVERSITY: "+UNIVERSITY);
    }

}
class Constructorchain{

    public static void main(String[] args) {
        Student1 s1,s2,s3;
         s1=new Student1();
         s2=new Student1("Preeti");
         s2.setHometown("Indore");
         s3=new Student1("Sneha","Bhopal");
         s3.setName("Ankita");
         System.out.println("Roll no is :"+s2.getRollno()+". Name is: "+s2.getName()+". City is: "+s2.getHometown() );     
         
         s3.display();
         
    }
}



