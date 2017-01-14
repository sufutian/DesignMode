package 原型模式;

import java.util.ArrayList;

/**
 * Created by sufutian on 2016/11/10/15:52.
 */

public class Document implements Cloneable{

    private String text;

    private int i;

    private ArrayList imageView;
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

     Document clonee() {
         /**
          * 浅拷贝
          */
         try {
             Document doc=(Document) super.clone();
             doc.text=this.text;
             doc.i=this.i;
             return doc;
         } catch (CloneNotSupportedException e) {
             e.printStackTrace();
         }

         /**
          * 深拷贝
          */
         /*try {
             Document doc=(Document) super.clone();
             doc.text=this.text;
             doc.i=this.i;
             doc.imageView= (ArrayList) this.imageView.clone(); //引用类型
             return doc;
         } catch (CloneNotSupportedException e) {
             e.printStackTrace();
         }*/

         return null;
    }

    public void show(){
        System.out.print(getText());
        System.out.print(getI()+"");
        System.out.print("\n");
    }
}
