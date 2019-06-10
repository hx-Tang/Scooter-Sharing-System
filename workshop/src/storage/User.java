package storage;

public class User {
	private int id;
	private String name;
	private String email;
	private int status; //-1=blocked，0=be not using scooters，other number=the scooter id this user is using
	
	public User(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.status = 0;
	}
	
	public User() {
		// TODO 
	}

	public String toString() {
		return "id="+id+"\nname="+name+"\nemail="+email+"\nstatus="+status;
	}
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id 
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name 
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email 要设置的 
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status 
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
}
