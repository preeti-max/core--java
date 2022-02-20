interface Shape{
    void draw();

}
interface Polygon{



double getArea();
double getPerimeter();
default public boolean isPolygon(){
    return true;
}


}
class Shape1 implements Shape{
    String shapeName;
    
    public void draw(){
        System.out.println("I am of "+this.shapeName+" shape");
    }

}
class Line extends Shape1{
    String shapeName;
    
    public Line() {
        this.shapeName = "Line";
    }
    public void draw(){
        System.out.println("I am of "+this.shapeName+" shape");
    }

   
}
abstract class Shape2 extends Shape1 implements Polygon{
double area=0;
double perimeter=0;
int noOfSides=0;

   

    @Override
    public String toString() {
        return "Shape2 [area=" + area + ", noOfSides=" + noOfSides + ", perimeter=" + perimeter + "]";
    }
    
    

}
class Triangle extends Shape2{
    String shapeName;
    
    double a;
    double b;
    double c;
    
    public Triangle(double a, double b, double c) {
        this.shapeName = "Trianlge";
        this.a = a;
        this.b = b;
        this.c = c;
        this.noOfSides = 3;
    }

    public double getPerimeter(){
        
        return this.perimeter=a+b+c;

    }

    public double getArea(){
        double s=this.getPerimeter()/2;
        return this.area= Math.sqrt(s*(s-a)*(s-b)*(s-c));

    }
    public void draw(){
        System.out.println("I am of "+this.shapeName+" shape");
    }
    

}
class Rectangle extends Shape2{
        String shapeName;
    
    int l;
    int b;
    public Rectangle( int l, int b) {
        this.shapeName = "Rectangle";
        this.l = l;
        this.b = b;
        this.noOfSides=4;
    }
    public double getArea(){
        return this.area=l*b;

    }
    public double getPerimeter(){
        return this.perimeter= 2*(l+b);
    }
    public void draw(){
        System.out.println("I am of "+this.shapeName+" shape");
    }

}
public class PolygonDriver {

    public static void main(String[] args) {
        Line line= new Line();
        Triangle triangle=new Triangle(2,4,5);
        Rectangle rect=new Rectangle(3,4);
        line.draw();
        System.out.println("ARea of traingle: "+triangle.getArea());
        System.out.println("Area of rectangle: "+rect.getArea());
        System.out.println("Perimeter of triangle : "+triangle.getPerimeter());
        System.out.println("Perimeter of Rectangle: "+rect.getPerimeter());
        System.out.println(triangle.isPolygon());
        triangle.draw();
        rect.draw();
        line.draw();
        System.out.println(triangle);
        System.out.println(rect);

        
    }
    
}
