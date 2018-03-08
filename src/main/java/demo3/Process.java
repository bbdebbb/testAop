package demo3;

import java.util.ArrayList;
import java.util.List;

/**
 * 控制流程语句
 */
public class Process {
    public static void main(String[] args) {
        char d=1;
        switch (d) {
            case 'a':System.out.println("1");
        }

        //break和continue
        while (true) {
            System.out.println("kaishi");
            break;
        }



        // if-else
        int i = 0;
//         if(i!=0) System.out.println("just do it");
//         else if(i==0) System.out.println("haha");

        //迭代
        //一次都不执行
        //while (i==0)System.out.println("迭代");
        //执行一次
        do{System.out.println("第一次");}while (i==0);
        //for循环
        for(int b=0;b<5;b++) {
            System.out.println("逗比");
        }
        //foreach
        String[] jj = {"1","2","3","4","5"};
        List<Object> list = new ArrayList<Object>();
        list.add("1");
        list.add("2");
        for (Object s:list) {
            System.out.println(s);
        }
    }
}
