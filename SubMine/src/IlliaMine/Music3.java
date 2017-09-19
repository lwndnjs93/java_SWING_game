package IlliaMine;

import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music3 {
public static Clip clip; //음악을 담는 객체
 
 public Music3(String bgm) throws Exception{  //음악을 매개변수로 받고 실행 
  try{
   Stop();	// 음악 정지
   InputStream is = new BufferedInputStream(Music.class.getResourceAsStream("/bgm/" + bgm)); //파일의 위치는 매개변수로 넘어온 파일이름이 들어가도록 설정
   AudioInputStream ais = AudioSystem.getAudioInputStream(is); // 오디오스트림
   clip = AudioSystem.getClip(); // clip에 새로운 음악 재생할수있는 형태로 변경
   clip.open(ais); // 음악파일 실행할수있도록 설정
  }
  catch(Exception e){
   Stop();
  }
 }
 
 public void Play(){ //음악실행
  clip.setFramePosition(0); //clip이 생성되면 항상 가장 앞부분부터 실행되도록 설정
  clip.start(); //시작.
 }
 
 public void Stop(){ //음악중지
  if(clip != null){ //클립이 실행중인 경우
   clip.stop(); //정지
  }
 }
} 

