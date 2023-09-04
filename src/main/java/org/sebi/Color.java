package org.sebi;

import java.util.List;

import org.hibernate.annotations.Type;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "byVector", resultClass = Color.class, query = "SELECT * FROM Color ORDER BY rgb <-> cast(:vector as vector) LIMIT 5")
public class Color extends PanacheEntity {

    @Column(columnDefinition = "vector(3)")
    @Type(JsonType.class)
    public List<Double> rgb;

    public static List<Color> findNearestNeighbors(String vector) {
     return   getEntityManager().createNamedQuery("byVector", Color.class).setParameter("vector",vector).getResultList();   
    }
}
