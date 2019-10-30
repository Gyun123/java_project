package HomeWork_01_01;


public class longLongisGood {
	
	byte[] mb_data;//成员域；
	
	public longLongisGood(String a)//构造方法，将String变量转化为mb_data数据；
	{
		
		mb_data=new byte[a.length()];
		
			mb_data=a.getBytes();
		
	}
	
	public longLongisGood(int[] a)//数组构造方法，将数组数据先转化为String数据然后再转化为mb.data数据
	{
		
		String b=new String();
		String as=new String();
		int yo=0;
		
		for(int i=0;i<a.length;i++)
		{
			b+=a[i];
		}
		for(int i=0;i<b.length();i++)//清除数据前无用的0
		{
			if(b.charAt(i)!='0')
				{yo=i;
				break;}
			yo=b.length()-1;
		}
		
		as=b.substring(yo);
		mb_data=new byte[as.length()];
		
		mb_data=as.getBytes();
		
		
	}

	public longLongisGood()//空构造方法；
	{
		
		mb_data=new byte[1];
		mb_data[0]='0';
		
		
	}
	
	
	public int[] changeInt(byte[] a)//将mb_data转化为int数组的方法，方便计算；
	{
		int[]x = new int[a.length];
		String as = new String(a);
		String bs = new String();
		int yo=0;
		for(int i=0;i<as.length();i++)//清除数据前无用的0
		{
			if(as.charAt(i)!='0')
				{yo=i;
				break;}
			yo=as.length()-1;
		}
		bs=as.substring(yo);
		x=new int[bs.length()];
			for(int i=bs.length()-1;i>=0;i--)
			{
				if(bs.charAt(i)=='-') //遇到负号时跳出，将int数组x 此时下标的前一位设定为负数；
				{
					x[i+1]=-1*Integer.parseInt(String.valueOf(bs.charAt(i+1)));
					break;
				}
				x[i]=Integer.parseInt(String.valueOf(bs.charAt(i)));
			}

			
		return x;
	}
	
	
	
	public String change()//将mb_data数据反向转化为可输出显示的String数据
	{
		String a=new String(mb_data);
		return a;
	}
	
	public longLongisGood  add(longLongisGood b)//加法运算
	{
		int yo=0;//用于清除String数组前无用的0
		String[] c = new String[this.mb_data.length+b.mb_data.length];//初始化String数组
		int asd=0;//判定每个数字相加是否>10
		int as[]=new int[this.mb_data.length],bs[]=new int[b.mb_data.length];//将mb_data数据转化为int数组数据
		int yoyo=0;//结果正负判断
		as=this.changeInt(mb_data);
		bs=this.changeInt(b.mb_data);
		
		
		if(as.length>1&&bs.length>1) { //若两者长度都大于一，进入正负判断
		if(as[1]<0&&bs[1]<0)//若两者都为负数，将两者变为正数进行加，然后加上yoyo=1进行结果正负判断
		{
			yoyo=1;
			as[1]*=-1;
			bs[1]*=-1;
		}
		else if(as[1]<0)//前者为负数，将前者变为正数，然后用后者减去前者。
			{as[1]=as[1]*-1;return b.sub(new longLongisGood(as));}
		else if(bs[1]<0)//后者为负数，将后者变为正数，然后用前者减去后者。
			{bs[1]=bs[1]*-1;return this.sub(new longLongisGood(bs));}
		}
		
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
		
		
		for(int i=0;i<a.length();i++)//清除数据前无用的0
		{
			if(a.charAt(i)!='0')
				{yo=i;
				break;}	
			yo=a.length()-1;
		}
			
		String newa = a.substring(yo);
		
		if(yoyo==1)//若结果正负判断为1，则结果前加负号
		{
			newa="-"+newa;
		}
		
		
		
		longLongisGood s=new longLongisGood(newa);
		
		return s;
		
		
	}
	
