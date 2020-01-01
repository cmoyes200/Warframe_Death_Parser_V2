public class Main {

    public static void main (String[] args) {
        DAO dao = new DAO();
        dao.load();
        dao.printRepository();
    }
}
