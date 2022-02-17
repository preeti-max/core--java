abstract class Shape{
    String shape;
    double area;
    double perimeter;
    Shape(){
        this.shape ="NULL";
        this.area =0;
        this.perimeter =0;
    }
    void setShape(String shape){
        this.shape =shape;
    }
    void setArea(double area){
        this.area = area;
    }
    void setPerimeter(double perimeter){
        this.perimeter =perimeter; 
    }

    public String getShape() {
        return shape;
    }
    public double getArea() {
        return area;
    }
    public double getPerimeter() {
        return perimeter;}

    
    abstract void calculateArea();
    abstract void calculatePerimeter();
    abstract void draw();

}
class Rectangle extends Shape{
    int length;
    int breadth;
    Rectangle(int length, int breadth){
        this.shape="Rectangle";
        this.length = length;
        this.breadth = breadth;
    }
    void calculateArea(){
        this.area=this.length*this.breadth;
    }
    void calculatePerimeter(){
        this.perimeter=2*(this.length+this.breadth);
    }
    void draw(){
        System.out.println(this.shape+" drawn");
    }

}
class Square extends Shape{
    int side;
    
    Square(int side){
        this.side = side;
        this.shape="Square";
        
    }
    void calculateArea(){
        this.area=side*side;
    }
    void calculatePerimeter(){
        this.perimeter=4*side;
    }
    void draw(){
        System.out.println(this.shape+" drawn");

    }

}
class Circle extends Shape{
    int radius;
    Circle(int radius){
        this.radius=radius;
        this.shape="Circle";
    }
    void calculateArea(){
        this.area=3.14*radius*radius;
    }
    void calculatePerimeter(){
        this.perimeter=2*3.14*radius;
    }
    void draw(){
        System.out.println(this.shape+" drawn");
    }
}
public class ShapeDriver {
    public static void main(String[] args) {
        Shape rect = new Rectangle(3,4);
        Shape square = new Square(2);
        Shape circle = new Circle(5);
        rect.calculateArea();
        square.calculateArea();
        circle.calculateArea();
        rect.calculatePerimeter();
        square.calculatePerimeter();
        circle.calculatePerimeter();

        System.out.println("Area of "+rect.getShape()+" "+rect.getArea()+"\n Permimeter :"+rect.getPerimeter());
        System.out.println("Area of "+square.getShape()+" "+square.getArea()+"\n Permimeter :"+square.getPerimeter());
        System.out.println("Area of "+circle.getShape()+" "+circle.getArea()+"\n Permimeter :"+circle.getPerimeter());

        


        
    }
    
}