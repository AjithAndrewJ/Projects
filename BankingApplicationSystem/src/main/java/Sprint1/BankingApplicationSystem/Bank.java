package Sprint1.BankingApplicationSystem;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity 
public class Bank {
	@Id
	protected int accno;
	protected String holderName;
	protected long accbalance;
	
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public long getAccbalance() {
		return accbalance;
	}
	public void setAccbalance(long accbalance) {
		this.accbalance = accbalance;
	}
	public Bank(int accno, String holderName, long accbalance) {
		super();
		this.accno = accno;
		this.holderName = holderName;
		this.accbalance = accbalance;
	}
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
}
