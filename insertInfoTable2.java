package itamar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertInfoTable2 {

	// insert from exel to table 2
    public static void main(String[] args)
    {
    	String url = "jdbc:mysql://localhost:3306/sima";
        String user = "root";
        String password = "Sunnybarak23";

        try (Connection con = DriverManager.getConnection(url, user, password);
             BufferedReader br = new BufferedReader(new FileReader("C:\\eclipse\\highschool_friendships.csv"))) {

            String line;
            boolean first = true;
            while ((line = br.readLine()) != null) {
                if(first) {
                    first = false;
                    continue;
                }
                String[] values = line.split(",");
                // Insert the data into the table
                String sql = "INSERT INTO highschool_friendships (id, friend_id, other_friend_id) "
                		+ "VALUES (?,?,?) ON DUPLICATE KEY UPDATE id=?";
                try (PreparedStatement stmt = con.prepareStatement(sql)) {
                    stmt.setString(1, values[0]);
                    if(values.length > 1 && !values[1].isEmpty())
                        stmt.setString(2, values[1]);
                    else
                        stmt.setNull(2, java.sql.Types.NULL);
                    if(values.length > 2 && !values[2].isEmpty())
                        stmt.setString(3, values[2]);
                    else
                        stmt.setNull(3, java.sql.Types.NULL);
                    stmt.setString(4, values[0]);
                    stmt.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}