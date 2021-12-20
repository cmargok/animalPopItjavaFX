package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.animation.ScaleTransition;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;

public class GameContollers  implements Initializable{
	
	//enlazando los ids desde fxml para poder trabajar con ellos
	@FXML
	private Button pig,wolf,sheep,dog,frog,chicken,cow,lyon,cat,monkey,playNextLevel,menuBotton,backBotton,yes,no;
	@FXML
	private Label level,nameUsercd,showAnswers,showNumberLevel;
	@FXML
	private ImageView pigImage,wolfImage,sheepImage,dogImage,frogImage,chickenImage,cowImage,lyonImage,catImage,monkeyImage,nextLevelBackground,exitConfirmation;
	
	//atributos privados
	private String[] sequence,answers;
	private static final String[] AnimalsList = {"pig","wolf","sheep","dog","frog","chicken","cow", "lyon","cat","monkey"};
	private int delayTime=2000;
	private int levelNumberr = 1;
	protected static int levelNumberStatic=1;
	private int answersPosition=0;
	private Parent root;
	private Scene scene;
	private Stage stage3;
	
	//informacion del usuario
	private String nameUser = MainMenuControllers.user.getNamePlayer();
		
	//sonidos
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
	//musica de fondo
	private Media audio = new Media(getClass().getResource("/audio/jungle.wav").toString());	
	protected  MediaPlayer mediaGamePlayer = new MediaPlayer(audio);
	
	
	//-----------------------------------------------------METODOS Y FUCIONES----------------------------------------------//
	
	//metodo que inicia el juego
	public void initGame() {	
		playNextLevel.setVisible(false);
		menuBotton.setVisible(false);
		backBotton.setVisible(false);
		nextLevelBackground.setVisible(false);
		showNumberLevel.setVisible(false);
		
		showAnswers.setText("-");
		sequence=new String[levelNumberStatic];
		level.setText(String.valueOf(levelNumberStatic));
		disableAll(true);
		System.out.println("Creando secuencia ");
		for (int i = 0; i < levelNumberStatic; i++) {			
			sequence[i] = AnimalsList[(int) (Math.random() * 10)];
			System.out.println(i+" "+sequence[i]);		
		}
		playRound();				
	}
	
	//-----------------Inicio Animales-----------------------//
	public void pig() {
		allStop();
		pigSound.play();	
		System.out.println(answersPosition+" pig");	
		answers[answersPosition]="pig";
		answersPosition++;
		showAnswers.setText(showAnswers.getText()+"pig"+"-");
		if(answersPosition==levelNumberStatic) {
			checkWin(sequence, answers);
		}
			
	}
	public void wolf() {
		allStop();
		wolfSound.play();
		System.out.println(answersPosition+" wolf");	
		answers[answersPosition]="wolf";
		answersPosition++;
		showAnswers.setText(showAnswers.getText()+"wolf"+"-");
		if(answersPosition==levelNumberStatic) {
			checkWin(sequence, answers);
		}
	}		
	public void sheep() {
		allStop();
		sheepSound.play();
		System.out.println(answersPosition+" sheep");
		answers[answersPosition]="sheep";
		showAnswers.setText(showAnswers.getText()+"sheep"+"-");
		answersPosition++;
		if(answersPosition==levelNumberStatic) {
			checkWin(sequence, answers);
		}
	}	
	public void dog() {
		allStop();
		dogSound.play();
		System.out.println(answersPosition+" dog");	
		answers[answersPosition]="dog";
		answersPosition++;
		showAnswers.setText(showAnswers.getText()+"dog"+"-");
		if(answersPosition==levelNumberStatic) {
			checkWin(sequence, answers);
		}
	}
	public void frog() {
		allStop();
		frogSound.play();
		System.out.println(answersPosition+" frog");	
		answers[answersPosition]="frog";
		answersPosition++;
		showAnswers.setText(showAnswers.getText()+"frog"+"-");
		if(answersPosition==levelNumberStatic) {
			checkWin(sequence, answers);
		}
	}
	public void chicken() {
		allStop();
		chickenSound.play();
		System.out.println(answersPosition+" chicken");
		answers[answersPosition]="chicken";
		answersPosition++;
		showAnswers.setText(showAnswers.getText()+"chicken"+"-");
		if(answersPosition==levelNumberStatic) {
			checkWin(sequence, answers);
		}
	}
	public void cow() {
		allStop();
		cowSound.play();
		System.out.println(answersPosition+" cow");	
		answers[answersPosition]="cow";
		answersPosition++;
		showAnswers.setText(showAnswers.getText()+"cow"+"-");
		if(answersPosition==levelNumberStatic) {
			checkWin(sequence, answers);
		}
	}
	public void lyon() {
		allStop();
		lyonSound.play();
		System.out.println(answersPosition+" lyon");	
		answers[answersPosition]="lyon";
		answersPosition++;
		showAnswers.setText(showAnswers.getText()+"lyon"+"-");
		if(answersPosition==levelNumberStatic) {
			checkWin(sequence, answers);
		}
	}
	public void cat() {
		allStop();
		catSound.play();
		System.out.println(answersPosition+" cat");	
		answers[answersPosition]="cat";
		answersPosition++;
		showAnswers.setText(showAnswers.getText()+"cat"+"-");
		if(answersPosition==levelNumberStatic) {
			checkWin(sequence, answers);
		}
	}
	public void monkey() {	
		allStop();
		monkeySound.play();
		System.out.println(answersPosition+" monkey");	
		answers[answersPosition]="monkey";
		answersPosition++;
		showAnswers.setText(showAnswers.getText()+"monkey"+"-");
		if(answersPosition==levelNumberStatic) {
			checkWin(sequence, answers);
		}
	}
	
