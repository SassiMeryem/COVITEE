package com.pfe.covite.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;
import java.util.Objects;
import java.time.LocalDate;

import com.pfe.covite.domain.enumeration.Categorie;

import com.pfe.covite.domain.enumeration.Service;

/**
 * A Commande.
 */
@Entity
@Table(name = "commande")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "commande")
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @NotNull
    @Column(name = "prix", nullable = false)
    private Float prix;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private Categorie type;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "typeservice", nullable = false)
    private Service typeservice;

    @ManyToOne
    @JsonIgnoreProperties("commandes")
    private Vehicule vehicule;

    @ManyToOne
    @JsonIgnoreProperties("commandes")
    private Position position;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Commande date(LocalDate date) {
        this.date = date;
        return this;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Float getPrix() {
        return prix;
    }

    public Commande prix(Float prix) {
        this.prix = prix;
        return this;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Categorie getType() {
        return type;
    }

    public Commande type(Categorie type) {
        this.type = type;
        return this;
    }

    public void setType(Categorie type) {
        this.type = type;
    }

    public Service getTypeservice() {
        return typeservice;
    }

    public Commande typeservice(Service typeservice) {
        this.typeservice = typeservice;
        return this;
    }

    public void setTypeservice(Service typeservice) {
        this.typeservice = typeservice;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public Commande vehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
        return this;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Position getPosition() {
        return position;
    }

    public Commande position(Position position) {
        this.position = position;
        return this;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Commande)) {
            return false;
        }
        return id != null && id.equals(((Commande) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Commande{" +
            "id=" + getId() +
            ", date='" + getDate() + "'" +
            ", prix=" + getPrix() +
            ", type='" + getType() + "'" +
            ", typeservice='" + getTypeservice() + "'" +
            "}";
    }
}
