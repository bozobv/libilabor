package Controller;

import Graphics.*;
import Modell.*;

public class Controller 
{
	IModell modell;
	IView view;
	
	public Controller createController() {
		view=new Graphics();
		Menu menu=view.initializeMenu();
		
		//TODO implementalni a menu reszt meg mindenfele if-et hogy jo adatokat adott-e meg ilyenek ha nem fuck off
		//----------------------------------------
		int height = 0,width = 0,FrozenItemDrop = 0,snowHeight = 0;
		//----------------------------------------
		
		Controller controller= new Controller(height, width, FrozenItemDrop, snowHeight);
		return controller;
	}
	
	private Controller(int height, int width, int FrozenItemDrop, int snowHeight) {
		this.modell=new Map(height, width, FrozenItemDrop, snowHeight);
	}
	
	void startGame(){
		
	}
	
	void endGame(){
		EndGame endGame=view.initializeEndGame();
	}
	
	void refreshGraphics(){
		view.updateGraphics();
	}
	
	void play(){
		
		
	}
}
