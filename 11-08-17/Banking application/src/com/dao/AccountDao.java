package com.dao;

import java.util.Scanner;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.model.Account;
public class AccountDao {

	// Reference for HibernateTemlate to perform database operations
	HibernateTemplate template;

	// Method to get HibernateTemplate reference
	public HibernateTemplate getTemplate() {
		return template;
	}

	// Method to set HibernateTemplate reference
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	// Method to save account details in database
	public void createAccount(Account account) {
		getTemplate().save(account);
	}

	// Method to transfer money from one account to another account
	// This method verifies balance amount 
	public void transferMoney(int fromAccount, int toAccount, int amount) {
		Account account = getTemplate().get(Account.class, fromAccount);
		Account account1 = getTemplate().get(Account.class, toAccount);

		// checking if balance_avaliable is less than transfer_amount
		if (account.getpBalance() < amount)
			System.out.println("insufficient balance");
		else {
			account.setpBalance(account.getpBalance() - amount);
			account1.setpBalance(account1.getpBalance() + amount);
			getTemplate().update(account);
			getTemplate().update(account1);
			System.out.println("Transfered sucessfully......");
		}
	}

	// Method to verify account number
	public boolean verifyAccount(int accountNO,boolean checkStatus) {
		return checkStatus;
	}

	// Method to display balance
	public void getAccountBalance(int accountNo) {
		Account account = getTemplate().get(Account.class, accountNo);
		System.out.println("Balance for account with accountNo " + accountNo
				+ ":" + account.getpBalance());
	}

	// Method to check account number
	public boolean checkAccount(int accountNo,boolean checkStatus) {
		return checkStatus;
	}
}
