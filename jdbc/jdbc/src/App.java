import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        final String url = "jdbc:mysql://localhost:3306/my_org";
        final String username = "root";
        final String password = "Chaitanya@137";
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            try (Statement st = con.createStatement()) {
                String query = "Alter Table worker ADD COLUMN email varchar(30)";
                String query2 = "UPDATE worker set email=concat(substring(LOWER(first_name),1,1),'.',LOWER(last_name),'@myorg.com')";

                st.execute(query);
                st.executeUpdate(query2);
                String query3 = """
                        UPDATE Worker
                            SET email = REPLACE(email, ".com", ".in")
                            """;
                st.executeUpdate(query3);

            }

            // Select concat(substring(LOWER(first_name),1,1),LOWER(last_name),'@myorg.com'
            // )from worker;

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
