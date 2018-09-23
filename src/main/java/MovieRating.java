public enum MovieRating {
    ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, UNRATED;

    public String toS() {
        switch (this) {

            case UNRATED:
                return "unrated";

            case ZERO:
                return "0 / 10";

            case ONE:
                return "1 / 10";

            case TWO:
                return "2 / 10";

            case THREE:
                return "3 / 10";

            case FOUR:
                return "4 / 10";

            case FIVE:
                return "5 / 10";

            case SIX:
                return "6 / 10";

            case SEVEN:
                return "7 / 10";

            case EIGHT:
                return "8 / 10";

            case NINE:
                return "9 / 10";

            case TEN:
                return "10 / 10";

                default:
                    return "unrated";
        }
    }
}
