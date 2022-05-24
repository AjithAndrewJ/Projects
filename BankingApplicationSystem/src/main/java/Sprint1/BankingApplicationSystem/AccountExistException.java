package Sprint1.BankingApplicationSystem;

@SuppressWarnings("serial")
public class AccountExistException extends Exception{
	 public AccountExistException(String message) {
		 super(message);
	 }
}
