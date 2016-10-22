package GameRule;

import GameFrame.GameWindow;
/**
 * 
 * 设置边界规则
 * @author 关桐
 * 对于这个规则类中的方法其实可以合并为一个
 * 在下次修改中需要修改
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
