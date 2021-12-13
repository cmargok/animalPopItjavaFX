package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Main extends Application {
	
	
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			playMusic();
			Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	protected static MediaPlayer mediaPlayer;
	public void playMusic() {
		Media audio = new Media(getClass().getResource("/audio/MainMenu.wav").toString());		  
		  mediaPlayer= new MediaPlayer(audio);
		 mediaPlayer.play();
		 mediaPlayer.setCycleCount(5);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
