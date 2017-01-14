package 工厂方法模式;

/**
 * Created by sufutian on 2016/11/10/17:17.
 */

public class BaoMaCar extends Product {

    @Override
    BaoMaCar methodTire() {
        super.methodTire();
        System.out.print("baoma tire\n");
        return this;
    }

    @Override
    BaoMaCar methodGlass() {
        super.methodGlass();
        System.out.print("baoma glass\n");
        return this;
    }
}
