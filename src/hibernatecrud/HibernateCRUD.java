/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatecrud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author YUNUS
 */
public class HibernateCRUD {
    
    public static void create(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Transaction ts = session.beginTransaction();
        
        Hayvan h = new Hayvan("Monica", "Kedi");
        h.setId(1);
        session.save(h);
        
        ts.commit();
        
    }
    
    public static void read(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Transaction ts = session.beginTransaction();
        
        Hayvan h = (Hayvan) session.load(Hayvan.class, 1);      
        System.out.println("Hayvan ismi: " + h.getAd() + " Hayvan Türü: " + h.getTur());
        
        ts.commit();
        
    }
    
    public static void update(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Transaction ts = session.beginTransaction();
        
        Hayvan h = (Hayvan) session.load(Hayvan.class, 1);      
        h.setAd("Sütçü");
        
        ts.commit();
        
    }
    
    public static void delete(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Transaction ts = session.beginTransaction();
        
        Hayvan h = (Hayvan) session.load(Hayvan.class, 1);      
        session.delete(h);
        
        ts.commit();
        
    }
}
