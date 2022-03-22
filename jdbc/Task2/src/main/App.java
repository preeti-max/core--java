package main;

import java.sql.*;
import dao.WorkerDAO;
import dao.WorkerDAOImplementation;
import model.Worker;
import util.DatabaseConnection;

public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DatabaseConnection.getConnection()) {
            WorkerDAO workerDao = new WorkerDAOImplementation(con);
            Worker w = new Worker(19, "Shreya", "Das", 20000, new Date(System.currentTimeMillis()), "HR",
                    "p.kumari@my_org.in");
            Worker w1 = new Worker(18, "Rahul", "r.kumar@my_org.in");

            System.out.println(workerDao.add(w));

            workerDao.delete(17);
            System.out.println(workerDao.getWorker(5));
            workerDao.update(w1);

        }

        catch (SQLException e) {
            System.out.println(e);
        }

    }

}
