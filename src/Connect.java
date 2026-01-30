import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tnp",
                "root",
                "satyam721");
        System.out.println("Connected to Server");

        Statement stmt=con.createStatement();
        String sql="CREATE TABLE Laptop (" +
                "lid INT PRIMARY KEY," +
                "lname VARCHAR(30)," +
                "processor varchar(30)," +
                "price INT)";

        stmt.executeUpdate(sql);

        con.close();
        stmt.close();
    }


}
