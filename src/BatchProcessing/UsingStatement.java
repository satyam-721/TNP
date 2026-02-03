package BatchProcessing;

import java.sql.*;

public class UsingStatement {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tnp",
                "root",
                "satyam721");
        System.out.println("Connected to Server");

        //CREATING
        Statement st = con.createStatement();
        st.addBatch("INSERT INTO laptop VALUES(3,'dell','ryzen',65000)");
        st.addBatch("INSERT INTO laptop VALUES(4,'asus','ryzen',40000)");
        st.addBatch("INSERT INTO laptop VALUES(5,'hp','i6',60000)");
        st.addBatch("INSERT INTO laptop VALUES(6,'vistus','nvidia',95000)");
//        st.addBatch("Select * from Laptop");   //not gonna work

        int[] results = st.executeBatch();       //returns no of line effected for each execution in array

        for(int i=0;i< results.length;i++){
            System.out.print(results[i] + ", ");
        }



    }



}
