package ua.iot.trip;

import ua.iot.trip.ReviewGenerator;

public class GeneratorLauncher {
    public static void main(String[] args) {
        ReviewGenerator reviewGenerator = new ReviewGenerator();
        reviewGenerator.generateReview();
        System.out.println("Reviews were successfully generated");
    }
}
