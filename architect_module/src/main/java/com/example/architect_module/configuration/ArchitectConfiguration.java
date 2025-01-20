package com.example.architect_module.configuration;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.Location;
import org.flywaydb.core.api.ResourceProvider;
import org.flywaydb.core.api.resource.LoadableResource;
import org.flywaydb.core.internal.configuration.models.FlywayModel;
import org.flywaydb.core.internal.scanner.filesystem.FileSystemScanner;
import org.flywaydb.core.internal.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.example.architect_module.constants.ArchitectConstants.BASE_MIGRATION_RESOURCES_PATH;

@Configuration
public class ArchitectConfiguration {

    @Value("${spring.flyway.url}")
    private String url;

    @Value("${spring.flyway.user}")
    private String username;

    @Value("${spring.flyway.password}")
    private String password;

    @Bean
    public Flyway getFlyway() {
        Location location = new Location(BASE_MIGRATION_RESOURCES_PATH);

        Flyway flyway = Flyway.configure()
                .dataSource(url, username, password)
                .locations(location)
                .resourceProvider(new ResourceProvider() {

                    @Override
                    public LoadableResource getResource(String name) {
                        return null;
                    }

                    @Override
                    public Collection<LoadableResource> getResources(String prefix, String[] suffixes) {
                        List<LoadableResource> result = new ArrayList<>();
                        for (LoadableResource resource : new FileSystemScanner(Charset.forName(FlywayModel.defaults().getEncoding()), true, true, true).scanForResources(location)) {
                            if (StringUtils.startsAndEndsWith(resource.getFilename(), prefix, suffixes)) {
                                result.add(resource);
                            }
                        }
                        return result;
                    }
                })
                .load();
        flyway.migrate();
        return flyway;
    }
}
