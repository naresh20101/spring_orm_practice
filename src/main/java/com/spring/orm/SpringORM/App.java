package com.spring.orm.SpringORM;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.SpringORM.Dao.StudentDao;
import com.spring.orm.SpringORM.Entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao=context.getBean("studentDao", StudentDao.class);
        Student student=new Student(3,"Jatender","Umerkot");
        int r=studentDao.insert(student);
       System.out.println("Done.."+ r);
       studentDao.delete(1);
       //Update Operation
        Student s=new Student();
       s.setStudentId(1);
        s.setStudentName("Naresh khatri");
        s.setStudentCity("New Chhore");
       studentDao.update(s);
       //Getting single row
       Student s1=studentDao.getStudent(1);
       System.out.println(s1);
       //Get all records
        List<Student> s2=studentDao.getAll();
        for(Student st:s2)
        {
        	System.out.println(st);
        }
        
        
    }
}
