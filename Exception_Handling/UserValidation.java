package Exception_Handling;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;
class PhoneNumber {
     String countryCode;
     String phNo;

    PhoneNumber(String countryCode, String phNo) {
        this.countryCode = countryCode;
        this.phNo = phNo;
    }

    @Override
    public String toString() {
        return countryCode + "-" + phNo;
    }
}
class IndianPhoneNumber extends PhoneNumber {
    IndianPhoneNumber(String countryCode, String phNo){
        super(countryCode, phNo);
    }
    

    
}
class User{
private String email;
private String password;
private String firstName;
private String lastName;
private PhoneNumber[] phoneNumber;
Date dateOfBirth;
User(){

}
public User(String email, String password, String firstName, String lastName, PhoneNumber[] phoneNumber,Date dateOfBirth) {
    this.email = email;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.dateOfBirth = dateOfBirth;
}

public Date getDateOfBirth() {
    return dateOfBirth;
}
public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
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
public PhoneNumber[] getPhoneNumber() {
    return phoneNumber;
}
public void setPhoneNumber(PhoneNumber[] phoneNumber) {
    this.phoneNumber = phoneNumber;
}
@Override
public String toString() {
    return "User [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
            + ", phoneNumber=" + Arrays.toString(phoneNumber) + "]";
}

}
class InvalidInputException extends Exception {
    public InvalidInputException(String s){
        super(s);
    }
}
class Validate {
    private static int month;
    public static void validate(User user) throws InvalidInputException {
        if(!(onlyAlphabets(user.getFirstName())&& onlyAlphabets(user.getLastName()))){
            throw new InvalidInputException("First name and Last name must contain only alphabets");
        }
        if(!passwordVerification(user.getPassword())){
            throw new InvalidInputException("The length of password should be between 8 to 16 charcaters and it must include atleat one digit");
    
        }
        if(!emailVerification(user.getEmail())){
            throw new InvalidInputException("Email must contain @ and . and it should not have any spaces");
    
    
        }
        if(!phoneVerification(user.getPhoneNumber())){
            throw new InvalidInputException("Phone no must contain only digits and it should be 10 charcaters long");
    
        }
        if(!dateVerification(user.getDateOfBirth())){
            throw new InvalidInputException("Invalid date");

        }
        
    
    }
    public static boolean dateVerification(Date dateOfBirth){
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateOfBirth);
        String dayNames[] = new DateFormatSymbols().getWeekdays();  
        String weekday=dayNames[cal.get(Calendar.DAY_OF_WEEK)];
        int month = cal.get(Calendar.MONTH);
        int date=cal.get(Calendar.DATE);
        int year=cal.get(Calendar.YEAR);
        
        
        if((month>=1 && month<=12)&&(date>=1 && date<=31)&&(year>=1900 && year<=2009)){
            System.out.println("DOB is: "+year+"-"+month+"-"+date+" "+weekday);
            return true;
        }
        return false;

        
    }
    public static boolean phoneVerification(PhoneNumber[] phone){
        for(int j=0;j<phone.length;j++){
            String s=phone[j].phNo;
            if(s.length()!=10){
                return false;
    
            }
            for(int i=0;i<s.length();i++){
                if(!(s.charAt(i)>='0' && s.charAt(i)<='9')){ return false;}
                
            }
        }
       
        return true;
    }
    public static boolean emailVerification(String email){
       return email.contains("@")&& email.contains(".")&&(!email.contains(" "));

    }
    public static  boolean passwordVerification(String password){

        if(!(password.length() >=8 && password.length()<=16)){
            return false;
        }
        for (int i = 0; i < password.length(); i++) {
  

            if (password.charAt(i) >= '0'
                && password.charAt(i) <= '9') {
                return true;
            }}
           
            return false;
            

    }
    public static boolean onlyAlphabets(
        String str)
      {
        int n=str.length();

          if (str == null || str == "") {
              return false;
          }
    

          for (int i = 0; i < n; i++) {

              if (!Character
                  .isLetter(str.charAt(i))) {
                  return false;
              }
          }
          return true;
      }

}
public class UserValidation{
   
    public static void main(String[] args) throws ParseException{
        Scanner scanner = new Scanner(System.in);
        String email="istat@gmail.com";
        String password="hijk2fgjh";
        String firstName="Preeti";
        String lastName="Kumari";
        PhoneNumber p1=new PhoneNumber("+91","5678990879");
        PhoneNumber p2=new PhoneNumber("+91","9878990790");
        PhoneNumber[]phoneNumber={p1,p2};
        String s="12-03-2000";
        Date date=new SimpleDateFormat("dd-MM-yyyy").parse(s);

User user=new User(email,password,firstName,lastName,phoneNumber,date);

try{
    Validate.validate(user);
    String fullname=firstName+" "+lastName;
    System.out.println("fullname="+fullname);
    System.out.println(user);
    IndianPhoneNumber[] indianphone=new IndianPhoneNumber[phoneNumber.length];
for(int i=0;i<phoneNumber.length;i++){
    indianphone[i]=new IndianPhoneNumber("+91",phoneNumber[i].phNo);
}
System.out.println(indianphone[0]);
   
}
catch(InvalidInputException e){
    System.out.println(e);
}










        
    }
}