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
	
	public String  add(longLongisGood b)//�ӷ�����
	{
		String[] c = new String[this.mb_data.length+b.mb_data.length];//��ʼ��String����
		int asd=0;//�ж�ÿ����������Ƿ�>10
		
		if(this.mb_data.length>b.mb_data.length)//�ж�������ߵĳ��ȣ�������a>b�������
		{
			c = new String[this.mb_data.length];
			byte[] s = b.mb_data;//����װ��b������
			b.mb_data=new byte[this.mb_data.length];//���¶���b�Ĵ�С
			for(int i=this.mb_data.length-s.length,j=0;i<this.mb_data.length;i++)//��s��b�����ݽ������
			{
				b.mb_data[i]=s[j];
				j++;
			}
		}else if(this.mb_data.length<b.mb_data.length){//���ǣ�a<b�������
			c = new String[b.mb_data.length];
			byte[] s = this.mb_data;
			this.mb_data=new byte[b.mb_data.length];//���¶���this�Ĵ�С
			for(int i=b.mb_data.length-s.length, j=0;i<b.mb_data.length;i++)//��s��this�����ݽ������
			{
				
				this.mb_data[i]=s[j];
				j++;
			}
		}else if(this.mb_data.length==b.mb_data.length)
		{
			c = new String[this.mb_data.length];
		}
		
		for(int i = this.mb_data.length-1;i>=0;i--)//��ʼ�ӷ�����
		{
			if(this.mb_data[i]+b.mb_data[i]>9)//��������Ӵ���9����asd�ж�Ϊ1����asd��Ϊ1�ж����������ڼ�10�������ټ�1
			{
				c[i]=String.valueOf(this.mb_data[i]+b.mb_data[i]-10);
				if(asd==1)
				c[i]=String.valueOf(this.mb_data[i]+b.mb_data[i]-10+1);
				asd=1;
			}
			else if(asd==1)//��������Ӳ�����9����asd�ж�Ϊ1��
			{
				if(this.mb_data[i]+b.mb_data[i]+1>9) { //����������ټ�1�����9�����9���������ұ���asdΪ1�ж�
					c[i]=String.valueOf(this.mb_data[i]+b.mb_data[i]-9);
				}else { //����������ټ�1���Բ�����9����ֱ��������Ӻ��1������asd�ж���0
					c[i]=String.valueOf(this.mb_data[i]+b.mb_data[i]+1);
					asd=0;
				}
				
			}else c[i]=String.valueOf(this.mb_data[i]+b.mb_data[i]);//��������Ӳ�����9��asd�ж�Ϊ0��������ֱ�����
		}
		
		String a = new String();//�½�һ��String����a������c String���鴮������������
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
