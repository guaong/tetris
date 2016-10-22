package GameRule;

import GameFrame.GameWindow;
/**
 * 
 * �������
 * @author ��ͩ
 * �ܾ��ù���д���е�࣬���ҿɺϲ�
 */
public class DownRule {

	//���׹���
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
	//�ж��Ƿ������з���
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
	//�ж�����Ƿ��з���
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
	//�ж��ұ��Ƿ��з���
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
