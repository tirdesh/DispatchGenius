package app.receiver;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class StarRatingControl extends HBox {
    private final IntegerProperty rating = new SimpleIntegerProperty(0);
    private final IntegerProperty selectedRating = new SimpleIntegerProperty(0);

    public StarRatingControl() {
        setAlignment(Pos.CENTER);
        setSpacing(2);
        createStars();
    }

    private void createStars() {
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Polygon star = new Polygon(
                    10.0, 0.0,
                    14.0, 12.0,
                    22.0, 14.0,
                    16.0, 20.0,
                    18.0, 28.0,
                    10.0, 24.0,
                    2.0, 28.0,
                    4.0, 20.0,
                    -2.0, 14.0,
                    6.0, 12.0
            );
            star.setFill(Color.GRAY);
            star.setOnMouseClicked(event -> {
                setSelectedRating(finalI + 1);
                updateStarAppearance();
            });
            getChildren().add(star);
        }
    }

    private void updateStarAppearance() {
        for (int i = 0; i < getChildren().size(); i++) {
            Polygon star = (Polygon) getChildren().get(i);
            if (i < selectedRating.get()) {
                star.setFill(Color.GOLD);
            } else {
                star.setFill(Color.GRAY);
            }
        }
    }

    public int getRating() {
        return rating.get();
    }

    public void setRating(int rating) {
        this.rating.set(rating);
        this.selectedRating.set(rating);
        updateStarAppearance();
    }

    public IntegerProperty ratingProperty() {
        return rating;
    }

    public int getSelectedRating() {
        return selectedRating.get();
    }

    public void setSelectedRating(int selectedRating) {
        this.selectedRating.set(selectedRating);
    }

    public IntegerProperty selectedRatingProperty() {
        return selectedRating;
    }
}