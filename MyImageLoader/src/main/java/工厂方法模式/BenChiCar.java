package 工厂方法模式;

/**
 * Created by sufutian on 2016/11/10/17:17.
 */

public class BenChiCar extends Product {

    @Override
    BenChiCar methodTire() {
        super.methodTire();
        System.out.print("benchi tire\n");
        return this;
    }

    @Override
    BenChiCar methodGlass() {
        super.methodGlass();
        System.out.print("benchi gladd\n");
        return this;
    }
}
