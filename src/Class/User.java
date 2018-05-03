package Class;

public class User{

    private String account;
    private String password;
    private String userName;
    private String head_img;
    
    
    public static String ACCOUNT = "account";
    public static String PASSWORD = "passWord";
    public static String USERNAME = "userName";
    
	public User(String account, String password, String userName) {
		super();
		this.account = account;
		this.password = password;
		this.userName = userName;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getHead_img() {
		return head_img;
	}
	public void setHead_img(String head_img) {
		this.head_img = head_img;
	}
    
    
   
}
    
