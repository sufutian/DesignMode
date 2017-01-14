package 抽象工厂.Product.tire;

import 抽象工厂.IProduct.ITire;

/**
 * Created by sufutian on 2016/11/12/14:52.
 */

public class SmallTire implements ITire{

    @Override
    public void productTire() {
        System.out.print("small tire \n");
    }
}
