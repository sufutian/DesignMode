package 抽象工厂.Factory;

import 抽象工厂.IFactory.ITireFactory;
import 抽象工厂.IProduct.ITire;
import 抽象工厂.Product.tire.BigTire;
import 抽象工厂.Product.tire.SmallTire;

/**
 * Created by sufutian on 2016/11/12/14:51.
 */

public class TireFactory implements ITireFactory {

    private TireFactory() {
    }

    ;

    private static TireFactory instance = new TireFactory();

    public static TireFactory getInstance() {
        return instance;
    }

    @Override
    public ITire createTire(TireType tireType) {
        ITire tire = null;
        switch (tireType) {
            case big:
                tire = new BigTire();
                break;
            case small:
                tire = new SmallTire();
                break;
        }
        tire.productTire();
        return tire;
    }


}
