class Address{
    Location location;
    String state;
    String country;
    

    public Address(Location location, String state, String country) {
        this.location = location;
        this.state = state;
        this.country = country;
    }
    
}
class Location{
    String street;
    String city;
    public Location(){

    }
    public Location(String street, String city) {
        this.street = street;
        this.city = city;
    }

    
}
class UPIPaymentApps implements Cloneable {
    String name;
    String country;
    int dailyLimit;
    double maxDailyAmount;
    Address headOfficeLocation;

    

    public UPIPaymentApps(String name, String country, int dailyLimit, double maxDailyAmount,
            Address headOfficeLocation) {
        this.name = name;
        this.country = country;
        this.dailyLimit = dailyLimit;
        this.maxDailyAmount = maxDailyAmount;
        this.headOfficeLocation = headOfficeLocation;
    }

   

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Location newDependency=new Location(this.headOfficeLocation.location.street,this.headOfficeLocation.location.city);
        Address newDependencyObj= new Address(newDependency,this.headOfficeLocation.state,this.headOfficeLocation.country);
        UPIPaymentApps newObj= new UPIPaymentApps(this.name,this.country,this.dailyLimit,this.maxDailyAmount,newDependencyObj);
        
        return newObj;
    }

    @Override
    public String toString() {
        return "UPIPaymentApps [country=" + country + ", dailyLimit=" + dailyLimit + ", headOfficeLocation="
                + headOfficeLocation + ", maxDailyAmount=" + maxDailyAmount + ", name=" + name + "]";
    }
}

public class UPIDriver {
    public static void main(String[] args) throws Exception {
        Location location = new Location("Officer's Colony","Koriya");
        Address address=new Address(location,"Chhattisgarh","India");
        UPIPaymentApps bhim = new UPIPaymentApps("BHIM", "India", 10, 100000,address);
        System.out.println(bhim);


        UPIPaymentApps Paytm=(UPIPaymentApps)bhim.clone();
        System.out.println(Paytm);
        Paytm.headOfficeLocation.location.city="Bhopal";
        Paytm.headOfficeLocation.state="Madhya Pradesh";
        System.out.println("city of bhim object: "+bhim.headOfficeLocation.location.city);
        System.out.println("city of paytm object: "+Paytm.headOfficeLocation.location.city);
        System.out.println("state of bhim obj: "+bhim.headOfficeLocation.state);
        System.out.println("state of paytm object : "+Paytm.headOfficeLocation.state);
        
    }
}