package org.dspace.app.rest;

import org.dspace.content.Faculty;
import org.dspace.app.rest.FacultyDAO;
import org.dspace.app.rest.FacultyService;
import org.dspace.core.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

import java.sql.SQLException;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    private FacultyDAO facultyDAO;

    @Override
    public List<Faculty> findall(Context context) throws SQLException {
        return facultyDAO.findall(context);
    }

    @Override
    public Faculty findByFacultyId(Context context, int facultyId) throws SQLException {
        return facultyDAO.findByFacultyId(context, facultyId);
    }
}
