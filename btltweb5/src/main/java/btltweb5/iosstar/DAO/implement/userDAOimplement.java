package btltweb5.iosstar.DAO.implement;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import btltweb5.iosstar.*;
import btltweb5.iosstar.Config.DBConnectMySQL;
import btltweb5.iosstar.DAO.IUserDAO;
import btltweb5.iosstar.Model.usermodel;

public class userDAOimplement extends DBConnectMySQL implements IUserDAO {
	public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;
	@Override
	public List<usermodel> findAll() {
		String query = "select * from users";
        List<usermodel> list = new ArrayList<>();
        try {
            conn = DBConnectMySQL.getDatabaseConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new usermodel(rs.getInt("id"), rs.getString("username"), 
                		rs.getString("password"),rs.getString("email"), 
                		rs.getString("fullname"),rs.getString("avatar"),rs.getString("phone"),
                		rs.getInt("role_id"), rs.getDate("datecreate")));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public usermodel findById(int id) {
		 String query = "SELECT * FROM users where user_id = ? ";
	        usermodel user = null;
	        try {
	            conn = DBConnectMySQL.getDatabaseConnection();
	            ps = conn.prepareStatement(query);
	            ps.setInt(1, id);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                user = new usermodel(rs.getInt("id"), rs.getString("username"), 
	                		rs.getString("password"),rs.getString("email"), 
	                		rs.getString("fullname"),rs.getString("vatar"),rs.getString("phone"),
	                		rs.getInt("role_id"), rs.getDate("datecreate"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return user;
	}

	@Override
	public void insert(usermodel user) {
		 List<usermodel> users = findAll();
	        String query = "insert into users (username, password, email,"
	        		+ "fullname, avatar, role_id,phone,datecreate)"
	        		+ " values (?,?,?,?,?,?,?,?)";
	        for (usermodel existingUser : users) {
	            if (existingUser.getUsername().equals(user.getUsername())) {
	                break;
	            }
	        }	       
	        try {
	            conn = DBConnectMySQL.getDatabaseConnection();
	            ps = conn.prepareStatement(query);
	            ps.setString(1, user.getUsername());
	            ps.setString(2, user.getPassword());
	            ps.setString(3, user.getEmail());
	            ps.setString(4, user.getFullname());
	            ps.setString(5, user.getAvatar());
	            ps.setInt(6, user.getRoleid());
	            ps.setString(7, user.getPhone());
	            ps.setDate(8, user.getCreateDate());
	            ps.executeUpdate();
	            System.out.println("Đã tạo tài khoản thành công");
	            System.out.println(user);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
	public void updatePassword(String email, String newPassword)
	{
	        String query = "update users set user_password = ? where user_email= ?";
	        	       
	        try {
	            conn = DBConnectMySQL.getDatabaseConnection();
	            ps = conn.prepareStatement(query);
	            ps.setString(1, newPassword);
	            ps.setString(2, email);
	            ps.executeUpdate();
	        	} catch (Exception e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public usermodel findByUserName(String username) {
		String query = "SELECT * FROM users where username = ? ";
        usermodel user = null;
        try {
            conn = DBConnectMySQL.getDatabaseConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new usermodel(rs.getInt("id"), rs.getString("username"), 
                		rs.getString("password"),rs.getString("email"), 
                		rs.getString("fullname"),rs.getString("avatar"),rs.getString("phone"),
                		rs.getInt("role_id"), rs.getDate("datecreate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return user;
	}
	

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "select * from users where user_email = ?";
		try {
		conn = DBConnectMySQL.getDatabaseConnection();
		ps = conn.prepareStatement(query);
		ps.setString(1, email);
		rs = ps.executeQuery();
		if (rs.next()) {
		duplicate = true;
		}
		ps.close();
		conn.close();
		} catch (Exception ex) {}
		return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "select * from users where user_name = ?";
		try {
		conn = DBConnectMySQL.getDatabaseConnection();
		ps = conn.prepareStatement(query);
		ps.setString(1, username);
		rs = ps.executeQuery();
		if (rs.next()) {
		duplicate = true;
		}
		ps.close();
		conn.close();
		} catch (Exception ex) {}
		return duplicate;

	}

	@Override
	public boolean checkExistPhone(String phone) {
		boolean duplicate = false;
		String query = "select * from users where user_phone = ?";
		try {
		conn = DBConnectMySQL.getDatabaseConnection();
		ps = conn.prepareStatement(query);
		ps.setString(1, phone);
		rs = ps.executeQuery();
		if (rs.next()) {
		duplicate = true;
		}
		ps.close();
		conn.close();
		} catch (Exception ex) {}
		return duplicate;
	}	
	
    
    
    
	public static void main(String[] args) {
        userDAOimplement userDAOI = new userDAOimplement();
        userDAOI.findAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập 1: Đăng nhập");
        System.out.println("Nhập 2: Đăng kí");
        System.out.println("Nhập 3: Tìm thông tin qua ID");
        int number = input.nextInt();
        System.out.println(number);
        if (number == 1) {
            System.out.println("Đăng nhập");
            System.out.println("Hãy nhập thông tin Username");
            String username_1 = input.next();
            input.nextLine();
            System.out.println("Hãy nhập thông tin: Password ");
            String password_1 = input.nextLine();
        } else if (number == 2) {
            System.out.println("Đăng kí");
            input.nextLine();
            System.out.println("Hãy nhập thông tin: Username ");
            String username = input.nextLine();
            System.out.println("Hãy nhập thông tin: Password ");
            String password_2 = input.nextLine();
            System.out.println("Hãy nhập thông tin: Email ");
            String email = input.nextLine();
            System.out.println("Hãy nhập thông tin: Fullname ");
            String fullname = input.nextLine();
            System.out.println("Hãy nhập thông tin: Image ");
            String image = input.nextLine();
     
           // userDAOI.insert(user2);
        } else if (number == 3) {
            System.out.println("Tìm ID");
            System.out.println("Nhập vào số ID: ");
            int id = input.nextInt();
           // usermodel user3 = userDAOI.findByID(id);
        }
        input.close();
    }

	

}


