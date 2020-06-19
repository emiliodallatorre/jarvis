import channels.Channel;
import channels.Terminal;
import processing.Processor;

public class Main {
    public static void main(String[] args) {
        Channel currentChannel = new Terminal();
        currentChannel.initialize();

        Processor processor = new Processor();

        while(true) {
            String input = currentChannel.input();

            String output = processor.process(input);

            currentChannel.output(output);
        }
    }
}
