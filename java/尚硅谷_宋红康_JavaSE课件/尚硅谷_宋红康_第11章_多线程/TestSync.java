class MyThread implements Runnable{
	int ticket = 100;
	Boolean b = false;
	public void run(){
		while(true){
			if(b == true){
				sale();
			}else{
				synchronized (this) {
					if (ticket > 0) {
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()
								+ ":" + ticket--);
					}
					b = true;
				}
			}
		}
	}
	synchronized void sale(){
		if(ticket>0){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("********");
			System.out.println(Thread.currentThread().getName()+":"+ticket--);
		}
		b = false;
	}
}
public class TestSync {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		Thread t1 = new Thread(mt);
		Thread t2 = new Thread(mt);
		t1.start();
		t2.start();
	}
}