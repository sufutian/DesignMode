package 工厂方法模式;

/**
 * Created by sufutian on 2016/11/10/12:17.
 */

public class Test {

    public static void main(String[] args){


        Factory.getBenChi().methodGlass().methodTire();

        Factory.getBaoMa().methodTire().methodGlass();

        Factory.getCar(BaoMaCar.class).methodGlass();

    }

}
