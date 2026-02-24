package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import UUtil.DBconnection;
import model.Candidate;

public class CandidateDAO {
	
	public List<Candidate> getAllCandidates()
	{
		List<Candidate> list = new ArrayList<>();
		String sql = "select * from candidates";
		try {
			Connection con = DBconnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Candidate c = new Candidate();
				c.setCandidateId(rs.getInt("candidate_id"));
				c.setName(rs.getString("name"));
				c.setParty(rs.getString("party"));
				c.setVotes(rs.getInt("votes"));
				list.add(c);
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public void voteincrement(int candidate_id)
	{
		String sql = "update candidates set votes = votes+1 where candidate_id=?";
		try 
		{
			Connection con = DBconnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, candidate_id);
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public boolean addCandidate(Candidate c)
	{
		String sql = "insert into candidates(name,party) values(?,?)";
		try
		{
			Connection con = DBconnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getParty());
			return ps.executeUpdate()>0;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

}
