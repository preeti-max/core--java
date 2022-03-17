package Collections;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

interface Client {
    double getCharges();

    double calculatePayment(GregorianCalendar invoiceDate);

    void sendEmail(double payment);

}

abstract class Service implements Client, Comparable<Service> {
    int id;
    String name;
    String email;
    double charges;
    GregorianCalendar dateOfAgreement;

    Service(int id, String name, String email, double charges, GregorianCalendar dateOfAgreement) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.charges = charges;
        this.dateOfAgreement = dateOfAgreement;
    }

    public double getCharges() {
        return this.charges;
    }

    public void sendEmail(double pendingPayment) {
        System.out.println("Your payment of Rs." + pendingPayment + " is pending");
    }

    @Override
    public int compareTo(Service other) {
        if (this.id == other.id)
            return 0;
        if (this.id > other.id)
            return 1;
        return -1;
    }

}

class Customer extends Service {

    public Customer(int id, String name, String email, double charges, GregorianCalendar dateOfAgreement) {
        super(id, name, email, charges, dateOfAgreement);
    }

    public double calculatePayment(GregorianCalendar invoiceDate) {
        return (double) (getCharges() * (invoiceDate.get(Calendar.DATE) - dateOfAgreement.get(Calendar.DATE)));
    }

    @Override
    public String toString() {
        return "Customer [charges=" + charges + ", dateOfAgreement=" + dateOfAgreement.getTime() + ", email=" + email
                + ", id="
                + id + ", name=" + name + "]\n";
    }

}

class Business extends Service {
    double gstRate;

    public Business(int id, String name, String email, double charges, GregorianCalendar dateOfAgreement,
            double gstRate) {
        super(id, name, email, charges, dateOfAgreement);
        this.gstRate = gstRate;
    }

    public double getGST() {
        return this.gstRate;
    }

    public double calculatePayment(GregorianCalendar invoiceDate) {
        return (getCharges() * this.gstRate
                * (invoiceDate.get(Calendar.DATE) - dateOfAgreement.get(Calendar.DATE)));
    }

    // override toString()
    @Override
    public String toString() {
        return "Business [charges=" + charges + ", dateOfAgreement=" + dateOfAgreement.getTime() + ", email=" + email
                + ", gstRate=" + gstRate + ", id=" + id + ", name=" + name + "]\n";
    }

}

public class MyCompany {
    public static void main(String[] args) {
        Service cus1 = new Customer(10, "preeti", "preeti@gmail.com", 2000.0, new GregorianCalendar(2022, 2, 9));
        Service cus2 = new Customer(22, "Aksu", "aksu@gmail.com", 3000.0, new GregorianCalendar(2022, 2, 1));

        Service bus1 = new Business(56, "shreya", "shreya@gmail.com", 1000, new GregorianCalendar(2022, 3, 4),
                2.3);
        Service bus2 = new Business(40, "anan", "anan@gmail.com", 2000, new GregorianCalendar(2022, 2, 9),
                1.7);

        List<Service> list = new ArrayList<>();
        list.add(cus1);
        list.add(cus2);
        list.add(bus1);
        list.add(bus2);
        double[] pendingPayment = new double[4];
        for (int i = 0; i < list.size(); i++) {
            pendingPayment[i] = list.get(i).calculatePayment(new GregorianCalendar(2022, 2, 31));
            list.get(i).sendEmail(pendingPayment[i]);
        }

        Collections.sort(list);
        System.out.println("Accoring to id \n" + list);

        list.sort((ob1, ob2) -> (int) (ob2.getCharges() - ob1.getCharges()));
        System.out.println("Accoring to charges \n" + list);

        list.sort((ob1, ob2) -> (ob1.dateOfAgreement.get(Calendar.DATE)
                - ob2.dateOfAgreement.get(Calendar.DATE)));
        System.out.println("Accoring to date \n" + list);
    }
}
