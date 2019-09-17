package com.mycompany.myapp.config;

import com.github.dockerjava.api.command.CreateContainerCmd;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.GenericContainer;

import java.util.function.Consumer;

@Configuration
public class RedisTestContainerConfiguration {

    @Bean(name = "testContainerRedis")
    public Object testContainerRedis() {
        Consumer<CreateContainerCmd> cmd = e -> e.withPortBindings(new PortBinding(Ports.Binding.bindPort(6379), new ExposedPort(6379)));
        GenericContainer redis =
            new GenericContainer("redis:5.0.5")
                .withExposedPorts(6379)
                .withCreateContainerCmdModifier(cmd);
        redis.start();
        return null;
    }
}
