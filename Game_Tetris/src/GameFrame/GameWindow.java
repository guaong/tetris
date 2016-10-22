package GameFrame;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import GameRule.BorderRule;
import GameRule.ClearRule;
import GameRule.DieRule;
import GameRule.DownRule;
import GameRule.TurnRule;
/**
 * 
 * ����ʱ�����һ����
 * ��������
 * @author ��ͩ
 * �ں��ڵ�ʹ���п����ٸ������һ���÷ֵ��������һ��Ԥ����һ��Ҫ��ʲô�����
 * �ڷ�����ɫ����״����Ҳ�����޸ģ���Ȼ����������awt�Ľ���û�н����κ��޸�
 * �ܱ�
 * ��ǰ�ڿ��ǲ��ܵ���ֻ���ǵ�draw��block�����ºܶ��������ʵ��
 * �����Ʒ���д���뵽��һ��boolean�Ͷ�ά���飬��ȷ�����Ƿ�ǰλ���з���
 * д�ú��з�����һ�����⵱���䵽��֮���ж����Ƿ��ܼ������䣬�ָ�clear���һ�У���Ϊ�ж�
 * Ȼ��������д��ת����ʱ�����ֵ�һ��ͼ������ʱ��ת�ᳬ����Ļ����ʱ���clear�����������д��ת����ʱҲ�����׺ܶ�
 * Ҳ�����ڳ���turnruleд�Ĺ��ָ���
 * �ڴ�����ɺ��ּ���˫����������������
 * 
 */
public class GameWindow extends Frame{
	
	//����
	public static int downx[] = new int[12];
	public static int downy[] = new int[18];
	//�滭
	public static int drawx[] = new int[12];
	public static int drawy[] = new int[18];
	//���
	public static boolean clear[][] = new boolean[12][19];
	//����
	public static int blockx[] = new int[4];
	public static int blocky[] = new int[4];
	
	public final int BLOCK_HEIGHT = 30;
	public final int BLOCK_WIDTH = 30;
	private int time=400;
	public static int a=1;
	
	DrawBlock d = new DrawBlock();
	BorderRule b=new BorderRule();
	DownRule r =new DownRule();
	ClearRule c= new ClearRule();
	TurnRule t =new TurnRule();
	public GameWindow(int i){}
	
	public GameWindow() {

		setSize(400,600);

		setLocation(450, 100);

		setResizable(false);

		setVisible(true);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});

		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				if(e.getKeyCode() == 37){  //left
					if(b.getLeft()){
						if(r.leftRule()){
							for(int i=0;i<4;i++){
								blockx[i]-=30;
							}
						}

					}

				}
				else if(e.getKeyCode() == 39){  //right
					if(b.getRight()){
						if(r.rightRule()){
							for(int i=0;i<4;i++){
								blockx[i]+=30;
							}
						}

					}

				}
				else if(e.getKeyCode() == 38){  //up

					t.getTurn();

				}
				else if(e.getKeyCode() == 40){  //down
					time=10;
				}

			}
		});

		getValue();
		ChangeBlock();
		//d.Block4();
		//�߳̽������Ĳ���ִ��
		new MyThread().start();
		
	}


	
	//��ֵ����
	public void getValue(){
		int flag1=20;
		int flag2=40;
		for(int i=0;i<12;i++){
			downx[i]=flag1;
			drawx[i]=flag1;
			clear[i][18]=true;
			flag1+=30;
		}
		for(int j=0;j<18;j++){
			downy[j]=flag2;
			drawy[j]=flag2;
			flag2+=30;
		}
	}
	
	public void paint(Graphics g) {

		int count=0;
		//������Ϸ����ı߿�
		if(a==1){
			g.setColor(Color.white);
			g.fillRect(20, 40, 360, 540);
			g.setColor(Color.black);
			g.drawRect(20, 40, 360, 540);
			g.setColor(Color.red);
			g.drawLine(20,130,380,130);
			if(r.otherRule()){
				for(int i=0;i<4;i++){
					if(blockx[i]!=0&&blocky[i]!=0){
						g.setColor(Color.black);
						g.fillRect(blockx[i], blocky[i],BLOCK_HEIGHT , BLOCK_WIDTH);
						g.setColor(Color.white);
						g.drawRect(blockx[i], blocky[i],BLOCK_HEIGHT , BLOCK_WIDTH);
						blocky[i]+=30;
					}
				} 

			}
			else{
				d.DrawAll();
				ChangeBlock();
				//d.Block2();
				time=400;
			}
			//�������еķ���
			c.useClear();
			for(int j=0;j<12;j++){
				for(int k =0;k<18;k++){
					if(clear[j][k]){
						g.setColor(Color.black);
						g.fillRect(drawx[j], drawy[k],BLOCK_HEIGHT, BLOCK_WIDTH);
						g.setColor(Color.white);
						g.drawRect(drawx[j], drawy[k],BLOCK_HEIGHT, BLOCK_WIDTH);
					}

				}
			}
		}
		else{
			g.setColor(Color.white);
			g.fillRect(20, 40, 360, 540);
			g.setColor(Color.black);
			g.drawRect(20, 40, 360, 540);
			g.setColor(Color.red);
			g.drawLine(20,130,380,130);
			a=1;
		}
	}

	//˫����
	private Image offScreenImage = null;
	public void update(Graphics g){
		if(offScreenImage == null){
			offScreenImage = this.createImage(400,600);
		}
		Graphics gOff=offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	//�߳̿����ػ�
	class MyThread extends Thread{
		public void run(){

			while(true){
				if(DieRule.toDie()){
					new GradeFrame();
					while(a==1){}
				}
				else{
					repaint();
				}
				try {
					sleep(time);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public void ChangeBlock(){
		int count=0;
		count = (int)(Math.random()*7)+1;
		switch(count){
		case 1 : d.Block1();;break;
		case 2 : d.Block2();break;
		case 3 : d.Block3();break;
		case 4 : d.Block4();break;
		case 5 : d.Block5();break;
		case 6 : d.Block6();break;
		case 7 : d.Block7();break;
		}
	}
	
}
