package task1;

import java.util.HashSet;
import java.util.Set;

/*
 * Write parameterized methods union(Set set1, Set set2) and intersect(Set set1, Set set2),
 *  realizing the operations of union and intersection of two sets.
 *  Test the operation of these techniques on two pre-filled sets.
 * */
class Union {
    @SafeVarargs
    public static <T> Set<T> union(Set<T>... args) {
        Set<T> unionSet = new HashSet<>();

        for (Set<T> set : args) {
            unionSet.addAll(set);
        }

        return unionSet;
    }

    @SafeVarargs
    public static<T> Set<T> intersect(Set <T> ... args) {
        Set<T> intersectSet = new HashSet<>();

        if(args.length == 0) {
            return intersectSet;
        }

        intersectSet.addAll(args[0]);

        for (Set<T> sets: args){
            intersectSet.retainAll(sets);
        }

        return intersectSet;
    }
}
