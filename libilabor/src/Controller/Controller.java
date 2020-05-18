package Controller;

import Graphics.*;
import Modell.*;

public class Controller 
{
	IModell modell;
	
	IView view=new Graphics();
	
	public void initializeMap(int height, int width, int FrozenItemDrop, int snowHeight) {
        modell = new Map(height,width,FrozenItemDrop, snowHeight,this);
	}
	
	public void startGame()
	{
		view.initializeGameArea(modell);
	}
	
	public void endGame()
	{
		view.initializeEndGame(this);
	}
		
	public void refreshGraphics(IModell modell){
		view.refreshGraphics(modell);

	}
	
	public void play(){	

	}
	public void setIfController(){
		modell.setIfController(this);
	}
	
	public void initializeMenu(){
	    view.initializeMenu(this);
    }

	public IModell getModell() {
		return modell;
	}

	public void setModell(IModell modell) {
		this.modell = modell;
	}

	public void dispose() {
		view.dispose();
	}
}
