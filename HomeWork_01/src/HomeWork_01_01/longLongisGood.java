package HomeWork_01_01;


public class longLongisGood {
	
	byte[] mb_data;//��Ա��
	
	public longLongisGood(String a)//���췽������String����ת��Ϊmb_data���ݣ�
	{
		
		mb_data=new byte[a.length()];
		
			mb_data=a.getBytes();
		
	}
	
	public longLongisGood(int[] a)//���鹹�췽����������������ת��ΪString����Ȼ����ת��Ϊmb.data����
	{
		
		String b=new String();
		String as=new String();
		int yo=0;
		
		for(int i=0;i<a.length;i++)
		{
			b+=a[i];
		}
		for(int i=0;i<b.length();i++)//�������ǰ���õ�0
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
			yo=as.length()-1;
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
		int yoyo=0;//��������ж�
		as=this.changeInt(mb_data);
		bs=this.changeInt(b.mb_data);
		
		
		if(as.length>1&&bs.length>1) { //�����߳��ȶ�����һ�����������ж�
		if(as[1]<0&&bs[1]<0)//�����߶�Ϊ�����������߱�Ϊ�������мӣ�Ȼ�����yoyo=1���н�������ж�
		{
			yoyo=1;
			as[1]*=-1;
			bs[1]*=-1;
		}
		else if(as[1]<0)//ǰ��Ϊ��������ǰ�߱�Ϊ������Ȼ���ú��߼�ȥǰ�ߡ�
			{as[1]=as[1]*-1;return b.sub(new longLongisGood(as));}
		else if(bs[1]<0)//����Ϊ�����������߱�Ϊ������Ȼ����ǰ�߼�ȥ���ߡ�
			{bs[1]=bs[1]*-1;return this.sub(new longLongisGood(bs));}
		}
		
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
			yo=a.length()-1;
		}
			
		String newa = a.substring(yo);
		
		if(yoyo==1)//����������ж�Ϊ1������ǰ�Ӹ���
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
		int asde[]=new int[this.mb_data.length];
		int as[]=new int[this.mb_data.length],bs[]=new int[b.mb_data.length];//ת������
		as=this.changeInt(mb_data);
		bs=this.changeInt(b.mb_data);
		int yo=0;//�������0��
		int yoyo=0;//��������ж�
		if(as.length>1&&bs.length>1)//�����߳��ȴ���1�����������ж�
		{
			if(as[1]<0&&bs[1]<0)//����Ϊ��
			{
				bs[1]*=-1;as[1]*=-1;return new longLongisGood(bs).sub(new longLongisGood(as));
			}
			else if(as[1]<0)//ǰ��Ϊ��
				{bs[1]=bs[1]*-1;return this.add(new longLongisGood(bs));}
			else if(bs[1]<0)//����Ϊ��
				{bs[1]=bs[1]*-1;return this.add(new longLongisGood(bs));}
		}
		
		
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
			
			asde=new int[bs.length];
			asde=as;
			as=bs;
			bs=asde;
			
			yoyo=1;//��Ϊ������С�ڼ��ߣ���������ж�Ϊ1
		}else if(as.length==bs.length)//���߳�����ȵ����
		{
			c = new String[as.length];
			if(as[0]<bs[0])//��������ͷ����ֵС�ڼ��ߣ���������ж�Ϊ1��
			{
				int tmp[];
				tmp=bs;
				bs=as;
				as=tmp;
				yoyo=1;
				
			}
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
	
	public longLongisGood  x(longLongisGood b)//�˷�����
	{
		int sb=0;
		int sd=0;
		int as[]=new int[this.mb_data.length],bs[]=new int[b.mb_data.length];
		int yoyo = 0;//��������ж�
		as=this.changeInt(mb_data);
		bs=this.changeInt(b.mb_data);
		
		if(as.length>1&&bs.length>1)//���߳��ȴ���1�����������жϡ�
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
			if(i<as.length-1) y-=sb;//��һ�����������ɺ󣬵ڶ��������Ľ��λ��ǰ�ƣ��൱�ڳ���10
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
			sb++;//ÿ���һ�γ�����ˣ�10�Ĵη����ӡ�
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
				
		}//newa���齫a������ǰ������0ȥ����
		
		
		
		
		//���潫ÿ��������˽����ӣ��ó����ս��
		
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
		int[] s = bs;//����װ��b������
		
		
		if(as.length>bs.length||as.length==bs.length)//�ж�������ߵĳ��ȣ�������a>b�������
		{
			
			bs=new int[as.length];//���¶���b�Ĵ�С
			for(int i=0;i<s.length;i++)//��s��b�����ݽ������
			{
				bs[i]=s[i];
			}
			
		}else if(as.length<bs.length){//���ǣ�a<b�������
			return new longLongisGood("0");
		}
		
		while(true)
		{
			yes=yes.sub(new longLongisGood(bs));//�����߼�ȥ����
			String no = yes.change();//String����no��¼yes��mb.data�仯
			if(no.charAt(0)=='-'&&yes.add(new longLongisGood(bs)).mb_data.length>=b.mb_data.length)//��������߼�ȥ����С��0���ұ����߳��ȱȳ��߳��ȴ���ߵ���
			{	//���ߺ���һλ�ٽ��еݼ�����
				if(yes.add(new longLongisGood(bs)).mb_data.length==b.mb_data.length&&b.mb_data.length==1&&b.mb_data[0]>yes.add(new longLongisGood(bs)).mb_data[0])
					break;//���������������������ȣ�������1���ҳ������ڱ��������������ó������
				yes=yes.add(new longLongisGood(bs));
				j++;
				c=j;
				for(int a=0;a<s.length;a++)
				{
					
					
					bs[c]=s[a];
					c++;
				}
				
				
				
				for(int i=0;i<j;i++)//�����ƺ����µ�ǰ������ݸ���Ϊ0
				{
					bs[i]=0;
				}
				
				
				
			}else if(no.charAt(0)=='-')
			{
				break;
			}else
			{
				jl[j]++;//�ݼ�һ�Σ��ͼ�¼һ�Σ����յó����
			}
		}
		int aw[]=jl;
		jl = new int[j+1];
		//ȥ��jl�����õ�0��
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
		//���мӼ��˳�������change����mb.data���ݱ�ΪString���ݵĲ�����
			System.out.println((a.ds(b)).change());
			System.out.println((a.add(b)).change());
			System.out.println((a.x(b)).change());
			System.out.println((a.sub(b)).change());
			

		
		
	}
	
	
	

	

}
