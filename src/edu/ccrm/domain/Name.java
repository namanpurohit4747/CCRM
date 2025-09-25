package edu.ccrm.domain;

public final class Name {
    private final String first;
    private final String last;
    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }
    public String getFirst() { return first; }
    public String getLast() { return last; }
    public String getFull() { return first + " " + last; }
}
