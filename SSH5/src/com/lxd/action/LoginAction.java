package com.lxd.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lxd.bean.Admin;
import com.lxd.bean.Student;
import com.lxd.bean.Teacher;
import com.lxd.bean.User;

import com.lxd.dao.AdminDao;
import com.lxd.dao.StudentDao;
import com.lxd.dao.TeacherDao;
import com.lxd.dao.UserDao;

@Component
@Scope("prototype")
public class LoginAction extends SuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String role;
	private String name;
	private String password;
	private Student student;
	private StudentDao studentDao;
	private Admin admin;
	private AdminDao adminDao;
	private Teacher teacher;
	private TeacherDao teacherDao;
	private User user;
	private UserDao userDao;
	private String message;
	

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	@Resource
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public Admin getAdmin() {
		return admin;
	}

	
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public AdminDao getAdminDao() {
		return adminDao;
	}
	@Resource
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	@Resource
	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception  {
		// HttpServletRequest request = ServletActionContext.getRequest();
		// String roles = request.getParameter("role");
		System.out.println("############" + role + "###" + role.getClass());
		// System.out.println(role.equals(1));
		
		if (role.equals("1")) {
			// ######
			// System.out.println(role);
			Student s = new Student();

			//System.out.println("ognl#######################################" + id + password);
			s.setName(name);
		//	System.out.println("new###a##############################dmin###id######"+s.getId());
			s.setPassword(password);
			//System.out.println("new###ad##################min###password######"+s.getPassword());
			
		//	System.out.println("new###########################admin###password######"+s.getPassword()+s.getId());
			
			s = studentDao.existUser(s);
			if (s != null) {
				// ###session##############################
				session.put("loginInfo", s.getName());
				return "success_student";
			}
		} else if (role.equals("2")) {
			// ######
			// System.out.println(role);
			//System.out.println(role+"#####################");
			Teacher t=new Teacher();
			//System.out.println("ognl######### ######### ######### ######### #####################" + id + password);
			t.setName(name);
			//System.out.println("new###a###### ######### ######### ###dmin###id######"+t.getId());
			t.setPassword(password);
			//System.out.println("new###admi###### ######### ###n###password######"+t.getPassword());
			
		//	System.out.println("n ###### ###### ###### ######ew###admin###password######"+t.getPassword());
			try {
				t=teacherDao.existTeacher(t);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("n 11111###### ###### ###### ######ew###admin###password######"+t.getPassword());
			//System.out.println("n 22222###### ###### ###### ######ew###admin###password######"+t.getPassword());
			//System.out.println("n 333333###### ###### ###### ######ew###admin###password######"+t.getPassword());
			if (t != null) {
				// ###session##############################
				session.put("loginInfo", t);
				return "success_teacher";
			}

		} else if (role.equals("3")) {
			// #########
			Admin a = new Admin();
			//System.out.println("ognl#####################" + id + password);
			a.setName(name);
			//System.out.println("new###admin###id######"+a.getId());
			a.setPassword(password);
		//	System.out.println("new###admin###password######"+a.getPassword());
			
			a = adminDao.checkAdmin(a);
		//	System.out.println("LoginAction######Admin###############"+admin.getName());
			if (a != null) {

				// ###session##############################
				session.put("loginInfo", a);
				return "success_admin";
			}

		} else if (role.equals("4")) {
			// ############
			// System.out.println(role);
			//System.out.println("################################################" + role + "###" + role.getClass());
			//System.out.println("############v############" + role + "###" + role.getClass());
			//System.out.println("####################################" + role + "###" + role.getClass());
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			user=userDao.existUserBylogin(user);
			if (user!=null) {
				session.put("loginInfo", user);
				return "success_user";
			}

		}
		this.setMessage("##########################################");
		return INPUT;
	}

}
