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
	
	public longLongisGood  add(longLongisGood b)//�ӷ�����
	{
		String[] c = new String[this.mb_data.length+b.mb_data.length];//��ʼ��String����
		int asd=0;//�ж�ÿ����������Ƿ�>10
		int as[]=new int[this.mb_data.length],bs[]=new int[b.mb_data.length];
		as=this.changeInt(mb_data);
		bs=this.changeInt(b.mb_data);
		
		if(as.length>bs.length)//�ж�������ߵĳ��ȣ�������a>b�������
		{
			c = new String[as.length];
			int[] s = bs;//����װ��b������
			bs=new int[as.length];//���¶���b�Ĵ�С
			for(int i=as.length-s.length,j=0;i<as.length;i++)//��s��b�����ݽ������
			{
				bs[i]=s[j];
				j++;
			}
		}else if(as.length<bs.length){//���ǣ�a<b�������
			c = new String[bs.length];
			int[] s = as;
			as=new int[bs.length];//���¶���this�Ĵ�С
			for(int i=bs.length-s.length, j=0;i<bs.length;i++)//��s��this�����ݽ������
			{
				
				as[i]=s[j];
				j++;
			}
		}else if(as.length==bs.length)
		{
			c = new String[as.length];
		}
		
		
		
		for(int i = as.length-1;i>=0;i--)//��ʼ�ӷ�����
		{
			if(as[i]+bs[i]>9)//��������Ӵ���9����asd�ж�Ϊ1����asd��Ϊ1�ж����������ڼ�10�������ټ�1
			{
				c[i]=String.valueOf(as[i]+bs[i]-10);
				if(asd==1)
				c[i]=String.valueOf(as[i]+bs[i]-10+1);
				asd=1;
			}
			else if(asd==1)//��������Ӳ�����9����asd�ж�Ϊ1��
			{
				if(as[i]+bs[i]+1>9) { //����������ټ�1�����9�����9���������ұ���asdΪ1�ж�
					c[i]=String.valueOf(as[i]+bs[i]-9);
				}else { //����������ټ�1���Բ�����9����ֱ��������Ӻ��1������asd�ж���0
					c[i]=String.valueOf(as[i]+bs[i]+1);
					asd=0;
				}
				
			}else c[i]=String.valueOf(as[i]+bs[i]);//��������Ӳ�����9��asd�ж�Ϊ0��������ֱ�����
		}
		
		String a = new String();//�½�һ��String����a������c String���鴮������������
		for(int i = 0;i<c.length;i++)
		{
			a+=c[i];
		}
		
		longLongisGood s=new longLongisGood(a);
		
		return s;
		
		
	}
	
	public longLongisGood  sub(longLongisGood b)//�ӷ�����
	{
		String[] c = new String[this.mb_data.length+b.mb_data.length];//��ʼ��String����
		int asd=0;//�ж�ÿ����������Ƿ�<0
		int as[]=new int[this.mb_data.length],bs[]=new int[b.mb_data.length];
		as=this.changeInt(mb_data);
		bs=this.changeInt(b.mb_data);
		
		
		
		if(as.length>bs.length)//�ж�������ߵĳ��ȣ�������a>b�������
		{
			c = new String[as.length];
			int[] s = bs;//����װ��b������
			bs=new int[as.length];//���¶���b�Ĵ�С
			for(int i=as.length-s.length,j=0;i<as.length;i++)//��s��b�����ݽ������
			{
				bs[i]=s[j];
				j++;
			}
		}else if(as.length<bs.length){//���ǣ�a<b�������
			c = new String[bs.length];
			int[] s = as;
			as=new int[bs.length];//���¶���this�Ĵ�С
			for(int i=bs.length-s.length, j=0;i<bs.length;i++)//��s��this�����ݽ������
			{
				
				as[i]=s[j];
				j++;
			}
		}else if(as.length==bs.length)
		{
			c = new String[as.length];
		}
		
		
		
		for(int i = as.length-1;i>=0;i--)//��ʼ�ӷ�����
		{
			
			if(as[i]-bs[i]<0)//��������Ӵ���9����asd�ж�Ϊ1����asd��Ϊ1�ж����������ڼ�10�������ټ�1
			{
				c[i]=String.valueOf(as[i]-bs[i]+10);
				if(asd==1)
				c[i]=String.valueOf(as[i]-bs[i]+10-1);
				asd=1;
			}
			else if(asd==1)//��������Ӳ�����9����asd�ж�Ϊ1��
			{
				if(as[i]-bs[i]-1<0) { //����������ټ�1�����9�����9���������ұ���asdΪ1�ж�
					c[i]=String.valueOf(as[i]-bs[i]+10-1);
				}else { //����������ټ�1���Բ�����9����ֱ��������Ӻ��1������asd�ж���0
					c[i]=String.valueOf(as[i]-bs[i]-1);
					asd=0;
				}
				
			}else c[i]=String.valueOf(as[i]-bs[i]);//��������Ӳ�����9��asd�ж�Ϊ0��������ֱ�����
			
		}
		
		if(as[0]<bs[0])
			c[0]=String.valueOf(as[0]-bs[0]);
		
		String a = new String();//�½�һ��String����a������c String���鴮������������
		for(int i = 0;i<c.length;i++)
		{
			a+=c[i];
		}
		
		longLongisGood s=new longLongisGood(a);
				
		return s;
		
		
	}
	
	public longLongisGood  x(longLongisGood b)//�ӷ�����
	{
		int sb=0;
		int sd=0;
		int as[]=new int[this.mb_data.length],bs[]=new int[b.mb_data.length];
		as=this.changeInt(mb_data);
		bs=this.changeInt(b.mb_data);
		if(as.length>bs.length)//�ж�������ߵĳ��ȣ�������a>b�������
		{
			int[] s = bs;//����װ��b������
			bs=new int[as.length];//���¶���b�Ĵ�С
			for(int i=as.length-s.length,j=0;i<as.length;i++)//��s��b�����ݽ������
			{
				bs[i]=s[j];
				j++;
			}
		}else if(as.length<bs.length){//���ǣ�a<b�������
			int[] s = as;
			as=new int[bs.length];//���¶���this�Ĵ�С
			for(int i=bs.length-s.length, j=0;i<bs.length;i++)//��s��this�����ݽ������
			{
				
				as[i]=s[j];
				j++;
			}
		}
		
		String [][] c = new String[bs.length][as.length+bs.length];//��ʼ��String����
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
		

				
		
		String a[] = new String[bs.length];//�½�һ��String����a������c String���鴮������������
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
