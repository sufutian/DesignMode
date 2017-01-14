package Builder模式;

/**
 * Created by sufutian on 2016/11/10/12:10.
 */

public abstract class Builder {

    protected abstract Builder buildBoard(String mBoard);

    protected abstract Builder buildDiaplay(String mDisplay);

    protected abstract Builder buildOs();

    protected abstract Computer createComputer();

}
