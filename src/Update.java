import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Update {
    public static void main(String[] args){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tnp",
                    "root",
                    "satyam721");


            String sql="UPDATE Laptop SET processor=? where lid=?";
            PreparedStatement pstm= con.prepareStatement(sql);

            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the Lid to change");
            pstm.setInt(2,Integer.parseInt(br.readLine()));
            System.out.print("Enter the new processor name");
            pstm.setString(1,br.readLine());

            int count=pstm.executeUpdate();
            System.out.println("Line Effected: "+count);

        }catch (SQLException | ClassNotFoundException |IOException e){
            System.out.println("Error happened during execution"+e);
        }


    }
}
