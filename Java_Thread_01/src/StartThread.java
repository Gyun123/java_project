
public class StartThread extends Thread{
	
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("һ�����衣");
		}
		
	}
	
	public static void main(String[] args)
	{
		
		StartThread a = new StartThread();
		a.start();//�������߳�
		/*a.run() ��ִ�з�������û�п������߳�*/
		for(int i=0;i<10;i++)
		{
			System.out.println("һ��д���롣");
		}
		
	}

}
