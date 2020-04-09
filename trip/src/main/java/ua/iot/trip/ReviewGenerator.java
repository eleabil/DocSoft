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
    int id = 1;

    {
        try {
            usernames = Files.readAllLines(USERNAMES.toPath(), Charset.defaultCharset());
            listingNames = Files.readAllLines(LISTING_NAMES.toPath(), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String generateUsername(){
        return usernames.get(random.nextInt(usernames.size()));
    }

    public String generateListingName(){
        return listingNames.get(random.nextInt(listingNames.size()));
    }

    public String generateDateCreated(){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String date = formatter.format(new Date());
        return date;
    }

    public int generateRateStars(){
        return random.nextInt(6);
    }

    public String generateReviewText(){
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }

    public String generateReviewTitle(){
        String[] arr={"Excellent!", "Good", "Okay", "Nice", "Awesome", "Bad", "Awful", "Disgusting"};
        Random r=new Random();
        int randomTitle = r.nextInt(arr.length);
        String title = arr[randomTitle];
        return title;
    }

    public void generateReview(){
        try {
            PrintWriter writer = new PrintWriter("Review.csv", "UTF-8");
            for(int i = 0;i<=1000; i++){
                writer.println(generateListingName() + " " +  generateReviewTitle() + " " +
                        generateReviewText() + " " + generateDateCreated() + " " +
                        generateRateStars() + " " + generateUsername());
            }
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

}
