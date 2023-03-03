import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

//写一个类继承JFrame方法 方便自己增加功能
public class mainFrame extends JFrame implements KeyListener {

    /*将图片的编号放在二维数组里面 将来做移动业务也是根据图片在二维数组里面存放的位置来做*/
    int[][] data = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    int[][] win = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    //计数器变量
    int count = 0;

    int row;    //0号元素的行坐标
    int column;  //0号元素的列坐标

    /*此方法用来初始化窗口*/
    public void initFrame() {
        //设置窗体大小
        setSize(514, 595);
        //设置关闭模式
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //设置窗口永远在屏幕的最上层
        setAlwaysOnTop(true);
        //设置窗口居中
        setLocationRelativeTo(null);
        //设置标题
        setTitle("石头迷阵单机版V1.0");
        //取消默认布局
        setLayout(null);


    }

    /*此方法用来绘制窗口*/
    public void paintView() {

        //绘制界面之前，先清空界面
        getContentPane().removeAll();
        if (victory()) {
            //胜利，加载胜利图片
            JLabel jLabelWin = new JLabel(new ImageIcon("E:\\myCode\\test03\\image\\win.png"));
            jLabelWin.setBounds(124, 230, 266, 88);
            getContentPane().add(jLabelWin);
        }

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                JLabel j1 = new JLabel(new ImageIcon("E:\\myCode\\test03\\image\\" + data[j][i] + ".png"));
                j1.setBounds(50 + 100 * i, 90 + 100 * j, 100, 100);
                getContentPane().add(j1);
            }
        }
        JLabel background = new JLabel(new ImageIcon("E:\\myCode\\test03\\image\\background.png"));
        background.setBounds(26, 30, 450, 484);
        getContentPane().add(background);

        //添加步数显示
        JLabel score = new JLabel("步数为：" + count);
        score.setBounds(50, 20, 100, 20);
        getContentPane().add(score);

        //添加重新游戏按钮
        JButton replay = new JButton("重新游戏");
        replay.setBounds(350, 20, 100, 20);
        getContentPane().add(replay);
        replay.setFocusable(false);
        //为重新游戏按钮添加监听
        replay.addActionListener(e -> {
            //重新游戏 步数为0
            count = 0;
            //重新打乱游戏数据
            initData();
            //重新加载游戏界面
            paintView();
        });

        //刷新界面
        getContentPane().repaint();
    }

    /*初始化数组（打乱二维数组中的值）*/
    public void initData() {
        //遍历二维数组
        for (int i = 0; i < data.length; i++) {
            Random r = new Random();
            for (int j = 0; j < data[i].length; j++) {
                //data[i][j]  产生二维数组中的一个随机位置让其与当前位置做交换
                int RandomX = r.nextInt(4);
                int RandomY = r.nextInt(4);

                //data[RandomX][RandomY] 与data[i][j] 做交换
                int temp = data[RandomX][RandomY];
                data[RandomX][RandomY] = data[i][j];
                data[i][j] = temp;
            }
        }
        //找到 0 号元素的位置，为移动业务做准备
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] == 0) {
                    row = i;
                    column = j;
                }
            }
        }
    }

    /*此方法用于处理移动业务*/
    private void move(KeyEvent e) {
        if (victory()) {
            return;
        } else {
            if (e.getKeyCode() == 37 || e.getKeyCode() == 65) {
                //左移动业务（空白块和右边交换）：0号元素与右边的元素交换位置，如果 0 号元素在最右边，不做处理
                //colum = 3 ---> 0 号元素在最右边
                if (column != 3) {
                    // data[row][colum] 与 data[row][++colum] 交换
                    int temp = data[row][column];
                    data[row][column] = data[row][column + 1];
                    data[row][column + 1] = temp;
                    //交换完成 空白块的位置也需要随着更改
                    column++;
                    count++;

                }
            } else if (e.getKeyCode() == 38 || e.getKeyCode() == 87) {
                //上移动业务（空白块和下面交换）：如果空白块在最下面，不处理，否则就与下面一块交换
                //row = 3 ---> 0 号元素在最下面
                if (row != 3) {
                    //data[row][colum] 与 data[row+1][colum]
                    int temp = data[row][column];
                    data[row][column] = data[row + 1][column];
                    data[row + 1][column] = temp;

                    //移动完成 更新空白块位置
                    row++;
                    count++;
                }
            } else if (e.getKeyCode() == 39 || e.getKeyCode() == 68) {
                //右移动业务（空白块与左边交换）：如果空白块在最左边，不处理，否则就与左边交换
                //colum = 0 ---> 0 号元素在最左边
                if (column != 0) {
                    //data[row][colum] 与 data[row][colum - 1]
                    int temp = data[row][column];
                    data[row][column] = data[row][column - 1];
                    data[row][column - 1] = temp;

                    //移动完成，更新空白块位置
                    column--;
                    count++;

                }
            } else if (e.getKeyCode() == 40 || e.getKeyCode() == 83) {
                //下移动，空白块与上面做交换
                //下移动业务，空白块在最上面不做处理，否则将空白块与上面一块交换
                //row = 0 ---> 0 号元素在最上面
                if (row != 0) {
                    //data[row][colum] 与 data[row--][colum]
                    int temp = data[row][column];
                    data[row][column] = data[row - 1][column];
                    data[row - 1][column] = temp;

                    //移动完成，更新空白块位置
                    row--;
                    count++;

                }
            } else if (e.getKeyCode() == 90) {
                //触发作弊器
                data = new int[][]{
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 0}
                };
                row = 3;
                column = 3;
            }
        }

    }

    /*编写方法用于判断是否胜利*/
    public boolean victory() {

        //将 data 里面的数据逐一与 win比较 如果完全一样说明游戏胜利
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    //构造方法,让这个类一创建对象就调用了这两个方法
    public mainFrame() {
        //初始化窗口
        initFrame();
        //注册监听
        this.addKeyListener(this);
        //初始化数据(打乱数据以产生随机的游戏场景)
        initData();
        //绘制窗口
        paintView();
        //最后设置窗口可见
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        move(e);
        paintView();

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}
