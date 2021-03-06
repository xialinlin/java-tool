package org.osgl.util;

public class DelegatingListTest extends ListTestBase {

    @Override
    protected C.List<Integer> prepareData(int... ia) {
        C.List<Integer> l = prepareEmptyData();
        l.append(C.list(ia));
        return l;
    }

    @Override
    protected C.List<Integer> prepareEmptyData() {
        return C.newList();
    }

    @Override
    protected <T> C.List<T> prepareTypedData(T... ta) {
        C.List<T> l = C.newSizedList(ta.length);
        for (T t : ta) {
            l.add(t);
        }
        return l;
    }
}
