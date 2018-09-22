package com.example.sessionreplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SessionreplicationApplication {

	public static final String HAZELCAST_INSTANCE_NAME = "hazelcast_instance";
    public static final String GROUP_CONFIG_NAME = "session_replication_group";
	public static final String MAP_CONFIG_NAME = "session_replication_map";

	public static void main(String[] args) {
		SpringApplication.run(SessionreplicationApplication.class, args);
	}

}
