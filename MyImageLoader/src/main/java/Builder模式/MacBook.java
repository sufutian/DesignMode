package Builder模式;

/**
 * Created by sufutian on 2016/11/10/12:05.
 */

public class MacBook extends Computer {

    public MacBook() {

    }

    @Override
    protected void setBorad(String board) {
        super.setBorad(board);
        System.out.print(board+"\n");
    }

    @Override
    protected void setDisplay(String mDisplay) {
        super.setDisplay(mDisplay);
        System.out.print(mDisplay+"\n");
    }

    @Override
    protected void setOs() {
        System.out.print("ios\n");
    }

}
