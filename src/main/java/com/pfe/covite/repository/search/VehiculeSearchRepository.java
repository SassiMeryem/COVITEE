package com.pfe.covite.repository.search;

import com.pfe.covite.domain.Vehicule;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the {@link Vehicule} entity.
 */
public interface VehiculeSearchRepository extends ElasticsearchRepository<Vehicule, Long> {
}
