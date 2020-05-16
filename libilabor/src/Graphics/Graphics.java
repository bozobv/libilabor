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
	public void updateGraphics(){
		// TODO Auto-generated method stub
	}

	@Override
	public Menu initializeMenu() {
		// TODO Auto-generated method stub
		return new Menu();
	}
	
	public EndGame initializeEndGame() {
		// TODO Auto-generated method stub
		return new EndGame();
	}
}
