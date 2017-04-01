package com.lxd.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;

import com.lxd.bean.User;
import com.lxd.dao.UserDao;


@Scope("prototype")
public class RegisterAction extends SuperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private String gender;
	private String message;
	private String username;
	private String password;
	private String password2;
	private String email;
	private UserDao userDao;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getEmail() {
		return email;
	}  

	public void setEmail(String email) {
		this.email = email;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String execute() throws Exception{
		//if(userBiz.exist())
		System.out.println("#########@@@User####################################");
		System.out.println("#########@@@User####################################");
	
		System.out.println("#########@@@User####################################");
		System.out.println("#########@@@User####################################");	System.out.println("#########@@@User####################################");
	
		User user=new User();
		user.setName(username);
		user.setPassword(password);
		user.setSex(gender);
		user.setEmail(email);
		System.out.println("###########################"+username+password+user.getName());
//		System.out.println("#########@@@User####################################");
//		System.out.println("############cczxczxz###Action@@@@@@@@User####################################");
//		System.out.println("############cczxczxz###Action@@@@@@@@User####################################");
		if(userDao.existUser(user)==null){
			userDao.add(user);
			System.out.println("############cczxczxz###Action@@@@@@@@User####################################");
			return "register_success";
		}
		System.out.println("##################Adfgg ddddfgdgdsgdfgsdction@@@@@@@@User####################################");
		System.out.println("##################Action@ddfgdfgdgdfgdsgdfgdfsgfg####################################");
		this.setMessage("############################################################");
		return INPUT;
		
		
	}
    @Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}


}
	