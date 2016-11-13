package com.qimh.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.qimh.entity.Employee;
import com.qimh.service.Dao;

//模型驱动
public class EmployeeAction implements RequestAware,ModelDriven<Employee>{

	private Dao dao = new Dao();
	//需要在当前的EmployeeActioin 中定义employeeId 属性
	//以接受参数，用来给删除和更新用
//	private int employeeId;
	
	private Employee employee;
	
	
//	public void setEmployeeId(int employeeId) {
//		this.employeeId = employeeId;
//	}
//	
//	public int getEmployeeId() {
//		return employeeId;
//	}
	//获取所有用户信息
	public String list(){
		
		request.put("emps", dao.getEmployees());
		return "list";
	}
	
	
	//删除用户
	public String del(){
		//dao.del(employeeId);
		dao.del(employee.getEmployeeId());
		//返回结果的类型应为：redirectAction
		//也可以是chain，实际上是没有必要的，因为不需要再下个action中保留当前action的状态，
		//还有一个是，若使用chain则到达目标页面后，地址栏显示的依然是删除的那个连接，刷新时会重复提交。
		return "del";
	}
	
	
	
	//添加用户
	public String add(){
		
		
		//根据hashCode可以判断是同一个employee对象
		System.out.println("employee ："+employee.hashCode());
		System.out.println("值栈栈顶对象："+ActionContext.getContext().getValueStack().peek().hashCode());
		
		dao.add(employee);
		
		return "add";
	}
	
	//修改用户信息
	public String edit(){
		Employee emp = dao.get(employee.getEmployeeId());
		//员工信息返回的前台页面
		request.put("emp", emp);
		System.out.println("edit  emp:"+emp);
		return "edit";
	}
	
	

	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		employee = new Employee();
		return employee;//new Employee()
	}

}
