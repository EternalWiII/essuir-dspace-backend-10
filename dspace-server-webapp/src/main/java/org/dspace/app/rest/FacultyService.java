package org.dspace.app.rest;

import org.dspace.content.Faculty;
import org.dspace.core.Context;
import java.util.List;
import java.util.UUID;

import java.sql.SQLException;

public interface FacultyService {
    List<Faculty> findall(Context context) throws SQLException;
    Faculty findByFacultyId(Context context, int facultyId) throws SQLException;
}
