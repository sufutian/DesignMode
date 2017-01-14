package 抽象工厂.Factory;

import 抽象工厂.IFactory.IGlassFactory;
import 抽象工厂.IProduct.IGlass;
import 抽象工厂.Product.glass.BlueGlass;
import 抽象工厂.Product.glass.RedGlass;
import 抽象工厂.Product.glass.YellowGlass;

/**
 * Created by sufutian on 2016/11/12/14:51.
 */

public class GlassFactory implements IGlassFactory{


    private GlassFactory(){};

    private static GlassFactory instance=new GlassFactory();

    public static GlassFactory getInstance(){
        return instance;
    }

    @Override
    public IGlass createGlass(GlassType glassType) {
        IGlass glass=null;
        switch (glassType){
            case blue:
                glass= new BlueGlass();
                break;
            case red:
                glass= new RedGlass();
                break;
            case yellow:
                glass=new YellowGlass();
        }
        glass.productGlass();
        return glass;
    }
}
