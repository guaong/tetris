package GameFrame;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeFrame extends Frame{

	private Button again = new Button("再次");
	private Button exit = new Button("退出");
	private Label label= new Label("失败",Label.CENTER);
	public GradeFrame(){
		setSize(300,200);
		setLocation(500, 200);
		setResizable(false);
		setAlwaysOnTop(true);
		add(again);
		add(exit);
		add(label);
		label.setFont(new Font("楷体", Font.BOLD, 26));
		again.setBounds(70, 150, 50, 30);
		exit.setBounds(180, 150, 50, 30);
		again.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("再次")){
					GameWindow.a=2;
					for(int i=0;i<12;i++){
						for(int j=0;j<18;j++){
							GameWindow.clear[i][j]=false;
						}
					}
					dispose();
				}

			}
		});
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("退出")){
					System.exit(0);
				}

			}
		});
		setVisible(true);
	}
}