	public longLongisGood  sub(longLongisGood b)//减法运算
	{
		String[] c = new String[this.mb_data.length+b.mb_data.length];//初始化String数组
		int asd=0;//判定每个数字相减是否<0
		int asde[]=new int[this.mb_data.length];
		int as[]=new int[this.mb_data.length],bs[]=new int[b.mb_data.length];//转化数据
		as=this.changeInt(mb_data);
		bs=this.changeInt(b.mb_data);
		int yo=0;//清除无用0；
		int yoyo=0;//结果正负判断
		if(as.length>1&&bs.length>1)//若两者长度大于1，进行正负判断
		{
			if(as[1]<0&&bs[1]<0)//两者为负
			{
				bs[1]*=-1;as[1]*=-1;return new longLongisGood(bs).sub(new longLongisGood(as));
			}
			else if(as[1]<0)//前者为负
				{bs[1]=bs[1]*-1;return this.add(new longLongisGood(bs));}
			else if(bs[1]<0)//后者为负
				{bs[1]=bs[1]*-1;return this.add(new longLongisGood(bs));}
		}
		
		
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
			
			asde=new int[bs.length];
			asde=as;
			as=bs;
			bs=asde;
			
			yoyo=1;//因为被减者小于减者，结果正负判断为1
		}else if(as.length==bs.length)//两者长度相等的情况
		{
			c = new String[as.length];
			if(as[0]<bs[0])//若被减者头部数值小于减者，结果正负判断为1；
			{
				int tmp[];
				tmp=bs;
				bs=as;
				as=tmp;
				yoyo=1;
				
			}
		}
		
		
		
		
		for(int i = as.length-1;i>=0;i--)//开始减法运算
		{
			
			if(as[i]-bs[i]<0)//若两者相减小于0，则asd判定为1，若asd已为1判定，则自身相减后加10保留后再减1
			{
				c[i]=String.valueOf(as[i]-bs[i]+10);
				if(asd==1)
				c[i]=String.valueOf(as[i]-bs[i]+10-1);
				asd=1;
			}
			else if(asd==1)//若两者相减不小于0，但asd判定为1；
			{
				if(as[i]-bs[i]-1<0) { //若两者相减后再减1后小于0，则加10后减1保留，并且保持asd为1判定
					c[i]=String.valueOf(as[i]-bs[i]+10-1);
				}else { //若两者相减后再减1仍不低于0，则直接两者相减后再减1，并且asd判定归0
					c[i]=String.valueOf(as[i]-bs[i]-1);
					asd=0;
				}
				
			}else c[i]=String.valueOf(as[i]-bs[i]);//若两者相减不小于0，asd判定为0，则两者直接相加
			
		}
		
		if(as[0]<bs[0])//若被减者最大位小于减者，则两者相减后保存（出现负号）
			c[0]=String.valueOf(as[0]-bs[0]);
		
		String a = new String();//新建一个String类型a变量将c String数组串起来，并返回
		for(int i = 0;i<c.length;i++)
		{
			a+=c[i];
		}
		
		for(int i=0;i<a.length();i++)//去除无用0；
		{
			if(a.charAt(i)!='0')
				{yo=i;
				break;}
			yo=a.length()-1;
				
		}
		
		String newa = a.substring(yo);
		
		if(yoyo==1)
		{
			newa="-"+newa;
		}
		
		longLongisGood s=new longLongisGood(newa);
				
