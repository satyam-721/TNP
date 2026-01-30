import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    public static void main(String[] args){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tnp",
                    "root",
                    "satyam721");


            String sql="UPDATE Laptop SET processor='intel i4' where lid=2";
            PreparedStatement pstm= con.prepareStatement(sql);


        }catch (SQLException | ClassNotFoundException e){
            System.out.println("Error happened during execution"+e);
        }



    }
}
