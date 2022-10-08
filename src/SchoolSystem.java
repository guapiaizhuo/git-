import java.util.ArrayList;
import java.util.StringTokenizer;

//SchoolSystem类实现了ISignUp, IParams两个接口，继承接口默认方法，并且重写接口方法
public class SchoolSystem implements ISignUp, IParams{
    Integer big;
    Integer medium;
    Integer small;

    //SchoolSystem构造方法
    SchoolSystem(Integer big, Integer medium, Integer small){
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    //判断添加学生的是否成功的方法
    public boolean addStudent(Integer stuType){
        Integer[] School = {big, medium, small};
        return switch (stuType) {
            case 1, 2, 3 -> School[stuType-1] > 0;
            default -> false;
        };
    }



    //结果输出方法，重写接口
    @Override
    public void print(Integer []data, ArrayList plan) {
        String out = "[" +"null";
        for (int i=0;i< plan.size();i++){
            out = out+","+addStudent((Integer) plan.get(i));
            setData((Integer) plan.get(i));
        }
        System.out.println(out+"]");
    }

    //方法入口
    public static void main(String[] args) throws Exception {
        System.out.println("请输入参数");
        System.out.println("请输入数据");
        IParams params = ISignUp.parse();//SchoolSystem.parse();
        Integer []data = {params.getBig(), params.getMedium(), params.getSmall()};
        SchoolSystem sc = new SchoolSystem (params.getBig(), params.getMedium(),params.getSmall());
        ArrayList<Integer> plan = params. getPlanSignUp ();
        for (int i = 0; i < plan.size(); i++) {
            sc.addStudent(plan.get(i));
        }
        sc.print(data,plan);



    }

    //get方法
    @Override
    public int getBig() {
        return big;
    }

    @Override
    public int getMedium() {
        return medium;
    }

    @Override
    public int getSmall() {
        return small;
    }

    //set方法，朗母达表达式
    @Override
    public void setData(Integer integer) {
        switch (integer) {
            case 1 -> big = big - 1;
            case 2 -> medium = medium - 1;
            case 3 -> small = small - 1;
        }
    }

    //重写招生计划的方法
    @Override
    public ArrayList<Integer> getPlanSignUp() {
        StringTokenizer methodMap = new StringTokenizer(method,",");
        StringTokenizer dataMap = new StringTokenizer(data,"]");
        ArrayList<String> ArrList = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (methodMap.hasMoreElements()){
            String md = (String) methodMap.nextElement();
            if (md.contains("addStudent")) {
                ArrList.add((String) dataMap.nextElement());
            }
            else
                dataMap.nextElement();
        }
        for (String s : ArrList) {
            if (s.contains("1"))
                arrayList.add(1);
            else if (s.contains("2"))
                arrayList.add(2);
            else if (s.contains("3"))
                arrayList.add(3);
        }
        return arrayList;
    }
}
