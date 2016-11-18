package com.qimh.model;

/**
 * 1.
 * Department 是模型，实际录入的Department
 * depName 可以直接写到s:textfield 的那么属性中，那manager属性如何处理呢？
 * 
 * struts2 表单标签的name值可以被赋为属性的属性：name = manager.name ,name = manager.birth
 * 
 * 2.manager中有一个Date类型的birth属性,struts2 可以完成自动类型的转换吗？
 * 
 * 全局的类型转化器可以正常工作吗？
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
