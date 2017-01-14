package Builder模式;

/**
 * Created by sufutian on 2016/11/10/12:17.
 */

public class Test {


    public static void main(String[] args){

        new MackBookBuilder().buildOs().buildBoard("因特尔").buildDiaplay("液晶");

        //new AlertDialog.Builder(getApplicationContext()).setTitle("haha").setMessage("xixi").create().show();
        //某些样式相似 内容不同 可复用的 页面

        MacBook computer = (MacBook) new MackBookBuilder().createComputer();


        new LenovoBuilder().buildOs().buildBoard("英伟达").buildDiaplay("高清4k");



    }

}
