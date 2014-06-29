package com.periodiccraft.pcm.util;

import java.util.*;

public class MultiKeyHashMap<K1, K2, V> implements MultiKeyMap<K1, K2, V> {

    private final Map<K1, V> K1_MAP = new HashMap<>();
    private final Map<K2, V> K2_MAP = new HashMap<>();

    @Override
    public int size() {
        return K1_MAP.size();
    }

    @Override
    public boolean isEmpty() {
        return K1_MAP.isEmpty();
    }

    @Override
    public boolean containsKey1(K1 key) {
        return K1_MAP.containsKey(key);
    }

    @Override
    public boolean containsKey2(K2 key) {
        return K2_MAP.containsKey(key);
    }

    @Override
    public boolean containsValue(V value) {
        return K1_MAP.containsValue(value);
    }

    @Override
    public V getByKey1(K1 key) {
        return K1_MAP.get(key);
    }

    @Override
    public V getByKey2(K2 key) {
        return K2_MAP.get(key);
    }

    @Override
    public V put(K1 key, K2 key2, V value) {
        K1_MAP.put(key, value);
        return K2_MAP.put(key2, value);
    }

    @Override
    public V remove(Object key) {
        K1_MAP.remove(key);
        return K2_MAP.remove(key);
    }

    @Override
    public void clear() {
        K1_MAP.clear();
        K2_MAP.clear();
    }

    @Override
    public Set<K1> keySet1() {
        return K1_MAP.keySet();
    }

    @Override
    public Set<K2> keySet2() {
        return K2_MAP.keySet();
    }

    @Override
    public Collection<V> values() {
        return K1_MAP.values();
    }
}
