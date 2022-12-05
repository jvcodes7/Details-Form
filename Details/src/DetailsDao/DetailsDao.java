package DetailsDao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.Detailsbean.Details;

@WebServlet("/DetailsDao")
public class DetailsDao extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static  Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = (Connection) DriverManager.getConnection(
					"jdbc:sqlserver://192.168.7.23:1433;database=jayesh", "sa",
					"Tender@123");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return con;
	}
	public static Details getPersonById(int id){
		Details e=new Details();
		
		try{
			Connection con=DetailsDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from table1 where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setGender(rs.getString(3));
				e.setcity(rs.getString(4));
				e.sethobbies(rs.getString(5));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}

	public static List<Details> getAllEmployees(){
		List<Details> list=new ArrayList<Details>();
		
		try{
			Connection con=DetailsDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from table1");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Details e=new Details();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setGender(rs.getString(3));
				e.setcity(rs.getString(4));
				e.sethobbies(rs.getString(5));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}

}
