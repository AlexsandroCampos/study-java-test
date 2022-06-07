package studyjavatest;

public class App {
    public String getGretting() {
        return "hello world.";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGretting());
    }
}