package libilabor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Test {

    public static void main(String[] args)
    {
    	CompareTexts ct= new CompareTexts();
    	try {
			ct.compare();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	CommandHandler ch = new CommandHandler();
    	ch.handling();
    }
 }
