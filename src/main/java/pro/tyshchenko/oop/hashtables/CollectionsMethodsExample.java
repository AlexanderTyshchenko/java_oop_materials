package pro.tyshchenko.oop.hashtables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Alexander Tyshchenko.
 */
public class CollectionsMethodsExample {

    public static void main(String[] args) {
        CollectionsMethodsExample object = new CollectionsMethodsExample();
    }

    private Map<Integer, String>            map =           new HashMap<>();
    private NavigableMap<Integer, String>   navigableMap =  new TreeMap<>();
    private SortedMap<Integer, String>      sortedMap =     new TreeMap<>();
    private List<String>                    list =          new ArrayList<>();
    private Set<String>                     set =           new HashSet<>();
    private SortedSet<String>               sortedSet =     new TreeSet<>();

    public List<String> getList() {
        return Collections.unmodifiableList(list);
    }

    public Map<Integer, String> getMap() {
        return Collections.unmodifiableMap(map);
    }

    public Set<String> getSet() {
        return Collections.unmodifiableSet(set);
    }

    public Collection<String> getCollection() {
        return Collections.unmodifiableCollection(list);
    }

    public NavigableMap<Integer, String> getNavigableMap() {
        return Collections.unmodifiableNavigableMap(navigableMap);
    }

    public SortedMap<Integer, String> getSortedMap() {
        return Collections.unmodifiableSortedMap(sortedMap);
    }

    public SortedSet<String> getSortedSet() {
        return Collections.unmodifiableSortedSet(sortedSet);
    }
}
