package com.infinite.college;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

@ManagedBean(name = "collegeDAO")
public class CollegeDAO {

	SessionFactory sf;

	public String generateStudentId() {
		sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(StudentDetails.class);
		List<StudentDetails> StudentList = cr.list();
		if (StudentList.size() == 0) {
			return "S001";
		}

		int id = Integer.parseInt(StudentList.get(StudentList.size() - 1).getStudentId().substring(1));
		String sid = String.format("S%03d", ++id);
		return sid;
	}

	public String addStd(StudentDetails student) {
		sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		String stdid = generateStudentId();
		Transaction t = session.beginTransaction();
		student.setStudentId(stdid);
		session.save(student);
		t.commit();
		return "Show.xhtml?faces-redirect=true";

	}

	public List<StudentDetails> showStudent() {
		sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Query query = session.createQuery("from StudentDetails");
		Criteria cr = session.createCriteria(StudentDetails.class);
		List<StudentDetails> stdList = query.list();
		return stdList;
	}

	public List<StudentDetails> searchstd(int dateOfJoin) {
		sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(StudentDetails.class);
		cr.add(Restrictions.eq("dateOfJoin", dateOfJoin));
		List<StudentDetails> stdList = cr.list();
		return stdList;

	}
}
