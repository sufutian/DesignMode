package 抽象工厂.Product.glass;

import 抽象工厂.IProduct.IGlass;

/**
 * Created by sufutian on 2016/11/12/14:52.
 */

public class BlueGlass implements IGlass {

    @Override
    public void productGlass() {
        System.out.print("blue glass \n");
    }
}
