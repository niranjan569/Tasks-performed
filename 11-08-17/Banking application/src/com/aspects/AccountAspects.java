package com.aspects;

import java.util.Iterator;
import java.util.List;
import javax.swing.text.StyledEditorKit.BoldAction;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.model.Account;

@Aspect
public class AccountAspects {

	// Reference for HibernateTemlate to perform database operations
	HibernateTemplate template;

	// Reference for SessionFactory to perform database operations using native
	// sql queries
	SessionFactory factory;

	// Method to get HibernateTemplate reference
	public HibernateTemplate getTemplate() {
		return template;
	}

	// Method to set HibernateTemplate reference
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	// Method to get SessionFactory reference
	public SessionFactory getFactory() {
		return factory;
	}

	// Method to set SessionFactory reference
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	// Pointcut for createAccount()
	@Pointcut("execution(* com.dao.AccountDao.createAccount(..)) && args(account,..)")
	public void createAccount(Account account) {
	}

	// Advice for createAccount()
	// This method will check whether account already exists before registering
	@Around("createAccount(account)")
	public void beforeAdvice(ProceedingJoinPoint pjp, Account account) {
		Session session = factory.openSession();

		SQLQuery query = session
				.createSQLQuery("select * from Account where AccountNo="
						+ account.getpAccountNo());
		List<Account> list = query.list();
		Iterator<Account> iterator = list.iterator();
		if (iterator.hasNext()) {
			System.out
					.println("Choose another account number, account already exsists....");
		} else {

			System.out.println("Creating account......");
			try {
				pjp.proceed();
			} catch (Throwable e) {
				e.printStackTrace();
			}
			System.out.println("Account created sucessfully....");
		}
		session.close();
	}

	// Pointcut for verifyAccount()
	@Pointcut("execution(*  com.dao.AccountDao.verifyAccount(..)) && args(accountNo,checkStatus,..)")
	public void verifyAccount(int accountNo, boolean checkStatus) {
	}

	// Advice for verifyAccount()
	// This method will verify account before transfering money
	@Around("verifyAccount(accountNo,checkStatus)")
	public boolean verifyAdvice(ProceedingJoinPoint pjp, int accountNo, boolean checkStatus) throws Throwable {

		Account account = getTemplate().get(Account.class, accountNo);
		if (account != null) {
			System.out.println("Account verified sucessfully......");
				pjp.proceed();
				return checkStatus= true;
		} else {
			System.out
					.println("Account does not exist try with correct details.....");
			pjp.proceed();
			return checkStatus= false;
		}
	}

	// Pointcut for checkAccount()
	@Pointcut("execution(*  com.dao.AccountDao.checkAccount(..)) && args(accountNo,checkStatus,..)")
	public void checkAccount(int accountNo, boolean checkStatus) {
	}

	// Advice for checkAccount()
	@Around("checkAccount(accountNo,checkStatus)")
	public boolean checkAdvice(ProceedingJoinPoint pjp, int accountNo,
			boolean checkStatus) throws Throwable {

		Account account = getTemplate().get(Account.class, accountNo);
		if (account == null) {
			pjp.proceed();
			return checkStatus = true;
		} else {
			System.out.println("Account exist try again.....");
			// System.exit(0);
			pjp.proceed();
			return checkStatus = false;
		}
	}
}
