package uz.ssd.locationsender.config;

import com.hazelcast.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfig {
    @Bean
    public Config configure() {
        return new Config().setInstanceName("hazelcast-instance")
                .addMapConfig(new MapConfig().setName("location_cache")
                        .setMaxSizeConfig(new MaxSizeConfig(999999, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
                        .setEvictionPolicy(EvictionPolicy.LRU).setTimeToLiveSeconds(20))
                .addMapConfig(new MapConfig().setName("user_cache")
                        .setMaxSizeConfig(new MaxSizeConfig(999999, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
                        .setEvictionPolicy(EvictionPolicy.LRU).setTimeToLiveSeconds(20))
                .setGroupConfig(new GroupConfig().setName("location").setPassword("1234"));
    }
}