		return s;
		
		
	}
	
	public longLongisGood  x(longLongisGood b)//乘法运算
	{
		int sb=0;
		int sd=0;
		int as[]=new int[this.mb_data.length],bs[]=new int[b.mb_data.length];
		int yoyo = 0;//结果正负判断
		as=this.changeInt(mb_data);
		bs=this.changeInt(b.mb_data);
		
		if(as.length>1&&bs.length>1)//两者长度大于1，进行正负判断。
		{
			
			if(as[1]<0&&bs[1]<0)
			{
				as[1]*=-1;
				bs[1]*=-1;
			}
			else if(as[1]<0)
			{
				as[1]*=-1;
				yoyo=1;
			}
			else if(bs[1]<0)
			{
				bs[1]*=-1;
				yoyo=1;
				
			}
		}
		
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
		
		String [][] c = new String[bs.length][as.length+bs.length];//初始化String数组，用二维数组模拟竖式乘法
		for(int i=as.length-1;i>=0;i--)//String内数据初始化为0；
		{
			
			for(int j=as.length+bs.length-1;j>=0;j--)
			{
				c[i][j]="0";
				
			}
			
		}
		
		
		for(int i=as.length-1;i>=0;i--)//开始乘法计算
		{
			
			int y=bs.length+as.length-1;//用于每个数相乘后的位置迁移
			if(i<as.length-1) y-=sb;//第一个乘数相乘完成后，第二个乘数的结果位置前移，相当于乘以10
			for(int j=bs.length-1;j>=0;j--)
			{
				
				if(as[i]*bs[j]>=10)
				{
					
					c[i][y]=String.valueOf((as[i]*bs[j])%10+sd);//相乘
					sd=(as[i]*bs[j]+sd)/10;
				
				}else 
				{
					c[i][y]=String.valueOf(as[i]*bs[j]+sd);
					sd=(as[i]*bs[j]+sd)/10;
				}
				--y;
				
				
			}
			sb++;//每完成一次乘数相乘，10的次方增加。
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
		
		String newa[]=new String[bs.length];
		for(int i=0;i<a.length;i++)
		{
			int yo=0;
			for(int j=0;j<a[i].length();j++)
			{
				if(a[i].charAt(j)!='0')
				{yo=i;
				break;}
			}
			newa[i] = a[i].substring(yo);
				
		}//newa数组将a数组中前面多余的0去除；
		
		
		
		
		//下面将每个乘数相乘结果相加，得出最终结果
		
		longLongisGood x[] = new longLongisGood[a.length] ;
		longLongisGood s = new longLongisGood();
		
		for(int i=0;i<a.length;i++)
		{
			x[i] =new longLongisGood(newa[i]);
		}
		
		
		
		for(int i=0;i<a.length;i++)
		{
			s=s.add(x[i]);
		}
		
		String asw=new String();
		
		if(yoyo==1)
		{
			asw = "-"+s.change();
			return new longLongisGood(asw);
		}

		return s;
		
		
	}
	
	
	public longLongisGood ds(longLongisGood b)
	{
		int j=0;
		int c=0;
		int jl[]=new int[this.mb_data.length];
		longLongisGood yes=this;
		int as[]=new int[this.mb_data.length],bs[]=new int[b.mb_data.length];
		as=this.changeInt(mb_data);
		bs=this.changeInt(b.mb_data);
		int[] s = bs;//用于装载b的内容
		
		
		if(as.length>bs.length||as.length==bs.length)//判断相加两者的长度（现在是a>b的情况）
		{
			
			bs=new int[as.length];//重新定义b的大小
			for(int i=0;i<s.length;i++)//用s对b的内容进行黏贴
			{
				bs[i]=s[i];
			}
			
		}else if(as.length<bs.length){//这是（a<b）的情况
			return new longLongisGood("0");
		}
		
		while(true)
		{
			yes=yes.sub(new longLongisGood(bs));//被除者减去除者
			String no = yes.change();//String数据no记录yes的mb.data变化
			if(no.charAt(0)=='-'&&yes.add(new longLongisGood(bs)).mb_data.length>=b.mb_data.length)//如果被除者减去除者小于0，且被除者长度比除者长度大或者等于
			{	//除者后退一位再进行递减操作
				if(yes.add(new longLongisGood(bs)).mb_data.length==b.mb_data.length&&b.mb_data.length==1&&b.mb_data[0]>yes.add(new longLongisGood(bs)).mb_data[0])
					break;//如若被除数与除数长度相等，都等于1，且除数大于被除数，跳出，得出结果；
				yes=yes.add(new longLongisGood(bs));
				j++;
				c=j;
				for(int a=0;a<s.length;a++)
				{
					
					
					bs[c]=s[a];
					c++;
				}
				
				
				
				for(int i=0;i<j;i++)//将后移后，留下的前面的数据覆盖为0
				{
					bs[i]=0;
				}
				
				
				
			}else if(no.charAt(0)=='-')
			{
				break;
			}else
			{
				jl[j]++;//递减一次，就记录一次，最终得出结果
			}
		}
		int aw[]=jl;
		jl = new int[j+1];
		//去除jl里无用的0；
		for(int i=0;i<jl.length;i++)
		{
			jl[i]=aw[i];
		}
		
			
		longLongisGood yo=new longLongisGood(jl);
		return yo;

		
		
		
		
		
		
		
		
	}
	
	public  static void main(String[] args)
	{
		
		longLongisGood a = new longLongisGood("132");
		longLongisGood b = new longLongisGood("12");
		//进行加减乘除操作，change就是mb.data数据变为String数据的操作。
			System.out.println((a.ds(b)).change());
			System.out.println((a.add(b)).change());
			System.out.println((a.x(b)).change());
			System.out.println((a.sub(b)).change());
			

		
		
	}
	
	
	

	

}
