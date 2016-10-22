package GameFrame;
/**
 * 
 * 
 * @author 关桐
 * 俄罗斯方块制作基本思路
 * 利用repaint和线程的配合改变每次绘制方块的坐标，实现视觉上的下落
 * 其中需要考虑的规则
 * 1 判断是否下落到底
 * 2 判断当下面有方块时是否停止
 *     当然1和2是可以通用一个方法的，即clear[i][j]==true
 * 3 判断翻转后是否方块会超出屏幕范围(即两边和下面)
 * 4 判断翻转后是否方块重合
 * 其他规则比较容易想清楚不详述
 * 终于搞定啦从十一假期到10月13号中间断断续续终于将最基本功能完成啦
 * 时间2016年10月13日11点20分
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GameWindow();
	}

}
