package 课设.JFrame;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

public class LiberalCheck extends JFrame {
    Connection con;
    String driver="com.mysql.cj.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/exam?useUnicode=true&serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true";
    String user="root";
    String password="123456";

    public LiberalCheck(){
        setTitle("文科生地区查询");
        setVisible(true);
        setSize(700,400);
        setLocation(700, 300);

        JLabel label = new JLabel("地区:");
        String[] listDate = new String[]{"请选择地区","广州","深圳","汕头"};

        JComboBox<String> comboBox = new JComboBox<String>(listDate);

        JTextArea a = new JTextArea(30,80);
        a.setEditable(false);

        Box box1 = Box.createHorizontalBox();
        box1.add(label);
        box1.add(comboBox);
        Box box2 = Box.createHorizontalBox();
        box2.add(a);

        Box vBox = Box.createVerticalBox();
        vBox.add(box1);
        vBox.add(box2);
        this.setContentPane(vBox);
        this.pack();

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int stateChange=e.getStateChange();
                String item=e.getItem().toString();
                if(stateChange==ItemEvent.SELECTED){
                    if(item == "广州"){
                        a.setText("");
                        try{
                            Class.forName(driver);
                            con = DriverManager.getConnection(url,user,password);
                            //创建statement类对象，用来执行SQL语句
                            Statement statement = con.createStatement();
                            String sql = "select * from liberal where score='广州'";
                            ResultSet rs = statement.executeQuery(sql);
                            a.append("考号\t姓名\t年龄\t性别\t中学名称\t语文\t数学\t英语\t历史\t地理\t总分\n");
                            int number,age,chinese,math,english,history,graphy,sum;
                            String name,sex,school,score;
                            while (rs.next()){
                                number = rs.getInt("number");
                                name = rs.getString("name");
                                age = rs.getInt("age");
                                sex = rs.getString("sex");
                                school = rs.getString("school");
                                chinese = rs.getInt("chinese");
                                math = rs.getInt("math");
                                english = rs.getInt("english");
                                history = rs.getInt("history");
                                graphy = rs.getInt("graphy");
                                sum = rs.getInt("sum");
                                a.append(number+"\t"+name+"\t"+age+"\t"+sex+"\t"+school+"\t"+chinese+"\t"+math+"\t"+english+"\t"+history+"\t"+graphy+"\t"+sum+"\n");
                            }
                        }catch(ClassNotFoundException e1) {
                            System.out.println("Sorry,can`t find the Driver!");
                            e1.printStackTrace();
                        }catch(SQLException e1) {
                            e1.printStackTrace();
                        }catch(Exception e1) {
                            e1.printStackTrace();
                        }finally {
                            System.out.println("数据库数据成功获取！！");
                        }
                    }
                    else if(item == "深圳"){
                        a.setText("");
                        try{
                            Class.forName(driver);
                            con = DriverManager.getConnection(url,user,password);
                            //创建statement类对象，用来执行SQL语句
                            Statement statement = con.createStatement();
                            String sql = "select * from liberal where score='深圳'";
                            ResultSet rs = statement.executeQuery(sql);
                            a.append("考号\t姓名\t年龄\t性别\t中学名称\t语文\t数学\t英语\t历史\t地理\t总分\n");
                            int number,age,chinese,math,english,history,graphy,sum;
                            String name,sex,school,score;
                            while (rs.next()){
                                number = rs.getInt("number");
                                name = rs.getString("name");
                                age = rs.getInt("age");
                                sex = rs.getString("sex");
                                school = rs.getString("school");
                                chinese = rs.getInt("chinese");
                                math = rs.getInt("math");
                                english = rs.getInt("english");
                                history = rs.getInt("history");
                                graphy = rs.getInt("graphy");
                                sum = rs.getInt("sum");
                                a.append(number+"\t"+name+"\t"+age+"\t"+sex+"\t"+school+"\t"+chinese+"\t"+math+"\t"+english+"\t"+history+"\t"+graphy+"\t"+sum+"\n");
                            }
                        }catch(ClassNotFoundException e1) {
                            System.out.println("Sorry,can`t find the Driver!");
                            e1.printStackTrace();
                        }catch(SQLException e1) {
                            e1.printStackTrace();
                        }catch(Exception e1) {
                            e1.printStackTrace();
                        }finally {
                            System.out.println("数据库数据成功获取！！");
                        }
                    }
                    else if(item == "汕头"){
                        a.setText("");
                        try{
                            Class.forName(driver);
                            con = DriverManager.getConnection(url,user,password);
                            //创建statement类对象，用来执行SQL语句
                            Statement statement = con.createStatement();
                            String sql = "select * from liberal where score='汕头'";
                            ResultSet rs = statement.executeQuery(sql);
                            a.append("考号\t姓名\t年龄\t性别\t中学名称\t语文\t数学\t英语\t历史\t地理\t总分\n");
                            int number,age,chinese,math,english,history,graphy,sum;
                            String name,sex,school,score;
                            while (rs.next()){
                                number = rs.getInt("number");
                                name = rs.getString("name");
                                age = rs.getInt("age");
                                sex = rs.getString("sex");
                                school = rs.getString("school");
                                chinese = rs.getInt("chinese");
                                math = rs.getInt("math");
                                english = rs.getInt("english");
                                history = rs.getInt("history");
                                graphy = rs.getInt("graphy");
                                sum = rs.getInt("sum");
                                a.append(number+"\t"+name+"\t"+age+"\t"+sex+"\t"+school+"\t"+chinese+"\t"+math+"\t"+english+"\t"+history+"\t"+graphy+"\t"+sum+"\n");
                            }
                        }catch(ClassNotFoundException e1) {
                            System.out.println("Sorry,can`t find the Driver!");
                            e1.printStackTrace();
                        }catch(SQLException e1) {
                            e1.printStackTrace();
                        }catch(Exception e1) {
                            e1.printStackTrace();
                        }finally {
                            System.out.println("数据库数据成功获取！！");
                        }
                    }
                }
            }
        });
    }
}
