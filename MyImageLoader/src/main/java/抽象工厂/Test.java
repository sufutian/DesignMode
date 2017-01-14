package 抽象工厂;

import 抽象工厂.Factory.CarFactory;
import 抽象工厂.IFactory.ICarFactory;

/**
 * Created by sufutian on 2016/11/12/15:36.
 */

public class Test {

    public static void main(String[] args){

        CarFactory.getInstance().createAcar(ICarFactory.CarType.baoma);

        CarFactory.getInstance().createAcar(ICarFactory.CarType.benchi);

    }
}
