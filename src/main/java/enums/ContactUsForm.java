package enums;

public enum ContactUsForm {

    FIRST_NAME(0),
    LAST_NAME(1),
    EMAIL(2),
    COMPANY(3),
    CONTACT(4),
    MESSAGE(5),
    ;

    private final int index;

    ContactUsForm(int index) {

        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "ContactUsForm{" +
                "index=" + index +
                '}';
    }
}
