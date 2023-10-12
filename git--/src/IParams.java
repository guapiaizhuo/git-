import java.util.ArrayList;

interface IParams {
    public int getBig();
    public int getMedium();
    public int getSmall();
    public void setData(Integer integer);

    // 获取入学序列，例如 [1 2 2 3] 表示 依次报名入学一名大班学生，中班学生，中班学生，小班学生
    public ArrayList<Integer> getPlanSignUp();
}
