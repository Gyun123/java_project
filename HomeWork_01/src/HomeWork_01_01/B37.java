

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
    JLabel label;//标签
    JTextArea textArea;//文本框
    JFileChooser fileChooser;//文件选择
    FileInputStream fileInStream;

    public B37() {
        // TODO Auto-generated constructor stub
        f=new JFrame("浏览器");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane=f.getContentPane();
        textArea=new JTextArea();
        JScrollPane scrollPane=new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(350, 300));
        final JTextArea textArea = new JTextArea(10, 10);
        
        JPanel panel=new JPanel();
        JMenuBar menuBar1=new JMenuBar();  //添加菜单条组件
        f.setJMenuBar(menuBar1);          //将菜单栏添加到顶层容器中
        JMenu menu1=new JMenu("文件");
        JMenu menu2=new JMenu("编辑");
      //将菜单组件添加到菜单条组件中
        menuBar1.add(menu1);//把文件跟编辑放在菜单栏中
        menuBar1.add(menu2);
        
        
        //创建菜单项组件（文件）
        final JMenuItem item1=new JMenuItem("打开");
        final JMenuItem item2=new JMenuItem("保存");
        
        
        JMenuItem item3=new JMenuItem("退出");
        menu1.add(item1);
        menu1.add(item2);
       // menu1.addSeparator();           //菜单项之间的分隔线组件
        
        menu1.addSeparator();
        menu1.add(item3);
//创建（编辑）
        final JMenuItem item4=new JMenuItem("复制");
        final JMenuItem item5=new JMenuItem("粘贴");
        menu2.add(item4);
        menu2.add(item5);
        
        //设置顶层容器类的可见性
        f.setVisible(true);
        label=new JLabel("",JLabel.CENTER);//标签初始化
        contentPane.add(label, BorderLayout.NORTH);//把标签加进去
        contentPane.add(scrollPane, BorderLayout.CENTER);//滚动条（文本框在内）放进容器内
        contentPane.add(panel, BorderLayout.SOUTH);//面板加方框进
        f.pack();//让窗口适应组件大小（最佳大小）
        
        
        //处理退出菜单项的动作事件
        item3.addActionListener(new ActionListener() {
            
           
            public void actionPerformed( ActionEvent e) {
                // TODO Auto-generated method stub
                int i=JOptionPane.showConfirmDialog(null, "是否退出系统",
                        "退出确认对话框",JOptionPane.YES_NO_CANCEL_OPTION);
                //通过（手动）对话框中按钮的选择来决定结果，单机yes时，窗口直接消失
                if(i==0)//关闭？
                    f.dispose();
                
            }
        });
      //打开文件
        item1.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JFileChooser chooser = new JFileChooser();                               //JFileChooser.APPROVE_OPTION获得选中文件的对象
                if (chooser.showOpenDialog(item1)==JFileChooser.APPROVE_OPTION) {//打开文件        chooser.showOpenDialog找到文本文件将他显示出来
                    File file = chooser.getSelectedFile();//返回从文件对话框中选中的文件
                    textArea.setText(file.getName()+":"+file.getPath()+"\n"+file.length());
                    readFile(file);//读取             //文件名+文件路径，文件字节大小
                };
                  
            }       
        });//保存文件     
        item2.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JFileChooser chooser = new JFileChooser();//JFileChooser将内存中的数据写进本地磁盘
                if (chooser.showSaveDialog(item2)==JFileChooser.APPROVE_OPTION) {//
                    File file = chooser.getSelectedFile();
                    writeFile(file.getPath());// writeFile可以将数据写入一个文件或者I/O设备。  .getPath路径
            }
            }
        });
}
  //复制
    /*item4.addActionListener(new ActionListener(){
    	
    }
    );*/
        public void copyFile(File file){//复制文件
            File to=new File(file.getAbsolutePath()+"_copy");
            if (file.isFile()) {
                byte[] buf = new byte[1024];//字节流
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
public void readFile(File file){//读文件
        BufferedReader bReader;
        try {
            bReader=new BufferedReader(new FileReader(file));//一行一行写，慢慢来，牛逼
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
    {//写文件
        FileOutputStream fos= null;
        try {
            fos=new FileOutputStream(savepath);
            fos.write(textArea.getText().getBytes());
            fos.close();
            System.out.println("已保存");
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