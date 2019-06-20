package pack;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
  
  
public class StoreData {  
	 private static SessionFactory factory; 
    public static void main( String[] args )  
    {  
  
    	  try {
 	         factory = new Configuration().configure().buildSessionFactory();
 	      } catch (Throwable ex) { 
 	         System.err.println("Failed to create sessionFactory object." + ex);
 	         throw new ExceptionInInitializerError(ex); 
 	      }
    	   Session session = factory.openSession();
 	      Transaction t = null;
 	      try {
 	    	 t = session.beginTransaction();
 	    	 @SuppressWarnings("unchecked")
			List<Employee> employees = session.createQuery("FROM Employee E WHERE E.topicid = 2").list(); 
 	    	 for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();){
 	            Employee employee = (Employee) iterator.next(); 
 	            System.out.println("First Name: " + employee.getName()); 
 	         }
 
			 t.commit(); 
 	      }catch(HibernateException e) {
 	    	 if (t!=null) t.rollback();
	         e.printStackTrace(); 
 	      }finally {
 	    	 System.out.println("successfully saved");    
 	        factory.close();  
 	        session.close();   
 	      }
         
        
    }  
}  
