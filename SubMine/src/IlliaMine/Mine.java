package IlliaMine;

import javax.swing.JButton;

public class Mine extends JButton{
    private int state = 0; // 지뢰의 상태유무 : 0 - 지뢰 없음, 9 - 지뢰, 1~8 - 주변의 지뢰수
    private boolean clicked = false; // 칸이 눌렸는지 안눌렸는지 체크
    private boolean flag = false;	//	깃발 눌렸는지 안눌렸는지 체크			//
    
    public Mine() {
        state = 0; 			// 모든 칸 초기화
        clicked = false;	// 아직 안 열렸음! 
    }
    
    public int getState(){
        return state;
    }
    
    public void setState(int state){		// 주변 지뢰수 or 지뢰
        this.state = state;
    }
    
    public boolean getClicked(){
        return clicked;
    }
    
    public void setClicked(boolean clicked ){
        this.clicked = clicked;
    }
    
    public void setButtonLabel(){
    	this.setText("" + state);
    }
    
    public void setflag(boolean flag){			//
    	this.flag = flag;
    }
    
    public boolean getflag(){					//
        return flag;
    }
   
} 

