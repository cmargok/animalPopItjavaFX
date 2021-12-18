package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Task;

public class GameContollers  implements Initializable{

	@FXML
	private Button pig,wolf,sheep,dog,frog,chicken,cow,lyon,cat,monkey;
	@FXML
	private Label level;
	@FXML
	private ImageView pigImage,wolfImage,sheepImage,dogImage,frogImage,chickenImage,cowImage,lyonImage,catImage,monkeyImage;
	
	
	private String[] sequence,answers;
	private Sound soundBotton,AnimalSound;
	private static final String[] AnimalsList = {"pig","wolf","sheep","dog","frog",
												"chicken","cow", "lyon","cat","monkey"};
	private int delayTime=2000;

	private int levelNumber = 1;	
	private Sound pigSound = new Sound("pig", "botton");
	private Sound wolfSound = new Sound("wolf", "botton");
	private Sound sheepSound = new Sound("sheep", "botton");
	private Sound dogSound = new Sound("dog", "botton");
	private Sound frogSound = new Sound("frog", "botton");
	private Sound chickenSound = new Sound("chicken", "botton");
	private Sound cowSound = new Sound("cow", "botton");
	private Sound lyonSound = new Sound("lyon", "botton");
	private Sound catSound = new Sound("cat", "botton");
	private Sound monkeySound = new Sound("monkey", "botton");
	private Media audio = new Media(getClass().getResource("/audio/jungle.wav").toString());
	protected  MediaPlayer mediaGamePlayer = new MediaPlayer(audio);
	
	
	
	public void initGame() {		
		sequence=new String[levelNumber];
		level.setText(String.valueOf(levelNumber));
		disableAll(true);
		System.out.println("llamado de creacion de nivel ----------"+levelNumber);
		for (int i = 0; i < levelNumber; i++) {			
			sequence[i] = AnimalsList[(int) (Math.random() * 10)];
			System.out.println(sequence[i]);
		}
		playRound();				
	}
	
	
	public void pig() {
		allStop();
		pigSound.play();
		System.out.println("cerdo");		
	}
	public void wolf() {
		allStop();
		wolfSound.play();
		System.out.println("lobo");		
	}
		
	public void sheep() {
		allStop();
		sheepSound.play();
		System.out.println("oveja");		
	}	
	public void dog() {
		allStop();
		dogSound.play();
		System.out.println("dog");		
	}
	public void frog() {
		allStop();
		frogSound.play();
		System.out.println("rana");		
	}
	public void chicken() {
		allStop();
		chickenSound.play();
		System.out.println("gallo");		
	}
	public void cow() {
		allStop();
		cowSound.play();
		System.out.println("vaca");		
	}
	public void lyon() {
		allStop();
		lyonSound.play();
		System.out.println("leon");		
	}
	public void cat() {
		allStop();
		catSound.play();
		System.out.println("gato");		
	}
	public void monkey() {	
		allStop();
		monkeySound.play();
		System.out.println("mono");		
	}
	
	
	
	
	
