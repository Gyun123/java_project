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
	
	public  String add(longLongisGood b)//�ӷ�����
	{
		String[] c = new String[this.mb_data.length+b.mb_data.length];//�����߳����ܺͳ�ʼ��String����
		int asd=0;//�ж�ÿ����������Ƿ�>10
		
		if(this.mb_data.length>b.mb_data.length)//�ж�������ߵĳ��ȣ�������a>b�������
		{
			c = new String[this.mb_data.length];
			byte[] s = b.mb_data;//����װ��b������
			b.mb_data=new byte[this.mb_data.length];//���¶���b�Ĵ�С
			for(int i=this.mb_data.length-s.length;i<this.mb_data.length;i++)//��s��b�����ݽ������
			{
				int j=0;
				b.mb_data[i]=s[j];
				j++;
			}
			
				for(int j=b.mb_data.length-1;j>=0;j--)//��ʱ���߳�����ͬ��ʵ��Ҳ���õ�ǰ����this����Ϊ��ʼ������ѡ��Ӻ���ǰ���мӷ�����
				{
					if(b.mb_data[j]+this.mb_data[j]>9)//�� ��ǰ���� ��Ӻ�>9����ǰ����-10����������asd����ж���int���ݱ��Ϊ1
					{
						c[j]=String.valueOf(b.mb_data[j]+this.mb_data[j]-10);
						asd=1;
						
					}
					else{//����ǰ�������û��>9����������²���
						if(asd==1)//�ж�Ϊ1����֪������ǰһλ�������������>9������������Ӻ�Ҫ+1
						{
							if(b.mb_data[j]+this.mb_data[j]+1>9) //��������Ӻ���+1��>9���򱣳�asd�ж�����Ϊ1������������Ӻ�-9��������Ϊ+1��>9��
							{
								c[j]=String.valueOf(b.mb_data[j]+this.mb_data[j]-9);
								
							}
							else {//��������Ӻ���+1���Բ�>9��������+1������asd�ж����ݹ�0
								c[j] =String.valueOf(b.mb_data[j]+this.mb_data[j]+1);
								asd=0;
								
							}
							
						}	
						else{//asd�ж�����Ϊ0������£��������
							c[j] =String.valueOf(b.mb_data[j]+this.mb_data[j]);
						}
					}
					
				}
				

				
				
		}
		String a = new String();
		for(int i = 0;i<c.length;i++)//ʹ���´�����String���� a �� �������ݵ�String ���� c �����������з��ء�
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
