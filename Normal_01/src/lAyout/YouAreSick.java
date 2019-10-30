package lAyout;

import java.awt.*;

import javax.swing.*;

public class YouAreSick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame app=new JFrame("组合布局");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(215,150);
		Container c=app.getContentPane();
		c.setLayout(new FlowLayout());
		JPanel p[]=new JPanel[3];
		for(int i=0;i<3;i++)
		{
			p[i]=new JPanel();
			p[i].setLayout(new GridLayout(1,i+1));
			c.add(p[i]);			
		}
		String s;
		JButton b=new JButton("nice");
		int []pj= {0,1,2};
		for(int i=0;i<3;i++)
		{
			p[pj[i]].add(b);
		}
		app.setVisible(true);
		
		
				

	}

}
