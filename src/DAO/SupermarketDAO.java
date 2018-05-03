package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Class.Supermarket;
import Class.User;
import DBConnect.DBConnect;

public class SupermarketDAO {
	
	public static void main(String[] args) {
        //本地验证Main函数
		ArrayList<Supermarket> Supermarkets = GetSupermarketbyCity("山东省 泰安市 泰山区");
		for (Supermarket supermarket : Supermarkets) {
			 System.out.println(supermarket.getAccount());
			 System.out.println(supermarket.getName_s());
			 System.out.println(supermarket.getAddres());
			 System.out.println(supermarket.getMark());
		}
			         
    }
	
	 public static ArrayList<Supermarket> GetSupermarketbyCity(String city){
		 	ArrayList<Supermarket> Supermarkets = new ArrayList<Supermarket>();
			Connection conn=null;
			PreparedStatement prep=null;
			ResultSet rSet=null;
			try{
				conn=DBConnect.getDbconnection();
				String sql="SELECT account,name_s,addres,mark FROM supermarket WHERE supermarket.city = '"+city+"'";
				prep=conn.prepareStatement(sql);
				rSet=prep.executeQuery();
				while (rSet.next()) {
					Supermarket supermarket = new Supermarket(null,null);
					supermarket.setAccount(rSet.getString("account"));
					supermarket.setName_s(rSet.getString("name_s"));
					supermarket.setAddres(rSet.getString("addres"));
					supermarket.setMark(rSet.getFloat("mark"));
					Supermarkets.add(supermarket);
					}
			}catch(Exception e){
				
			}finally{
				DBConnect.closeDB(conn, prep, rSet);
			}
			
		return Supermarkets;
	 }
	 public static ArrayList<Supermarket> GetSupermarketbyNameAndCity(String name_s,String city){
		 	ArrayList<Supermarket> Supermarkets = new ArrayList<Supermarket>();
			Connection conn=null;
			PreparedStatement prep=null;
			ResultSet rSet=null;
			try{
				conn=DBConnect.getDbconnection();
				String sql="SELECT account,name_s,addres,mark FROM supermarket WHERE supermarket.city = '"+city+"' AND name_s like '%"+name_s+"%'";
				prep=conn.prepareStatement(sql);
				rSet=prep.executeQuery();
				while (rSet.next()) {
					Supermarket supermarket = new Supermarket(null,null);
					supermarket.setAccount(rSet.getString("account"));
					supermarket.setName_s(rSet.getString("name_s"));
					supermarket.setAddres(rSet.getString("addres"));
					supermarket.setMark(rSet.getFloat("mark"));
					Supermarkets.add(supermarket);
					}
			}catch(Exception e){
				
			}finally{
				DBConnect.closeDB(conn, prep, rSet);
			}
			
		return Supermarkets;
	 }
}
