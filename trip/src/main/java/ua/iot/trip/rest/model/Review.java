package ua.iot.trip.rest.model;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;

    @Column(name = "listing_name")
    private String listingName;

    @Column(name = "review_title")
    private String reviewTitle;

    @Column(name = "review_text")
    private String reviewText;

    @Column(name = "date_created")
    private String dateCreated;

    @Column(name = "rate_stars")
    private int rateStars;

    @Column(name = "username")
    private String username;

    public Review() {
    }

    public Review(Integer reviewId, String listingName, String reviewTitle,
                  String reviewText, String dateCreated,
                  int rateStars, String username) {
        this.reviewId = reviewId;
        this.listingName = listingName;
        this.reviewTitle = reviewTitle;
        this.reviewText = reviewText;
        this.dateCreated = dateCreated;
        this.rateStars = rateStars;
        this.username = username;
    }

    public Review(String listingName, String reviewTitle,
                  String reviewText, String dateCreated,
                  int rateStars, String username) {
        this.listingName = listingName;
        this.reviewTitle = reviewTitle;
        this.reviewText = reviewText;
        this.dateCreated = dateCreated;
        this.rateStars = rateStars;
        this.username = username;
    }

    public Review(String reviewTitle, String reviewText, int rateStars) {
        this.reviewTitle = reviewTitle;
        this.reviewText = reviewText;
        this.rateStars = rateStars;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public String getListingName() {
        return listingName;
    }

    public void setListingName(String listingName) {
        this.listingName = listingName;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getRateStars() {
        return rateStars;
    }

    public void setRateStars(int rateStars) {
        this.rateStars = rateStars;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
