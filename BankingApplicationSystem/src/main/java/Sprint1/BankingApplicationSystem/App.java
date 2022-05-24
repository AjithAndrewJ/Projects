package Sprint1.BankingApplicationSystem;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main( String[] args ){
    	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	Session session=factory.openSession();
    	int choice;
    	BankService bs=new BankService();
    	Scanner sc=new Scanner(System.in);
    	do {
	    	System.out.println("Press 1. for Add Account\nPress 2. for Withdrawal Amount\n"
	    			+ "Press 3. for Deposit Amount\nPress 4. for Check Balance\nPress 5. for Transaction History\n"
	    			+ "Press 6. for Update Account\nPress 7. for Delete Acount\nPress 8. for Quit"); 
	    	System.out.println("===================================================================="); 
	    	choice=bs.inputMisMat(session); 
	    	System.out.println("===================================================================="); 
	    	switch(choice) {
	    	case 1:
	    		bs.createAccount(session);
	    		break;
	    	case 2:
	    		bs.createWithdrawal(session);
	    		break;
	    	case 3:
	    		bs.createDeposit(session);
	    		break;
	    	case 4:
	    		bs.createCheckBalance(session);
	    		break;
	    	case 5:
	    		bs.createTransactionHistory(session);
	    		break;
	    	case 6:
	    		bs.createUpdateAccount(session);
	    		break;
	    	case 7:	
	    		bs.createDeleteAccount(session);
	    		break;
	    	case 8:
	    		System.out.println("Thank You Visit Again!");
	    		System.out.println("===================================================================="); 
	    		break;
	    	default:
	    		System.err.println("Enter the Correct choice!");
	    		System.out.println("====================================================================");
	    	}
    	}while(choice!=8);
    	sc.close();
    }
}
