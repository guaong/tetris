package GameFrame;
/**
 * 
 * ���Ʒ���
 * @author ��ͩ
 * ��Ȼ�����ں������޸ĵ������������ӻ���ɾ��
 * ����ɾ�������Ƚ��鷳����Ϊ�ҷ����ǰ�123...˳������޸�һ�����ܻᶯ�ö�
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
	//������ֹͣ�����¼
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
