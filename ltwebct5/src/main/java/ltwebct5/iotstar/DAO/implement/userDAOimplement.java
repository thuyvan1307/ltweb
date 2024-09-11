package ltwebct5.iotstar.DAO.implement;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ltwebct5.iotstar.*;
import ltwebct5.iotstar.Config.DBConnectMySQL;
import ltwebct5.iotstar.DAO.IUserDAO;
import ltwebct5.iotstar.Model.usermodel;


public class userDAOimplement extends DBConnectMySQL implements IUserDAO {

    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public List<usermodel> findall() {
        String query = "select * from users";
        List<usermodel> list = new ArrayList<>();
        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new usermodel(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
                        rs.getString("email"), rs.getString("fullname"), rs.getString("images")));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

	@Override
	public usermodel findByID(int id) {
		String query = "SELECT * FROM users where id = ? ";
        usermodel user = null;
        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new usermodel(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
                        rs.getString("email"), rs.getString("fullname"), rs.getString("images"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null)
            System.out.println("Không tìm thấy ID " + id);
        return user;
   
	}

	@Override
	public usermodel findByName(String name) {
		String query = "SELECT * FROM users where username = ? ";
        usermodel user = null;
        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new usermodel(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("fullname"),
                    rs.getString("images")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null)
        {
            System.out.println("Không tìm thấy name " + name);
        }
        
        return user;

	}

	@Override
	public usermodel login(String username, String password) {
		userDAOimplement userDAOI = new userDAOimplement();
    	usermodel user = userDAOI.findByName(username);
    	if (user != null && password.equals(user.getPassword())) {
    	return user;
    	}
    	return null;
	}

	@Override
	public void insert(usermodel user) {
		// TODO Auto-generated method stub
		List<usermodel> users = findall();
        String query = "INSERT INTO users (username, password, email, fullname, images) VALUES (?, ?, ?, ?, ?)";
        boolean usernameExists = false;
        for (usermodel existingUser : users) {
            if (existingUser.getUsername().equals(user.getUsername())) {
                usernameExists = true;
                break;
            }
        }
        if (usernameExists) {
            System.out.println("Username đã được sử dụng. Vui lòng chọn username khác.");
            return;
        }
        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getFullname());
            ps.setString(5, user.getImage());
            ps.executeUpdate();
            System.out.println("Đã tạo tài khoản thành công");
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Lỗi khi tạo tài khoản");
        }
	}
	public static void main(String[] args) {
        userDAOimplement userDAOI = new userDAOimplement();
        userDAOI.findall();
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
            usermodel loggedInUser = userDAOI.login(username_1, password_1);
            System.out.println(loggedInUser);
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
            usermodel user2 = new usermodel(username, password_2, email, fullname, image);
            userDAOI.insert(user2);
        } else if (number == 3) {
            System.out.println("Tìm ID");
            System.out.println("Nhập vào số ID: ");
            int id = input.nextInt();
            usermodel user3 = userDAOI.findByID(id);
            System.out.println(user3);
        }
        input.close();
    }

}


