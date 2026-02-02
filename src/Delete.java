import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tnp",
                "root",
                "satyam721"
        );

        String sql="Delete from Laptop where lid =?";
        PreparedStatement psmt= con.prepareStatement(sql);
        System.out.print("Enter the lid to Delete");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        psmt.setInt(1,Integer.parseInt(br.readLine()));

        psmt.executeUpdate();


    }

}