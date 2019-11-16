

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class B37 {

    JFrame f;
    JLabel label;//��ǩ
    JTextArea textArea;//�ı���
    JFileChooser fileChooser;//�ļ�ѡ��
    FileInputStream fileInStream;

    public B37() {
        // TODO Auto-generated constructor stub
        f=new JFrame("�����");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane=f.getContentPane();
        textArea=new JTextArea();
        JScrollPane scrollPane=new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(350, 300));
        final JTextArea textArea = new JTextArea(10, 10);
        
        JPanel panel=new JPanel();
        JMenuBar menuBar1=new JMenuBar();  //��Ӳ˵������
        f.setJMenuBar(menuBar1);          //���˵�����ӵ�����������
        JMenu menu1=new JMenu("�ļ�");
        JMenu menu2=new JMenu("�༭");
      //���˵������ӵ��˵��������
        menuBar1.add(menu1);//���ļ����༭���ڲ˵�����
        menuBar1.add(menu2);
        
        
        //�����˵���������ļ���
        final JMenuItem item1=new JMenuItem("��");
        final JMenuItem item2=new JMenuItem("����");
        
        
        JMenuItem item3=new JMenuItem("�˳�");
        menu1.add(item1);
        menu1.add(item2);
       // menu1.addSeparator();           //�˵���֮��ķָ������
        
        menu1.addSeparator();
        menu1.add(item3);
//�������༭��
        final JMenuItem item4=new JMenuItem("����");
        final JMenuItem item5=new JMenuItem("ճ��");
        menu2.add(item4);
        menu2.add(item5);
        
        //���ö���������Ŀɼ���
        f.setVisible(true);
        label=new JLabel("",JLabel.CENTER);//��ǩ��ʼ��
        contentPane.add(label, BorderLayout.NORTH);//�ѱ�ǩ�ӽ�ȥ
        contentPane.add(scrollPane, BorderLayout.CENTER);//���������ı������ڣ��Ž�������
        contentPane.add(panel, BorderLayout.SOUTH);//���ӷ����
        f.pack();//�ô�����Ӧ�����С����Ѵ�С��
        
        
        //�����˳��˵���Ķ����¼�
        item3.addActionListener(new ActionListener() {
            
           
            public void actionPerformed( ActionEvent e) {
                // TODO Auto-generated method stub
                int i=JOptionPane.showConfirmDialog(null, "�Ƿ��˳�ϵͳ",
                        "�˳�ȷ�϶Ի���",JOptionPane.YES_NO_CANCEL_OPTION);
                //ͨ�����ֶ����Ի����а�ť��ѡ�����������������yesʱ������ֱ����ʧ
                if(i==0)//�رգ�
                    f.dispose();
                
            }
        });
      //���ļ�
        item1.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JFileChooser chooser = new JFileChooser();                               //JFileChooser.APPROVE_OPTION���ѡ���ļ��Ķ���
                if (chooser.showOpenDialog(item1)==JFileChooser.APPROVE_OPTION) {//���ļ�        chooser.showOpenDialog�ҵ��ı��ļ�������ʾ����
                    File file = chooser.getSelectedFile();//���ش��ļ��Ի�����ѡ�е��ļ�
                    textArea.setText(file.getName()+":"+file.getPath()+"\n"+file.length());
                    readFile(file);//��ȡ             //�ļ���+�ļ�·�����ļ��ֽڴ�С
                };
                  
            }       
        });//�����ļ�     
        item2.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JFileChooser chooser = new JFileChooser();//JFileChooser���ڴ��е�����д�����ش���
                if (chooser.showSaveDialog(item2)==JFileChooser.APPROVE_OPTION) {//
                    File file = chooser.getSelectedFile();
                    writeFile(file.getPath());// writeFile���Խ�����д��һ���ļ�����I/O�豸��  .getPath·��
            }
            }
        });
}
  //����
    /*item4.addActionListener(new ActionListener(){
    	
    }
    );*/
        public void copyFile(File file){//�����ļ�
            File to=new File(file.getAbsolutePath()+"_copy");
            if (file.isFile()) {
                byte[] buf = new byte[1024];//�ֽ���
                int length=0;
                try {
                    FileInputStream in=new FileInputStream(file);
                    FileOutputStream out=new FileOutputStream(to);
                    while((length=in.read(buf))>0){
                        out.write(buf,0,length);
                    }
                    out.flush();
                    in.close();
                    out.close();
                } catch (Exception e) {
                    // TODO Auto-generated catchblock
                    e.printStackTrace();
                }

            }
        }
public void readFile(File file){//���ļ�
        BufferedReader bReader;
        try {
            bReader=new BufferedReader(new FileReader(file));//һ��һ��д����������ţ��
            StringBuffer sBuffer=new StringBuffer();
            String str;
            while((str=bReader.readLine())!=null)
            {
                sBuffer.append(str+'\n');
                System.out.println(str);
            }
            textArea.setText(sBuffer.toString());
        } catch (Exception e) 
        {
            // TODO: handle exception
        }
    }
    public void writeFile(String savepath)
    {//д�ļ�
        FileOutputStream fos= null;
        try {
            fos=new FileOutputStream(savepath);
            fos.write(textArea.getText().getBytes());
            fos.close();
            System.out.println("�ѱ���");
        } catch (Exception e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       textArea.getText();
    }
    
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new B37();

    }
}