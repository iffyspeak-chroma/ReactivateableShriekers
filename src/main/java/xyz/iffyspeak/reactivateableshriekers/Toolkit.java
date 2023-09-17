package xyz.iffyspeak.reactivateableshriekers;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Toolkit {

    public static class FunnyMessage
    {
        public static List<String> activateMessageList = Arrays.asList(
                "<red><b>How inhumane.</b></red>",
                "<red><b>What a way to remove someone.</b></red>",
                "<red><b>Well that's going to be unfortunate.</b></red>",
                "<red><b>May god have mercy on you and the soul you've just cursed.</b></red>",
                "<red><b>Who hurt you?</b></red>",
                "<red><b>That's just foul.</b></red>",
                "<red><b>You'd better run before you trigger it yourself.</b></red>",
                "<red><b>Wouldn't want to be on the receiving end of this.</b></red>",
                "<red><b>Is this really any different from bombing them?</b></red>",
                "<red><b>Soulless.</b></red>",
                "<red><b>Intrusive thought or done purposely?</b></red>",
                "<red><b>Toxic.</b></red>"
        );

        public static String getRandomActivateMessage()
        {
            return activateMessageList.get(Toolkit.RNG.RandomRange(activateMessageList.size(), 0));
        }
    }

    public static class RNG {
        public static int RandomRange(int high, int low)
        {
            return (new Random().nextInt(high-low) + low);
        }
    }
}
