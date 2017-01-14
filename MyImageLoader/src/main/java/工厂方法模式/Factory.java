package 工厂方法模式;

/**
 * Created by sufutian on 2016/11/10/17:19.
 */

public class Factory {


    //静态工厂
    public static BenChiCar getBenChi(){
        return new BenChiCar();
    }

    public static BaoMaCar getBaoMa(){
        return new BaoMaCar();
    }

    /**
     * 反射得到实例
     * @param clazz
     * @param <T>
     * @return
     */

    public static <T extends Product> T getCar(Class<T> clazz){
        Product product=null;
        try {
            product = (Product) Class.forName(clazz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) product;
    }

}
