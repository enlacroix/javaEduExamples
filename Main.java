import perm.Permutation;

import java.util.*;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        Permutation perm = new Permutation(new LinkedHashSet<>(Arrays.asList(2, 3, 4, 5, 1)));
        Permutation perm2 = new Permutation("2, 1, 5, 3, 4");
        System.out.println(perm.cycleStructure());
        System.out.println(perm.pow(5));

        System.out.println(perm2.cycleStructure());
        System.out.println(perm2.pow(6));

    }
}
