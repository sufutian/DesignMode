package 抽象工厂.IFactory;

import 抽象工厂.IProduct.ITire;

/**
 * Created by sufutian on 2016/11/12/14:47.
 */

public interface ITireFactory {

    enum TireType{
        big,small
    }

    ITire createTire(TireType tireType);
}
