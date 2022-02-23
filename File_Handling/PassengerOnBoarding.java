package File_Handling;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
class AirTicket{
   private String passenger;
   private String source;
   private String destination;
public AirTicket(String passenger, String source, String destination) {
    this.passenger = passenger;
    this.source = source;
    this.destination = destination;
}
public String getPassenger() {
    return passenger;
}
public void setPassenger(String passenger) {
    this.passenger = passenger;
}
public String getSource() {
    return source;
}
public void setSource(String source) {
    this.source = source;
}
public String getDestination() {
    return destination;
}
public void setDestination(String destination) {
    this.destination = destination;
}
@Override
public String toString() {
    return "AirTicket [destination=" + destination + ", passenger=" + passenger + ", source=" + source + "]";
}
   
}
public class PassengerOnBoarding {
    public static void main(String[] args) throws ParseException {
       String s=args[0];
       Date dateOfJourney=new SimpleDateFormat("dd-MM-yyyy").parse(s);

        AirTicket ticket = new AirTicket("Preeti","Delhi","Mumbai");
        System.out.println(ticket+" "+dateOfJourney);
        

        
    }
    
}
