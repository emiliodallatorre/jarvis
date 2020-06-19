import channels.Channel;
import channels.Telegram;
import processing.Processor;

public class Main {
    public static void main(String[] args) {
        Channel currentChannel = new Telegram();
        currentChannel.initialize();

        Processor processor = new Processor();
        processor.initialize();

        while (true) {
            String input = currentChannel.input();

            String output = processor.process(input);

            currentChannel.output(output);
        }
    }
}
