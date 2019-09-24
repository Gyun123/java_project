package HomeWork_01_01;

public class longLongisGood {
	
	byte[] mb_data;
	
	public longLongisGood(String a)
	{
		mb_data=new byte[a.length()];
		for(int i=0;i<a.length();i++)
		{
			mb_data[i]=(byte) Integer.parseInt(String.valueOf(a.charAt(i)));
		}
	}
	
	
	
	public String change()
	{
		String a=new String(mb_data);
		return a;
	}
	
	public String  add(longLongisGood b)//加法运算
	{
		String[] c = new String[this.mb_data.length+b.mb_data.length];//初始化String数组
		int asd=0;//判定每个数字相加是否>10
		
		if(this.mb_data.length>b.mb_data.length)//判断相加两者的长度（现在是a>b的情况）
		{
			c = new String[this.mb_data.length];
			byte[] s = b.mb_data;//用于装载b的内容
			b.mb_data=new byte[this.mb_data.length];//重新定义b的大小
			for(int i=this.mb_data.length-s.length,j=0;i<this.mb_data.length;i++)//用s对b的内容进行黏贴
			{
				b.mb_data[i]=s[j];
				j++;
			}
		}else if(this.mb_data.length<b.mb_data.length){//这是（a<b）的情况
			c = new String[b.mb_data.length];
			byte[] s = this.mb_data;
			this.mb_data=new byte[b.mb_data.length];//重新定义this的大小
			for(int i=b.mb_data.length-s.length, j=0;i<b.mb_data.length;i++)//用s对this的内容进行黏贴
			{
				
				this.mb_data[i]=s[j];
				j++;
			}
		}else if(this.mb_data.length==b.mb_data.length)
		{
			c = new String[this.mb_data.length];
		}
		
		for(int i = this.mb_data.length-1;i>=0;i--)//开始加法运算
		{
			if(this.mb_data[i]+b.mb_data[i]>9)//若两者相加大于9，则asd判定为1，若asd已为1判定，则自身在减10保留后再加1
			{
				c[i]=String.valueOf(this.mb_data[i]+b.mb_data[i]-10);
				if(asd==1)
				c[i]=String.valueOf(this.mb_data[i]+b.mb_data[i]-10+1);
				asd=1;
			}
			else if(asd==1)//若两者相加不大于9，但asd判定为1；
			{
				if(this.mb_data[i]+b.mb_data[i]+1>9) { //若两者相加再加1后大于9，则减9保留，并且保持asd为1判定
					c[i]=String.valueOf(this.mb_data[i]+b.mb_data[i]-9);
				}else { //若两者相加再加1后仍不大于9，则直接两者相加后加1，并且asd判定归0
					c[i]=String.valueOf(this.mb_data[i]+b.mb_data[i]+1);
					asd=0;
				}
				
			}else c[i]=String.valueOf(this.mb_data[i]+b.mb_data[i]);//若两者相加不大于9，asd判定为0，则两者直接相加
		}
		
		String a = new String();//新建一个String类型a变量将c String数组串起来，并返回
		for(int i = 0;i<c.length;i++)
		{
			a+=c[i];
		}
		
		return a;
		
		
	}
	
	public  static void main(String[] args)
	{
		
		longLongisGood a = new longLongisGood("123");
		longLongisGood b = new longLongisGood("1222");

		System.out.println(a.add(b));
		
	}
	
	
	

	

}
