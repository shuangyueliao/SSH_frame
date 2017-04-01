package com.lxd.action;

import javax.annotation.Resource;


import com.lxd.bean.Student;
import com.lxd.dao.StudentDao;

public class StudentAction extends SuperAction{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private Student student;
	
	private StudentDao studentDao;
	
	private int id;
	private String s_pageNow;
	private int pageNow=1;
	
	
	
	public StudentDao getStudentDao() {
		return studentDao;
	}

	@Resource
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getS_pageNow() {
		return s_pageNow;
	}

	public void setS_pageNow(String sPageNow) {
		s_pageNow = sPageNow;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}


	public String update(){
		try {
			studentDao.update(student);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "student_update_success";
		
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	

	public String updateInput(){
		Student student= (Student) studentDao.findById(Student.class, id);
		//##########################################
		request.put("student",student);
		return "student_updateInput_success";
	}
	public String delete(){
		
		System.out.println("##########StudentAction###delete##############################");
		System.out.println("#########StudentAction###delete#############################################admin#########"+id);
		
		try {
			studentDao.delById(Student.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "student_delete_success";
		
	}
	public String add(){
		System.out.println("StudentAction######Student######"+student.getName()+student.getGrade().getId()+student.getGrade().getClass());
		System.out.println("##########StudentAction###add##############################");
		//System.out.println("#########AdminAction###add#############################################NewAction#########");
		//String hql="from Admin where id='"+admin.getName()+"' and password='"+admin.getPassword()+"'";
		System.out.println("StudentAction#####################"+student.getGrade().getId());
		
		try {
			studentDao.add(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("##########StudentAction###add##############################");
		return "student_add_success";
	}
	
	
	
	public String showList(){
		
		System.out.println("##@@@@@@StudentAction######Student###s_pageNow##@@@@@@@@#"+s_pageNow+"+##################");
		if(s_pageNow!=null)
		{
			pageNow=Integer.parseInt(s_pageNow);
			System.out.println("#####pageNow##@@@@@@@@#"+pageNow+"+#######pageNow##########");
		}
		String hql="from Student order by id";
		request.put("studentList",studentDao.excuteQueryByPage(hql, pageNow, 3));

		String hql1="select count(*) from Student";
		int pageCount=studentDao.getPageCount(hql1, 3);
		//######Admin######PageCount
		
		int totalCount=studentDao.getTotalCount(hql1, 3);
		request.put("pageCount",pageCount);
		request.put("totalCount",totalCount);
		request.put("pageNow",pageNow);
		return "student_showList_success";
	}
	
}
