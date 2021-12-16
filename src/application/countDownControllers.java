package application;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
public class countDownControllers  implements Initializable{

		@FXML
		private Label countLabel;
		@FXML
		private ImageView countBack,tipViewA,tipViewB;			
		
		private Timeline timer;
		private int number=3;
		private Image tipA, tipB;// = new Image(getClass().getResourceAsStream("/images/unmute.png"));
				
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
						if(number>0) {						
							countLabel.setText(String.valueOf(number));
							number--;
						}else {							
							//countLabel.setStyle("-fx-font-size: 20px;");
							countLabel.setText("GO");
							timer.stop();
						}
					})); 
		
			try {
			timer.play();
			}catch(Exception e) {
				e.printStackTrace();
			}
			Main.mediaPlayer.stop();	
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
			default : r= "tip0"; break;				
			}		
			return r;			
		}
		
}
