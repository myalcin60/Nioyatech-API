package pojoDatas;

public class UserServicesPojo {
	private int id;
	private String username;

	public UserServicesPojo(int id, String username) {
		this.id = id;
		this.username = username;
	}

	public UserServicesPojo() {
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"id = '" + id + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}
