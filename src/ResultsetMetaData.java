import java.sql.*;

public class ResultsetMetaData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tnp",
                "root",
                "satyam721");
        System.out.println("Connected to Server");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("Select * from Laptop");

        ResultSetMetaData rsm = rs.getMetaData();

        //GET COLUMN COUNT
        int cols=rsm.getColumnCount();
        System.out.println("Column count: "+cols);

        //PRINT COLUMN NAMES
        for(int i=1;i<=rsm.getColumnCount();i++){
            System.out.print( rsm.getColumnName(i) + ", ");
        }
        System.out.println();

        // GET COLUMN DATATYPE
        for(int i=1;i<=rsm.getColumnCount();i++){
            System.out.print( rsm.getColumnTypeName(i) + ", ");
        }
        System.out.println();

        //CHECK FOR NULL COLUMNS
        for(int i=1;i<=rsm.getColumnCount();i++){
            System.out.print( rsm.isNullable(i) + "," );
        }
    }

}
