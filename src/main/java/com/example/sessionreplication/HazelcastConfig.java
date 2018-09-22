package com.example.sessionreplication;

import com.hazelcast.config.*;
import com.hazelcast.map.listener.MapListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.MapSession;

import static com.example.sessionreplication.SessionreplicationApplication.GROUP_CONFIG_NAME;
import static com.example.sessionreplication.SessionreplicationApplication.HAZELCAST_INSTANCE_NAME;
import static com.example.sessionreplication.SessionreplicationApplication.MAP_CONFIG_NAME;

@Configuration
public class HazelcastConfig {

    @Bean
    public MapListener mapListener() {
        return new HazelcastEntryListener();
    }

    @Bean
    public Config config() {

        final Config config = new Config();
        config.setInstanceName(HAZELCAST_INSTANCE_NAME);
        config.getGroupConfig().setName(GROUP_CONFIG_NAME);
        config.addMapConfig(mapConfig());

        final NetworkConfig networkConfig = config.getNetworkConfig();

        final JoinConfig joinConfig = networkConfig.getJoin();
        joinConfig.getMulticastConfig().setEnabled(false);
        joinConfig.getTcpIpConfig()
                  .setEnabled(true)
                  .addMember("127.0.0.1");

        return config;
    }

    // Since we are creating the map it's important to purge sessions
    // by setting a reasonable value for time to live
    // as the default is 0 which means infinite
    private MapConfig mapConfig() {
        final MapConfig mapConfig = new MapConfig();
        mapConfig.setName(MAP_CONFIG_NAME);
        mapConfig.setTimeToLiveSeconds(MapSession.DEFAULT_MAX_INACTIVE_INTERVAL_SECONDS);
        mapConfig.setEvictionPolicy(EvictionPolicy.LRU);
        mapConfig.addEntryListenerConfig(new EntryListenerConfig(HazelcastEntryListener.class.getName(), false, false ) );
        return mapConfig;
    }
}
