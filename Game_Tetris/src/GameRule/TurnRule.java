package GameRule;

import GameFrame.DrawBlock;
import GameFrame.GameWindow;
/**
 * 
 * 旋转规则
 * @author 关桐
 * 写的最戳的的一个规则，不怪规则定制本身，而是前期考虑不够周全导致规则不好定制
 */
public class TurnRule {
	/**
	 * 
	 * 翻转规则出现两个严重错误
	 * 1 出现当旋转一定次数后出现会在某一固定位置出现一个方块，并开始下落，到一定位置后消失
	 * 2 如果我使用a，则会出现图形变换
	 * @return
	 */

	public void getTurn(){
		
		if((DrawBlock.q==3||DrawBlock.q==4||DrawBlock.q==5||DrawBlock.q==7)&&
				GameWindow.blockx[0]!=20&&GameWindow.blockx[0]!=350){
			int num1[]=new int[4];
			int num2[]=new int[4];
			for(int i=1;i<4;i++){
				
				if(GameWindow.blockx[i]!=0&&GameWindow.blocky[i]!=0){
					
					num1[i]=GameWindow.blockx[i];
					num2[i]=GameWindow.blocky[i];
					int a=GameWindow.blockx[0]-GameWindow.blockx[i];
					int b=GameWindow.blocky[0]-GameWindow.blocky[i];
					GameWindow.blockx[i]=GameWindow.blockx[0]+(b);
					GameWindow.blocky[i]=GameWindow.blocky[0]-(a);
					for(int j=0;j<12;j++){
						for(int k=0;k<18;k++){
							if(GameWindow.blockx[i]==GameWindow.drawx[j]&&GameWindow.blocky[i]==GameWindow.drawy[k]){
								if(GameWindow.clear[j][k]){
									GameWindow.blockx[i]=num1[i];
									GameWindow.blocky[i]=num2[i];
								}
							}
						}
					}
				}
			}
			for(int j=1;j<4;j++){
				if(GameWindow.blocky[j]>=580){
					for(int k=1;k<4;k++){
						if(GameWindow.blockx[k]!=0&&GameWindow.blocky[k]!=0){
							GameWindow.blockx[k]=num1[k];
							GameWindow.blocky[k]=num2[k];
						}
					}
				}
			}
		}
		else if(DrawBlock.q==2&&GameWindow.blockx[1]!=20&&GameWindow.blockx[0]!=350){
			int num1[]=new int[4];
			int num2[]=new int[4];
			for(int i=1;i<4;i++){
				if(GameWindow.blockx[i]!=0&&GameWindow.blocky[i]!=0){
					num1[i]=GameWindow.blockx[i];
					num2[i]=GameWindow.blocky[i];
					int a=GameWindow.blockx[0]-GameWindow.blockx[i];
					int b=GameWindow.blocky[0]-GameWindow.blocky[i];
					GameWindow.blockx[i]=GameWindow.blockx[0]+(b);
					GameWindow.blocky[i]=GameWindow.blocky[0]-(a);
					for(int j=0;j<12;j++){
						for(int k=0;k<18;k++){
							if(GameWindow.blockx[i]==GameWindow.drawx[j]&&GameWindow.blocky[i]==GameWindow.drawy[k]){
								if(GameWindow.clear[j][k]){
									GameWindow.blockx[i]=num1[i];
									GameWindow.blocky[i]=num2[i];
								}
							}

						}
					}
				}
			}
			for(int j=1;j<4;j++){
				if(GameWindow.blocky[j]>=580){
					for(int k=1;k<4;k++){
						if(GameWindow.blockx[k]!=0&&GameWindow.blocky[k]!=0){
							GameWindow.blockx[k]=num1[k];
							GameWindow.blocky[k]=num2[k];
						}
					
					}
				}
			}
		}

	}

}
