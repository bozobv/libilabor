package Graphics;
import Controller.*;
import Modell.*;
public class Graphics implements IView {
	Menu menu;
	GameArea garea;
	EndGame eg;
	
	@Override
	public void initialize(){
		// TODO Auto-generated method stub
	}
	@Override
	public void refreshGraphics(IModell modell){
		// TODO Auto-generated method stub
		garea.refresh(modell);
	}

	@Override
	public void initializeMenu() {
		menu = new Menu();

	}
	
	public void initializeEndGame() {
		eg= new EndGame();

	}
	@Override
	public void initializeGameArea() {
		// TODO Auto-generated method stub
		garea= new GameArea();

	}
}
