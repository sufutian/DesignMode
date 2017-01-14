package Builder模式;

/**
 * Created by sufutian on 2016/11/10/12:06.
 */

public class MackBookBuilder extends Builder {

    MacBook macBook=new MacBook();

    @Override
    protected Builder buildBoard(String mBoard) {
         macBook.setBorad(mBoard);
         return this;
    }

    @Override
    protected Builder buildDiaplay(String mDisplay) {
        macBook.setDisplay(mDisplay);
        return this;
    }

    @Override
    protected Builder buildOs() {
        macBook.setOs();
        return this;
    }

    @Override
    protected Computer createComputer() {
        return macBook;
    }
}
