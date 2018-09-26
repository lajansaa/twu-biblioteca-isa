public class Book extends Item {
    public Book(String title, String year) {
        super(title, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Book)) {
            return false;
        }
        Book book2 = (Book) obj;
        return book2.title.equals(title) && book2.year.equals(year);
    }
}
