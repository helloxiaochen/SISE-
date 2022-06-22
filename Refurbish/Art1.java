package 课设.Refurbish;

import 课设.Dao.DBSourse;
import 课设.Dao.StringUtils;
import 课设.JFrame.Art;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class Art1 extends JFrame {
    Vector rowData, columnNames;
    JTable jt = null;
    JScrollPane jsp = null;
    PreparedStatement ps = null;
    Connection ct = null;
    ResultSet rs = null;

    public Art1(){
        setTitle("艺术生成绩录入");
        setVisible(true);
        setSize(700,400);
        setLocation(700, 300);

        //面板和输入框
        JLabel l1 = new JLabel("学号:");
        JLabel l2 = new JLabel("姓名:");
        JLabel l3 = new JLabel("年龄:");
        JLabel l4 = new JLabel("性别:");
        JLabel l5 = new JLabel("学校:");
        JLabel l6 = new JLabel("生源地:");
        JLabel l8 = new JLabel("语文:");
        JLabel l9 = new JLabel("数学:");
        JLabel l10 = new JLabel("英语:");
        JLabel l11 = new JLabel("艺术");
        JLabel l7 = new JLabel("总分:");
        JTextField t1 = new JTextField(10);
        JTextField t2 = new JTextField(10);
        JTextField t3 = new JTextField(10);
        JTextField t4 = new JTextField(10);
        JTextField t5 = new JTextField(10);
        JTextField t6 = new JTextField(10);
        JTextField t7 = new JTextField(10);
        JTextField t8 = new JTextField(10);
        JTextField t9 = new JTextField(10);
        JTextField t10 = new JTextField(10);
        JTextField t11 = new JTextField(10);

        //创建水平容器
        Box box1 = Box.createHorizontalBox();
        box1.add(l1);
        box1.add(t1);
        box1.add(l2);
        box1.add(t2);
        box1.add(l3);
        box1.add(t3);
        box1.add(l4);
        box1.add(t4);
        box1.add(l5);
        box1.add(t5);
        Box box2 = Box.createHorizontalBox();
        box2.add(l6);
        box2.add(t6);
        box2.add(l8);
        box2.add(t8);
        box2.add(l9);
        box2.add(t9);
        box2.add(l10);
        box2.add(t10);
        box2.add(l11);
        box2.add(t11);
        box2.add(l7);
        box2.add(t7);

        //创建JTable显示数据库数据
        columnNames = new Vector();
        columnNames.add("学号");
        columnNames.add("姓名");
        columnNames.add("年龄");
        columnNames.add("性别");
        columnNames.add("学校");
        columnNames.add("地区");
        columnNames.add("语文");
        columnNames.add("数学");
        columnNames.add("英语");
        columnNames.add("艺术");
        columnNames.add("总分");
        //rowData可以存放多行,开始从数据库里取
        rowData = new Vector();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam?useUnicode=true&serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true",
                    "root", "123456");
            ps = ct.prepareStatement("select * from art");
            rs = ps.executeQuery();

            while (rs.next()) {
                Vector hang = new Vector();
                hang.add(rs.getString(1));
                hang.add(rs.getString(2));
                hang.add(rs.getInt(3));
                hang.add(rs.getString(4));
                hang.add(rs.getString(5));
                hang.add(rs.getString(6));
                hang.add(rs.getInt(7));
                hang.add(rs.getInt(8));
                hang.add(rs.getInt(9));
                hang.add(rs.getInt(10));
                hang.add(rs.getInt(11));

                rowData.add(hang);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (ct != null) {
                    ct.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        jt = new JTable(rowData,columnNames);
        jsp = new JScrollPane(jt);
        Box box3 = Box.createHorizontalBox();
        box3.add(jsp);
        Box vBox2 = Box.createVerticalBox();
        vBox2.add(box3);

        //定义按钮
        JButton enterbtn = new JButton("录入");
        JButton delectbtn = new JButton("删除");
        JButton refeshbtn = new JButton("刷新");
        Box box4 = Box.createHorizontalBox();
        box4.add(enterbtn);
        box4.add(delectbtn);
        box4.add(refeshbtn);

        //创建垂直容器，放置水平箱
        Box vBox = Box.createVerticalBox();
        vBox.add(box1);
        vBox.add(box2);
        vBox.add(box3);
        vBox.add(box4);
        this.setContentPane(vBox);
        this.pack();

        enterbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String sql = null;

                int number1 = t1.getColumns();
                String name1 = t2.getText();
                int age1 = t3.getColumns();
                String sex1 = t4.getText();
                String school1 = t5.getText();
                String score1 = t6.getText();
                int chinese1 = t7.getColumns();
                int math1 = t8.getColumns();
                int english1 = t9.getColumns();
                int art1 = t10.getColumns();
                int sum1 = t11.getColumns();

                if(StringUtils.isEmpty(String.valueOf(number1))){
                    JOptionPane.showMessageDialog(null,"学号不能为空,必须为正数");
                    return;
                }
                if(StringUtils.isEmpty(name1)){
                    JOptionPane.showMessageDialog(null,"名字不能为空");
                    return;
                }
                if(StringUtils.isEmpty(String.valueOf(age1))){
                    JOptionPane.showMessageDialog(null,"年龄不能为空");
                    return;
                }
                if(StringUtils.isEmpty(sex1)){
                    JOptionPane.showMessageDialog(null,"性别不能为空");
                    return;
                }
                if(StringUtils.isEmpty(school1)){
                    JOptionPane.showMessageDialog(null,"学校不能为空");
                    return;
                }
                if(StringUtils.isEmpty(score1)){
                    JOptionPane.showMessageDialog(null,"地区不能为空");
                    return;
                }
                if(StringUtils.isEmpty(String.valueOf(chinese1))){
                    JOptionPane.showMessageDialog(null,"语文成绩不能为空,必须为正数");
                    return;
                }
                if(StringUtils.isEmpty(String.valueOf(math1))){
                    JOptionPane.showMessageDialog(null,"数学成绩不能为空,必须为正数");
                    return;
                }
                if(StringUtils.isEmpty(String.valueOf(english1))){
                    JOptionPane.showMessageDialog(null,"英语成绩不能为空,必须为正数");
                    return;
                }
                if(StringUtils.isEmpty(String.valueOf(art1))){
                    JOptionPane.showMessageDialog(null,"艺术成绩不能为空，必须为正数");
                    return;
                }
                if(StringUtils.isEmpty(String.valueOf(sum1))){
                    JOptionPane.showMessageDialog(null,"总成绩不能为空,必须为正数");
                    return;
                }

                if(e.getSource() == enterbtn){
                    int number = Integer.parseInt(t1.getText());
                    String name = t2.getText();
                    int age = Integer.parseInt(t3.getText());
                    String sex = t4.getText();
                    String school = t5.getText();
                    String score = t6.getText();
                    int chinese = Integer.parseInt(t7.getText());
                    int math = Integer.parseInt(t8.getText());
                    int english = Integer.parseInt(t9.getText());
                    int art = Integer.parseInt(t10.getText());
                    int sum = Integer.parseInt(t11.getText());

                    DBSourse sourse = new DBSourse("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/exam?useUnicode=true&serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true",
                            "root", "123456");
                    sql = "insert art(number,name,age,sex,school,score,chinese,math,english,art,sum) value("+"?,?,?,?,?,?,?,?,?,?,?)";

                    try {
                        Connection connection = sourse.getConnection();
                        System.out.println(connection);
                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setString(1, String.valueOf(number));
                        preparedStatement.setString(2,name);
                        preparedStatement.setString(3,String.valueOf(age));
                        preparedStatement.setString(4,sex);
                        preparedStatement.setString(5,school);
                        preparedStatement.setString(6,score);
                        preparedStatement.setString(7,String.valueOf(chinese));
                        preparedStatement.setString(8,String.valueOf(math));
                        preparedStatement.setString(9, String.valueOf(english));
                        preparedStatement.setString(10,String.valueOf(art));
                        preparedStatement.setString(11,String.valueOf(sum));

                        int i = preparedStatement.executeUpdate();
                        if(i > 0){
                            System.out.println(i+"成功行");
                        }
                        JOptionPane.showMessageDialog(null,"录入成功");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,"学号、年龄、各科成绩、总分必须为正数");
                        ex.printStackTrace();
                    }
                }
            }
        });

        delectbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int number1 = t1.getColumns();
                String name1 = t2.getText();
                int age1 = t3.getColumns();
                String sex1 = t4.getText();
                String school1 = t5.getText();
                String score1 = t6.getText();
                int chinese1 = t7.getColumns();
                int math1 = t8.getColumns();
                int english1 = t9.getColumns();
                int art1 = t10.getColumns();
                int sum1 = t11.getColumns();

                if(StringUtils.isEmpty(String.valueOf(number1))){
                    JOptionPane.showMessageDialog(null,"学号不能为空,必须为正数");
                    return;
                }
                if(StringUtils.isEmpty(name1)){
                    JOptionPane.showMessageDialog(null,"名字不能为空");
                    return;
                }
                if(StringUtils.isEmpty(String.valueOf(age1))){
                    JOptionPane.showMessageDialog(null,"年龄不能为空");
                    return;
                }
                if(StringUtils.isEmpty(sex1)){
                    JOptionPane.showMessageDialog(null,"性别不能为空");
                    return;
                }
                if(StringUtils.isEmpty(school1)){
                    JOptionPane.showMessageDialog(null,"学校不能为空");
                    return;
                }
                if(StringUtils.isEmpty(score1)){
                    JOptionPane.showMessageDialog(null,"地区不能为空");
                    return;
                }
                if(StringUtils.isEmpty(String.valueOf(chinese1))){
                    JOptionPane.showMessageDialog(null,"语文成绩不能为空,必须为正数");
                    return;
                }
                if(StringUtils.isEmpty(String.valueOf(math1))){
                    JOptionPane.showMessageDialog(null,"数学成绩不能为空,必须为正数");
                    return;
                }
                if(StringUtils.isEmpty(String.valueOf(english1))){
                    JOptionPane.showMessageDialog(null,"英语成绩不能为空,必须为正数");
                    return;
                }
                if(StringUtils.isEmpty(String.valueOf(art1))){
                    JOptionPane.showMessageDialog(null,"艺术成绩不能为空，必须为正数");
                    return;
                }
                if(StringUtils.isEmpty(String.valueOf(sum1))){
                    JOptionPane.showMessageDialog(null,"总成绩不能为空,必须为正数");
                    return;
                }

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = null;
                    PreparedStatement preparedStatement = null;
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam?useUnicode=true&serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true",
                            "root","123456");
                    String sql = "delete from art where number=?";
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setInt(1,Integer.parseInt(t1.getText()));
                    preparedStatement.executeUpdate();
                    preparedStatement.close();
                    JOptionPane.showMessageDialog(null,"删除成功");
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        refeshbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Art();
                dispose();
            }
        });
    }
}