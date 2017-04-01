package com.muke.employee.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.muke.employee.domain.Department;
import com.muke.employee.domain.PageBean;
import com.muke.employee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Component
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	private Department department=new Department();
	private DepartmentService departmentService;
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	@Resource
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}

	private Integer currPage=1;
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public String findAll(){
		PageBean<Department>pageBean=departmentService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	public String saveUI(){
		return "saveUI";
	}
	
	public String save(){
		departmentService.save(department);
		return "saveSuccess";
	}
	public String edit(){
		department=departmentService.findById(department.getDid());
		return "editSuccess";
	}
	public String update(){
		departmentService.update(department);
		return "updateSuccess";
	}
	public String delete(){
		department=departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
		
	}
}