	//-----------------------Fin Animales---------------------------//
	
	
	//muestra la secuencia en un sgundo thread
	public void playRound() {

		Task<Void> showSequence = new Task<Void>() {

			@Override
			protected Void call() throws Exception {
				System.out.println("mostrando secuencia al usuario");
				try {					
                    Thread.sleep(1500);                  
                } catch (InterruptedException e) {
                	
                }
			
				for (int i = 0 ; i< levelNumberStatic ; i++) {	
					System.out.println((i)+" "+sequence[i]);
					
					switch (sequence[i]) {
						case "dog":										
							dogImage.setVisible(true);
							dogSound.play();
							setDelay(delayTime);
							setImageInvisible(sequence[i]);						
							break;
						case "cat":	
							catImage.setVisible(true);
							catSound.play();	
							setDelay(delayTime);
							setImageInvisible(sequence[i]);
							break;
						case "cow":		
							cowImage.setVisible(true);
							cowSound.play();	
							setDelay(delayTime);
							setImageInvisible(sequence[i]);
							break;
						case "chicken":			
							chickenImage.setVisible(true);
							chickenSound.play();
							setDelay(delayTime);
							setImageInvisible(sequence[i]);
							break;
						case "pig":			
							pigImage.setVisible(true);					
							pigSound.play();	
							setDelay(delayTime);
							setImageInvisible(sequence[i]);
							break;
						case "frog":
							frogImage.setVisible(true);
							frogSound.play();	
							setDelay(delayTime);
							setImageInvisible(sequence[i]);
							break;
						case "lyon":
							lyonImage.setVisible(true);
							lyonSound.play();
							setDelay(delayTime);
							setImageInvisible(sequence[i]);
							break;
						case "monkey":
							monkeyImage.setVisible(true);
							monkeySound.play();
							setDelay(delayTime);
							setImageInvisible(sequence[i]);
							break;
						case "sheep":
							sheepImage.setVisible(true);
							sheepSound.play();
							setDelay(delayTime);
							setImageInvisible(sequence[i]);
							break;
						case "wolf":
							wolfImage.setVisible(true);
							wolfSound.play();
							setDelay(delayTime);
							setImageInvisible(sequence[i]);
							break;								
					}	
					//end for		
				}			
				disableAll(false);	
				answers=new String[levelNumberStatic];
				
				System.out.println("fin de la secuencia mostrada");
				System.out.println("esperando acciones del usuario");
				
				
				return null;			
			}			
		};		
		new Thread(showSequence).start();		
	}
	
	//metodo para parar sonidos de los animales
	 void allStop() {
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
		
	private void checkWin(String []seq, String ans[]) {
		
		Task<Void> sleeper = new Task<Void>() {
			@Override
			protected Void call() throws Exception{
				disableAll(true);
			try {					
                Thread.sleep(750);                  
            } catch (InterruptedException e) {            	
            }
			System.out.println();
			System.out.println("validando resultados");		
			
			if(Arrays.equals(seq, ans)){
				
				levelNumberStatic++;
				winActions();
				
				
				
			}else {
				allStop();
				System.out.println("perdiste");
			}
			return null;		
		}
	};
	new Thread(sleeper).start();
	answersPosition=0;
	showNumberLevel.setText(String.valueOf(levelNumberStatic+1));
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nameUsercd.setText(nameUser);
		System.out.println("************** NIVEL "+levelNumberStatic+" **************");
		//showAnswers.setText("-");
		mediaGamePlayer.play();
		mediaGamePlayer.setCycleCount(10);
		initGame();
		
	}
	
	
	private void winActions() {
		
		System.out.println("avanzaste de nivel");
		allStop();
		nextLevelBackground.setVisible(true);
		playNextLevel.setVisible(true);
		menuBotton.setVisible(true);
		backBotton.setVisible(true);
		showNumberLevel.setVisible(true);
		nextLevelAnimation();		
		System.out.println("proximo nivel -> "+levelNumberStatic);
		System.out.println();
		System.out.println();
		System.out.println("************** NIVEL "+levelNumberStatic+" **************");
		
	}
	public void nextLevel(ActionEvent ev) {
		if(levelNumberStatic%3==0) {
			try {	
				//aqui cambiamos la escena por el conteo
				root = FXMLLoader.load(getClass().getResource("countDownw.fxml"));
				stage3 = (Stage)((Node) ev.getSource()).getScene().getWindow();
				scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("/styles/general.css").toExternalForm());
				stage3.setScene(scene);
				stage3.show();						
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}					
			ev.consume();
			
			
		}else {
			initGame();
		}
	}
	private void nextLevelAnimation() {
		ScaleTransition nextLevelA = new ScaleTransition();
		nextLevelA.setDuration(Duration.millis(700)); 
		nextLevelA.setNode(playNextLevel);
		nextLevelA.setByX(0.05);
		nextLevelA.setByY(0.05);
		nextLevelA .setCycleCount(nextLevelA .INDEFINITE);
		nextLevelA .setAutoReverse(true); 
		nextLevelA .play();
		
	}
	
	
	
	public void backToMainMenu() {
		yes.setVisible(true);
		no.setVisible(true);
		exitConfirmation.setVisible(true);
	}
	public void yesActions(ActionEvent event) {
		try {
			System.out.println("nos vemos pronto - "+ MainMenuControllers.user.getNamePlayer());
			answersPosition=0;
			
			levelNumberStatic=1;
			root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
			stage3 = (Stage)((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/styles/mainMenu.css").toExternalForm());
			stage3.setScene(scene);
			stage3.show();			
			
			} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}event.consume();
	
	}
	public void noActions() {
		yes.setVisible(false);
		no.setVisible(false);
		exitConfirmation.setVisible(false);
		
		
	}
	
	
}


