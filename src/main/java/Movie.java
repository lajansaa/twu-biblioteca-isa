public class Movie extends Item {
    private String director;
    private MovieRating rating;

    public Movie(String title, String year, String director, MovieRating rating) {
        super(title, year);
        this.director = director;
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public String getRating() {
        return rating.toS();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Movie)) {
            return false;
        }
        Movie movie2 = (Movie) obj;
        return movie2.title.equals(title) && movie2.year.equals(year) && movie2.director.equals(director) && movie2.rating.equals(rating);
    }

}
