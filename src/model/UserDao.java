package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	
	private String db="projectx";
	private String url="jdbc:mysql://localhost:3306/"+db;
	private String uname="root";
	private String pass="abc123";
	private Connection con;
	
	private Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(url,uname,pass);
		
		return con;
	}
	
	
	public int save(User u) throws ClassNotFoundException, SQLException
	{
		String sql="insert into user (fname, lname, email, mob, web, pass, terms) values(?,?,?,?,?,?,?)";
		PreparedStatement ps=getConnection().prepareStatement(sql);
		ps.setString(1,u.getFname() );
		ps.setString(2,u.getLname() );
		ps.setString(3,u.getEmail() );
		ps.setString(4,u.getMob() );
		ps.setString(5,u.getWeb() );
		ps.setString(6,u.getPass() );
		ps.setString(7,u.getTerms() );
		
		return ps.executeUpdate();
	}
	
	public int delete(int uid) throws ClassNotFoundException, SQLException
	{
		String sql="DELETE FROM user WHERE uid=?";
		PreparedStatement ps=getConnection().prepareStatement(sql);
		ps.setInt(1,uid );
		return ps.executeUpdate();
	}
	
	public int countUser() throws ClassNotFoundException, SQLException
	{
		String sql="SELECT count(uid) FROM user";
		PreparedStatement ps=getConnection().prepareStatement(sql);
	
	
		ResultSet rs=ps.executeQuery();
		rs.next();
		
		int a=rs.getInt(1);
	
		return a;
	}
	
	
	public List<User> getAllUser() throws ClassNotFoundException, SQLException
	{
		String sql="SELECT * FROM user";
		PreparedStatement ps=getConnection().prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		
		List<User> ul=new ArrayList<User>();
		
		
		while(rs.next())
		{
			User u =new User();
			u.setUid(rs.getInt(1));
			u.setFname(rs.getString(2));
			u.setLname(rs.getString(3));
			u.setEmail(rs.getString(4));
			u.setMob(rs.getString(5));
			u.setWeb(rs.getString(6));
			u.setPass(rs.getString(7));
			u.setTerms(rs.getString(8));
			ul.add(u);
		}
		
	
		return ul;
	}
	
	public boolean checkEmail(String email) throws ClassNotFoundException, SQLException
	{
		String sql="SELECT * FROM user where email=?";
		PreparedStatement ps=getConnection().prepareStatement(sql);
		ps.setString(1, email);
		
		ResultSet rs=ps.executeQuery();
		
		boolean a= rs.absolute(1);
		System.out.println("user : "+a);
		return a;
	}
	
	
	
	public User getUser(String id) throws ClassNotFoundException, SQLException
	{
		String sql="SELECT * FROM user where uid=?";
		PreparedStatement ps=getConnection().prepareStatement(sql);
		ps.setString(1, id);
		
		ResultSet rs=ps.executeQuery();
		User u=null;
		boolean a= rs.absolute(1);
		if(a)
		{
			String fname=rs.getString(2);
			String lname=rs.getString(3);
			String email=rs.getString(4);
			String mob=rs.getString(5);
			String web=rs.getString(6);
			String upass=rs.getString(7);
			String terms=rs.getString(8);
			
			
			
			u=new User(Integer.parseInt(id), fname, lname, email, mob, web, upass, terms);
		}
		
		
		
		return u;
	}
	
	
	public int update(User u) throws ClassNotFoundException, SQLException
	{
		String sql="update user set fname=?, lname=?, email=?, mob=?, web=?, pass=?, terms=? where uid=?";
		PreparedStatement ps=getConnection().prepareStatement(sql);
		ps.setString(1,u.getFname() );
		ps.setString(2,u.getLname() );
		ps.setString(3,u.getEmail() );
		ps.setString(4,u.getMob() );
		ps.setString(5,u.getWeb() );
		ps.setString(6,u.getPass() );
		ps.setString(7,u.getTerms() );
		ps.setInt(8, u.getUid());
		
		return ps.executeUpdate();
	}

	
	

}
