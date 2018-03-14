package multithread.designpattern.masterworker;

/**
 * Created by Ocean lin on 2018/3/14.
 *
 * @author Ocean lin
 */
public class Task {
    private int id;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