	public void playRound() {

		Task<Void> showSequence = new Task<Void>() {

			@Override
			protected Void call() throws Exception {
				System.out.println("nivel actual "+levelNumber);
				try {
					System.out.println("esntre");
                    Thread.sleep(1500);
                  
                } catch (InterruptedException e) {
                	
                }
			
				for (int i = 0 ; i< levelNumber ; i++) {	
					System.out.println("posicion "+(i+1));
					
					switch (sequence[i]) {
						case "dog":					
							System.out.println("dog");
							dogImage.setVisible(true);
							dogSound.play();
							setDelay(delayTime);
							setImageInvisible(sequence[i]);						
							break;
						case "cat":					
							System.out.println("cat");
							catImage.setVisible(true);
							catSound.play();	
							setDelay(delayTime);
							setImageInvisible(sequence[i]);
							break;
						case "cow":			
							System.out.println("cow");
							cowImage.setVisible(true);
							cowSound.play();	
							setDelay(delayTime);
							setImageInvisible(sequence[i]);
							break;
						case "chicken":			
							System.out.println("chicken");
							chickenImage.setVisible(true);
							chickenSound.play();
							setDelay(delayTime);
							setImageInvisible(sequence[i]);
							break;
						case "pig":			
							System.out.println("pig mon");
							pigImage.setVisible(true);					
							pigSound.play();	
							setDelay(delayTime);
							setImageInvisible(sequence[i]);
							break;
						case "frog":
							System.out.println("frog");
							frogImage.setVisible(true);
							frogSound.play();	
							setDelay(delayTime);
							setImageInvisible(sequence[i]);
							break;
						case "lyon":
							System.out.println("lyon");
							lyonImage.setVisible(true);
							lyonSound.play();
							setDelay(delayTime);
							setImageInvisible(sequence[i]);
							break;
						case "monkey":
							monkeyImage.setVisible(true);
							monkeySound.play();
							System.out.println("monkey");
							setDelay(delayTime);
							setImageInvisible(sequence[i]);
							break;
						case "sheep":
							System.out.println("sheep");
							sheepImage.setVisible(true);
							sheepSound.play();
							setDelay(delayTime);
							setImageInvisible(sequence[i]);
							break;
						case "wolf":
							System.out.println("wolf");
							wolfImage.setVisible(true);
							wolfSound.play();
							setDelay(delayTime);
							setImageInvisible(sequence[i]);
							break;								
					}	
					//end for		
				}			
				disableAll(false);			
				levelNumber++;
				System.out.println("proximo nivel -> "+levelNumber);				
				return null;			
			}			
		};		
		new Thread(showSequence).start();		
	}
	
	//metodo para parar sonidos de los animales
	private void allStop() {
		pigSound.stop(); 
		wolfSound.stop(); 
		sheepSound.stop(); 
		dogSound.stop(); 
		frogSound.stop(); 
		chickenSound.stop(); 
		cowSound.stop(); 
		lyonSound.stop(); 
		catSound.stop(); 
		monkeySound.stop(); 		
	}
	
	//metodo para hacer un delay al hilo
	private void setDelay(int z) {			
		try {
            Thread.sleep(z);          
        }catch (InterruptedException e) {        	
        }		
	}
	
	//metodo para deshabilitar los botones y evitar click sobre los animales
	private void disableAll(boolean t) {		
		pig.setDisable(t);
		pig.setOpacity(1);
		wolf.setDisable(t);
		wolf.setOpacity(1);
		sheep.setDisable(t);
		sheep.setOpacity(1);
		dog.setDisable(t);
		dog.setOpacity(1);
		frog.setDisable(t);
		frog.setOpacity(1);
		chicken.setDisable(t);
		chicken.setOpacity(1);
		cow.setDisable(t);
		cow.setOpacity(1);
		lyon.setDisable(t);
		lyon.setOpacity(1);
		cat.setDisable(t);
		cat.setOpacity(1);
		monkey.setDisable(t);
		monkey.setOpacity(1);		
	}	
	
	//metodo para mostrar visualmente la secuencia
	private void setImageInvisible(String animal) {		
		switch (animal) {
		case "dog":		
			dogImage.setVisible(false);			
			break;
		case "cat":		
			catImage.setVisible(false);								
			break;
		case "cow":
			cowImage.setVisible(false);							
			break;
		case "chicken":
			chickenImage.setVisible(false);			
			break;
		case "pig":	;
			pigImage.setVisible(false);									
			break;
		case "frog":		
			frogImage.setVisible(false);								
			break;
		case "lyon":	
			lyonImage.setVisible(false);		
			break;
		case "monkey":
			monkeyImage.setVisible(false);			
			break;
		case "sheep":		
			sheepImage.setVisible(false);			
			break;
		case "wolf":	
			wolfImage.setVisible(false);			
			break;		
		}
	}
	
	
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		mediaGamePlayer.play();
		mediaGamePlayer.setCycleCount(10);
		
	}
	
	
	
	
	
	
	
	
}


