
public class TDownloader extends Thread {
	
	
	private String url;
	private String name;
	
	public TDownloader(String url,String name)
	{
		this.url=url;
		this.name=name;
	}
	
	public void run()
	{
		WebDownloader a = new WebDownloader();
		a.Download(url, name);
		System.out.println(name);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TDownloader ass = new TDownloader("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=410137747,215460389&fm=26&gp=0.jpg","anima1.jpg");
		TDownloader hole = new TDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1568643144831&di=b36aada8b3f9fd6a9609af0924157098&imgtype=0&src=http%3A%2F%2Fpic.rmb.bdstatic.com%2Ffcd9555bd33f379035bcc05e71be30d2.jpeg","anima02.jpeg");
		TDownloader great = new TDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1568643224356&di=1a4ec9451b10f99851b0da8ac45a09ef&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fblog%2F201406%2F19%2F20140619183735_fi8Ez.jpeg","anima03.jpeg");
		
		ass.start();
		hole.start();
		great.start();
		

	}

}
