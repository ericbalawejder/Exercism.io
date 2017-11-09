// Given a decimal number, convert it to the appropriate sequence of events for a secret handshake.
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class HandshakeCalculator
{
    List<Signal> calculateHandshake(int number)
    {
        List<Signal> secretHandshake = new ArrayList<>();
        // Using bitwise comparison: 4 & 7 == 4. 00000100 & 00000111 == 00000100
        if ((number & 1) > 0)
        {
            secretHandshake.add(Signal.WINK);
        }
        if ((number & 2) > 0)
        {
            secretHandshake.add(Signal.DOUBLE_BLINK);
        }
        if ((number & 4) > 0)
        {
            secretHandshake.add(Signal.CLOSE_YOUR_EYES);
        }
        if ((number & 8) > 0)
        {
            secretHandshake.add(Signal.JUMP);
        }
        if ((number & 16) > 0)
        {
            Collections.reverse(secretHandshake);
        }
        return secretHandshake;
    }
}
