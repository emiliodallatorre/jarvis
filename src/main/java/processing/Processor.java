package processing;

import com.rivescript.Config;
import com.rivescript.RiveScript;

public class Processor {
    RiveScript riveScript;

    public String process(String input) {
        String reply = riveScript.reply("user", input);

        return reply;
    }

    public void initialize() {
        // Create a new bot with the default settings.
        riveScript = new RiveScript(Config.utf8());

        // Load a directory full of RiveScript documents (.rive files)
        riveScript.loadDirectory("./replies");

        // Sort the replies after loading them!
        riveScript.sortReplies();

    }
}
