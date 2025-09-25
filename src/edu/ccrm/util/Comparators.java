package edu.ccrm.util;

import edu.ccrm.domain.Course;
import java.util.Comparator;

public class Comparators {
    public static Comparator<Course> byCode = (c1, c2) -> c1.getCode().compareTo(c2.getCode());
    public static Comparator<Course> byCredits = (c1, c2) -> Integer.compare(c1.getCredits(), c2.getCredits());
}
