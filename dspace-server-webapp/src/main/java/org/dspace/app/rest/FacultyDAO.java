package org.dspace.app.rest;

import org.dspace.content.Faculty;
import org.dspace.core.Context;
import java.sql.SQLException;
import java.util.List;

public interface FacultyDAO {
    List<Faculty> findall(Context context) throws SQLException;
    Faculty findByFacultyId(Context context, int facultyId) throws SQLException;
}
