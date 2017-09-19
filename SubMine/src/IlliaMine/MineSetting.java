package IlliaMine;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MineSetting {
    private int width; // 지뢰찾기 가로 크기
    private int height; // 지뢰찾기 세로 크기
    private int mineNum; // 지뢰수

    // 특별한 설정이 없으면 기본 8*8 에 10개의 지뢰를 설정한다.
    public MineSetting() {
        width = 8;
        height = 8;
        mineNum = 10;
        
    }
    //오버로딩 : 동적으로 받음 (사용자 정의)
    public MineSetting(int x, int y, int number) {
        setWidth(x);
        setHeight(y);
        setMineNumber(number);
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public int getMineNum(){
        return mineNum;
    }
    
    public void setWidth(int x){
        width = x;
    }
    
    public void setHeight(int y){
        height = y;
    }
    
    public void setMineNumber(int number){
        mineNum = number;
    }
     
    public static void Playsound(String Sound)
    {
    	 try
         {
         AudioInputStream ais = AudioSystem.getAudioInputStream(new File(Sound));
         Clip clip = AudioSystem.getClip();
         clip.open(ais);
         clip.start();
         }
         catch (Exception e)
         {
        	 e.printStackTrace();
         }
    }
}