package 课设.JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Main extends JFrame {
    public Main(){
        setTitle("首页");
        setVisible(true);
        setSize(900,600);
        setLocation(700,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //菜单栏
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jm1 = new JMenu("成绩录入");
        JMenu jm14 = new JMenu("地区查询");
        JMenu jm9 = new JMenu("备份");
        JMenuItem jm3 = new JMenuItem("理科");
        JMenuItem jm4 = new JMenuItem("文科");
        JMenuItem jm5 = new JMenuItem("艺术");
        JMenuItem jm11 = new JMenuItem("理科");
        JMenuItem jm12 = new JMenuItem("文科");
        JMenuItem jm13 = new JMenuItem("艺术");
        JMenuItem jm6 = new JMenuItem("sql备份");
        jm1.add(jm3);
        jm1.add(jm4);
        jm1.add(jm5);
        jm14.add(jm11);
        jm14.add(jm12);
        jm14.add(jm13);
        jm9.add(jm6);
        jMenuBar.add(jm1);
        jMenuBar.add(jm14);
        jMenuBar.add(jm9);
        add(jMenuBar, BorderLayout.NORTH);

        //背景图片
        this.setVisible(true);
        ImageIcon img = new ImageIcon("src\\课设\\Icon\\photo.png");
        JLabel imgLabel = new JLabel(img);
        this.getLayeredPane().add(imgLabel,new Integer(Integer.MIN_VALUE));
        imgLabel.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
        Container cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        ((JPanel)cp).setOpaque(false);

        jm3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Science();
            }
        });
        jm4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Liberal();
            }
        });
        jm5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Art();
            }
        });
        jm11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ScienceCheck();
            }
        });
        jm13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ArtCheck();
            }
        });
        jm12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ArtCheck();
            }
        });
        jm6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newBackup(e);
                JOptionPane.showMessageDialog(null,"备份成功");
            }
        });
    }

    public boolean newBackup(ActionEvent e){
        try{
            Runtime rt = Runtime.getRuntime();
            // 调用 调用mysql的安装目录的命令
            Process child = rt.exec("cmd /c D:/mysql8/bin/mysqldump -h localhost -p3306 -uroot -p123456 test > D:\\高考成绩录入系统.sql");
            // 把进程执行中的控制台输出信息写入.sql文件，即生成了备份文件。注：如果不对控制台信息进行读出，则会导致进程堵塞无法运行
            InputStream in = child.getInputStream();// 控制台的输出信息作为输入流
            InputStreamReader xx = new InputStreamReader(in, "utf-8");
            // 设置输出流编码为utf-8。这里必须是utf-8，否则从流中读入的是乱码
            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            // 组合控制台输出信息字符串
            BufferedReader br = new BufferedReader(xx);
            while ((inStr = br.readLine()) != null) {
                sb.append(inStr + "\r\n");
            }
            outStr = sb.toString();

            // 要用来做导入用的sql目标文件：
            FileOutputStream fout = new FileOutputStream("D:\\IDEA project\\src\\test\\test.sql");
            OutputStreamWriter writer = new OutputStreamWriter(fout, "utf-8");
            writer.write(outStr);
            writer.flush();
            in.close();
            xx.close();
            br.close();


            if(child.waitFor() == 0){//0 表示线程正常终止。
                return true;
            }
        }catch (Exception a) {
            a.printStackTrace();
        }
        return false;
    }



    public static void main(String[] args){
        new Main();
    }
}
