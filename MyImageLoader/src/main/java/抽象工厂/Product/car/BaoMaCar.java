package 抽象工厂.Product.car;

import 抽象工厂.Factory.GlassFactory;
import 抽象工厂.Factory.TireFactory;
import 抽象工厂.IFactory.IGlassFactory;
import 抽象工厂.IFactory.ITireFactory;
import 抽象工厂.IProduct.ICar;

/**
 * Created by sufutian on 2016/11/12/14:52.
 */

public class BaoMaCar implements ICar{
    @Override
    public void packageGlass() {
        GlassFactory.getInstance().createGlass(IGlassFactory.GlassType.yellow);
    }

    @Override
    public void packageTire() {
        TireFactory.getInstance().createTire(ITireFactory.TireType.small);
    }
}
