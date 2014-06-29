package com.periodiccraft.pcm.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public interface MultiKeyMap<K1, K2, V> extends Cloneable, Serializable {

    public int size();

    public boolean isEmpty();

    public boolean containsKey1(K1 key);

    public boolean containsKey2(K2 key);

    public boolean containsValue(V value);

    public V getByKey1(K1 key);

    public V getByKey2(K2 key);

    public V put(K1 key, K2 key2, V value);

    public V remove(Object key);

    public void clear();

    public Set<K1> keySet1();

    public Set<K2> keySet2();

    public Collection<V> values();
}
