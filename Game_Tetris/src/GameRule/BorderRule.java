package GameRule;

import GameFrame.GameWindow;
/**
 * 
 * ���ñ߽����
 * @author ��ͩ
 * ��������������еķ�����ʵ���Ժϲ�Ϊһ��
 * ���´��޸�����Ҫ�޸�
 *
 */
public class BorderRule {

	public boolean getLeft(){
		boolean flag = true ;
		for(int i=0;i<4;i++){
			if(GameWindow.blockx[i]==20){
				flag = false;
				break;
			}
			else{
				flag = true;
			}
		}
		return flag;
	}
	
	public boolean getRight(){
		boolean flag = true ;
		for(int i=0;i<4;i++){
			if(GameWindow.blockx[i]==350){
				flag = false;
				break;
			}
			else{
				flag = true;
			}
		}
		return flag;
	}
	
}
