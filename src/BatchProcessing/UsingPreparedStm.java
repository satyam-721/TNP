package BatchProcessing;

import java.sql.*;

public class UsingPreparedStm {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tnp",
                "root",
                "satyam721");
        System.out.println("Connected to Server");

        //CREATING
        String sql = "INSERT INTO Laptop VALUES(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setInt(1,7);
        ps.setString(2,"Lenovo");
        ps.setString(3,"ryzen");
        ps.setInt(4,50000);
        ps.addBatch();                                //adding to conatiner

        ps.setInt(1,8);
        ps.setString(2,"MSI");
        ps.setString(3,"ryzen");
        ps.setInt(4,89000);
        ps.addBatch();

        ps.setInt(1,9);
        ps.setString(2,"Lenovo");
        ps.setString(2,"Redmi");      //overwrites
        ps.setString(3,"ryzen");
        ps.setInt(4,50000);
        ps.addBatch();

        int[] results = ps.executeBatch();       //returns no of line effected for each execution in array

        for(int i=0;i< results.length;i++){
            System.out.print(results[i] + ", ");
        }
        
        

    }
}
