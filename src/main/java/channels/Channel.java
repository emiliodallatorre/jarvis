package channels;

public interface Channel {
    String input();

    void output(String output);

    void initialize();
}
