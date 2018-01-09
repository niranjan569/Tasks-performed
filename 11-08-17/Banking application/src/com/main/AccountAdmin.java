package com.main;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.dao.AccountDao;
import com.model.Account;

public class AccountAdmin {

	public static void main(String[] args) {

		// Load cofiguration file
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Beans.xml");
		// get instanse of StudentDao
		AccountDao dao = (AccountDao) context.getBean("accountDao");

		System.out.println("-----------Welcome to bank application-----------");
		Scanner scanner = new Scanner(System.in);
		boolean con = true;

		// Showing user menu until he selects n
		while (con) {
			System.out.println("Select operation");
			System.out
					.println("\t1.Create account\n\t2.Transfer money\n\t3.Display balance");
			System.out.println("Enter your choice");
			boolean b = false;
			int choice = scanner.nextInt();
			switch (choice) {
			// case for account creation
			case 1:
				
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter AccountNo");
				int accountNo = Integer.parseInt(sc.nextLine());
				b = dao.checkAccount(accountNo, b);
				// Checking whether account already exists or not
				if (b) {
					System.out.println("Enter name");
					String name = sc.nextLine();
					System.out.println("Enter balance");
					int balance = sc.nextInt();
					Account account = new Account();
					account.setpAccountNo(accountNo);
					account.setpName(name);
					account.setpBalance(balance);
					dao.createAccount(account);
				}
				break;
			// case for Transfering money
			case 2:
				System.out.println("Transfer money");
				System.out.println("Enter from account number");
				int fromAccount = scanner.nextInt();
				b = dao.verifyAccount(fromAccount, b);

				// verifying from account details
				if (b) {
					System.out.println("Enter to account number");
					int toAccount = scanner.nextInt();
					// Checking whether from and to accounts are same
					if (fromAccount != toAccount) {
						b = dao.verifyAccount(toAccount, b);

						// verifying to account details
						if (b) {
							System.out.println("Enter amount to transfer");
							int amount = scanner.nextInt();
							dao.transferMoney(fromAccount, toAccount, amount);
						}
					} else {
						System.out
								.println("From and To accounts can't be same");
					}
				}
				break;
			// case for displaying balance
			case 3:
				System.out.println("Enter account number");
				int accountNo1 = scanner.nextInt();
				b = dao.verifyAccount(accountNo1, b);
				// verifying account details
				if(b)
				dao.getAccountBalance(accountNo1);
				break;
			default:
				System.out.println("Wrong choice.....");
				break;
			}
			System.out.println("Do you want to continue......(y/n)");
			char c = scanner.next().charAt(0);
			if (c == 'n')
				con = false;
		}
		scanner.close();
		System.out
				.println("-----------Thanks for using our service-----------");
	}
}
