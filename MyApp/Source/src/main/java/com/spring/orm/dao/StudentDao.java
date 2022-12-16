package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int insert(Student s)
	{
		int i=(Integer)this.hibernateTemplate.save(s);
		return i;
	}

	public Student getStudent(int studentId)
	{
		Student s=this.hibernateTemplate.get(Student.class, studentId);
		return s;
	}
	
	public List<Student> getAllStudents()
	{
		List<Student> list = this.hibernateTemplate.loadAll(Student.class);
		return list;
	}
	
	@Transactional
	public void updateStudent(Student s)
	{
		this.hibernateTemplate.update(s);
	}
	
	@Transactional
	public void deleteStudent(int id)
	{
		Student s=this.hibernateTemplate.get(Student.class, id);
		this.hibernateTemplate.delete(s);
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	
}
