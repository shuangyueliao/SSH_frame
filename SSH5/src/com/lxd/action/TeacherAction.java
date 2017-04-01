package com.lxd.action;

import javax.annotation.Resource;


import com.lxd.bean.Teacher;
import com.lxd.dao.TeacherDao;

public class TeacherAction extends SuperAction{
	/**
	 * 
	 */
	
	
	
	
	private static final long serialVersionUID = 1L;
	private Teacher teacher;
	private TeacherDao teacherDao;
	private int id;
	private String s_pageNow;
	private int pageNow=1;
	
     
	public String update(){
		teacherDao.update(teacher);
		return "teacher_update_success";
		
	}

	
	public String updateInput(){
		
		Teacher teacher= (Teacher) teacherDao.findById(Teacher.class, id);
		//##########################################
		request.put("teacher",teacher);
		return "teacher_updateInput_success";
	}
	public String delete(){
		
		System.out.println("##########TeacherAction###delete##############################");
		System.out.println("#########TeacherAction###delete#############################################admin#########"+id);
		
		try {
			teacherDao.delById(Teacher.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "teacher_delete_success";
		
	}
	public String add(){
		System.out.println("TeacherAction######Teacher######"+teacher.getName()+teacher.getProjects().getClass()+teacher.getClass());
		System.out.println("##########TeacherAction###add##############################");
		//System.out.println("#########AdminAction###add#############################################NewAction#########");
		//String hql="from Admin where id='"+admin.getName()+"' and password='"+admin.getPassword()+"'";
		System.out.println("TeacherAction#####################"+teacher.getId());
		
		try {
			teacherDao.add(teacher);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("##########TeacherAction###add##############################");
		return "teacher_add_success";
	}
	
	
	
	public String showList(){
		
		System.out.println("##@@@@@@TeacherAction######Teacher###s_pageNow##@@@@@@@@#"+s_pageNow+"+##################");
		if(s_pageNow!=null)
		{
			pageNow=Integer.parseInt(s_pageNow);
			System.out.println("#####pageNow##@@@@@@@@#"+pageNow+"+#######pageNow##########");
		}
		String hql="from Teacher order by id";
		request.put("teacherList",teacherDao.excuteQueryByPage(hql, pageNow, 3));

		String hql1="select count(*) from Teacher";
		int pageCount=teacherDao.getPageCount(hql1, 3);
		//######Admin######PageCount
		
		int totalCount=teacherDao.getTotalCount(hql1, 3);
		request.put("pageCount",pageCount);
		request.put("totalCount",totalCount);
		request.put("pageNow",pageNow);
		return "teacher_showList_success";
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
	
	
}
