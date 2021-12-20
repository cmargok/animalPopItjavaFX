package application;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainMenuControllers  implements Initializable{

	//atributos privados
	private boolean help;
	private boolean settings;
	private boolean credits;
	private DialogPane dialog;
	public static Player user;
	private Parent root;
	private Scene scene;
	private Stage stage1;
	
	
	Stage stage;
	//enlazando los ids desde fxml para poder trabajar con ellos
	@FXML
	ImageView popUpView,mute,shadowImage,entryUser,title;
	@FXML 
	private AnchorPane sceneMainMenu;
	@FXML 
	private Button exitButton,cancelInitGame,initGame,closePront,playButton;
	@FXML
	private TextField entryUserField;
	
	private static String nameUser;
	
	//archivos privados u ocultos
	private Sound soundBotton = new Sound("botton","botton");
	
	private Image unmuteImage = new Image(getClass().getResourceAsStream("/images/unmute.png"));
	private Image muteImage = new Image(getClass().getResourceAsStream("/images/mute.png"));
	
	private Image helpImage = new Image(getClass().getResourceAsStream("/images/helpImage.png"));		
	private Image creditsImage = new Image(getClass().getResourceAsStream("/images/creditsImage.png"));
	private Image settingsImage = new Image(getClass().getResourceAsStream("/images/settingsImage.png"));		
	private ScaleTransition scale = new ScaleTransition();
	
	//boton play
	public void playButtonActions() {				
			popUpView.setVisible(false);
			shadowImage.setVisible(true);	
			initGame.setVisible(true);	
			cancelInitGame.setVisible(true);
			entryUser.setVisible(true);
			entryUserField.requestFocus();
			entryUserField.setVisible(true);
			enter();			
	}	
	//metodo para definir que pasa cuando se da enter, estando ubicado en el cuadro de texto
	//inicia el conteo desde el enter, siempre que se cumplan las condiciones para ello
	private void enter() {
		entryUserField.setOnKeyPressed(event ->{			
			if(event.getCode() == KeyCode.ENTER) {				
				String c = entryUserField.getText();					
				if(c=="" || c.length()<=2) {						
					entryUserField.clear();
					entryUserField.setText("");
					// aqui debemos mostrar letrero que indique("Digite un usuario correcto");					
				}else{
					System.out.println("usuario validado correctamente");
					entryUserField.setEditable(false);
					setNameForUser();					
					try {	
						//aqui cambiamos la escena por el conteo
						root = FXMLLoader.load(getClass().getResource("countDownw.fxml"));
						stage1 = (Stage)((Node) event.getSource()).getScene().getWindow();
						scene = new Scene(root);
						scene.getStylesheets().add(getClass().getResource("/styles/general.css").toExternalForm());
						stage1.setScene(scene);
						stage1.show();						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
					event.consume();					
				}				
			}		
		});	
	}
	//metodo para iniciar el conteo desd eel mouse, siempre que se cumplan las condiciones para ello
	public void initGame(ActionEvent event) throws IOException {		
		String c = entryUserField.getText();					
		if(c=="" || c.length()<=2) {						
			entryUserField.clear();
			entryUserField.setText("");
			// aqui debemos mostrar letrero que indique("Digite un usuario correcto");					
		}else{
			System.out.println("usuario validado correctamente");
			entryUserField.setEditable(false);
			setNameForUser();
			//aqui cambiamos la escena por el conteos
			root = FXMLLoader.load(getClass().getResource("countDownw.fxml"));
			stage1 = (Stage)((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/styles/general.css").toExternalForm());
			stage1.setScene(scene);
			stage1.show();
			event.consume();
		}		
	}	
	//metodo para definir lo que ocurre cuando le damos al boton cancelar, que esta debajo del cuadro de texto
	public void cancelInit() {
		shadowImage.setVisible(false);	
		initGame.setVisible(false);	
		cancelInitGame.setVisible(false);
		entryUserField.setVisible(false);
		entryUserField.clear();
		entryUserField.setText("");
		entryUser.setVisible(false);
		closePront.setVisible(false);
		popUpView.setVisible(false);	
	}
	//boton ayuda o instrucciones
	public void helpButtonActions() {	
		soundBotton.play();			
		if(!help) {
			setImageView(helpImage, 1);		
		}else {
			popUpView.setVisible(false);	
			closePront.setVisible(false);
			help=false;				
		}		
	}
	//boton configuraciones
	public void settingsButtonActions() {		
		soundBotton.play();		
		if(!settings) {
			setImageView(settingsImage, 2);				
		}else {
			popUpView.setVisible(false);
			closePront.setVisible(false);
			settings=false;			
		}		
	}
	//boton creditos
	public void creditsButtonActions() {	
		soundBotton.play();					
		if(!credits) {
			setImageView(creditsImage, 3);		
		}else {
			popUpView.setVisible(false);	
			closePront.setVisible(false);
			credits=false;			
		}		
	}
	//boton silenciar sonido
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
	//boton salir
	public void exit() {
		Alert exitAlert = new Alert(AlertType.CONFIRMATION);
		exitAlert.setTitle("Animal Pop It Alert");
		exitAlert.setHeaderText("");
		exitAlert.setContentText("¿Esta seguro que desea salir?");		
		dialog = exitAlert.getDialogPane();
		dialog.getStylesheets().add(getClass().getResource("/styles/general.css").toExternalForm());		
		dialog.getStyleClass().add("dialog");		
		if(exitAlert.showAndWait().get()==ButtonType.OK) {
			stage =(Stage) sceneMainMenu.getScene().getWindow();			
			stage.close();
		}				
	}
		
	//PRIVATE METHODS
	//definir que imagen se va a mostrar, help, settings or credits
	private void setImageView(Image im, int c) {
		closePront.setVisible(true);
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
	
	
	private void setNameForUser() {					
		if(entryUserField.getLength()<=10) {
			nameUser = entryUserField.getText();			
		}else {
			nameUser = entryUserField.getText(0,10);		
		}
		user = new Player(nameUser);
		System.out.println("usuario: "+ user.getNamePlayer());	
	}
	private void playButtonAnimation() {
		ScaleTransition play = new ScaleTransition();
		play.setDuration(Duration.millis(850)); 
		play.setNode(playButton);
		play.setByX(0.08);
		play.setByY(0.08);
		play.setCycleCount(play.INDEFINITE);
		play.setAutoReverse(true); 
		play.play();		
	}
	
	

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		playButtonAnimation();
		
	}
}