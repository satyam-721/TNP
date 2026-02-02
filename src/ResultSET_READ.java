import java.sql.*;

public class ResultSET_READ{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tnp",
                "root",
                "satyam721");
        System.out.println("Connected to Server");

        Statement stmt=con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );
        String sql="select * from multiple";
        ResultSet rs= stmt.executeQuery(sql);
        System.out.println("___Using next ");

        while(rs.next()){
            System.out.println(rs.getString("name"));
        }

//        rs.afterLast();
        System.out.println("____previous");
        while(rs.previous()){
            System.out.println(rs.getString("name"));

        }


        //go to first row
        System.out.println("___ First row");
        rs.first();
        System.out.println(rs.getString("name"));
        //same for last




        //Absolute Position
        rs.absolute(-3);
        System.out.println("____ Absolute");
        System.out.println(rs.getString("name"));

        //Relative Position  according to the current cursor position
        rs.relative(-1);
        System.out.println("____ Relative");
        System.out.println(rs.getString("name"));


//        rs.afterLast();
//        rs.beforeFirst();


        con.close();
        stmt.close();
    }


}
