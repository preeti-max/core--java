package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Worker;
import util.DatabaseConnection;

public class WorkerDAOImplementation implements WorkerDAO {
    Connection connection = null;

    public WorkerDAOImplementation(Connection con) {
        this.connection = con;
    }

    public int add(Worker worker)
            throws SQLException {
        String query = """
                INSERT INTO Worker (
                    WORKER_ID,
                    FIRST_NAME,
                    LAST_NAME,
                    SALARY,
                    JOINING_DATE,
                    DEPARTMENT,
                    email)
                VALUES
                (?,?,?,?,?,?,? )""";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, worker.getWorker_id());
        ps.setString(2, worker.getFirst_name());
        ps.setString(3, worker.getLast_name());
        ps.setInt(4, worker.getSalary());
        ps.setDate(5, worker.getJoining_date());
        ps.setString(6, worker.getDepartment());
        ps.setString(7, worker.getEmail());
        return ps.executeUpdate();

    }

    public void delete(int workerId)
            throws SQLException {
        String query = String.format("DELETE FROM worker WHERE worker_id=%d", workerId);
        try (Statement statement = connection.createStatement()) {
            int k = statement.executeUpdate(query);
            System.out.println(k + " records deleted");
        }

        /*
         * String query = "Delete from worker WHERE worker_id=?";
         * try (PreparedStatement statement = connection.prepareStatement(query)) {
         * statement.setInt(1, workerId);
         * 
         * int k = statement.executeUpdate(query);
         * System.out.println(k + " records deleted");
         * }
         */

    }

    public Worker getWorker(int workerId)
            throws SQLException {

        return new Worker(workerId);

    }

    public List<Worker> getWorkers()
            throws SQLException {
        String query = "SELECT * FROM worker";
        List<Worker> list = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int worker_id = rs.getInt("worker_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                int salary = rs.getInt("salary");
                Date date = rs.getDate("joining_date");
                String department = rs.getString("department");
                String email = rs.getString("email");

                list.add(new Worker(worker_id, first_name, last_name, salary, date, department, email));
            }
        }

        return list;

    }

    public void update(Worker emp)
            throws SQLException {

    }

}
