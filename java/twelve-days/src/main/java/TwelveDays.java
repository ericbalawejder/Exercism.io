import java.util.Map;
import java.util.HashMap;

// Output the song to 'The Twelve Days of Christmas'.
class TwelveDays
{
    private static final Map<Integer, String> song = new HashMap<>();
    static
    {
        song.put(1, "On the first day of Christmas my true love gave " +
            "to me, a Partridge in a Pear Tree.\n");
        song.put(2, "On the second day of Christmas my true love gave to " +
            "me, two Turtle Doves, and a Partridge in a Pear Tree.\n");
        song.put(3, "On the third day of Christmas my true love gave to me, " +
            "three French Hens, two Turtle Doves, and a Partridge in a Pear " +
            "Tree.\n");
        song.put(4, "On the fourth day of Christmas my true love gave to me, " +
            "four Calling Birds, three French Hens, two Turtle Doves, and a " +
            "Partridge in a Pear Tree.\n");
        song.put(5, "On the fifth day of Christmas my true love gave to me, " +
            "five Gold Rings, four Calling Birds, three French Hens, two " +
            "Turtle Doves, and a Partridge in a Pear Tree.\n");
        song.put(6, "On the sixth day of Christmas my true love gave to me, " +
            "six Geese-a-Laying, five Gold Rings, four Calling Birds, three " +
            "French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n");
        song.put(7, "On the seventh day of Christmas my true love gave to me, " +
            "seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four " +
            "Calling Birds, three French Hens, two Turtle Doves, and a Partridge " +
            "in a Pear Tree.\n");
        song.put(8, "On the eighth day of Christmas my true love gave to me, eight " +
            "Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold " +
            "Rings, four Calling Birds, three French Hens, two Turtle Doves, and a " +
            "Partridge in a Pear Tree.\n");
        song.put(9, "On the ninth day of Christmas my true love gave to me, nine " +
            "Ladies Dancing, eight Maids-a-Milking, seven Swans-a-Swimming, six " +
            "Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, " +
            "two Turtle Doves, and a Partridge in a Pear Tree.\n");
        song.put(10, "On the tenth day of Christmas my true love gave to me, ten " +
            "Lords-a-Leaping, nine Ladies Dancing, eight Maids-a-Milking, seven " +
            "Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling " +
            "Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear " +
            "Tree.\n");
        song.put(11, "On the eleventh day of Christmas my true love gave to me, " +
            "eleven Pipers Piping, ten Lords-a-Leaping, nine Ladies Dancing, eight " +
            "Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold " +
            "Rings, four Calling Birds, three French Hens, two Turtle Doves, and a " +
            "Partridge in a Pear Tree.\n");
        song.put(12, "On the twelfth day of Christmas my true love gave to me, " +
            "twelve Drummers Drumming, eleven Pipers Piping, ten Lords-a-Leaping, " +
            "nine Ladies Dancing, eight Maids-a-Milking, seven Swans-a-Swimming, " +
            "six Geese-a-Laying, five Gold Rings, four Calling Birds, three French " +
            "Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n");
    }

    String verse(int verseNumber)
    {
        return song.get(verseNumber);
    }

    String verses(int startVerse, int endVerse)
    {
        StringBuilder lyrics = new StringBuilder();
        for (int i = startVerse; i <= endVerse; i++)
        {
            if (i == endVerse)
            {
                lyrics.append(song.get(i));
            }
            else
            {
                lyrics.append(song.get(i)).append("\n");
            }
        }
        return lyrics.toString();
    }

    String sing()
    {
        return verses(1, song.size());
    }
}
