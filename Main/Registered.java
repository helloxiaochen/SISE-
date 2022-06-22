package 课设.Main;


import 课设.Dao.DBSourse;
import 课设.Dao.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registered extends JFrame {
    private JFrame frame;
    private JTextField t1;
    private JPasswordField t2;

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    Registered window = new Registered();
                    window.frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public Registered(){
        initialize();
    }

    private void initialize(){
        frame = new JFrame("注册");
        frame.setBounds(400, 200, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocation(700,300);
        frame.setVisible(true);
        frame.getContentPane().setLayout(null);

        JLabel l1 = new JLabel("用户名：");
        l1.setBounds(100, 56, 54, 15);
        frame.getContentPane().add(l1);

        JLabel l2 = new JLabel("密码：");
        l2.setBounds(100, 102, 54, 15);
        frame.getContentPane().add(l2);

        t1 = new JTextField();
        t1.setBounds(196, 53, 100, 21);
        frame.getContentPane().add(t1);
        t1.setColumns(10);

        t2 = new JPasswordField();
        t2.setEchoChar('*');
        t2.setBounds(196, 96,100, 21);
        frame.getContentPane().add(t2);
        t2.setColumns(10);

        JButton btn1 = new JButton("注册");
        btn1.setBounds(190, 169, 93, 23);
        frame.getContentPane().add(btn1);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = null;

                String username = t1.getText();
                String password = String.valueOf(t2.getPassword());
                if(StringUtils.isEmpty(username)){
                    JOptionPane.showMessageDialog(null, "用户名不能为空！");
                    return;
                }
                if(StringUtils.isEmpty(password)){
                    JOptionPane.showMessageDialog(null, "密码不能为空！");
                    return;
                }

                DBSourse sourse = new DBSourse("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/exam?useUnicode=true&serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true",
                        "root", "123456");
                sql = "insert into user values(?,?)";

                try {
                    Connection connection = sourse.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1,username);
                    preparedStatement.setString(2,password);
                    preparedStatement.execute();
                    JOptionPane.showMessageDialog(null,"注册成功");

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
    }
}
