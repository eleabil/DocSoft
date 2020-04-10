package ua.iot.trip.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import ua.iot.trip.rest.model.Review;

import javax.transaction.Transactional;
import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Integer> {

    Review findReviewByReviewId(Integer id);

    List<Review> findByRateStars(int rateStars);

    List<Review> findByListingName(String listingName);

    @Transactional
    @Modifying
    void deleteByReviewId(Integer id);

    @Transactional
    @Modifying
    void deleteAll();
}
