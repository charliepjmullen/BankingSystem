import java.io.*;

import javax.swing.JFileChooser;

 
public class BankFileFunctions extends BankApplication{

	static JFileChooser fc;
	 static RandomAccessFile input;
	 static RandomAccessFile output;

	public static void writeFile(){
		SaveFile.saveToFile();
		CloseFile.closeFile();
	}
	
	public static void saveFileAs(){
		SaveFileAs.saveToFileAs();
		SaveFile.saveToFile();	
		CloseFile.closeFile();
	}
	
	public static void readFile(){
		OpenFile.openFileRead();
		ReadFile.readRecords();
		CloseFile.closeFile();		
	}
	
	
	
	
	
	
	
	
	
	

}
