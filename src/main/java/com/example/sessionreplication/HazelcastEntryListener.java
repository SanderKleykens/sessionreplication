package com.example.sessionreplication;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.MapEvent;
import com.hazelcast.map.listener.EntryAddedListener;
import com.hazelcast.map.listener.EntryEvictedListener;
import com.hazelcast.map.listener.EntryRemovedListener;
import com.hazelcast.map.listener.EntryUpdatedListener;
import com.hazelcast.map.listener.MapClearedListener;
import com.hazelcast.map.listener.MapEvictedListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HazelcastEntryListener implements EntryAddedListener<String, String>,
        EntryRemovedListener<String, String>,
        EntryUpdatedListener<String, String>,
        EntryEvictedListener<String, String>,
        MapEvictedListener,
        MapClearedListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(HazelcastEntryListener.class);

    @Override
    public void entryAdded(EntryEvent<String, String> event) {
        LOGGER.debug("Hazelcast Entry Added: {}", event);
    }

    @Override
    public void entryRemoved(EntryEvent<String, String> event) {
        LOGGER.debug("Hazelcast Entry Removed: {}", event);
    }

    @Override
    public void entryUpdated( EntryEvent<String, String> event) {
        LOGGER.debug("Hazelcast Entry Updated: {}", event);
    }

    @Override
    public void entryEvicted( EntryEvent<String, String> event) {
        LOGGER.debug("Hazelcast Entry Evicted: {}", event);
    }

    @Override
    public void mapEvicted( MapEvent event) {
        LOGGER.debug("Hazelcast Map Evicted: {}", event);
    }

    @Override
    public void mapCleared( MapEvent event) {
        LOGGER.debug("Hazelcast Map Cleared: {}", event);
    }
}