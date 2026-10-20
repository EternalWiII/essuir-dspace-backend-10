package org.dspace.app.rest;

import org.dspace.core.Context;
import org.dspace.content.Chair;
import java.util.List;
import java.util.UUID;

import java.sql.SQLException;

public interface ChairDAO {
    Chair findByChairId(Context context, int chairId) throws SQLException;
    List<String> findall(Context context) throws SQLException;
    List<Chair> findByFacultyId(Context context, int facultyId) throws SQLException;
}
