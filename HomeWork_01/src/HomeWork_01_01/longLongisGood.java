package HomeWork_01_01;


public class longLongisGood {
	
	byte[] mb_data;//��Ա��
	
	public longLongisGood(String a)//���췽������String����ת��Ϊmb_data���ݣ�
	{
		
		mb_data=new byte[a.length()];
		
			mb_data=a.getBytes();
		
	}
	
	public longLongisGood(int[] a)//�չ��췽����
	{
		String b=new String();
		for(int i=0;i<a.length;i++)
		{
			b+=a[i];
		}
		mb_data=new byte[b.length()];
		
		mb_data=b.getBytes();
		
		
	}

	public longLongisGood()//�չ��췽����
	{
		
		mb_data=new byte[1];
		mb_data[0]='0';
		
		
	}
	
	
	public int[] changeInt(byte[] a)//��mb_dataת��Ϊint����ķ�����������㣻
	{
		int[]x = new int[a.length];
		String as = new String(a);
		String bs = new String();
		int yo=0;
		for(int i=0;i<as.length();i++)//�������ǰ���õ�0
		{
			if(as.charAt(i)!='0')
				{yo=i;
				break;}
		}
		bs=as.substring(yo);
		x=new int[bs.length()];
			for(int i=bs.length()-1;i>=0;i--)
			{
				if(bs.charAt(i)=='-') //��������ʱ��������int����x ��ʱ�±��ǰһλ�趨Ϊ������
				{
					x[i+1]=-1*Integer.parseInt(String.valueOf(bs.charAt(i+1)));
					break;
				}
				x[i]=Integer.parseInt(String.valueOf(bs.charAt(i)));
			}

			
		return x;
	}
	
	
	
	public String change()//��mb_data���ݷ���ת��Ϊ�������ʾ��String����
	{
		String a=new String(mb_data);
		return a;
	}
	
	public longLongisGood  add(longLongisGood b)//�ӷ�����
	{
		int yo=0;//�������String����ǰ���õ�0
		String[] c = new String[this.mb_data.length+b.mb_data.length];//��ʼ��String����
		int asd=0;//�ж�ÿ����������Ƿ�>10
		int as[]=new int[this.mb_data.length],bs[]=new int[b.mb_data.length];//��mb_data����ת��Ϊint��������
		int yoyo=0;
		as=this.changeInt(mb_data);
		bs=this.changeInt(b.mb_data);
		if(as[1]<0&&bs[1]<0)
		{
			yoyo=1;
			as[1]*=-1;
			bs[1]*=-1;
		}
		else if(as[1]<0)
			{as[1]=as[1]*-1;return b.sub(new longLongisGood(as));}
		else if(bs[1]<0)
			{bs[1]=bs[1]*-1;return this.sub(new longLongisGood(bs));}
		
		
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
		
		
		for(int i=0;i<a.length();i++)//�������ǰ���õ�0
		{
			if(a.charAt(i)!='0')
				{yo=i;
				break;}	
		}
			
		String newa = a.substring(yo);
		
		if(yoyo==1)
		{
			newa="-"+newa;
		}
		
		
		
		longLongisGood s=new longLongisGood(newa);
		
		return s;
		
		
	}
	
	public longLongisGood  sub(longLongisGood b)//��������
	{
		String[] c = new String[this.mb_data.length+b.mb_data.length];//��ʼ��String����
		int asd=0;//�ж�ÿ����������Ƿ�<0
		int as[]=new int[this.mb_data.length],bs[]=new int[b.mb_data.length];//ת������
		as=this.changeInt(mb_data);
		bs=this.changeInt(b.mb_data);
		int yo=0;//�������0��
		
		
		
		
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
		
		
		
		for(int i = as.length-1;i>=0;i--)//��ʼ��������
		{
			
			if(as[i]-bs[i]<0)//���������С��0����asd�ж�Ϊ1����asd��Ϊ1�ж���������������10�������ټ�1
			{
				c[i]=String.valueOf(as[i]-bs[i]+10);
				if(asd==1)
				c[i]=String.valueOf(as[i]-bs[i]+10-1);
				asd=1;
			}
			else if(asd==1)//�����������С��0����asd�ж�Ϊ1��
			{
				if(as[i]-bs[i]-1<0) { //������������ټ�1��С��0�����10���1���������ұ���asdΪ1�ж�
					c[i]=String.valueOf(as[i]-bs[i]+10-1);
				}else { //������������ټ�1�Բ�����0����ֱ������������ټ�1������asd�ж���0
					c[i]=String.valueOf(as[i]-bs[i]-1);
					asd=0;
				}
				
			}else c[i]=String.valueOf(as[i]-bs[i]);//�����������С��0��asd�ж�Ϊ0��������ֱ�����
			
		}
		
		if(as[0]<bs[0])//�����������λС�ڼ��ߣ�����������󱣴棨���ָ��ţ�
			c[0]=String.valueOf(as[0]-bs[0]);
		
		String a = new String();//�½�һ��String����a������c String���鴮������������
		for(int i = 0;i<c.length;i++)
		{
			a+=c[i];
		}
		
		for(int i=0;i<a.length();i++)//ȥ������0��
		{
			if(a.charAt(i)!='0')
				{yo=i;
				break;}
			
				
		}
		
		String newa = a.substring(yo);
		
		longLongisGood s=new longLongisGood(newa);
				
		return s;
		
		
	}
	
