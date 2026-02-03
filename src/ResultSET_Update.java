import java.sql.*;

public class ResultSET_Update {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tnp",
                "root",
                "satyam721");
        System.out.println("Connected to Server");

        Statement stmt=con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE
        );
        String sql="select * from multiple";
        ResultSet rs= stmt.executeQuery(sql);


        //Updating the elements in database
        rs.next();
        rs.updateString("name","sat721");
        rs.updateRow();
        System.out.println(rs.getString("name"));


        //Insert New Element
        rs.moveToInsertRow();
        rs.updateInt("id",7);
        rs.insertRow();




        con.close();
        stmt.close();
    }


}
