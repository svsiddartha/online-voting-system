package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import UUtil.DBconnection;

public class AdminDAO {

	public boolean login(String username,String password) {
		String sql = "select * from admin where username=? and password=?";
		try {
			Connection con = DBconnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
