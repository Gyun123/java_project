package HomeWork_01_01;


public class longLongisGood {
	
	byte[] mb_data;
	
	public longLongisGood(String a)
	{
		
		mb_data=new byte[a.length()];
		
			mb_data=a.getBytes();
		
	}
	
	
	
	public longLongisGood()
	{
		
		mb_data=new byte[1];
		mb_data[0]='0';
		
		
	}
	
	public int[] changeInt(byte[] a)
	{
		int[]x = new int[a.length];
		
		for(int i=a.length-1;i>=0;i--)
		{
			x[i]=Integer.parseInt(String.valueOf(new String(a).charAt(i)));
		}
		
		return x;
	}
	
	
	
	public String change()
	{
		String a=new String(mb_data);
		return a;
	}
	
	public longLongisGood  add(longLongisGood b)//加法运算
	{
		String[] c = new String[this.mb_data.length+b.mb_data.length];//初始化String数组
		int asd=0;//判定每个数字相加是否>10
		int as[]=new int[this.mb_data.length],bs[]=new int[b.mb_data.length];
		as=this.changeInt(mb_data);
		bs=this.changeInt(b.mb_data);
		
		if(as.length>bs.length)//判断相加两者的长度（现在是a>b的情况）
		{
			c = new String[as.length];
			int[] s = bs;//用于装载b的内容
			bs=new int[as.length];//重新定义b的大小
			for(int i=as.length-s.length,j=0;i<as.length;i++)//用s对b的内容进行黏贴
			{
				bs[i]=s[j];
				j++;
			}
		}else if(as.length<bs.length){//这是（a<b）的情况
			c = new String[bs.length];
			int[] s = as;
			as=new int[bs.length];//重新定义this的大小
			for(int i=bs.length-s.length, j=0;i<bs.length;i++)//用s对this的内容进行黏贴
			{
				
				as[i]=s[j];
				j++;
			}
		}else if(as.length==bs.length)
		{
			c = new String[as.length];
		}
		
		
		
		for(int i = as.length-1;i>=0;i--)//开始加法运算
		{
			if(as[i]+bs[i]>9)//若两者相加大于9，则asd判定为1，若asd已为1判定，则自身在减10保留后再加1
			{
				c[i]=String.valueOf(as[i]+bs[i]-10);
				if(asd==1)
				c[i]=String.valueOf(as[i]+bs[i]-10+1);
				asd=1;
			}
			else if(asd==1)//若两者相加不大于9，但asd判定为1；
			{
				if(as[i]+bs[i]+1>9) { //若两者相加再加1后大于9，则减9保留，并且保持asd为1判定
					c[i]=String.valueOf(as[i]+bs[i]-9);
				}else { //若两者相加再加1后仍不大于9，则直接两者相加后加1，并且asd判定归0
					c[i]=String.valueOf(as[i]+bs[i]+1);
					asd=0;
				}
				
			}else c[i]=String.valueOf(as[i]+bs[i]);//若两者相加不大于9，asd判定为0，则两者直接相加
		}
		
		String a = new String();//新建一个String类型a变量将c String数组串起来，并返回
		for(int i = 0;i<c.length;i++)
		{
			a+=c[i];
		}
		
		longLongisGood s=new longLongisGood(a);
		
		return s;
		
		
	}
	
