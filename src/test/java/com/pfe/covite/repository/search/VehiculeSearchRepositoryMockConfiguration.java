package com.pfe.covite.repository.search;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

/**
 * Configure a Mock version of {@link VehiculeSearchRepository} to test the
 * application without starting Elasticsearch.
 */
@Configuration
public class VehiculeSearchRepositoryMockConfiguration {

    @MockBean
    private VehiculeSearchRepository mockVehiculeSearchRepository;

}
