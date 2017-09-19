package IlliaMine;

import javax.swing.JButton;

public class Mine extends JButton{
    private int state = 0; // ������ �������� : 0 - ���� ����, 9 - ����, 1~8 - �ֺ��� ���ڼ�
    private boolean clicked = false; // ĭ�� ���ȴ��� �ȴ��ȴ��� üũ
    private boolean flag = false;	//	��� ���ȴ��� �ȴ��ȴ��� üũ			//
    
    public Mine() {
        state = 0; 			// ��� ĭ �ʱ�ȭ
        clicked = false;	// ���� �� ������! 
    }
    
    public int getState(){
        return state;
    }
    
    public void setState(int state){		// �ֺ� ���ڼ� or ����
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

