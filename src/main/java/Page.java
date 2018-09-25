public interface Page {
    String getTitle();
    Page start(ActionAsker actionAsker);
    void printDescription();
}
