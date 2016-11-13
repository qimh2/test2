package com.qimh.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.qimh.entity.Employee;
import com.qimh.service.Dao;

//ģ������
public class EmployeeAction implements RequestAware,ModelDriven<Employee>{

	private Dao dao = new Dao();
	//��Ҫ�ڵ�ǰ��EmployeeActioin �ж���employeeId ����
	//�Խ��ܲ�����������ɾ���͸�����
//	private int employeeId;
	
	private Employee employee;
	
	
//	public void setEmployeeId(int employeeId) {
//		this.employeeId = employeeId;
//	}
//	
//	public int getEmployeeId() {
//		return employeeId;
//	}
	//��ȡ�����û���Ϣ
	public String list(){
		
		request.put("emps", dao.getEmployees());
		return "list";
	}
	
	
	//ɾ���û�
	public String del(){
		//dao.del(employeeId);
		dao.del(employee.getEmployeeId());
		//���ؽ��������ӦΪ��redirectAction
		//Ҳ������chain��ʵ������û�б�Ҫ�ģ���Ϊ����Ҫ���¸�action�б�����ǰaction��״̬��
		//����һ���ǣ���ʹ��chain�򵽴�Ŀ��ҳ��󣬵�ַ����ʾ����Ȼ��ɾ�����Ǹ����ӣ�ˢ��ʱ���ظ��ύ��
		return "del";
	}
	
	
	
	//����û�
	public String add(){
		
		
		//����hashCode�����ж���ͬһ��employee����
		System.out.println("employee ��"+employee.hashCode());
		System.out.println("ֵջջ������"+ActionContext.getContext().getValueStack().peek().hashCode());
		
		dao.add(employee);
		
		return "add";
	}
	
	//�޸��û���Ϣ
	public String edit(){
		Employee emp = dao.get(employee.getEmployeeId());
		//Ա����Ϣ���ص�ǰ̨ҳ��
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
