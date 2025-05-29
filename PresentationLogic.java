// File: PresentationLogic.java

/**
 * Simulates some backend logic for the presentation.
 * This class is intended as a conceptual representation and is not directly
 * executed or connected to the frontend in this simple static web presentation.
 * Its slide counting and navigation logic conceptually mirrors what the
 * JavaScript `script.js` does on the client-side.
 */
public class PresentationLogic {

    private int totalSlides;
    private int currentSlideNumber; // 0-indexed

    /**
     * Constructor for PresentationLogic.
     * @param totalSlides The total number of slides in the presentation.
     *                    Should be a positive integer.
     */
    public PresentationLogic(int totalSlides) {
        if (totalSlides <= 0) {
            throw new IllegalArgumentException("Total slides must be positive.");
        }
        this.totalSlides = totalSlides;
        this.currentSlideNumber = 0; // Start at the first slide (index 0)
    }

    /**
     * Gets the total number of slides.
     * @return The total number of slides.
     */
    public int getTotalSlides() {
        return totalSlides;
    }

    /**
     * Simulates advancing to the next slide.
     * If already at the last slide, the current slide number does not change.
     * @return The new current slide number (0-indexed).
     */
    public int goToNextSlide() {
        if (currentSlideNumber < totalSlides - 1) {
            currentSlideNumber++;
        }
        return currentSlideNumber;
    }

    /**
     * Simulates going back to the previous slide.
     * If already at the first slide, the current slide number does not change.
     * @return The new current slide number (0-indexed).
     */
    public int goToPreviousSlide() {
        if (currentSlideNumber > 0) {
            currentSlideNumber--;
        }
        return currentSlideNumber;
    }

    /**
     * Gets the current slide number.
     * @return The current slide number (0-indexed).
     */
    public int getCurrentSlideNumber() {
        return currentSlideNumber;
    }

    /**
     * Sets the current slide number directly.
     * If the provided number is out of bounds, it's adjusted to the nearest valid slide.
     * @param slideNumber The desired slide number (0-indexed).
     */
    public void setCurrentSlideNumber(int slideNumber) {
        if (slideNumber < 0) {
            this.currentSlideNumber = 0;
        } else if (slideNumber >= totalSlides) {
            this.currentSlideNumber = totalSlides - 1;
        } else {
            this.currentSlideNumber = slideNumber;
        }
    }

    /**
     * A simple main method for demonstration purposes.
     * This shows how the PresentationLogic class might be used.
     */
    public static void main(String[] args) {
        System.out.println("Demonstrating PresentationLogic:");
        PresentationLogic presentation = new PresentationLogic(5); // Example with 5 slides

        System.out.println("Initial state:");
        System.out.println("- Total slides: " + presentation.getTotalSlides());
        System.out.println("- Current slide: " + presentation.getCurrentSlideNumber()); // Expected: 0

        System.out.println("\nNavigating forward:");
        presentation.goToNextSlide(); // To slide 1
        System.out.println("- Current slide: " + presentation.getCurrentSlideNumber()); // Expected: 1
        presentation.goToNextSlide(); // To slide 2
        System.out.println("- Current slide: " + presentation.getCurrentSlideNumber()); // Expected: 2

        System.out.println("\nNavigating backward:");
        presentation.goToPreviousSlide(); // To slide 1
        System.out.println("- Current slide: " + presentation.getCurrentSlideNumber()); // Expected: 1

        System.out.println("\nTesting boundary conditions:");
        presentation.setCurrentSlideNumber(0); // Back to first slide
        System.out.println("- Set to slide 0. Current: " + presentation.getCurrentSlideNumber());
        presentation.goToPreviousSlide(); // Try to go before first
        System.out.println("- Attempt previous. Current: " + presentation.getCurrentSlideNumber()); // Expected: 0

        presentation.setCurrentSlideNumber(presentation.getTotalSlides() - 1); // Go to last slide
        System.out.println("- Set to last slide (" + (presentation.getTotalSlides() - 1) + "). Current: " + presentation.getCurrentSlideNumber());
        presentation.goToNextSlide(); // Try to go after last
        System.out.println("- Attempt next. Current: " + presentation.getCurrentSlideNumber()); // Expected: 4 (if 5 total slides)

        System.out.println("\nDemonstration complete.");
    }
}
