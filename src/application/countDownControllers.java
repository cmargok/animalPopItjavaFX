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

		@FXML
		private Label countLabel;
		@FXML
		private ImageView countBack,tipViewA,tipViewB;			
		@FXML
		private Button go;
		
		private Timeline timer;
		private int number=3;
		private Image tipA, tipB;
		private Parent root;
		private Scene scene;
		private Stage stage2;
		private Sound CountSound = new Sound("count", "botton");
				
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			System.out.println("------------------------------");
			System.out.println("New CountDown");
			String tip[] = new String [2];
			tip=setBackGround();
			tipA = new Image(getClass().getResourceAsStream("/images/"+tip[0]+".png"));
			tipB = new Image(getClass().getResourceAsStream("/images/"+tip[1]+".png"));
			tipViewA.setImage(tipA);
			tipViewB.setImage(tipB);
			
			timer = new Timeline();
			timer.setCycleCount(Timeline.INDEFINITE);
			timer.getKeyFrames().add( 
					new KeyFrame(Duration.millis(1000), 
					e -> {
						if(number>=1) {						
							countLabel.setText(String.valueOf(number));
							CountSound.play();
							System.out.println(number);
							number--;
						}else {								
							countLabel.setText("GO");
							System.out.println("go");							
							//sCountSound.play();
							timer.stop();	
							go.setVisible(true);
							
						}
					})); 
		
			try {
			timer.play();
			 
			 
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			Main.mediaPlayer.stop();	
		}		
		
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
