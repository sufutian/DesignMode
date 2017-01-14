package 抽象工厂.IFactory;

import 抽象工厂.IProduct.ICar;

/**
 * Created by sufutian on 2016/11/12/14:47.
 */

public interface ICarFactory {

    enum CarType{
        benchi,baoma
    }

    ICar createAcar(CarType type);

}
