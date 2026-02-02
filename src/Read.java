import javax.xml.transform.Result;
import java.sql.*;

public class Read {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tnp",
                "root",
                "satyam721"
        );
        Statement stmt=con.createStatement();

        String sql="select * from Laptop";

        ResultSet rs= stmt.executeQuery(sql);

        //Read
        while(rs.next()){

            int lid=rs.getInt(1);
            String lname=rs.getString(2);
            String processor=rs.getString(3);
            int price=rs.getInt(4);
            System.out.println("Lid: "+lid);
            System.out.println("LNAme: "+lname);
            System.out.println("Processor: "+processor);
            System.out.println("Price: "+price);
            System.out.println("\n");


        }



    }
}
