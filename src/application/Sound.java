package application;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

class Sound {
	MediaPlayer mediaPlayer;
	Media audio;
   	AudioClip clip;
   	String select;
  
      protected Sound(String urlSong, String audioOrCliP) {
    	  
    	  select=audioOrCliP;
    	  if(select.equals("botton")) {
    	//String wav= "/audio/"+urlSong+".wav";
    	  clip =new AudioClip(getClass().getResource("/audio/"+urlSong+".wav").toString());
    	  }
    	  else if(select.equals("audio")) {
    		  audio = new Media(getClass().getResource("/audio/"+urlSong+".wav").toString());		  
    		  mediaPlayer= new MediaPlayer(audio);
    		 mediaPlayer.play();
    		  
    	  }   
    }
   public void stop() {
	   clip.stop();
   }

   public void loop() {
	   if(select.equals("botton")) {
		   clip.setCycleCount(5);
	   }else {
		   mediaPlayer.setCycleCount(5);
	   }
   }
   public void play() {
	 //  mediaPlayer.play();
	   clip.play();
   }
}