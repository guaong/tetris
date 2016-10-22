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
 * 花费时间最长的一个类
 * 主界面类
 * @author 关桐
 * 在后期的使用中可以再给他添加一个得分的组件，和一个预判下一个要出什么的组件
 * 在方块颜色和形状上面也可作修改，当然界面依旧是awt的界面没有进行任何修改
 * 败笔
 * 在前期考虑不周导致只考虑到draw和block，导致很多规则不容易实现
 * 重新推翻重写后想到用一个boolean型二维数组，以确定他是否当前位置有方块
 * 写好后有发现啦一个问题当下落到底之后判断他是否还能继续下落，又给clear添加一行，作为判断
 * 然而后来在写翻转规则时，发现当一个图形贴边时翻转会超出屏幕，此时如果clear多出来两列在写翻转规则时也就容易很多
 * 也不至于出现turnrule写的过分复杂
 * 在大体完成后又加入双缓冲解决了闪屏问题
 * 
 */
public class GameWindow extends Frame{
	
	//下落
	public static int downx[] = new int[12];
	public static int downy[] = new int[18];
	//绘画
	public static int drawx[] = new int[12];
	public static int drawy[] = new int[18];
	//清除
	public static boolean clear[][] = new boolean[12][19];
	//方块
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
		//线程将与后面的并发执行
		new MyThread().start();
		
	}


	
	//将值传入
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
		//画出游戏界面的边框
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
			//绘制已有的方块
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

	//双缓冲
	private Image offScreenImage = null;
	public void update(Graphics g){
		if(offScreenImage == null){
			offScreenImage = this.createImage(400,600);
		}
		Graphics gOff=offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	//线程控制重画
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
