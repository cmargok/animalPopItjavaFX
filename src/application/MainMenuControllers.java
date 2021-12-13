package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MainMenuControllers {

//	 public void sound}
	private boolean help;
	private boolean settings;
	private boolean credits;
	
	@FXML
	ImageView instructionsView,mute;
	Button helpButton;	
	
	Image helpImage = new Image(getClass().getResourceAsStream("/images/helpImage.png"));	
	Image unmuteImage = new Image(getClass().getResourceAsStream("/images/unmute.png"));
	Image muteImage = new Image(getClass().getResourceAsStream("/images/mute.png"));
	Image creditsImage = new Image(getClass().getResourceAsStream("/images/creditsImage.png"));
	Image settingsImage = new Image(getClass().getResourceAsStream("/images/settingsImage.png"));
	
	
	public void helpButtonActions() {
		Sound sound = new Sound("botton","botton");
		sound.play();	
		
		
		
		
		
		if(!help) {
			instructionsView.setImage(helpImage);	
			instructionsView.setFitHeight(1012.0);
			instructionsView.setFitWidth(1114.0);
			instructionsView.setVisible(true);
			help=true;	
			settings=false;
			credits=false;
			
		}
		else {
			instructionsView.setVisible(false);		
			help=false;	
			
		}		
	}
	public void settingsButtonActions() {
		Sound sound = new Sound("botton","botton");
		sound.play();			
		
		if(!settings) {
			instructionsView.setImage(settingsImage);	
			instructionsView.setFitHeight(1012.0);
			instructionsView.setFitWidth(1114.0);
			instructionsView.setVisible(true);
			settings=true;
			credits=false;
			help=false;	
			
			
		}
		else {
			instructionsView.setVisible(false);		
			credits=false;			
		}		
	}
	public void creditsButtonActions() {
		Sound sound = new Sound("botton","botton");
		sound.play();			
		
		if(!credits) {
			instructionsView.setImage(creditsImage);	
			instructionsView.setFitHeight(1012.0);
			instructionsView.setFitWidth(1114.0);
			instructionsView.setVisible(true);
			credits=true;
			help=false;	
			settings=false;
			
		}
		else {
			instructionsView.setVisible(false);		
			credits=false;			
		}		
	}
	
	
	
	
	
	public void mute(ActionEvent e) {			
		//Main.mediaPlayer.stop();
		
		if(!Main.mediaPlayer.isMute()) {
			Main.mediaPlayer.setMute(true);
			mute.setImage(unmuteImage);
			
			
		}
		else {
			Main.mediaPlayer.setMute(false);	
			mute.setImage(muteImage);
		}		
	}
	
	public void exit() {
		
		System.exit(0);	
		
	}
	
	
	
			
	
			
}