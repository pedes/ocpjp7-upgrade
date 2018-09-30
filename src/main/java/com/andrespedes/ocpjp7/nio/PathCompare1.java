package com.andrespedes.ocpjp7.nio;

import java.nio.file.*;
// illustrates how to use compareTo and equals and also shows the difference between the two methods
class PathCompare1 {
    public static void main(String[] args) {
        Path path1 = Paths.get("..\\nio");
        Path path2 = Paths.get("\\Users\\andresc\\IdeaProjects\\ocpjp7-upgrade\\src\\main\\java\\com\\andrespedes\\ocpjp7\\nio");
        // comparing two paths using compareTo() method System.out.println("(path1.compareTo(path2) == 0) is: " + (path1.compareTo(path2) == 0));
        //comparing two paths using equals() method
        System.out.println("path1.equals(path2) is: " + path1.equals(path2));
        // comparing two paths using equals() method with absolute path
        System.out.println("path2.equals(path1.toAbsolutePath()) is "
                + path2.equals(path1.toAbsolutePath().normalize()));
    }
}
