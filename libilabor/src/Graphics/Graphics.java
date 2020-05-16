package Graphics;
import Controller.*;

public class Graphics implements IView {
	Menu menu;
	GameArea garea;
	EndGame eg;
	
	@Override
	public void initialize(){
		// TODO Auto-generated method stub
	}
	@Override
	public void refreshGraphics(){
		// TODO Auto-generated method stub
		garea.refresh();
	}

	@Override
	public Menu initializeMenu() {
		menu = new Menu();
		return menu;
	}
	
	public EndGame initializeEndGame() {
		eg= new EndGame();
		return eg;
	}
	@Override
	public GameArea initializeGameArea() {
		// TODO Auto-generated method stub
		garea= new GameArea();
		return garea;
	}
}
