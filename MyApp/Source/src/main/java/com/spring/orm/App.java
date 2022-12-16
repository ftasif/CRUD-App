package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.hibernate.dialect.MySQL57Dialect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
    
   	ApplicationContext con=	new ClassPathXmlApplicationContext("config.xml");
    StudentDao studentdao = con.getBean("studentDao",StudentDao.class);
    
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    
    boolean b=true;
    
    while(b)
    {
    	System.out.println("Press 1 for add new Student ");
    	System.out.println("Press 2 for display all Student ");
    	System.out.println("Press 3 for get details of single Student ");
    	System.out.println("Press 4 for update Student ");
    	System.out.println("Press 5 for delete Student ");
    	System.out.println("Press 6 for exit ");
    	
    	try
    	{
    		int i=Integer.parseInt(br.readLine());
    		switch(i)
    		{
    		case 1:
    			System.out.println("Enter UserId ");
    			int uid=Integer.parseInt(br.readLine());
    			System.out.println("Enter userName ");
    			String userName=br.readLine();
    			System.out.println("Enter userCity ");
    			String userCity=br.readLine();
    			int r=studentdao.insert(new Student(uid,userName,userCity));
    			System.out.println("Row Added with Student ID :"+r);
    			break;
    			
    		case 2:
    			List<Student> st = studentdao.getAllStudents();
    			
    			for(Student s:st)
    			{
    				System.out.println("Id : "+s.getStudentId());
    				System.out.println("Name : "+s.getStudentName());
    				System.out.println("City : "+s.getStudentCity());
    				System.out.println();
    			}
    			break;
    			
    		case 3:
    			System.out.println("Enter UserId ");
    			int userid=Integer.parseInt(br.readLine());
    			Student s1=studentdao.getStudent(userid);
    			System.out.println("Id : "+s1.getStudentId());
				System.out.println("Name : "+s1.getStudentName());
				System.out.println("City : "+s1.getStudentCity());
				System.out.println();
				break;
				
    		case 4:
    			System.out.println("Enter userId for update ");
    			int uid1=Integer.parseInt(br.readLine());
    			System.out.println("Enter New Name ");
    			String userName1=br.readLine();
    			System.out.println("Enter New City ");
    			String userCity1=br.readLine();
    			studentdao.updateStudent(new Student(uid1,userName1,userCity1));
    			System.out.println("Student Updated Successfully");
    			break;
    			
    		case 5:
    			System.out.println("Enter userId");
    			int idd=Integer.parseInt(br.readLine());
    			studentdao.deleteStudent(idd);
    			System.out.println("Student Deleted");
    			break;
    			
    		case 6:
    			b=false;
    			break;
    			
    			
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Invalid Input try another Input ");
    	}
    	
    }
    
    System.out.println("Thank You Using CRUD Application");
    
    
    }
}
