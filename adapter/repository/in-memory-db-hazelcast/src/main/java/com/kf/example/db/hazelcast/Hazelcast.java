package com.kf.example.db.hazelcast;

import com.hazelcast.core.HazelcastInstance;

import static com.hazelcast.core.Hazelcast.newHazelcastInstance;

public class Hazelcast {

    private static final Object LOCK = new Object();
    private static HazelcastInstance HAZELCAST;

    private Hazelcast() {}

    static HazelcastInstance getInstance() {
        if (HAZELCAST == null) {
            synchronized (LOCK) {
                if (HAZELCAST == null) {
                    HAZELCAST = newHazelcastInstance();
                }
            }
        }
        return HAZELCAST;
    }
}
