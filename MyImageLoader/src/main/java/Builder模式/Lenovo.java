package Builder模式;

/**
 * Created by sufutian on 2016/11/10/13:15.
 */

public class Lenovo extends Computer {
    @Override
    protected void setOs() {
        System.out.print("微软\n");
    }

    @Override
    protected void setBorad(String mBoard) {
        super.setBorad(mBoard);
        System.out.print(mBoard+"\n");
    }

    @Override
    protected void setDisplay(String mDisplay) {
        super.setDisplay(mDisplay);
        System.out.print(mDisplay+"\n");
    }
}
