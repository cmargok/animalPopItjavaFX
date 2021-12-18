package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		System.out.println("------------------------------");
		System.out.println("New Game");
		
		try {
			playMusic();
		/*	Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
			Scene sceneMainMenu = new Scene(root);
			sceneMainMenu.getStylesheets().add(getClass().getResource("/styles/mainMenu.css").toExternalForm());*/
			Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
			Scene sceneMainMenu = new Scene(root);
			sceneMainMenu.getStylesheets().add(getClass().getResource("/styles/mainMenu.css").toExternalForm());
			Image icon = new Image(getClass().getResourceAsStream("/images/icon.png"));
			primaryStage.getIcons().add(icon);
			primaryStage.setTitle("Animal Pop It V2");
			primaryStage.setScene(sceneMainMenu);
			//primaryStage.setFullScreen(true);
			primaryStage.setResizable(false);
			primaryStage.show();
			//lambda expression to set the X and ALT+F4 actions "close"
			primaryStage.setOnCloseRequest(event -> {
				event.consume();
				exit(primaryStage);
				});
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//PRIVATE METHODS
	protected static MediaPlayer mediaPlayer;
	public void playMusic() {
		Media audio = new Media(getClass().getResource("/audio/MainMenu.wav").toString());		  
		  mediaPlayer= new MediaPlayer(audio);
		 mediaPlayer.play();
		 mediaPlayer.setCycleCount(10);
	}
	//alert confirmation to exit the aplication
	private void exit(Stage stage) {
		DialogPane dialog;
		Alert exitAlert = new Alert(AlertType.CONFIRMATION);
		exitAlert.setTitle("Animal Pop It Alert");
		exitAlert.setHeaderText("");
		exitAlert.setContentText("¿Esta seguro que desea salir?");
		
		dialog = exitAlert.getDialogPane();
		dialog.getStylesheets().add(getClass().getResource("/styles/general.css").toExternalForm());
		
		dialog.getStyleClass().add("dialog");
		if(exitAlert.showAndWait().get()==ButtonType.OK) {
			stage.close();
			
		}		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}