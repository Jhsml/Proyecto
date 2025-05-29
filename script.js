// Wait for the DOM to be fully loaded before running the script
document.addEventListener('DOMContentLoaded', () => {
    // Select DOM elements based on IDs and classes from index.html
    const slides = document.querySelectorAll('#slides-container .slide'); // Select all elements with class 'slide' within '#slides-container'
    const prevButton = document.getElementById('prev-button'); // Select the 'Previous' button by its ID
    const nextButton = document.getElementById('next-button'); // Select the 'Next' button by its ID

    let currentSlideIndex = 0; // Variable to keep track of the currently displayed slide index
    const totalSlides = slides.length; // Total number of slides

    /**
     * Shows a specific slide and hides all others.
     * Also updates the state of navigation buttons.
     * @param {number} index - The index of the slide to show.
     */
    function showSlide(index) {
        // Hide all slides by removing the 'active' class
        slides.forEach(slide => {
            slide.classList.remove('active');
        });

        // Check if the slide at the given index exists
        if (slides[index]) {
            slides[index].classList.add('active'); // Show the target slide by adding the 'active' class
        } else {
            console.error(`Slide with index ${index} not found.`);
            return; // Exit if slide not found
        }

        // Update the current slide index
        currentSlideIndex = index;

        // Update the disabled state of the navigation buttons
        // Disable 'Previous' button if on the first slide
        if (prevButton) { // Check if button exists
            prevButton.disabled = (currentSlideIndex === 0);
        }
        // Disable 'Next' button if on the last slide
        if (nextButton) { // Check if button exists
            nextButton.disabled = (currentSlideIndex === totalSlides - 1);
        }
    }

    // Event listener for the 'Next' button
    if (nextButton) { // Check if button exists before adding listener
        nextButton.addEventListener('click', () => {
            if (currentSlideIndex < totalSlides - 1) { // Check if not the last slide
                showSlide(currentSlideIndex + 1); // Show the next slide
            }
        });
    }

    // Event listener for the 'Previous' button
    if (prevButton) { // Check if button exists before adding listener
        prevButton.addEventListener('click', () => {
            if (currentSlideIndex > 0) { // Check if not the first slide
                showSlide(currentSlideIndex - 1); // Show the previous slide
            }
        });
    }

    // Initial setup: Show the first slide if slides exist
    if (totalSlides > 0) {
        showSlide(0); // Show the first slide (index 0)
    } else {
        // If there are no slides, log a warning and disable buttons
        console.warn("No slides found in the presentation.");
        if (prevButton) prevButton.disabled = true;
        if (nextButton) nextButton.disabled = true;
    }
});
