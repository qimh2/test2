package com.qimh.hibernate.entities;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HibernateTest {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void init(){
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry(); 
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		System.out.println("init");
	}
	
	
	/**
	 * session 缓存，这里之看见一条查询记录的sql，
	 * 第二次在查询这条记录的时候，就会去session缓存中，直接把这个对象（记录）取出来。
	 */
	@Test
	public void testSessionCache() {
		
		
		News news = (News) session.get(News.class, 1);
		System.out.println(news);
		
		
		News news2 = (News) session.get(News.class, 1);
		System.out.println(news2);
		System.out.println("test");
	}
	
	/**
	 * flush:是数据表中的记录和Session缓存中的对象状态保持一致，为了保存一致，则可能会发送对应的sql语句
	 * 1.调用Transaction 中commit()方法中：先调用session的flush方法，再提交事物
	 * 2.flush()方法可能会发送sql语句，但不提交事物。
	 * 3.注意：在未提交事务或显示调用session.flush() 方法之前，也有可能进行flush() 操作。
	 * 1).执行HQL 或QBC 查询，会先进性flush()操作，以得到数据表的最新记录
	 * 2).若记录的ID，是由底层数据库使用自增长的方式生成，则在调用save() 方法时，会立即发送insert语句(insert后会生成主键ID这样对象的主键ID就存在了)
	 *    因为save() 方法后，必须保证对象的ID是存在
	 */
	@Test
	public void testSessionFlush(){
		News news = (News) session.get(News.class, 1);
		news.setAuthor("JAVA");
//		session.flush();
//		System.out.println(news);
		
		
		News news2 = (News) session.createCriteria(News.class).uniqueResult();//QBC
		System.out.println(news2);
		
	}
	
	
	@Test
	public void testSessionFlush2(){
		News news = new News("C++", "xiaoming", new Date());
		session.save(news);
	}
	
	
	
	/**
	 * refresh():会强制 发送select 语句，以使Session缓存中对象的状态和数据表中对应的记录状态一致
	 */
	@Test
	public void testSessionRefresh(){
		News news = (News) session.get(News.class, 32768);
		System.out.println(news);
		session.refresh(news);
		System.out.println(news);
	}
	
	@Test
	public void testSessionClear(){
		News news = (News) session.get(News.class, 1);
		session.clear();
		News news2 = (News) session.get(News.class, 1);
	}
	
	
	@After
	public void destory(){
		transaction.commit();
		session.close();
		sessionFactory.close();
		System.out.println("destory");
	}

}
