package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainMenuControllers {

	//atributos privados
	private boolean help;
	private boolean settings;
	private boolean credits;
	private DialogPane dialog;
	
	Stage stage;
	//ids desde fxml
	@FXML
	ImageView popUpView,mute,shadowImage;
	@FXML 
	private AnchorPane sceneMainMenu;
	@FXML 
	private Button exitButton,cancelInitGame,initGame;
	@FXML
	private TextField entryUserField;
	
	String nameUser;
	
	//archivos privados u ocultos
	private Sound soundBotton = new Sound("botton","botton");
	
	private Image unmuteImage = new Image(getClass().getResourceAsStream("/images/unmute.png"));
	private Image muteImage = new Image(getClass().getResourceAsStream("/images/mute.png"));
	
	private Image helpImage = new Image(getClass().getResourceAsStream("/images/helpImage.png"));		
	private Image creditsImage = new Image(getClass().getResourceAsStream("/images/creditsImage.png"));
	private Image settingsImage = new Image(getClass().getResourceAsStream("/images/settingsImage.png"));
	
	
	
	
	
	public void playButtonActions() {
		
		//	nameUser = entryUserField.getText(0, 9);
			popUpView.setVisible(false);
			shadowImage.setVisible(true);	
			initGame.setVisible(true);	
			cancelInitGame.setVisible(true);
			entryUserField.setVisible(true);
			System.out.println("nameUser");
		
	}
	
	public void initGame() {
		System.out.println("Game Starting");
	}
	public void cancelInit() {
		shadowImage.setVisible(false);	
		initGame.setVisible(false);	
		cancelInitGame.setVisible(false);
		entryUserField.setVisible(false);
		
	}
	
	public void helpButtonActions() {	
		soundBotton.play();			
		if(!help) {
			setImageView(helpImage, 1);		
		}else {
			popUpView.setVisible(false);		
			help=false;				
		}		
	}
	
	public void settingsButtonActions() {		
		soundBotton.play();		
		if(!settings) {
			setImageView(settingsImage, 2);				
		}else {
			popUpView.setVisible(false);		
			settings=false;			
		}		
	}
	
	public void creditsButtonActions() {	
		soundBotton.play();					
		if(!credits) {
			setImageView(creditsImage, 3);		
		}else {
			popUpView.setVisible(false);		
			credits=false;			
		}		
	}
	
	public void mute(ActionEvent e) {		
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
		Alert exitAlert = new Alert(AlertType.CONFIRMATION);
		exitAlert.setTitle("Animal Pop It Alert");
		exitAlert.setHeaderText("");
		exitAlert.setContentText("¿Esta seguro que desea salir?");
		
		dialog = exitAlert.getDialogPane();
		dialog.getStylesheets().add(getClass().getResource("general.css").toExternalForm());
		
		dialog.getStyleClass().add("dialog");
		
		
		if(exitAlert.showAndWait().get()==ButtonType.OK) {
			stage =(Stage) sceneMainMenu.getScene().getWindow();			
			stage.close();
		}		
		

		
		
	}
	
	
	
	//PRIVATE METHODS
	private void setImageView(Image im, int c) {
		popUpView.setImage(im);			
		popUpView.setVisible(true);		
		switch (c) {
		case 1: help=true;
				settings=false;
				credits=false;	
				break;
		case 2: settings=true;
				credits=false;
				help=false;
				break;
		case 3: credits =true;
				help=false;	
				settings=false;
				break;
		}		
	}
	
}