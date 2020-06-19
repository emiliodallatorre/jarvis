package channels;

import java.util.function.Function;

public interface Channel {
    String input();
    void output(String output);

    void initialize();
}
