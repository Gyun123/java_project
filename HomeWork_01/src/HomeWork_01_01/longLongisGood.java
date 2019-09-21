package HomeWork_01_01;

public class longLongisGood {
	
	byte[] mb_data;
	
	public longLongisGood(String a)
	{
		mb_data=new byte[a.length()];
		for(int i=a.length()-1;i>=0;i--)
		{
			mb_data[i]=(byte) Integer.parseInt(String.valueOf(a.charAt(i)));
		}
	}
	
	
	
	public String change()
	{
		String a=new String(mb_data);
		return a;
	}
	
	public  String add(longLongisGood b)//加法运算
	{
		String[] c = new String[this.mb_data.length+b.mb_data.length];//用两者长度总和初始化String数组
		int asd=0;//判定每个数字相加是否>10
		
		if(this.mb_data.length>b.mb_data.length)//判断相加两者的长度（现在是a>b的情况）
		{
			c = new String[this.mb_data.length];
			byte[] s = b.mb_data;//用于装载b的内容
			b.mb_data=new byte[this.mb_data.length];//重新定义b的大小
			for(int i=this.mb_data.length-s.length;i<this.mb_data.length;i++)//用s对b的内容进行黏贴
			{
				int j=0;
				b.mb_data[i]=s[j];
				j++;
			}
			
				for(int j=b.mb_data.length-1;j>=0;j--)//此时两者长度相同，实际也可用当前（即this）作为开始，这里选择从后往前进行加法运算
				{
					if(b.mb_data[j]+this.mb_data[j]>9)//当 当前数字 相加后>9，则当前数字-10后保留，并将asd这个判断用int数据变更为1
					{
						c[j]=String.valueOf(b.mb_data[j]+this.mb_data[j]-10);
						asd=1;
						
					}
					else{//若当前数字相加没有>9，则进行以下步骤
						if(asd==1)//判断为1，可知比自身前一位的两个数字相加>9，则自身在相加后要+1
						{
							if(b.mb_data[j]+this.mb_data[j]+1>9) //若自身相加后，再+1，>9，则保持asd判断数据为1，并且自身相加后-9保留（因为+1才>9）
							{
								c[j]=String.valueOf(b.mb_data[j]+this.mb_data[j]-9);
								
							}
							else {//若自身相加后，再+1，仍不>9，则正常+1；并且asd判断数据归0
								c[j] =String.valueOf(b.mb_data[j]+this.mb_data[j]+1);
								asd=0;
								
							}
							
						}	
						else{//asd判断数据为0的情况下，正常相加
							c[j] =String.valueOf(b.mb_data[j]+this.mb_data[j]);
						}
					}
					
				}
				

				
				
		}
		String a = new String();
		for(int i = 0;i<c.length;i++)//使用新创建的String数据 a 将 保存数据的String 数组 c 串起来，进行返回。
		{
			a+=c[i];
		}
		
		return a;
		
		
	}
	
	public  static void main(String[] args)
	{
		
		longLongisGood a = new longLongisGood("1234");
		longLongisGood b = new longLongisGood("277");
		
		
		String yes = new String(a.mb_data);
		System.out.println(a.add(b));
	}
	
	
	

	

}
