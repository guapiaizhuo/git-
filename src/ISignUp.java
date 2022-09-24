import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public interface ISignUp {
    Scanner scanner = new Scanner(System.in);
    String method = scanner.next();
    String data = scanner.next();
    public void print(Integer []data,ArrayList plan);
    // 检查是否有 stuType对应的班级名额
    // 如果没有剩余名额，请返回 false ，否则学生将报名进入该班级并返回 true
    public boolean addStudent (Integer stuType);
    public static IParams parse() throws Exception{

        StringTokenizer methodMap = new StringTokenizer(method,",");
        StringTokenizer dataMap = new StringTokenizer(data,"]");
        SchoolSystem schoolSystem = null;
        for (int i=0;methodMap.hasMoreElements();i++){
            if (((String)methodMap.nextElement()).contains("SchoolSystem")) {
                for (int j=0;j<i-1;j++) {
                    dataMap.nextElement();
                }
                String SchoolSystemCode = (String) dataMap.nextElement();
                StringTokenizer codeMap = new StringTokenizer(SchoolSystemCode,",");
                ArrayList<Integer> arrayList = new ArrayList<>();
                while (codeMap.hasMoreElements()){
                    String NEW = (String) codeMap.nextElement();
                    NEW = NEW.replaceAll("[^0-9]","");
                    arrayList.add(Integer.valueOf(NEW));
                }
                schoolSystem = new SchoolSystem(arrayList.get(0),arrayList.get(1),arrayList.get(2));
            }

        }
        return schoolSystem;
    }


}
