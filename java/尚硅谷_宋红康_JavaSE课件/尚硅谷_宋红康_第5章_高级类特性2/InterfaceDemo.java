interface USB{		// 
	public void start() ;
	public void stop() ;	
}
class Computer{
	public static void show(USB usb){	
		usb.start() ;
		System.out.println("=========== USB �豸���� ========") ;
		usb.stop() ;
	}
};
class Flash implements USB{
	public void start(){	// ��д����
		System.out.println("U�̿�ʼ������") ;
	}
	public void stop(){		// ��д����
		System.out.println("U��ֹͣ������") ;
	}
};
class Print implements USB{
	public void start(){	// ��д����
		System.out.println("��ӡ����ʼ������") ;
	}
	public void stop(){		// ��д����
		System.out.println("��ӡ��ֹͣ������") ;
	}
};
public class InterfaceDemo{
	public static void main(String args[]){
		Computer.show(new Flash()) ;
		Computer.show(new Print()) ;

		c.show(new USB(){
			public void start(){
				System.out.println("�ƶ�Ӳ�̿�ʼ����");
			}
			public void stop(){
				System.out.println("�ƶ�Ӳ��ֹͣ����");
			}
		});
	}
};