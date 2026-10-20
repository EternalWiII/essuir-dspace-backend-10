package org.dspace.app.rest;

import org.dspace.content.Chair;
import org.dspace.app.rest.ChairDAO;
import org.dspace.core.AbstractHibernateDSODAO;
import org.dspace.core.Context;
import org.springframework.stereotype.Repository;
import java.util.UUID;

import jakarta.persistence.Query;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ChairDAOImpl extends AbstractHibernateDSODAO<Chair> implements ChairDAO {

    @Override
    public Chair findByChairId(Context context, int chairId) throws SQLException {
        Query query = createQuery(context, "SELECT c FROM Chair c WHERE chairId = :chairId");
        query.setParameter("chairId", chairId);
        List<Chair> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public List<String> findall(Context context) throws SQLException {
        Query query = createQuery(context, "SELECT c.chairName FROM Chair c");
        return query.getResultList();
    }

    @Override
    public List<Chair> findByFacultyId(Context context, int facultyId) throws SQLException {
        Query query = createQuery(context, "SELECT c FROM Chair c WHERE c.facultyId = :facultyId");
        query.setParameter("facultyId", facultyId);
        return query.getResultList();
    }
}
