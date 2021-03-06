package com.pfe.covite.service.impl;

import com.pfe.covite.service.VehiculeService;
import com.pfe.covite.domain.Vehicule;
import com.pfe.covite.repository.VehiculeRepository;
import com.pfe.covite.repository.search.VehiculeSearchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing {@link Vehicule}.
 */
@Service
@Transactional
public class VehiculeServiceImpl implements VehiculeService {

    private final Logger log = LoggerFactory.getLogger(VehiculeServiceImpl.class);

    private final VehiculeRepository vehiculeRepository;

    private final VehiculeSearchRepository vehiculeSearchRepository;

    public VehiculeServiceImpl(VehiculeRepository vehiculeRepository, VehiculeSearchRepository vehiculeSearchRepository) {
        this.vehiculeRepository = vehiculeRepository;
        this.vehiculeSearchRepository = vehiculeSearchRepository;
    }

    /**
     * Save a vehicule.
     *
     * @param vehicule the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Vehicule save(Vehicule vehicule) {
        log.debug("Request to save Vehicule : {}", vehicule);
        Vehicule result = vehiculeRepository.save(vehicule);
        vehiculeSearchRepository.save(result);
        return result;
    }

    /**
     * Get all the vehicules.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Vehicule> findAll(Pageable pageable) {
        log.debug("Request to get all Vehicules");
        return vehiculeRepository.findAll(pageable);
    }

    /**
     * Get one vehicule by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Vehicule> findOne(Long id) {
        log.debug("Request to get Vehicule : {}", id);
        return vehiculeRepository.findById(id);
    }

    /**
     * Delete the vehicule by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Vehicule : {}", id);
        vehiculeRepository.deleteById(id);
        vehiculeSearchRepository.deleteById(id);
    }

    /**
     * Search for the vehicule corresponding to the query.
     *
     * @param query the query of the search.
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Vehicule> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Vehicules for query {}", query);
        return vehiculeSearchRepository.search(queryStringQuery(query), pageable);    }
}
