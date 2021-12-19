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
			//damos play a la musica de fondo
			playMusic();
			//cargamos el archivo fxml como rrot o grupo de nodos
			Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
			//instanciamos la escena y como parametro le damos el grupo de nodos
			Scene sceneMainMenu = new Scene(root);
			//cargamos el archivo de estilos css para darle forma al archivo fxml y a la escena
			sceneMainMenu.getStylesheets().add(getClass().getResource("/styles/mainMenu.css").toExternalForm());	
			//cargamos el icono para la ventana
			Image icon = new Image(getClass().getResourceAsStream("/images/icon.png"));
			//seteamos el icono a la ventana
			primaryStage.getIcons().add(icon);
			//ponemos un titulo a la ventana
			primaryStage.setTitle("Animal Pop It V2");
			//al stage oescenario le mandamos ocmo escena el menuprincipal
			primaryStage.setScene(sceneMainMenu);
			//determinamos si es pantalla completa o no
			//primaryStage.setFullScreen(true);
			//definimos si la ventana es redimensionable
			primaryStage.setResizable(false);
			//mostramos la ventana
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
	//metodo para cargar y configurar la musica de fondo
	protected static MediaPlayer mediaPlayer;
	public void playMusic() {
		Media audio = new Media(getClass().getResource("/audio/MainMenu.wav").toString());		  
		  mediaPlayer= new MediaPlayer(audio);
		 mediaPlayer.play();
		 mediaPlayer.setCycleCount(10);
	}
	//alert confirmation to exit the aplication
	private void exit(Stage stage) {
		//creamos una nueva ventana vacia
		DialogPane dialog;
		//definimos de que tipo es la ventana
		Alert exitAlert = new Alert(AlertType.CONFIRMATION);
		//titulo a la ventana
		exitAlert.setTitle("Animal Pop It Alert");
		//texto que va en el cuerpo de la nueva ventana
		exitAlert.setHeaderText("");
		exitAlert.setContentText("¿Esta seguro que desea salir?");
		// a la ventana vacia la llenamos con la ventana de alerta
		dialog = exitAlert.getDialogPane();
		//cargamos estilos para la ventana, si asi los tiene
		dialog.getStylesheets().add(getClass().getResource("/styles/general.css").toExternalForm());
		dialog.getStyleClass().add("dialog");
		//definimos que hacer en la ventana
		if(exitAlert.showAndWait().get()==ButtonType.OK) {
			stage.close();
			
		}		
	}
	//metodo principal
	public static void main(String[] args) {
		launch(args);
	}
	
}