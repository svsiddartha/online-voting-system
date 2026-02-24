package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import UUtil.DBconnection;
import model.User;


public class UserDAO {

		public boolean userRegister(User user)
		{
			String sql = "insert into users(name,email,password,has_voted) values(?,?,?,false)";
			try
			{
				Connection con = DBconnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, user.getName());
				ps.setString(2, user.getEmail());
				ps.setString(3, user.getPassword());
				int num = ps.executeUpdate();
				return num>0;
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return false;
		}
		public User userLogin(String email,String password) {
			String sql = "select * from users where email=? and password=?";
			try
			{
				Connection con = DBconnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setString(1, email);
	            ps.setString(2, password);

				ResultSet rs = ps.executeQuery();
				
				if(rs.next())
				{
					User u = new User();
					u.setUserId(rs.getInt("user_id"));
					u.setName(rs.getString("name"));
					u.sethasVoted(rs.getBoolean("has_voted"));
					return u;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}
		public void  voteUpdate(int userId) {
			String sql = "update users set has_voted=true where user_id=?";
			try {
				Connection con = DBconnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, userId);
				ps.executeUpdate();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

}
