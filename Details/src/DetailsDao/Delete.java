package DetailsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Delete {
	public int delete(int id) {
		int status = 0;
		try {
			Connection con = DetailsDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("delete from table1 where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}
}
