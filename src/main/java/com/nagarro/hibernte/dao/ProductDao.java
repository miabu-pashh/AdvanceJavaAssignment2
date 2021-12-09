package com.nagarro.hibernte.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.nagarr.hibernate.dao.impl.ProductDaoInterface;
import com.nagarro.Product;


/**
 * The Class ProductDao.
 */
public class ProductDao implements ProductDaoInterface {

	/**
	 * Save product.
	 *
	 * @param product the product
	 */
	@Override
	public void saveProduct(Product product) {

		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		try {

			session.save(product);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {

				System.out.println("Sorry some error has occured!");
				transaction.rollback();
			}
		} finally {
			session.close();
		}

	}

	/**
	 * Session get.
	 *
	 * @return the list
	 */
	@SuppressWarnings("deprecation")
	public List<Product> sessionGet() {

		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<Product> q1 = session.createQuery("from Product");
		List<Product> product = q1.list();

		return product;

	}

}