	public longLongisGood  sub(longLongisGood b)//加法运算
	{
		String[] c = new String[this.mb_data.length+b.mb_data.length];//初始化String数组
		int asd=0;//判定每个数字相加是否<0
		int as[]=new int[this.mb_data.length],bs[]=new int[b.mb_data.length];
		as=this.changeInt(mb_data);
		bs=this.changeInt(b.mb_data);
		
		
		
		if(as.length>bs.length)//判断相加两者的长度（现在是a>b的情况）
		{
			c = new String[as.length];
			int[] s = bs;//用于装载b的内容
			bs=new int[as.length];//重新定义b的大小
			for(int i=as.length-s.length,j=0;i<as.length;i++)//用s对b的内容进行黏贴
			{
				bs[i]=s[j];
				j++;
			}
		}else if(as.length<bs.length){//这是（a<b）的情况
			c = new String[bs.length];
			int[] s = as;
			as=new int[bs.length];//重新定义this的大小
			for(int i=bs.length-s.length, j=0;i<bs.length;i++)//用s对this的内容进行黏贴
			{
				
				as[i]=s[j];
				j++;
			}
		}else if(as.length==bs.length)
		{
			c = new String[as.length];
		}
		
		
		
		for(int i = as.length-1;i>=0;i--)//开始加法运算
		{
			
			if(as[i]-bs[i]<0)//若两者相加大于9，则asd判定为1，若asd已为1判定，则自身在减10保留后再加1
			{
				c[i]=String.valueOf(as[i]-bs[i]+10);
				if(asd==1)
				c[i]=String.valueOf(as[i]-bs[i]+10-1);
				asd=1;
			}
			else if(asd==1)//若两者相加不大于9，但asd判定为1；
			{
				if(as[i]-bs[i]-1<0) { //若两者相加再加1后大于9，则减9保留，并且保持asd为1判定
					c[i]=String.valueOf(as[i]-bs[i]+10-1);
				}else { //若两者相加再加1后仍不大于9，则直接两者相加后加1，并且asd判定归0
					c[i]=String.valueOf(as[i]-bs[i]-1);
					asd=0;
				}
				
			}else c[i]=String.valueOf(as[i]-bs[i]);//若两者相加不大于9，asd判定为0，则两者直接相加
			
		}
		
		if(as[0]<bs[0])
			c[0]=String.valueOf(as[0]-bs[0]);
		
		String a = new String();//新建一个String类型a变量将c String数组串起来，并返回
		for(int i = 0;i<c.length;i++)
		{
			a+=c[i];
		}
		
		longLongisGood s=new longLongisGood(a);
				
		return s;
		
		
	}
	
	public longLongisGood  x(longLongisGood b)//加法运算
	{
		int sb=0;
		int sd=0;
		int as[]=new int[this.mb_data.length],bs[]=new int[b.mb_data.length];
		as=this.changeInt(mb_data);
		bs=this.changeInt(b.mb_data);
		if(as.length>bs.length)//判断相加两者的长度（现在是a>b的情况）
		{
			int[] s = bs;//用于装载b的内容
			bs=new int[as.length];//重新定义b的大小
			for(int i=as.length-s.length,j=0;i<as.length;i++)//用s对b的内容进行黏贴
			{
				bs[i]=s[j];
				j++;
			}
		}else if(as.length<bs.length){//这是（a<b）的情况
			int[] s = as;
			as=new int[bs.length];//重新定义this的大小
			for(int i=bs.length-s.length, j=0;i<bs.length;i++)//用s对this的内容进行黏贴
			{
				
				as[i]=s[j];
				j++;
			}
		}
		
		String [][] c = new String[bs.length][as.length+bs.length];//初始化String数组
		for(int i=as.length-1;i>=0;i--)
		{
			
			for(int j=as.length+bs.length-1;j>=0;j--)
			{
				c[i][j]="0";
				
			}
			
		}
		
		
		for(int i=as.length-1;i>=0;i--)
		{
			
			int y=bs.length+as.length-1;
			if(i<as.length-1) y-=sb;
			for(int j=bs.length-1;j>=0;j--)
			{
				
				if(as[i]*bs[j]>=10)
				{
					
					c[i][y]=String.valueOf((as[i]*bs[j])%10+sd);
					sd=(as[i]*bs[j]+sd)/10;
				
				}else 
				{
					c[i][y]=String.valueOf(as[i]*bs[j]+sd);
					sd=(as[i]*bs[j]+sd)/10;
				}
				--y;
				
				
			}
			sb++;
		}
		

				
		
		String a[] = new String[bs.length];//新建一个String类型a变量将c String数组串起来，并返回
		for(int i = 0;i<a.length;i++)
		{
			a[i]="";
		}
		for(int i = 0;i<bs.length;i++)
		{
			for(int j=0;j<c[i].length;j++)
			{
				a[i]+=c[i][j];
			}
		}
		
		
		
		longLongisGood x[] = new longLongisGood[a.length] ;
		longLongisGood s = new longLongisGood();
		
		for(int i=0;i<a.length;i++)
		{
			x[i] =new longLongisGood(a[i]);
		}
		
		
		
		for(int i=0;i<a.length;i++)
		{
			s=s.add(x[i]);
		}
		
		
		
		
		
		return s;
		
		
	}
	
	public  static void main(String[] args)
	{
		
		longLongisGood a = new longLongisGood("234");
		longLongisGood b = new longLongisGood("19");

		System.out.println((a.x(b)).change());
		
	}
	
	
	

	

}
