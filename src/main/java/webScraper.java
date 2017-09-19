import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author divyabhati
 *
 */
public class webScraper {

    /**
     *
     * @param url
     * @return
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String url = "http://erdani.com/tdpl/hamlet.txt";

        //Count total number of words in website
        String websiteString1 = urlToString(url);
        int count = 0;
        for (int i = 1; i < websiteString1.length() - 1; i++) {
            if (websiteString1.charAt(i) == ' ' && websiteString1.charAt(i - 1) != ' ' && websiteString1.charAt(i + 1) != ' '){
                count++;
            }
        }
        System.out.println("The website " + url + " has " + count + " words.");

        //Count number of occurrences of certain word
        int wordCount = 0;
        String word = "the";
        for (int i = 0; i < websiteString1.length() - word.length(); i++) {
            if (websiteString1.substring(i, i + word.length()).equals(word)) {
                wordCount++;
            }
        }
        System.out.println("The number of occurrences of the word " + word + " is " + wordCount);
    }



}
