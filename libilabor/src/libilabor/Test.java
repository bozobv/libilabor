package libilabor;

import java.io.File;
import java.io.IOException;



public class Test {

    public static void main(String[] args)
    {
    	/*String filePath = new File("").getAbsolutePath();
    	File file1 = new File(filePath +"/libilabor/src/kimenet.txt"); 
    	File file2 = new File(filePath +"/libilabor/src/elvart_kimenet.txt");
    	try{  
    	file1.createNewFile(); 
    	file2.createNewFile();
    	}   
    	catch (IOException e){  
    	e.printStackTrace();    
    	}  /*/       
    	
    	
    	CommandHandler ch = new CommandHandler();
    	ch.handling();
    	
    	try {
			CompareTexts.compare();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 }
