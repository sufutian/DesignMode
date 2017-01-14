package 抽象工厂.Factory;

import 抽象工厂.IFactory.ICarFactory;
import 抽象工厂.IProduct.ICar;
import 抽象工厂.Product.car.BaoMaCar;
import 抽象工厂.Product.car.BenChiCar;

/**
 * Created by sufutian on 2016/11/12/14:51.
 */

public class CarFactory implements ICarFactory{

    private CarFactory(){};

    private static CarFactory carFactory=new CarFactory();

    public static CarFactory getInstance(){
        return carFactory;
    }


    @Override
    public ICar createAcar(CarType type) {
        ICar iCar=null;
        switch (type){
            case baoma:
                iCar=new BaoMaCar();
                break;
            case benchi:
                iCar=new BenChiCar();
                break;
        }
        iCar.packageGlass();
        iCar.packageTire();
        return iCar;
    }
}
