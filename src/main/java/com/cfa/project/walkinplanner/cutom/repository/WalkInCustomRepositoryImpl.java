package com.cfa.project.walkinplanner.cutom.repository;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cfa.project.walkinplanner.models.WalkInDetailsModel;


@Repository
public class WalkInCustomRepositoryImpl implements WalkInCustomRepository{

	private static final int END_NUMBER_OF_DAYS = 7;

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// Walking Info by Date
	public List<WalkInDetailsModel> findByWalkingDate() {

		// Creating Session
		Session session = sessionFactory.openSession();

		List<WalkInDetailsModel> result = null;

		// Creating Criteria object
		Criteria criteria = session.createCriteria(WalkInDetailsModel.class, "WalkInDetailsModel")
				.createAlias("WalkInDetailsModel.companydetails", "companydetails");

		// Current Date
		Calendar currentDate = Calendar.getInstance();

		// Till Date after END_NUMBER_OF_DAYS
		Calendar endDate = Calendar.getInstance();
		endDate.add(Calendar.DATE, END_NUMBER_OF_DAYS);

		// To get records from Current date to next Seven days
		criteria.add(Restrictions.between("walkingdate", new java.sql.Date(currentDate.getTime().getTime()),
				new java.sql.Date(endDate.getTime().getTime())));

		// To sort records in ascending order of Date
		criteria.addOrder(Order.asc("walkingdate"));

		try {
			result = criteria.list();
		} catch (Exception ex) {
			System.out.println("ERROR in QUERY: " + ex.getMessage());
		}
		return result;
	}

}
