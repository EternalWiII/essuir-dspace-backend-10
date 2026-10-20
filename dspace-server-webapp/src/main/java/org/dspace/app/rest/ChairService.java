package org.dspace.app.rest;

import org.dspace.content.Chair;
import org.dspace.core.Context;
import java.util.List;
import java.util.UUID;

import java.sql.SQLException;

public interface ChairService {
    Chair findByChairId(Context context, int chairId) throws SQLException;
    List<String> findall(Context context) throws SQLException;
    List<Chair> findByFacultyId(Context context, int facultyId) throws SQLException;
}
