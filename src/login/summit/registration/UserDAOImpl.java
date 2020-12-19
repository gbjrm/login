package login.summit.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl implements UserDAO {

	static Connection con;
	static PreparedStatement ps;
	
	@Override
	public int insertUser(User u) {
		int status = 0;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("INSERT INTO userdb (user, password, name) VALUES (?, ?, ?)");
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getName());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public User getUser(String userid, String pass) {
		User u = new User();
		
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("select * from userdb where user=? and password=?");
			ps.setString(1, userid);
			ps.setString(2, pass);
			
			ResultSet rs =  ps.executeQuery();
			while (rs.next()) {
				u.setEmail(rs.getString(1));
				u.setPassword(rs.getString(2));
				u.setName(rs.getString(3));
				
				
				
			}
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return u;
	}

}
