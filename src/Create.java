import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Create {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tnp",
                "root",
                "satyam721");
        System.out.println("Connected to Server");

        String sql="insert into laptop values(?,?,?,?)";
        PreparedStatement psmt= con.prepareStatement(sql);

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while(true){
            System.out.print("Laptop ID: ");
            int lid=Integer.parseInt(br.readLine());

            System.out.print("Name: ");
            String lname=br.readLine();
            System.out.print("processor: ");
            String processor=br.readLine();
            System.out.print("Cost: ");
            int price=Integer.parseInt(br.readLine());

            psmt.setInt(1,lid);
            psmt.setString(2,lname);
            psmt.setString(3,processor);
            psmt.setInt(4,price);

            int count=psmt.executeUpdate();
            System.out.println(count+"Lines Updated");

            System.out.println("Do you need to Add more data?");
            if(br.readLine().equalsIgnoreCase("no")){
                break;
            }
        }

    }
}
