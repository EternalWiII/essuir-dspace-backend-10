package org.dspace.app.rest;

import org.dspace.content.Faculty;
import org.dspace.app.rest.FacultyDAO;
import org.dspace.core.AbstractHibernateDSODAO;
import org.dspace.core.Context;
import org.springframework.stereotype.Repository;
import java.util.UUID;

import jakarta.persistence.Query;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FacultyDAOImpl extends AbstractHibernateDSODAO<Faculty> implements FacultyDAO {
    @Override
    public List<Faculty> findall(Context context) throws SQLException {
        Query query = createQuery(context, "SELECT f FROM Faculty f");
        return query.getResultList();
    }

    @Override
    public Faculty findByFacultyId(Context context, int facultyId) throws SQLException {
        Query query = createQuery(context, "SELECT f FROM Faculty f WHERE facultyId = :facultyId");
        query.setParameter("facultyId", facultyId);
        List<Faculty> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }
}
