



public class circle extends Thread {

	Canvas canvas;
	int interval;
	int r,x,y;
	int clr = 0;

	public void setNewX() {
		this.x +=10;
		canvas.repaint();
	}

	public void setRad(int rad) {
		this.r = rad;
		canvas.repaint();
	}
	public void changeClr() {
		this.clr = 1;
		canvas.repaint();
	}

	public void changeToBlack() {
		this.clr = 0;
		canvas.repaint();
	}
		public circle(int x, int y, int r, Canvas c) {
			this.x = x;
			this.y = y;
			this.r = r;
			canvas = c;
			setDaemon(true);
		}



	}

