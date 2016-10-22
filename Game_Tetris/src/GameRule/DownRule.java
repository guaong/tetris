package GameRule;

import GameFrame.GameWindow;
/**
 * 
 * 下落规则
 * @author 关桐
 * 总觉得规则写的有点多，左右可合并
 */
public class DownRule {

	//到底规则
	public boolean bottomRule(){
		boolean flag = true;
		for(int i=0;i<4;i++){
			if(GameWindow.blocky[i]==550){
				flag = false;
				break;
			}
		}
		
		return flag;
	}
	//判断是否下面有方块
	public boolean otherRule(){
		boolean flag = true;
		for(int i=0;i<4;i++){
			int count=0;
			for(int j=0;j<12;j++){
				for(int k=0;k<18;k++){
					if(GameWindow.blockx[i]==GameWindow.drawx[j]&&GameWindow.blocky[i]==GameWindow.drawy[k]){
						count=k+1;
						if(GameWindow.clear[j][count]){
							flag = false;
						}
					}
				}
			}
			
		}
		return flag;
	}
	//判断左边是否有方块
	public boolean leftRule(){
		boolean flag = true;
		for(int i=0;i<4;i++){
			int count=0;
			for(int j=0;j<12;j++){
				for(int k=0;k<18;k++){
					if(GameWindow.blockx[i]==GameWindow.drawx[j]&&GameWindow.blocky[i]==GameWindow.drawy[k]){
						count=j-1;
						if(GameWindow.clear[count][k]){
							flag = false;
						}
					}
				}
			}
			
		}
		return flag;
	}
	//判断右边是否有方块
	public boolean rightRule(){
		boolean flag = true;
		for(int i=0;i<4;i++){
			int count=0;
			for(int j=0;j<12;j++){
				for(int k=0;k<18;k++){
					if(GameWindow.blockx[i]==GameWindow.drawx[j]&&GameWindow.blocky[i]==GameWindow.drawy[k]){
						count=j+1;
						if(GameWindow.clear[count][k]){
							flag = false;
						}
					}
				}
			}
			
		}
		return flag;
	}

}
