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
	
	
	//��ȡ����Ա��
	public List<Employee> getEmployees(){
		return new ArrayList<Employee>(emps.values());
	}
	
	//ɾ������Ա��
	public void del(int empId){
		emps.remove(empId);
	}
	
	//����һ��Ա��
	public void add(Employee emp){
		long time = System.currentTimeMillis();
		emp.setEmployeeId((int)time);
		
		emps.put(emp.getEmployeeId(), emp);
	}
	
	
	public Employee get(int empId){
		return emps.get(empId);
	}
	//�޸�һ��Ա��
	public void update (Employee emp){
		emps.put(emp.getEmployeeId(), emp);
	}
	
	//�༭Ա��
	public Employee edit(Employee employee){
		return emps.get(employee.getEmployeeId());
	}
	
}
