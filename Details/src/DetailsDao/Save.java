package DetailsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.Detailsbean.Details;

public class Save {
	public int save(Details d) {
		int status = 0;
		try {
			Connection con = DetailsDao.getConnection();

			PreparedStatement ps = con
					.prepareStatement("insert into table1(name,gender,city,hobbies) values (?,?,?,?)");
			ps.setString(1, d.getName());
			ps.setString(2, d.getGender());
			ps.setString(3, d.getcity());
			ps.setString(4, d.gethobbies());

		status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}
}
