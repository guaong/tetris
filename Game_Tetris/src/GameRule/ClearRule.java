package GameRule;

import GameFrame.GameWindow;
/**
 * 
 * 
 * �������
 * @author ��ͩ
 * ����˼·����ֱ�Ӽ��һ���Ƿ�Ϊtrue
 * 
 */
public class ClearRule {

	public void useClear(){
		for(int i=0;i<18;i++){
			int hang = 0;
			int num=0;
			int count=0;
			for(int j=0;j<12;j++){
				if(GameWindow.clear[j][i]){
					count++;
				}
			}
			if(count==12){
				hang=i;
				num=i-1;
				for(;hang>1;hang--){
					for(int k=0;k<12;k++){
						GameWindow.clear[k][hang]=GameWindow.clear[k][num];
					}
					num--;
				}
			}
		}
	}
}
