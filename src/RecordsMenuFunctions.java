import javax.swing.JOptionPane;

public class RecordsMenuFunctions extends BankApplication {

	
	public static void setOverdraft() {
		if(table.get(currentItem).getAccountType().trim().equals("Current")){
			String newOverdraftStr = JOptionPane.showInputDialog(null, "Enter new Overdraft", JOptionPane.OK_CANCEL_OPTION);
			overdraftTextField.setText(newOverdraftStr);
			table.get(currentItem).setOverdraft(Double.parseDouble(newOverdraftStr));
		}
		else
			JOptionPane.showMessageDialog(null, "Overdraft only applies to Current Accounts");
	
	}
	
	
	
	public static void deleteRecord() {
		
		table.remove(currentItem);
		JOptionPane.showMessageDialog(null, "Account Deleted");
		

		currentItem=0;
		while(!table.containsKey(currentItem)){
			currentItem++;
		}
		Display.displayDetails(currentItem);
	}
	
	public static void modifyRecord() {
		surnameTextField.setEditable(true);
		firstNameTextField.setEditable(true);
		
		openValues = true;
	}
		
	
	

	
	public static void setInterest() {
		
		 String interestRateStr = JOptionPane.showInputDialog("Enter Interest Rate: (do not type the % sign)");
		 if(interestRateStr!=null)
			 interestRate = Double.parseDouble(interestRateStr);
	
	}
}
