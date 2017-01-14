package 抽象工厂.Product.glass;

import 抽象工厂.IProduct.IGlass;

/**
 * Created by sufutian on 2016/11/12/15:44.
 */

public class YellowGlass implements IGlass {
    @Override
    public void productGlass() {
        System.out.print("yellow glass \n");
    }
}
