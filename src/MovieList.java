import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;

public class MovieList {
    public static int menu(){
        System.out.println("__________MOVIES_________");
        System.out.println("1) View List \n" +
                            "2) Add Movies \n" +
                            "3) Update Movies \n" +
                            "4) Exit");
        System.out.print("Enter your Choice: ");

        return new Scanner(System.in).nextInt();

    }

    public static void display(ResultSet rs) throws SQLException {
        while(rs.next()) {
            System.out.println("\n");
            System.out.println("id: " + rs.getInt(1));
            System.out.println("name: " + rs.getString(2));
            System.out.println("Type: " + rs.getString(3));
            System.out.println("Rating: " + rs.getFloat(4));

        }

    }

    public static void insert(PreparedStatement ps,Scanner sc) throws SQLException {

        System.out.print("Enter movie id: ");
        ps.setInt(1,sc.nextInt());
        sc.nextLine();
        System.out.print("Enter movie name: ");
        ps.setString(2,sc.nextLine());
        System.out.print("Enter movie type: ");
        ps.setString(3,sc.nextLine());
        System.out.print("Enter movie rating: ");
        ps.setFloat(4,sc.nextFloat());
        ps.executeUpdate();
        System.out.println("\n Successfully added an Item");
    }

    public static void update(Connection con, Scanner sc) throws SQLException {
        System.out.println("Enter the id to update");
        int id=sc.nextInt();
        System.out.println("1) Name \n" +
                "2) Type \n" +
                "3) rating");
        System.out.println("Type your choice to update");
        sc.nextLine();
        String choice=sc.nextLine();
        sc.nextLine();

        System.out.println("Enter new value");
        String sql="Update movies set "+choice+"= ? where id="+id;
        PreparedStatement ps=con.prepareStatement(sql);
        switch (choice){
            case "name", "type":
                ps.setString(1,sc.nextLine());
                break;
            case "rating":
                ps.setFloat(1,sc.nextFloat());
                break;

        }
        ps.executeUpdate();

    }


    public static void main(String[] args){
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tnp",
                    "root",
                    "satyam721"
            );

            PreparedStatement ps;
            Statement st = con.createStatement();
            Scanner sc=new Scanner(System.in);
            while(true) {
                switch (menu()) {
                    case 1:
                        ResultSet rs = st.executeQuery("select * from movies");

                        display(rs);
                        break;
                    case 2:
                        while (true) {
                            String sql = "insert into movies values(?,?,?,?)";
                            ps = con.prepareStatement(sql);
                            insert(ps, sc);
                            sc.nextLine();
                            System.out.println("Do you want to add more data?");

                            if (sc.nextLine().equalsIgnoreCase("no")) {
                                break;
                            }

                        }
                    case 3:
                        update(con, sc);
                        break;

                    case 4:
                        System.exit(-1);
                        break;

                }

            }

        } catch (Exception e) {
            System.out.println("Something Bad happened: "+e);
        }


    }
}
