package login.summit.registration;

public interface UserDAO {

	public int insertUser(User u);
	public User getUser(String userid, String password);
	
}
