import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.SortedSetMultimap;
import com.google.common.collect.TreeMultimap;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yuhua on 07/07/16.
 */
public class AbstractMapBasedMultimapTest {
    @Test
    public void testListMultimap() {
        Multimap<Integer, String> listMMP = ArrayListMultimap.create();
        //test null set
        Assert.assertTrue("size of empty map", listMMP.size() == 0);
        Assert.assertTrue("is empty?", listMMP.isEmpty());
        Assert.assertTrue("get from empty map", listMMP.get(1).isEmpty());
        Assert.assertFalse("containsKey from empty map", listMMP.containsKey(1));
        Assert.assertFalse("containsValue from empty map", listMMP.containsValue("a"));

        //add contents
        listMMP.put(1,"a");
        listMMP.put(1,"b");
        Assert.assertTrue("put into map", listMMP.size() == 2);
        Assert.assertTrue("contains key", listMMP.containsKey(1));
        Assert.assertTrue("contains value", listMMP.containsValue("a"));
        Assert.assertTrue("contains entry", listMMP.containsEntry(1,"a"));
        List<String> temp = new ArrayList<>();
        temp.add("c");
        temp.add("d");
        temp.add("e");
        listMMP.putAll(2,temp);
        Assert.assertTrue("get from filled map", listMMP.get(2).size()==3);
        temp = new ArrayList<>();
        temp.add("f");
        listMMP.replaceValues(1,temp);
        Assert.assertTrue("replace values", listMMP.get(1).size()==1);

        //remove
        listMMP.remove(2,"d");
        Assert.assertTrue("remove from filled map", listMMP.get(2).size()==2);
        listMMP.removeAll(1);
        Assert.assertTrue("removeAll from filled map", listMMP.get(1).size()==0);
        listMMP.clear();
        Assert.assertTrue("put into map", listMMP.size() == 0);
    }
    @Test
    public void testTreeMultimap(){
        SortedSetMultimap<Integer, Integer> treeMMP = TreeMultimap.create();
        //test null set
        Assert.assertTrue("size of empty map", treeMMP.size() == 0);
        Assert.assertTrue("is empty?", treeMMP.isEmpty());
        Assert.assertTrue("get from empty map", treeMMP.get(1).isEmpty());
        Assert.assertFalse("containsKey from empty map", treeMMP.containsKey(1));
        Assert.assertFalse("containsValue from empty map", treeMMP.containsValue(11));

        //add contents
        treeMMP.put(1,11);
        treeMMP.put(1,12);
        Assert.assertTrue("put into map", treeMMP.size() == 2);
        Assert.assertTrue("contains key", treeMMP.containsKey(1));
        Assert.assertTrue("contains value", treeMMP.containsValue(11));
        Assert.assertTrue("contains entry", treeMMP.containsEntry(1,11));
        List<Integer> temp = new ArrayList<>();
        temp.add(23);
        temp.add(21);
        temp.add(22);
        treeMMP.putAll(2,temp);
        Assert.assertTrue("get from filled map", treeMMP.get(2).size()==3);
        temp = new ArrayList<>();
        temp.add(13);
        treeMMP.replaceValues(1,temp);
        Assert.assertTrue("replace values", treeMMP.get(1).size()==1);

        //test sorted order
        Iterator it = treeMMP.get(2).iterator();
        int s1=(Integer) it.next();
        while(it.hasNext()){
            int s2 = (Integer) it.next();
            Assert.assertTrue("replace values", s2>=s1);
        }

        //remove
        treeMMP.remove(2,22);
        Assert.assertTrue("remove from filled map", treeMMP.get(2).size()==2);
        treeMMP.removeAll(1);
        Assert.assertTrue("removeAll from filled map", treeMMP.get(1).size()==0);
        treeMMP.clear();
        Assert.assertTrue("put into map", treeMMP.size() == 0);
    }

}
