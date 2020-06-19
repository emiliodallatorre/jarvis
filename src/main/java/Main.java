import channels.Channel;
import channels.Telegram;
import processing.Processor;

public class Main {
    public static void main(String[] args) {
        Channel currentChannel = new Telegram();
        currentChannel.initialize();

        Processor processor = new Processor();
        processor.initialize();

        // TODO: Trovare un modo per tenere più canali concorrenti.
        while (true) {
            String input = currentChannel.input();
            if (input.equals("/shutdown")) break;

            String output = processor.process(input);

            currentChannel.output(output);
        }
    }
}
