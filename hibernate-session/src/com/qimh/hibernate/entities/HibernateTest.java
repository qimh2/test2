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
	 * session ���棬����֮����һ����ѯ��¼��sql��
	 * �ڶ����ڲ�ѯ������¼��ʱ�򣬾ͻ�ȥsession�����У�ֱ�Ӱ�������󣨼�¼��ȡ������
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
	 * flush:�����ݱ��еļ�¼��Session�����еĶ���״̬����һ�£�Ϊ�˱���һ�£�����ܻᷢ�Ͷ�Ӧ��sql���
	 * 1.����Transaction ��commit()�����У��ȵ���session��flush���������ύ����
	 * 2.flush()�������ܻᷢ��sql��䣬�����ύ���
	 * 3.ע�⣺��δ�ύ�������ʾ����session.flush() ����֮ǰ��Ҳ�п��ܽ���flush() ������
	 * 1).ִ��HQL ��QBC ��ѯ�����Ƚ���flush()�������Եõ����ݱ�����¼�¼
	 * 2).����¼��ID�����ɵײ����ݿ�ʹ���������ķ�ʽ���ɣ����ڵ���save() ����ʱ������������insert���(insert�����������ID�������������ID�ʹ�����)
	 *    ��Ϊsave() �����󣬱��뱣֤�����ID�Ǵ���
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
	 * refresh():��ǿ�� ����select ��䣬��ʹSession�����ж����״̬�����ݱ��ж�Ӧ�ļ�¼״̬һ��
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
