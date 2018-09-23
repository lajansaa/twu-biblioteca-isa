public class StdOutDisplay implements Display {

    @Override
    public void print(String line) {
        System.out.println(line);
    }
}
