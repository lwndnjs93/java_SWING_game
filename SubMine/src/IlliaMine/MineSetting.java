package IlliaMine;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MineSetting {
    private int width; // ����ã�� ���� ũ��
    private int height; // ����ã�� ���� ũ��
    private int mineNum; // ���ڼ�

    // Ư���� ������ ������ �⺻ 8*8 �� 10���� ���ڸ� �����Ѵ�.
    public MineSetting() {
        width = 8;
        height = 8;
        mineNum = 10;
        
    }
    //�����ε� : �������� ���� (����� ����)
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