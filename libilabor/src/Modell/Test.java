package Modell;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import Controller.Controller;
import Graphics.Graphics;



public class Test {

    public static void main(String[] args)
    {
    /*	String filePath = new File("").getAbsolutePath();
    	File file1 = new File(filePath +"/kimenet.txt"); 
    	File file2 = new File(filePath +"/elvart_kimenet.txt");
    	try{  
    	file1.createNewFile(); 
    	file2.createNewFile();
    	}   
    	catch (IOException e){  
    	e.printStackTrace();    
    	}        
    	
    	
    	CommandHandler ch = new CommandHandler();
    	try {
			ch.handling();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	try {
			CompareTexts.compare();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    	/*CommandHandler ch = new CommandHandler();
		try 
		{
			ch.handling();
		} catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/

        Controller c=new Controller();
        c.initializeMenu();
        
        /*CommandHandler ch = new CommandHandler();
		try 
		{
			ch.handling();
		} catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/

    	//Graphics graphics = new Graphics();
    	//graphics.initializeMenu();
    	//graphics.initializeNewGameMenu();
    	//graphics.initializeEndGame();
    }
 }

    	