
public class StartThread extends Thread{
	
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("一边听歌。");
		}
		
	}
	
	public static void main(String[] args)
	{
		
		StartThread a = new StartThread();
		a.start();//开启新线程
		/*a.run() 是执行方法，并没有开启新线程*/
		for(int i=0;i<10;i++)
		{
			System.out.println("一边写代码。");
		}
		
	}

}
