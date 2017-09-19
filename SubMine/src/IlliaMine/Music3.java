package IlliaMine;

import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music3 {
public static Clip clip; //������ ��� ��ü
 
 public Music3(String bgm) throws Exception{  //������ �Ű������� �ް� ���� 
  try{
   Stop();	// ���� ����
   InputStream is = new BufferedInputStream(Music.class.getResourceAsStream("/bgm/" + bgm)); //������ ��ġ�� �Ű������� �Ѿ�� �����̸��� ������ ����
   AudioInputStream ais = AudioSystem.getAudioInputStream(is); // �������Ʈ��
   clip = AudioSystem.getClip(); // clip�� ���ο� ���� ����Ҽ��ִ� ���·� ����
   clip.open(ais); // �������� �����Ҽ��ֵ��� ����
  }
  catch(Exception e){
   Stop();
  }
 }
 
 public void Play(){ //���ǽ���
  clip.setFramePosition(0); //clip�� �����Ǹ� �׻� ���� �պκк��� ����ǵ��� ����
  clip.start(); //����.
 }
 
 public void Stop(){ //��������
  if(clip != null){ //Ŭ���� �������� ���
   clip.stop(); //����
  }
 }
} 

