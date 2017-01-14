package Builder模式;

/**
 * Created by sufutian on 2016/11/10/12:03.
 */

public abstract class Computer {

    protected String mBoard;
    protected String mDisplay;
    protected String mOS;

    protected void setBorad(String mBoard){
        this.mBoard=mBoard;
    }

    protected void setDisplay(String mDisplay){
        this.mDisplay=mDisplay;
    }


    protected abstract void setOs();

}
