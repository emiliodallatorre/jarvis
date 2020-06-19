package channels;

public interface Channel {
    String getName();

    String input();

    void output(String output);

    void initialize();
}
