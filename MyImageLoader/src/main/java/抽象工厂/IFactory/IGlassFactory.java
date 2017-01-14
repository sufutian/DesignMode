package 抽象工厂.IFactory;

import 抽象工厂.IProduct.IGlass;

/**
 * Created by sufutian on 2016/11/12/14:47.
 */

public interface IGlassFactory {

    enum GlassType{
        blue,red,yellow
    }
    IGlass createGlass(GlassType glassType);

}
