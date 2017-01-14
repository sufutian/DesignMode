package Builder模式;

/**
 * Created by sufutian on 2016/11/10/13:16.
 */

public class LenovoBuilder extends Builder {

    Lenovo lenovo=new Lenovo();

    @Override
    protected Builder buildBoard(String mBoard) {
        lenovo.setBorad(mBoard);
        return this;
    }

    @Override
    protected Builder buildDiaplay(String mDisplay) {
        lenovo.setDisplay(mDisplay);
        return this;
    }

    @Override
    protected Builder buildOs() {
        lenovo.setOs();
        return this;
    }

    @Override
    protected Computer createComputer() {
        return lenovo;
    }
}
