import java.util.Map;

import javax.swing.JOptionPane;

public class TransactionsMenuFunctions extends BankApplication {

	public static void calculateInterest() {
		if(table.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No records in the System");
		}else {
		for (Map.Entry<Integer, BankAccount> entry : table.entrySet()) {
			
			if(entry.getValue().getAccountType().equals("Current")){
				if(interestRate < 100 && interestRate >0) {
				double equation = 1 + ((interestRate)/100);
				entry.getValue().setBalance(entry.getValue().getBalance()*equation);
				JOptionPane.showMessageDialog(null, "Balances Updated");
				Display.displayDetails(entry.getKey());
			}else JOptionPane.showMessageDialog(null, "Can't deposit a negative amount.");
		}
		}
		}
	}
	
	public static void deposit() {
		if(table.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No records in the System");
		}else {
		String accNum = JOptionPane.showInputDialog("Account number to deposit into: ");
		boolean found = false;
		if(accNum!=null) {
		
		for (Map.Entry<Integer, BankAccount> entry : table.entrySet()) {
			if(accNum.equals(entry.getValue().getAccountNumber().trim())){
				found = true;
				String toDeposit = JOptionPane.showInputDialog("Account found, Enter Amount to Deposit: ");
				if(toDeposit!=null) {
					
				
					if (Double.parseDouble(toDeposit)<0) {
						JOptionPane.showMessageDialog(null, "Can't deposit a negative amount.");
					}
					else {
						
				
					entry.getValue().setBalance(entry.getValue().getBalance() + Double.parseDouble(toDeposit));
					Display.displayDetails(entry.getKey());
					}
				} else {
					Display.displayDetails(entry.getKey());
				}
			}
		}
		if (!found)
			JOptionPane.showMessageDialog(null, "Account number " + accNum + " not found.");
	}else {Display.displayDetails(currentItem);}
		}
	}
   
	public static void withdraw() {
		if(table.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No records in the System");
		}else {
		String accNum = JOptionPane.showInputDialog("Account number to withdraw from: ");
		
		if(accNum!=null) {
		
		for (Map.Entry<Integer, BankAccount> entry : table.entrySet()) {
			

			if(accNum.equals(entry.getValue().getAccountNumber().trim())){
				
				String toWithdraw = JOptionPane.showInputDialog("Account found, Enter Amount to Withdraw: ");
				
				if(toWithdraw != null) {
				if(entry.getValue().getAccountType().trim().equals("Current")){
					if(Double.parseDouble(toWithdraw) > entry.getValue().getBalance() + entry.getValue().getOverdraft())
						JOptionPane.showMessageDialog(null, "Transaction exceeds overdraft limit");
					else{
						entry.getValue().setBalance(entry.getValue().getBalance() - Double.parseDouble(toWithdraw));
						Display.displayDetails(entry.getKey());
					}
				}
				else if(entry.getValue().getAccountType().trim().equals("Deposit")){
					if(Double.parseDouble(toWithdraw) <= entry.getValue().getBalance()){
						entry.getValue().setBalance(entry.getValue().getBalance()-Double.parseDouble(toWithdraw));
						Display.displayDetails(entry.getKey());
					}
					else
						JOptionPane.showMessageDialog(null, "Insufficient funds.");
				}
				}else {Display.displayDetails(entry.getKey());}
			}			
		}
		}else {Display.displayDetails(currentItem);}
	}
	}
}
