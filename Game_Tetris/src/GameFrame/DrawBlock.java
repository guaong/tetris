package GameFrame;
/**
 * 
 * 绘制方块
 * @author 关桐
 * 当然可以在后期想修改的情况下自主添加或者删除
 * 不过删除起来比较麻烦，因为我方块是按123...顺序，因此修改一个可能会动好多
 *
 */
public class DrawBlock {
	public static int q;

	public void Block1(){
		GameWindow.blockx[0] = GameWindow.downx[5];
		GameWindow.blocky[0] = GameWindow.downy[1];
		GameWindow.blockx[1] = 0;
		GameWindow.blocky[1] = 0;
		GameWindow.blockx[2] = 0;
		GameWindow.blocky[2] = 0;
		GameWindow.blockx[3] = 0;
		GameWindow.blocky[3] = 0;
		q=1;
	}
	public void Block2(){
		GameWindow.blockx[0] = GameWindow.downx[5];
		GameWindow.blocky[0] = GameWindow.downy[1];
		GameWindow.blockx[1] = GameWindow.downx[6];
		GameWindow.blocky[1] = GameWindow.downy[1];
		GameWindow.blockx[2] = 0;
		GameWindow.blocky[2] = 0;
		GameWindow.blockx[3] = 0;
		GameWindow.blocky[3] = 0;
		q=2;
	}
	public void Block3(){
		GameWindow.blockx[0] = GameWindow.downx[5];
		GameWindow.blocky[0] = GameWindow.downy[1];
		GameWindow.blockx[1] = GameWindow.downx[6];
		GameWindow.blocky[1] = GameWindow.downy[1];
		GameWindow.blockx[2] = GameWindow.downx[4];
		GameWindow.blocky[2] = GameWindow.downy[0];
		GameWindow.blockx[3] = GameWindow.downx[4];
		GameWindow.blocky[3] = GameWindow.downy[1];
		q=3;
	}
	public void Block4(){
		GameWindow.blockx[0] = GameWindow.downx[5];
		GameWindow.blocky[0] = GameWindow.downy[1];
		GameWindow.blockx[1] = GameWindow.downx[6];
		GameWindow.blocky[1] = GameWindow.downy[1];
		GameWindow.blockx[2] = GameWindow.downx[4];
		GameWindow.blocky[2] = GameWindow.downy[1];
		GameWindow.blockx[3] = 0;
		GameWindow.blocky[3] = 0;
		q=4;
	}
	public void Block5(){
		GameWindow.blockx[0] = GameWindow.downx[5];
		GameWindow.blocky[0] = GameWindow.downy[1];
		GameWindow.blockx[1] = GameWindow.downx[6];
		GameWindow.blocky[1] = GameWindow.downy[1];
		GameWindow.blockx[2] = GameWindow.downx[4];
		GameWindow.blocky[2] = GameWindow.downy[1];
		GameWindow.blockx[3] = GameWindow.downx[5];
		GameWindow.blocky[3] = GameWindow.downy[0];
		q=5;
	}
	public void Block6(){
		GameWindow.blockx[0] = GameWindow.downx[5];
		GameWindow.blocky[0] = GameWindow.downy[0];
		GameWindow.blockx[1] = GameWindow.downx[6];
		GameWindow.blocky[1] = GameWindow.downy[0];
		GameWindow.blockx[2] = GameWindow.downx[5];
		GameWindow.blocky[2] = GameWindow.downy[1];
		GameWindow.blockx[3] = GameWindow.downx[6];
		GameWindow.blocky[3] = GameWindow.downy[1];
		q=6;
	}
	public void Block7(){
		GameWindow.blockx[0] = GameWindow.downx[5];
		GameWindow.blocky[0] = GameWindow.downy[1];
		GameWindow.blockx[1] = GameWindow.downx[6];
		GameWindow.blocky[1] = GameWindow.downy[1];
		GameWindow.blockx[2] = GameWindow.downx[5];
		GameWindow.blocky[2] = GameWindow.downy[0];
		GameWindow.blockx[3] = GameWindow.downx[4];
		GameWindow.blocky[3] = GameWindow.downy[0];
		q=7;
	}
	//将下落停止方块记录
	public void DrawAll(){
		for(int j=0;j<12;j++){
			for(int k =0;k<18;k++){
				for(int i=0;i<4;i++){
					if(GameWindow.drawx[j]==GameWindow.blockx[i]&&GameWindow.drawy[k]==GameWindow.blocky[i]){
						GameWindow.clear[j][k]=true;
					}
				}
			}
		}
	}
}
