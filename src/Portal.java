
import java.awt.Point;
import java.util.Random;

/**
 *
 * @author Chogapik
 */
public class Portal {

    private int nature; //-1 for snake , +1 for ladder
    private int start;
    private int end;

    /**
     *
     * @param maxCells
     */
    public Portal(int maxCells) {   //creates random portals
        Random luck = new Random();
        start = luck.nextInt(maxCells);
        end = luck.nextInt(maxCells);
        if (start < end) {
            nature = 1;
        } else {
            nature = -1;
        }
    }

    /**
     *
     * @return
     */
    public int returnNature() {
        return nature;
    }

    /**
     *
     * @return
     */
    public int returnStart() {
        return start;
    }

    /**
     *
     * @return
     */
    public int returnEnd() {
        return end;
    }

}
