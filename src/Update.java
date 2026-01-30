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


            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the Lid to change");
            System.out.println("What do you want to update \n" +
                    "1) Name \n" +
                    "2) Processor \n" +
                    "3) Price ");

            String column=br.readLine();
            String sql="UPDATE Laptop SET "+column+"=? where lid=?";
            PreparedStatement pstm= con.prepareStatement(sql);
            System.out.print("Enter Lid to change: ");
            pstm.setInt(2,Integer.parseInt(br.readLine()));

            switch (column.toLowerCase()){
                case "name":
                    System.out.print("Enter the new  name");
                    pstm.setString(1,br.readLine());
                    break;
                case "processor":
                    System.out.print("Enter the new processor name");
                    pstm.setString(1,br.readLine());
                    break;
                case "price":
                    System.out.println("Enter new Price");
                    pstm.setInt(1,Integer.parseInt(br.readLine()));
                    break;
            }


            int count=pstm.executeUpdate();
            System.out.println("Line Effected: "+count);

        }catch (SQLException | ClassNotFoundException |IOException e){
            System.out.println("Error happened during execution"+e);
        }


    }
}
