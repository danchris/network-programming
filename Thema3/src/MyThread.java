

public class MyThread extends Thread {

	public final Canvas canvas;
	public final circle cir;
	public final int last;
	public MyThread(circle c, Canvas canvas,int last) {
		this.cir = c;
		this.canvas = canvas;
		this.last = 1000*last;
		this.setDaemon(true);
	}
	public void run(){
		while (true){
			try {
				System.out.println("going to sleep..");
				sleep(1000+last);
			} catch (InterruptedException e) {
				System.out.println("sleep interrupted");

				e.printStackTrace();
			}
			System.out.println("woke up");
			cir.setNewX();
			canvas.repaint();
		}
	}


}
