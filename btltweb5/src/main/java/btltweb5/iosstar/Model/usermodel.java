package btltweb5.iosstar.Model;

import java.sql.Date;

public class usermodel {
	@SuppressWarnings("serial")
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password ;
	private String email;
	private String fullname;
	private String avatar;
	private String phone;
	private int roleid;
	private Date createDate;
	public usermodel() {
		super();
	}
	
	
	
	public usermodel(String username, String password, String email, String fullname, String phone, int roleid,
			Date createDate) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.fullname = fullname;
		this.phone = phone;
		this.roleid = roleid;
		this.createDate = createDate;
	}



	public usermodel(int id, String username, String password, String email, String fullname, String avatar,
			String phone, int roleid, Date createDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.fullname = fullname;
		this.avatar = avatar;
		this.phone = phone;
		this.roleid = roleid;
		this.createDate = createDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setImage(String avatar) {
		this.avatar = avatar;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "usermodel [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", fullname=" + fullname + ", image=" + avatar + ", phone=" + phone + ", roleid=" + roleid
				+ ", createDate=" + createDate + "]";
	}
	
	
	
	
}