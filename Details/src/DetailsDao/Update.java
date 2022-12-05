package DetailsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.Detailsbean.Details;

public class Update {
	public int update(Details d) {
		int status = 0;
		try {
			Connection con = DetailsDao.getConnection();

			PreparedStatement ps = con
					.prepareStatement("update table1 set name=?,gender=?,city=?,hobbies=? where id=? ");
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
