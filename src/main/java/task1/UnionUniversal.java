class UnionUniversal {
    public static <T, U extends Set<T>> U union(Class<U> classSet, Set<T>... args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        U unionSet = classSet.getDeclaredConstructor().newInstance();

        for (Set<T> set : args) {
            unionSet.addAll(set);
        }

        return unionSet;
    }

    public static <T, U extends Set<T>> U intersect(Class<U> classSet, Set<T>... args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        U intersectSet = classSet.getDeclaredConstructor().newInstance();

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
