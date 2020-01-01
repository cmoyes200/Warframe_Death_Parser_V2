import java.util.ArrayList;

public class Repository {

    private ArrayList<String> data;
    private String name;
    private String time;

    public Repository() {
        data = new ArrayList<>();
    }

    public void addData(String data) {
        this.data.add(data);
    }

    public void addName(String name) {
        this.name = name;
    }

    public void addTime(String time) {
        this.time = time;
    }

    public void print() {
        System.out.println(name + "\n" + time);
        for (String s:data) {
            System.out.println(s);
        }
    }
}
