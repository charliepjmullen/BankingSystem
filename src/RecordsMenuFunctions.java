import javax.swing.JOptionPane;

public class RecordsMenuFunctions extends BankApplication {

	
	public static void setOverdraft() {
		if(table.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No records in the System");
		}else {
		if(table.get(currentItem).getAccountType().trim().equals("Current")){
			String newOverdraftStr = JOptionPane.showInputDialog(null, "Enter new Overdraft", JOptionPane.OK_CANCEL_OPTION);
			overdraftTextField.setText(newOverdraftStr);
			table.get(currentItem).setOverdraft(Double.parseDouble(newOverdraftStr));
		}
		else
			JOptionPane.showMessageDialog(null, "Overdraft only applies to Current Accounts");
		}
	
	}
	
	
	
	public static void deleteRecord() {
		if(table.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No records in the System");
		}else {
		table.remove(currentItem);
		JOptionPane.showMessageDialog(null, "Account Deleted");
		

		currentItem=0;
		while(!table.containsKey(currentItem)){
			currentItem++;
		}
		Display.displayDetails(currentItem);
	}
	}
	
	public static void modifyRecord() {
		if(table.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No records in the System");
		}else {
		surnameTextField.setEditable(true);
		firstNameTextField.setEditable(true);
		
		openValues = true;
	}
	}
	
	

	
	public static void setInterest() {
		if(table.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No records in the System");
		}else {
		 String interestRateStr = JOptionPane.showInputDialog("Enter Interest Rate: (do not type the % sign)");
		 if(interestRateStr!=null)
			 interestRate = Double.parseDouble(interestRateStr);
		}
	}
}