	public longLongisGood  x(longLongisGood b)//�˷�����
	{
		int sb=0;
		int sd=0;
		int as[]=new int[this.mb_data.length],bs[]=new int[b.mb_data.length];
		int yoyo1=0,yoyo2=0;
		as=this.changeInt(mb_data,yoyo1);
		bs=this.changeInt(b.mb_data,yoyo2);
		System.out.println(yoyo2);
		if(yoyo1==1&&yoyo2==1)
			return this.x(b);
		
		
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
		
		String [][] c = new String[bs.length][as.length+bs.length];//��ʼ��String���飬�ö�ά����ģ����ʽ�˷�
		for(int i=as.length-1;i>=0;i--)//String�����ݳ�ʼ��Ϊ0��
		{
			
			for(int j=as.length+bs.length-1;j>=0;j--)
			{
				c[i][j]="0";
				
			}
			
		}
		
		
		for(int i=as.length-1;i>=0;i--)//��ʼ�˷�����
		{
			
			int y=bs.length+as.length-1;//����ÿ������˺��λ��Ǩ��
			if(i<as.length-1) y-=sb;
			for(int j=bs.length-1;j>=0;j--)
			{
				
				if(as[i]*bs[j]>=10)
				{
					
					c[i][y]=String.valueOf((as[i]*bs[j])%10+sd);//���
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
				
		}
		
		
		
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
	
		
		if(yoyo1==1||yoyo2==1)
			s.mb_data[0]*=-1;
		System.out.println(yoyo1);
		
		return s;
		
		
	}
	
	
	public longLongisGood ds(longLongisGood b)
	{
		int sb=0;
		int sd=this.mb_data.length-b.mb_data.length;
		int j=0;
		longLongisGood yes = new longLongisGood();
		byte[] ok = b.mb_data;
		b.mb_data = new byte[this.mb_data.length];
		for(int i = 0;i<b.mb_data.length;i++)
		{
			b.mb_data[i]='0';
		}
		for(int i=j;i<ok.length;i++)
		{
			b.mb_data[i]=ok[i];
		}
		
		
		if(this.mb_data.length<b.mb_data.length){//���ǣ�a<b�������
			longLongisGood sba= new longLongisGood("0");
			return sba ;
		}
		String no= new String();
		yes=this;
		
		while(true)
		{
			
			
			yes=yes.sub(b);

			no=new String(yes.mb_data);
				
			
			if(no.charAt(0)=='-'&&this.mb_data.length>=b.mb_data.length)
			{
				j++;
				for(int i=j;i<ok.length;i++)
				{
					b.mb_data[i]=ok[i];
					b.mb_data[i-1]='0';
				}
				yes=yes.add(b);
				
				continue;
			}else if(no.charAt(0)=='-')
			{
				break;
			}
			
			sb++;
			System.out.println(sb);
		}

		
		longLongisGood sab=new longLongisGood(String.valueOf(sb));
		
		return  sab;
		
		
		
		
		
		
		
	}
	
	public  static void main(String[] args)
	{
		
		longLongisGood a = new longLongisGood("211");
		longLongisGood b = new longLongisGood("-21");
		
			System.out.println((a.add(b)).change());
			

		
		
	}
	
	
	

	

}
