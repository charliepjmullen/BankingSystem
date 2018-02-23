import java.io.IOException;
import java.util.Map;

import javax.swing.JOptionPane;

public class SaveFile extends BankFileFunctions{

	public static void saveToFile(){
		
		if(table.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No records in the System");
		}else {
		RandomAccessBankAccount record = new RandomAccessBankAccount();
	
	      
	      for (Map.Entry<Integer, BankAccount> entry : table.entrySet()) {
			   record.setAccountID(entry.getValue().getAccountID());
			   record.setAccountNumber(entry.getValue().getAccountNumber());
			   record.setFirstName(entry.getValue().getFirstName());
			   record.setSurname(entry.getValue().getSurname());
			   record.setAccountType(entry.getValue().getAccountType());
			   record.setBalance(entry.getValue().getBalance());
			   record.setOverdraft(entry.getValue().getOverdraft());
			   
			   if(output!=null){
			   
			      try {
						record.write( output );
					} catch (IOException u) {
						u.printStackTrace();
					}
			   }
			   
			}
	}
	

	}
	
}
