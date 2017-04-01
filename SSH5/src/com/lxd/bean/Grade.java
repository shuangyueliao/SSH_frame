package com.lxd.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Grade entity. @author MyEclipse Persistence Tools
 */

public class Grade implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	@SuppressWarnings("unchecked")
	private Set students = new HashSet(0);

	// Constructors

	/** default constructor */
	public Grade() {
	}

	/** full constructor */
	@SuppressWarnings("unchecked")
	public Grade(String name, Set students) {
		this.name = name;
		this.students = students;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String grade) {
		this.name = grade;
	}

	@SuppressWarnings("unchecked")
	public Set getStudents() {
		return this.students;
	}

	@SuppressWarnings("unchecked")
	public void setStudents(Set students) {
		this.students = students;
	}

}