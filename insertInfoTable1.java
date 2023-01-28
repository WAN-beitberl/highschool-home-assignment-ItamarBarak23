package itamar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertInfoTable1 {

	
	// Insert from exel to table 1
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/sima";
        String user = "root";
        String password = "Sunnybarak23";

        try (Connection con = DriverManager.getConnection(url, user, password);
             BufferedReader br = new BufferedReader(new FileReader("C:\\eclipse\\highschool.csv"))) {

            String line;
            boolean first = true;
            while ((line = br.readLine()) != null) {
                if(first) {
                    first = false;
                    continue;
                }
                String[] values = line.split(",");
                // Insert the data into the table
                String sql = "INSERT INTO highschool (id, first_name, last_name, email, gender, ip_address, cm_height, age, has_car, car_color, grade, grade_avg, identification_card) "
                		+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE id=?";
                try (PreparedStatement st = con.prepareStatement(sql))
                {
                	int id = Integer.parseInt(values[0]);
            	    String first_name = values[1];
            	    String last_name = values[2];
            	    String email = values[3];
            	    String gender = values[4];
            	    String ip_address = values[5];
            	    int cm_height = Integer.parseInt(values[6]);
            	    int age = Integer.parseInt(values[7]);
            	    boolean has_car = Boolean.parseBoolean(values[8]);
            	    String car_color = values[9];
            	    int grade = Integer.parseInt(values[10]);
            	    double grade_avg = Double.parseDouble(values[11]);
            	    int identification_card = Integer.parseInt(values[12]);
            	    
            	    if(has_car == true && car_color == null) {
            	    	car_color = "unknown";
            	    }
            	
            	    if (has_car == false && car_color != null) {
            	        car_color = null;
            	    }
            	    
            	    
            	    st.setInt(1, id);
            	    st.setString(2, first_name);
            	    st.setString(3, last_name);
            	    st.setString(4, email);
            	    st.setString(5, gender);
            	    st.setString(6, ip_address);
            	    st.setInt(7, cm_height);
            	    st.setInt(8, age);
            	    st.setBoolean(9, has_car);
            	    st.setString(10, car_color);
            	    st.setInt(11, grade);
            	    st.setDouble(12, grade_avg);
            	    st.setInt(13, identification_card);
            	    st.setInt(14, id);
                    st.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}