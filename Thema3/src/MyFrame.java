import java.awt.BorderLayout;
import java.awt.event.*;

import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame{
	Canvas canvas = new Canvas();

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	public static void main(String[] args) {
		new MyFrame();

	}

	public MyFrame() throws HeadlessException {
		super("This is my frame");
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().add(canvas);
		JPanel panel = new JPanel();
		this.setSize(500,500);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		getContentPane().add(panel, BorderLayout.NORTH);
		//new MyThread(canvas).start();
		pack();
	}
}
