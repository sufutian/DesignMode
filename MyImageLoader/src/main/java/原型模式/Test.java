package 原型模式;

import java.util.ArrayList;

/**
 * Created by sufutian on 2016/11/10/12:17.
 */

public class Test {

    public static void main(String[] args){
        Document document=new Document();
        document.setText("one");
        document.setI(0);
        document.show();
        ArrayList<User> list=new ArrayList<User>();

        /**
         * 影子拷贝
         * 不改变原来对象的属性  clone出一个新的但不是new出来的
         */
        Document clone = document.clonee();
        clone.setText("two");
        clone.setI(1);
        clone.show();
        document.show();

        System.out.print("--------------\n");
        document.setText("change");
        document.setI(100);
        document.show();
        clone.show();


        int i=110;
        User user=new User();
        user.setName(i+"name");
        user.setAge(i);
        list.add(user);
        long start= System.currentTimeMillis();
        for (int j=0;j<100000;j++){  //深拷贝 避免过多的new对象
            User user1=user.clone(); //构造函数不会走
            //User user1=new User();
            user1.setName(j+"name");
            user1.setAge(j);
            list.add(user1);
        }
        long end= System.currentTimeMillis();

        System.out.print(list.toString());
        System.out.print("\n");
        System.out.print(user.toString());
        System.out.print("\n");
        System.out.print(list.get(12).toString());
        System.out.print("\n");
        System.out.print("time="+(end-start));




    }

}
