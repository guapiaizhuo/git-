import java.util.ArrayList;
import java.util.StringTokenizer;

public class SchoolSystem implements ISignUp, IParams{
    Integer big;
    Integer medium;
    Integer small;

    SchoolSystem(Integer big, Integer medium, Integer small){
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addStudent(Integer stuType){
        Integer[] School = {big, medium, small};
        return switch (stuType) {
            case 1, 2, 3 -> School[stuType] != 0;
            default -> false;
        };
    }




    @Override
    public void print(Integer []data, ArrayList plan) {
        String out = "[" + "["+data[0]+","+data[1]+","+data[2]+"]";
        for (int i=0;i< plan.size();i++){
            out = out+","+"["+plan.get(i)+"]";
        }
        System.out.println(out+"]");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("请输入参数");
        System.out.println("请输入数据");
        IParams params = ISignUp.parse();//SchoolSystem.parse();
        Integer []data = {params.getBig(), params.getMedium(), params.getSmall()};
        SchoolSystem sc = new SchoolSystem (params.getBig(), params.getMedium(),params.getSmall());
        ArrayList<Integer> plan = params. getPlanSignUp ();
        for (int i = 0; i < plan.size(); i++) {
            if (sc. addStudent (plan.get(i)))
                params.setData(plan.get(i));
        }
        sc.print(data,plan);



    }

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

    @Override
    public void setData(Integer integer) {
        switch (integer) {
            case 1 -> big = big - 1;
            case 2 -> medium = medium - 1;
            case 3 -> small = small - 1;
        }
    }


    @Override
    public ArrayList<Integer> getPlanSignUp() {
        StringTokenizer methodMap = new StringTokenizer(method,",");
        StringTokenizer dataMap = new StringTokenizer(data,"]");
        SchoolSystem schoolSystem = null;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i=0;methodMap.hasMoreElements();i++){
            if (((String)methodMap.nextElement()).contains("addStudent")) {
                for (int j=0;j<i-1;j++) {
                    dataMap.nextElement();
                }
                String SchoolSystemCode = (String) dataMap.nextElement();
                if (SchoolSystemCode.contains("1"))
                    arrayList.add(1);
                else if (SchoolSystemCode.contains("2"))
                    arrayList.add(2);
                else if (SchoolSystemCode.contains("3"))
                    arrayList.add(3);
            }
        }
        return arrayList;
    }
}
