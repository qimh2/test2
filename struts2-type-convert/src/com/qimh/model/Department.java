package com.qimh.model;

/**
 * 1.
 * Department ��ģ�ͣ�ʵ��¼���Department
 * depName ����ֱ��д��s:textfield ����ô�����У���manager������δ����أ�
 * 
 * struts2 ����ǩ��nameֵ���Ա���Ϊ���Ե����ԣ�name = manager.name ,name = manager.birth
 * 
 * 2.manager����һ��Date���͵�birth����,struts2 ��������Զ����͵�ת����
 * 
 * ȫ�ֵ�����ת������������������
 * 
 * @author qimh
 *
 */
public class Department {
	
	private Integer id;
	private String depName;
	
	private Manager manager;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", depName=" + depName + ", manager="
				+ manager + "]";
	}
	
	
	

}
