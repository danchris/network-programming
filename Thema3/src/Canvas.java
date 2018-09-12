import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;


public class Canvas extends JLabel implements MouseListener{

	private int x = -1;
	private int y = -1;
	private int rad = 10;
	private int last = 0;

	List<circle> circles = new ArrayList<circle>();

	public Canvas() {
		setPreferredSize(new Dimension(500,500));
		addMouseListener(this);
	}
	public void setRad(int rad) {
		circle cur;
		for(int i=0;i<circles.size();i++){
			cur = circles.get(i);
			cur.setRad(rad);
		}
		repaint();
	}


	public void paint(Graphics g){
		System.out.println(circles.size());

		if (x<0)
			reset();

		circle cur;
		for(int i=0;i<circles.size();i++){
			cur = circles.get(i);
			if (cur.clr ==  0) g.setColor(Color.black);
			else g.setColor(Color.red);
			g.drawOval(cur.x-rad, cur.y-rad, 2*cur.r, 2*cur.r);
			for(int j=0; j<circles.size(); j++) {
				if (j!=i) {
					circle tmp = circles.get(j);

					System.out.println("tmpX = "+tmp.x +" tmpY = "+tmp.y+" curX = "+cur.x+" curY = "+cur.y);
					if(Math.abs(tmp.x-cur.x)<=rad && Math.abs(tmp.y-cur.y)<=rad) {
						tmp.changeClr();
						cur.changeClr();
					}
					else {
						tmp.changeToBlack();
						cur.changeToBlack();
					}
				}
			}

		}
	}

	public void reset(){
		x=getWidth()/2;
		y=getHeight()/2;
	}

	@Override
	public void mouseClicked(MouseEvent ev) {
		x=ev.getX();
		y=ev.getY();
		newc();

	}
	public void newc() {
		circle next = new circle(x,y,rad,this);
		circles.add(next);
		new MyThread(next,this,last).start();
		System.out.println("Last="+last);
		this.last++;
		this.repaint();
	}
}
