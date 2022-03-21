package main;

import java.sql.*;

import dao.WorkerDAO;
import dao.WorkerDAOImplementation;
import model.Worker;
import util.DatabaseConnection;

public class App {
    public static void main(String[] args) throws Exception {

        try (Connection con = DatabaseConnection.getConnection()) {
            WorkerDAO workerDao = new WorkerDAOImplementation(con);
            Worker w = new Worker(18, "Preeti", "kumari", 20000, new Date(System.currentTimeMillis()), "HR",
                    "p.kumari@my_org.in");

            System.out.println(workerDao.add(w));

            workerDao.delete(17);
            System.out.println(workerDao.getWorker(5));

        }

        catch (SQLException e) {
            System.out.println(e);
        }

    }

}
