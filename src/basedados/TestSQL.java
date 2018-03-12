package basedados;
import java.awt.List;
import java.sql.*;
import java.util.ArrayList;

public class TestSQL {
    private  String connectionUrl ;
    private Connection con ;
    private Statement stmt = null;
    private ResultSet rs = null;

    public void connectDB() {
        
        try {  
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connectionUrl = "jdbc:sqlserver://DESKTOP-NFDQP8C;databaseName=projectBD;user=sa;password=123qwe;";

           // con = DriverManager.getConnection(connectionUrl);
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=projectBD;user=sa;password=123qwe;");
            System.out.println("Connected to database !");
                }
        catch (SQLException e) {
            System.out.println("SQL Exception: "+ e.toString());
        } 
        catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: "+ cE.toString());
        }        
    
    }    
    
    public ArrayList<String> getData(String SQL,int numCamp){
                    // SQL query command
                     ArrayList<String> data = new ArrayList<String>();
                    try{
                        
                  
                stmt = con.createStatement();
                rs = stmt.executeQuery(SQL);
                System.out.println("------->"+rs.toString());
                
                while (rs.next()){  
                    for(int i=0; i!=numCamp;i++){
                        
                        System.out.println("------->"+rs.getNString(SQL));
                        data.add(rs.getString(i) + " ");
                    }
                }
                
                    }catch (SQLException e) {
                System.out.println(e.toString());
        } 
                
        return data;
        
    }
}
