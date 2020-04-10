package ua.iot.trip;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ReviewGenerator {

    Random random = new Random();
    static final File USERNAMES = new File("src/Usernames.csv");
    static final File LISTING_NAMES = new File("src/ListingNames.csv");
    List<String> usernames;
    List<String> listingNames;

    {
        try {
            usernames = Files.readAllLines(USERNAMES.toPath(), Charset.defaultCharset());
            listingNames = Files.readAllLines(LISTING_NAMES.toPath(), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String generateUsername() {
        return usernames.get(random.nextInt(usernames.size()));
    }

    public String generateListingName() {
        return listingNames.get(random.nextInt(listingNames.size()));
    }

    public String generateDateCreated() {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(new Date());
    }

    public int generateRateStars() {
        return random.nextInt(6);
    }

    public String generateReviewText() {
        String randomString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            int index
                    = (int) (randomString.length()
                    * Math.random());
            sb.append(randomString
                    .charAt(index));
        }
        return sb.toString();
    }

    public String generateReviewTitle() {
        String[] titlesArray = {"Excellent!", "Good", "Okay", "Nice", "Awesome", "Bad", "Awful", "Disgusting"};
        int randomTitle = random.nextInt(titlesArray.length);
        return titlesArray[randomTitle];
    }

    public void generateReview() {
        try {
            PrintWriter printWriter = new PrintWriter("Review.csv", "UTF-8");
            for (int i = 0; i <= 1000; i++) {
                printWriter.println(generateListingName() + " " + generateReviewTitle() + " " +
                        generateReviewText() + " " + generateDateCreated() + " " +
                        generateRateStars() + " " + generateUsername());
            }
            printWriter.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}