package com.pfe.covite.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.pfe.covite.domain.enumeration.Categorie;
import com.pfe.covite.domain.enumeration.Service;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.LocalDateFilter;

/**
 * Criteria class for the {@link com.pfe.covite.domain.Commande} entity. This class is used
 * in {@link com.pfe.covite.web.rest.CommandeResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /commandes?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class CommandeCriteria implements Serializable, Criteria {
    /**
     * Class for filtering Categorie
     */
    public static class CategorieFilter extends Filter<Categorie> {

        public CategorieFilter() {
        }

        public CategorieFilter(CategorieFilter filter) {
            super(filter);
        }

        @Override
        public CategorieFilter copy() {
            return new CategorieFilter(this);
        }

    }
    /**
     * Class for filtering Service
     */
    public static class ServiceFilter extends Filter<Service> {

        public ServiceFilter() {
        }

        public ServiceFilter(ServiceFilter filter) {
            super(filter);
        }

        @Override
        public ServiceFilter copy() {
            return new ServiceFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private LocalDateFilter date;

    private FloatFilter prix;

    private CategorieFilter type;

    private ServiceFilter typeservice;

    private LongFilter vehiculeId;

    private LongFilter positionId;

    public CommandeCriteria() {
    }

    public CommandeCriteria(CommandeCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.date = other.date == null ? null : other.date.copy();
        this.prix = other.prix == null ? null : other.prix.copy();
        this.type = other.type == null ? null : other.type.copy();
        this.typeservice = other.typeservice == null ? null : other.typeservice.copy();
        this.vehiculeId = other.vehiculeId == null ? null : other.vehiculeId.copy();
        this.positionId = other.positionId == null ? null : other.positionId.copy();
    }

    @Override
    public CommandeCriteria copy() {
        return new CommandeCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public LocalDateFilter getDate() {
        return date;
    }

    public void setDate(LocalDateFilter date) {
        this.date = date;
    }

    public FloatFilter getPrix() {
        return prix;
    }

    public void setPrix(FloatFilter prix) {
        this.prix = prix;
    }

    public CategorieFilter getType() {
        return type;
    }

    public void setType(CategorieFilter type) {
        this.type = type;
    }

    public ServiceFilter getTypeservice() {
        return typeservice;
    }

    public void setTypeservice(ServiceFilter typeservice) {
        this.typeservice = typeservice;
    }

    public LongFilter getVehiculeId() {
        return vehiculeId;
    }

    public void setVehiculeId(LongFilter vehiculeId) {
        this.vehiculeId = vehiculeId;
    }

    public LongFilter getPositionId() {
        return positionId;
    }

    public void setPositionId(LongFilter positionId) {
        this.positionId = positionId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CommandeCriteria that = (CommandeCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(date, that.date) &&
            Objects.equals(prix, that.prix) &&
            Objects.equals(type, that.type) &&
            Objects.equals(typeservice, that.typeservice) &&
            Objects.equals(vehiculeId, that.vehiculeId) &&
            Objects.equals(positionId, that.positionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        date,
        prix,
        type,
        typeservice,
        vehiculeId,
        positionId
        );
    }

    @Override
    public String toString() {
        return "CommandeCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (date != null ? "date=" + date + ", " : "") +
                (prix != null ? "prix=" + prix + ", " : "") +
                (type != null ? "type=" + type + ", " : "") +
                (typeservice != null ? "typeservice=" + typeservice + ", " : "") +
                (vehiculeId != null ? "vehiculeId=" + vehiculeId + ", " : "") +
                (positionId != null ? "positionId=" + positionId + ", " : "") +
            "}";
    }

}
