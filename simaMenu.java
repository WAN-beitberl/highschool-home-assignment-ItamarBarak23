package itamar;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;



public class simaMenu {

	
	// option 1
	public static void schoolAvg()
	{
		
		try 
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sima","root","Sunnybarak23");
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select AVG(grade_avg) as school_avg from highschool");
			
			rs.next();
		    
			double avg = rs.getDouble("school_avg");

			System.out.println("school grade average: " + avg);

			st.close();
			con.close();
		}
		
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	
	// option 2
	public static void schoolBoysAvg()
	{
		
		try 
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sima","root","Sunnybarak23");
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select AVG(grade_avg) as boys_school_avg from highschool where gender = 'Male'");
			
			rs.next();
		    
			double avg = rs.getDouble("boys_school_avg");

			System.out.println("school boys grade average: " + avg);

			st.close();
			con.close();
		}
		
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	
	
	// option 3
	public static void schoolGirlsAvg()
	{
		
		try 
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sima","root","Sunnybarak23");
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select AVG(grade_avg) as girls_school_avg from highschool where gender = 'Female'");
			
			rs.next();
		    
			double avg = rs.getDouble("girls_school_avg");

			System.out.println("school girls grade average: " + avg);

			st.close();
			con.close();
		}
		
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	
	// option 4
	public static void above2mHavePurpleCarAvg()
	{
		
		try 
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sima","root","Sunnybarak23");
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select AVG(grade_avg) as above2mHavePurpleCar_school_avg from highschool where cm_height > 200 AND car_color = 'purple'");
			
			rs.next();
		    
			double avg = rs.getDouble("above2mHavePurpleCar_school_avg");

			System.out.println("school above 2 meters height and have purple car grade average: "+ avg);

			st.close();
			con.close();
		}
		
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	
	// option 5
	public static void studentsFriends(int checkId)
	{
		int friendId = 2000;
		int otherFriendId = 2000;
		try 
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sima","root","Sunnybarak23");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select id, friend_id, other_friend_id from highschool_friendships");
			
			while(rs.next())
			{
				if(rs.getInt("id") == checkId)
				{
					friendId= rs.getInt("friend_id");
					otherFriendId= rs.getInt("other_friend_id");
			        System.out.println("friend: " + friendId + " other friend: " + otherFriendId);
				}
			}
			
            rs = st.executeQuery("select id, friend_id, other_friend_id from highschool_friendships");
			
			while(rs.next())
			{
				if(rs.getInt("id") == friendId)
			        System.out.println("friend of friend: " + rs.getInt("friend_id") + " friend of other friend: " + rs.getInt("other_friend_id"));
				if(rs.getInt("id") == otherFriendId)
			        System.out.println("friend of friend: " + rs.getInt("friend_id") + " friend of other friend: " + rs.getInt("other_friend_id"));
			}

			st.close();
			con.close();
		}
		
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	
	// option 6
	public static void isPopularRegularOrLonely()
	{
		double countLonely = 0;
		double countPopular = 0;
		double countRegular = 0;
		try 
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sima","root","Sunnybarak23");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select id, friend_id, other_friend_id from highschool_friendships");
			
			while(rs.next())
			{
				if(rs.getInt("friend_id") > 0 && rs.getInt("other_friend_id") > 0 && rs.getInt("friend_id") < 1001 && rs.getInt("other_friend_id") < 1001)
					countPopular++;
				else
				{
					if((rs.getInt("friend_id") > 0 && rs.getInt("other_friend_id") > 0) || (rs.getInt("friend_id") < 1001 && rs.getInt("other_friend_id") < 1001))
						countRegular++;
					else
						countLonely++;
				}
			}
			double pLonely = (countLonely / 1000) * 100;
			double pRegular = (countRegular / 1000) * 100;
			double pPopular = (countPopular / 1000) * 100;
			
			System.out.println("The percentage of popular students: " + pPopular + " regular students: " + pRegular + " lonely students:" + pLonely);
			
			st.close();
			con.close();
		}
		
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	
	// option 7
	public static void avgOfStudent(int studentId)
	{
		try 
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sima","root","Sunnybarak23");
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select id, grade_avg from studentGrade");
			
			while(rs.next())
			{
			    if(studentId == rs.getInt("id"))
			        System.out.println("The average of the student is: " + rs.getDouble("grade_avg"));
			}
			st.close();
			con.close();
		}
		
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	
	public static Scanner in=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hello sima! this is the menu of the information of all the student. Enter 1-8 and print the following information about the students:");
		System.out.println("1 - The grade average of all the students in the school");
		System.out.println("2 - The grade average of the bpys in the school");
		System.out.println("3 - The grade average of the girls in the school");
		System.out.println("4 - The grade average of the students taller than 2 meters, and have purple car in the school");
		System.out.println("5 - The id's of certain student's friends");
		System.out.println("6 - The percentage of popular students, regular students and lonely students");
		System.out.println("7 - The id's of certain student's friends");
		System.out.println("8 - The grade average of certain student");
		int c = in.nextInt();
		boolean exit = false;
		while(exit == false)
		{
			
			// switch cases by the user
		    switch(c) 
		    {
		      case 1:
		        schoolAvg();
		        break;
		      case 2:
			      schoolBoysAvg();
		          break;
		      case 3:
			      schoolGirlsAvg();
			      break;
		      case 4:
		    	  above2mHavePurpleCarAvg();
		    	  break;
		      case 5:
		    	  System.out.println("Enter id to check");
		    	  int id = in.nextInt();
		    	  studentsFriends(id);
		    	  break;
		      case 6:
		    	  isPopularRegularOrLonely();
		    	  break;
		    	  
		      case 7:
		    	  System.out.println("Enter id to check");
		    	  int idAvg = in.nextInt();
		    	  avgOfStudent(idAvg);
		    	  break;
		    	  
		      case 8:
		    	  System.out.println("Exit from menu");
		    	  exit = true;
		    	  break;
		      default:
		    	  System.out.println("Enter another number");
		    }
		    if(exit == false)
		        c = in.nextInt();
		}
	}

}
