package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
public class countDownControllers  implements Initializable{

		//enlazando los ids desde fxml para poder trabajar con ellos
		@FXML
		private Label countLabel;
		@FXML
		private ImageView countBack,tipViewA,tipViewB;			
		@FXML
		private Button go;
		
		//atributos privados
		private Timeline timer;
		private int number=3;
		private Image tipA, tipB;
		private Parent root;
		private Scene scene;
		private Stage stage2;
		//instaciar nuevo sonido
		private Sound CountSound = new Sound("count", "botton");
				
		//como la clase es una clase inicialeble, en el siguiente metodo se define
		//lo que se realiza una vez sea instanciada o llamada la clase
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			System.out.println("------------------------------");
			System.out.println("New CountDown");
			//creamos array con 2 indices, para introducir los valores dados por el metodo que genera los tips de forma aleatoria
			String tip[] = new String [2];
			tip=setBackGround();
			tipA = new Image(getClass().getResourceAsStream("/images/"+tip[0]+".png"));
			tipB = new Image(getClass().getResourceAsStream("/images/"+tip[1]+".png"));
			tipViewA.setImage(tipA);
			tipViewB.setImage(tipB);
			//creamos un timer, que funciona como un thread aparte
			// sirve para actualizar el conteo regresivo desde 3 hasta que aparezca el boton Go			
			timer = new Timeline();
			timer.setCycleCount(Timeline.INDEFINITE);
			//definimos el conteo
			timer.getKeyFrames().add( 
					//definimos cuantos milisegundos dura cada conteo
					new KeyFrame(Duration.millis(1000), 
					e -> {
						if(number>=1) {			
							//cambiamos el texto del label, por el texto deseado
							countLabel.setText(String.valueOf(number));
							//reproducimos el sonido
							CountSound.play();
							System.out.println(number);
							number--;
						}else {								
							countLabel.setText("GO");
							System.out.println("go");							
							//sCountSound.play();
							timer.stop();	
							//hacemos visible el boton de go
							go.setVisible(true);							
						}
					})); 
		
			try {
			//iniciamos el contador
				timer.play();		 
			}catch(Exception e) {
				e.printStackTrace();
			}
			//paramos el sonido que venia desd eel menu pricipal
			Main.mediaPlayer.stop();	
		}		
		//una vez aparece el boton GO, se nos habilita el siguiente metodo, que cambia la escena, por la escena deseada
		//esta escena es la del juego como tal
		public void launchGame(ActionEvent event) {			
			try {
				root = FXMLLoader.load(getClass().getResource("game.fxml"));
				stage2 = (Stage)((Node) event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("/styles/game.css").toExternalForm());
				stage2.setScene(scene);
				stage2.show();				
				} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		//PRIVATE METHODS
		//metodo para sacar los 2 tips aleatorios sin repetirse, siempre que esta ventana sea llamada
		private String[] setBackGround() {
			String [] tip =new String[2];
			int a =(int) (Math.random() * 6);			
			int b;
			do {
				b =(int) (Math.random() * 6);
			}while(a==b);			
			tip[0]=ruteImage(a);
			tip[1]=ruteImage(b);						
			return tip;				
		}
		//metodo para definir la ruta de los tips, este metodo solo es llamado desde el metodo 
		private String ruteImage(int x) {			
			String r;
			switch(x){
			case 1: r= "tip0"; break;
			case 2: r= "tip1"; break;
			case 3: r= "tip2"; break;
			case 4: r= "tip3"; break;
			case 5: r= "tip4"; break;
			case 6: r= "tip5"; break;
			default : r= "tip0"; 				
			}		
			return r;			
		}
		
}
