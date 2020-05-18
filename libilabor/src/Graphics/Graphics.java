package Graphics;
import java.awt.*;
import javax.swing.*;
import Controller.*;
import Modell.*;

public class Graphics implements IView {
	Menu menu;
	GameArea garea;
	EndGame eg;
	NewGameWindow ngm;
	
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
	public void initializeMenu(Controller controller) {
		menu = new Menu(controller);
	}



	public void initializeEndGame(Controller controller) {
		eg = new EndGame(controller);

	}
	

	
	@Override
	public void initializeGameArea(IModell modell) {
		garea= new GameArea((Map) modell);

	}

	@Override
	public void dispose() {
		garea.dispose();
	}

	@Override
	public void scientistSkillWindow(int cap) {
		garea.scientistSkillWindow(cap);
	}
}
