package com.lxd.action;

import javax.annotation.Resource;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lxd.bean.Admin;
import com.lxd.dao.AdminDao;

@Component
@Scope("prototype")
public class AdminAction  extends SuperAction {

	/**
	 * 
	 */
	
	
	private Admin admin;
	private AdminDao adminDao;
	private int id;
	private String s_pageNow;
	private int pageNow=1;
	public AdminDao getAdminDao() {
		return adminDao;
	}
	@Resource
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	private static final long serialVersionUID = 1L;
	public String showList(){
		//System.out.println("#####s_pageNow##@@@@@@@@#"+s_pageNow+"+##################");
		if(s_pageNow!=null)
		{
			pageNow=Integer.parseInt(s_pageNow);
			//System.out.println("#####pageNow##@@@@@@@@#"+pageNow+"+#######pageNow##########");
		}
		String hql="from Admin order by id";
		//System.out.println("##########AdminAction###showList##############################");
		request.put("adminList",adminDao.excuteQueryByPage(hql, pageNow, 3));

		String hql1="select count(*) from Admin";
		int pageCount=adminDao.getPageCount(hql1, 3);
		//######Admin######PageCount
		request.put("pageCount",pageCount);
		int totalCount=adminDao.getTotalCount(hql1, 3);
		request.put("totalCount",totalCount);
		request.put("pageNow",pageNow);
		return "admin_showList_success";
	}
	public String add(){
		//System.out.println("##########AdminAction###add##############################");
		//System.out.println("#########AdminAction###add#############################################admin#########"+admin.getName()+admin.getPassword());
		//String hql="from Admin where id='"+admin.getName()+"' and password='"+admin.getPassword()+"'";
		//System.out.println("AdminAction######Admin######"+admin.getName()+admin.getPassword());
		adminDao.add(admin);
		//System.out.println("##########AdminAction###add##############################");
		return "admin_add_success";
	}
	public String execute() {
		session.get("loginInfo");
		return SUCCESS; 
	}
	
	
	public String updateInput(){
		
		Admin admin=(Admin) adminDao.findById(Admin.class, id);
		//##########################################
		request.put("admin",admin);
		
		return "admin_updateInput_success";
	}
	
	
	
	public String update(){
		//System.out.println("#########AdminAction###update#############################################update############admin#########"+admin.getName()+admin.getPassword());
		
		adminDao.update(admin);
		//System.out.println("#########AdminAction#####################update#############################################update############admin#########"+admin.getName()+admin.getPassword());
		
		return "admin_update_success";
		
	}
	
	
	public String delete(){
		
	//System.out.println("##########AdminAction###delete##############################");
	//System.out.println("#########AdminAction###delete#############################################admin#########"+id);
	
	try {
		adminDao.delById(Admin.class, id);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	
		return "admin_delete_success";
		
	}

	//#####################
	public String logout(){
//		ActionContext ctx=ActionContext.getContext();  
//		Map<K, V> session=ctx.getSession();  
//		session.get("XX");
//		return null;
		  System.out.println("***********AdminAction**************");
		  System.out.println("#########AdminAction############logout#########");
		  System.out.println("seession#########"+session.get("loginInfo"));
		  System.out.println("************AdminAction*************");
		if(session.get("loginInfo")!=null){
			session.remove("loginInfo");
			 System.out.println("######seession#########"+session.get("loginInfo"));
		}
		return "logout_success";
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
