package Sprint1.BankingApplicationSystem;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class BankService {
Scanner sc=new Scanner(System.in);
	
	String ch; 
	long withdraw,accbalance,damnt;
	int accno;
	String holderName;
	
	public void withdraw(long wamount,Bank bank,Session session) throws InsufficientBalanceException,MinimumBalanceException{
		try {  
			if(wamount<=bank.accbalance) {
				try {
					if(wamount>=100) {
						bank.accbalance=bank.accbalance-wamount;
						System.out.println("Rs."+wamount +" withdrawal has done successfully");
						TransactionHistory th=new TransactionHistory();
						th.setDate(new java.util.Date());
						th.setH("Rs."+wamount+" Withdraw");
						th.setBank(bank);
						session.save(th);
					}else {
						throw new MinimumBalanceException("Minimum withdrawal amount should be Rs.100\n------Withdrawal Failed------");
					}
				}catch (MinimumBalanceException e) {
					System.err.println(e.getMessage());
				}
			}else{ 
				throw new InsufficientBalanceException("Insufficient Account balance\n------Withdrawal Failed------"); 
			} 
		}catch(InsufficientBalanceException e) { 
			System.err.println(e.getMessage()); 
		} 
	} 

	public void deposit(long damnt,Bank bank,Session session) throws MinimumDepositException{
		try {
			if(damnt>=100) {
				bank.accbalance=bank.accbalance+damnt;
				System.out.println("Deposit is completed");
				TransactionHistory th=new TransactionHistory();
				th.setDate(new java.util.Date());
				th.setH("Rs."+damnt+" Deposit");
				th.setBank(bank);
				session.save(th);
			}else {
				throw new MinimumDepositException("Minimum deposit amount should be Rs.100\n------Deposit Failed------");
			}
		}catch(MinimumDepositException e) {
			System.err.println(e.getMessage());
		} 
	}

	public void checkBalance(Bank bk) {

		System.out.println("Account no:" + bk.accno); 
		System.out.println("Account Holder name:" + bk.holderName); 
		System.out.println("Account Balance:" + bk.accbalance); 
	}
	
	public Bank checkExistingAccount(int accounNum,Session session) {
		Bank b=session.get(Bank.class, accounNum);
		try {
			if(b!=null) {
				throw new AccountExistException("Account number already exist!");
			}
		}catch(AccountExistException e) {
			System.err.println(e.getMessage());
		}
		return b;
	}
	
	public Bank checkAccountNotFound(Session session) {
		System.out.println("Enter Account number: ");
		int accno=sc.nextInt();
		System.out.println("===================================================================="); 
		Bank b=session.find(Bank.class,accno);
		try {
			if(b==null) {
				throw new AccountNotFoundException("Account number not found!");
			}
		}catch(AccountNotFoundException e) {
			System.err.println(e.getMessage());
		}
		return b;
	}
	
	public void deleteFKT(Bank fkt,Session session) {
		Query q=session.createQuery("delete from TransactionHistory where bank_accno=:y");
		q.setParameter("y",fkt.getAccno());
		q.executeUpdate();
	}
	
	public void createAccount(Session session) {
		System.out.println("Enter Account number: ");
		accno=sc.nextInt();
		Bank ca=checkExistingAccount(accno,session);
		if(ca==null) {
			sc.nextLine();
			System.out.println("Enter Account holder name: ");
			holderName=sc.nextLine();
			System.out.println("Enter Deposit amount: ");
			accbalance=sc.nextLong();
			Transaction tx=session.beginTransaction();
			session.save(new Bank(accno, holderName, accbalance));
			tx.commit();
			System.out.println("Your Account has been created!");
		}
		System.out.println("===================================================================="); 
	}
	
	public void createWithdrawal(Session session) {
		Bank anf=checkAccountNotFound(session);
		if(anf!=null) {
			System.out.println("Enter Withdrawal amount: ");
			withdraw=sc.nextLong();
			Transaction tx=session.beginTransaction();
			try {
				withdraw(withdraw, anf,session);
			}catch (Exception e) {
				System.err.println(e.getMessage());
			}
			tx.commit();
		}
		System.out.println("====================================================================");
	}
	
	public void createDeposit(Session session) {
		Bank anf1=checkAccountNotFound(session);
		if(anf1!=null) {
			System.out.println("Enter deposit amount: ");
			damnt=sc.nextLong();
			Transaction tx=session.beginTransaction();
			try{
				deposit(damnt, anf1,session);
			}catch (Exception e) {
				System.err.println(e.getMessage());
		    }
			tx.commit();
		}
		System.out.println("===================================================================="); 
	}
	
	public void createCheckBalance(Session session) {
		Bank anf2=checkAccountNotFound(session);
		if(anf2!=null) {
			Transaction tx=session.beginTransaction();
				checkBalance(anf2);
			tx.commit();
		}
		System.out.println("===================================================================="); 
	}
	
	public void createUpdateAccount(Session session) {
		Bank anf4=checkAccountNotFound(session);
		if(anf4!=null) {
			sc.nextLine();
			System.out.println("Enter Account holder name: ");
			ch=sc.nextLine();
			anf4.setHolderName(ch);
			Transaction tx=session.beginTransaction();
			session.update(anf4);
			tx.commit();
			System.out.println("Your Account has been Updated!");
		}
		System.out.println("===================================================================="); 
	}
	
	public void createDeleteAccount(Session session) {
		Bank anf5=checkAccountNotFound(session);
		if(anf5!=null) {
			Transaction tx=session.beginTransaction();
			deleteFKT(anf5, session);
			session.delete(anf5);
			tx.commit();
			System.out.println("Your Account has been Deleted!");
		}
		System.out.println("===================================================================="); 
	}
	
	public void createTransactionHistory(Session session) {
		Bank anf3=checkAccountNotFound(session);
		if(anf3!=null) {
			Query q=session.createQuery("from TransactionHistory where bank_accno=:y");
			q.setParameter("y",anf3.getAccno());
			System.out.println("Account Holder: "+anf3.getHolderName());
			System.out.println("--------------------------------------------------------------------"); 
			@SuppressWarnings("unchecked")
			List<TransactionHistory> list=q.getResultList();
			for(TransactionHistory t:list) {
				System.out.println(t.display());
				System.out.println("===================================================================="); 
		    }	
		}
	}
	
	public int inputMisMat(Session session) {
		int choice;
		System.out.println("Enter your choice!");
		while(true) {
			try {
				choice=sc.nextInt();
				return choice;
			}catch (Exception e) {
				System.err.println("Invalid choice!");
				System.out.println("Enter the correct choice!");
			}
		}	
	}
}
