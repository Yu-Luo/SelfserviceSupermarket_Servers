package DAO;
import Class.User;
import java.util.ArrayList;
import DBConnect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static void main(String[] args) {
        //本地验证Main函数
        UserDAO userDAO = new UserDAO();
        Boolean a = userDAO.register("aaa","bbb","ccc");
        System.out.println(a);
    }
    //假设的数据源
    public ArrayList<User> users;

//    public UserDAO() {
//        // TODO Auto-generated constructor stub
//        users = new ArrayList<User>();
//        users.add(new User("1234","abcde","codingma"));
//        users.add(new User("654321@","abcdf123","codemayq"));
//    }
    //验证函数
    public Boolean register(String account,String password,String username)
    {
    	Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rSet=null;
		try{
			conn=DBConnect.getDbconnection();
			String sql="INSERT INTO user (`account`, `password`, `username`) VALUES ('"+account+"', '"+password+"', '"+username+"');";
			prep=conn.prepareStatement(sql);
			prep.executeUpdate();
			return true;
		}catch(Exception e){
			
		}finally{
			DBConnect.closeDB(conn, prep, rSet);
		}
		return false;
    }
    public String isLoginOK(String account,String password) {
     /*   for (User user : users) {
            if (user.getAccount().equals(account)) {
                if (user.getPassword().equals(password)) {
                    return user.getUserName();
                }
            }
        }
        return "false";*/
    	String username = null;
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rSet=null;
		try{
			conn=DBConnect.getDbconnection();
			String sql="select username from user where (account='"+account+"' and password='"+password+"')";
			prep=conn.prepareStatement(sql);
			rSet=prep.executeQuery();
			if (rSet.next()) {
					username = rSet.getString("username");
					System.out.println(username);
				}
			else username="0";
		}catch(Exception e){
			
		}finally{
			DBConnect.closeDB(conn, prep, rSet);
		}
		return username;		
    }
}