package GameRule;

import GameFrame.GameWindow;
/**
 * 
 * 死亡规则
 * @author 关桐
 * 思路只要有一个为true就死
 *
 */
public class DieRule {
	
	public static boolean toDie(){
		boolean flag=false;
		for(int i=0;i<12;i++){
			if(GameWindow.clear[i][2]){
				flag=true;
			}
		}
		
		return flag;
	}
}
