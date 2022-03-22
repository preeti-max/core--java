package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Worker;

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

        String query = "SELECT * FROM worker WHERE worker_id=?";
        Worker res = null;
        try (PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, workerId);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int workerId1 = result.getInt("worker_id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                int salary = result.getInt("salary");
                Date date = result.getDate("joining_date");
                String department = result.getString("department");
                String email = result.getString("email");

                res = new Worker(workerId1, firstName, lastName, salary, date, department, email);
            }
        }
        return res;

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

        String query = "Update worker Set worker_id =?,first_name=?,last_name=?,salary=?,joining_date=?,department=?,email=? where worker_id=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, emp.getWorker_id());
            ps.setString(2, emp.getFirst_name());
            ps.setString(3, emp.getLast_name());
            ps.setInt(4, emp.getSalary());
            ps.setDate(5, emp.getJoining_date());
            ps.setString(6, emp.getDepartment());
            ps.setString(7, emp.getEmail());
            ps.setInt(8, emp.getWorker_id());
            ps.executeUpdate();
        }

    }

}
