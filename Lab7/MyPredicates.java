package Lab7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class MyPredicates {
	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as coll.removeIf(p).)
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		// TODO
		for (T t : coll) {
			if (p.test(t)) {
				coll.remove(t);
			}
		}
	}

	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		// TODO
		for (T t : coll) {
			if (!p.test(t)) {
				coll.remove(t);
			}
		}
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		// TODO
		Set<T> result= new HashSet<>();
		for (T t : coll) {
			if(p.test(t)) {
				result.add(t);
			}
		}
		return result;
	}

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		// TODO
		int result=-1;
		Object[]arr= coll.toArray();
		for (int i = 0; i <coll.size(); i++) {
			if(p.test((T) arr[i])) {
				result= i;
				break;
			}
		}
		return result;
	}
}
