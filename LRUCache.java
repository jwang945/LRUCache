import java.util.LinkedList;
import java.util.List;
public class LRUCache{
    public static void main(String[] args){
        int num = 7;
        List<Integer> pages = new LinkedList<>();//1^:1,2^:2,1:2,1,3^:1,3,4^:3,4,1:4,1,2^
        pages.add(1);
        pages.add(2);
        pages.add(1);
        pages.add(3);
        pages.add(4);
        pages.add(1);
        pages.add(2);
        int maxSize = 3;
        System.out.println(misses(num, pages, maxSize));
    }
    private static int misses(int num, List<Integer> pages, int maxCacheSize){
        int misses = 0;
        List<Integer> cache = new LinkedList<>();
        for(Integer page : pages){
            if(cache.contains(page)){
                //in cache, remove and then add it
                cache.remove(page);
                cache.add(page);
            } else {
                //not in cache
                misses++;
                //add it to the cache
                if(cache.size() == maxCacheSize){
                    //remove LRU if at max capacity
                    cache.remove(0);
                }
                cache.add(page);
            }
        }
        return misses;
    }
}