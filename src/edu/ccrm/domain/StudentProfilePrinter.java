package edu.ccrm.domain;

public class StudentProfilePrinter {
    public static class StaticPrinter {
        public static void print(String info) {
            System.out.println("[StaticPrinter] " + info);
        }
    }
    public class InnerPrinter {
        public void print(String info) {
            System.out.println("[InnerPrinter] " + info);
        }
    }
}
