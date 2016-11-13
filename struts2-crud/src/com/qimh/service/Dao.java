package com.qimh.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.qimh.entity.Employee;

public class Dao {
	
	
	private static Map<Integer, Employee> emps = new LinkedHashMap<Integer, Employee>();
//	private static Map<Integer, Employee> emps = new HashMap<Integer, Employee>();

	static{
		emps.put(1001, new Employee(1001,"AA","aa","aa@qq.com"));
		emps.put(1002, new Employee(1002,"BB","bb","bb@qq.com"));
		emps.put(1003, new Employee(1003,"CC","cc","cc@qq.com"));
		emps.put(1004, new Employee(1004,"DD","dd","dd@qq.com"));
		emps.put(1005, new Employee(1005,"EE","ee","ee@qq.com"));
		
	}
	
	
	//获取所有员工
	public List<Employee> getEmployees(){
		return new ArrayList<Employee>(emps.values());
	}
	
	//删除所有员工
	public void del(int empId){
		emps.remove(empId);
	}
	
	//增加一个员工
	public void add(Employee emp){
		long time = System.currentTimeMillis();
		emp.setEmployeeId((int)time);
		
		emps.put(emp.getEmployeeId(), emp);
	}
	
	
	public Employee get(int empId){
		return emps.get(empId);
	}
	//修改一个员工
	public void update (Employee emp){
		emps.put(emp.getEmployeeId(), emp);
	}
	
	//编辑员工
	public Employee edit(Employee employee){
		return emps.get(employee.getEmployeeId());
	}
	
}
