package Controller;
import Graphics.*;
public interface IView {
	
	public void initialize();
	
	public void updateGraphics();
	
	public Menu initializeMenu();
	
	public EndGame initializeEndGame();
	
}
