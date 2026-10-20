package org.dspace.app.rest;

import org.dspace.content.Chair;
import org.dspace.app.rest.ChairDAO;
import org.dspace.app.rest.ChairService;
import org.dspace.core.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

import java.sql.SQLException;

@Service
public class ChairServiceImpl implements ChairService {

    @Autowired
    private ChairDAO chairDAO;

    @Override
    public Chair findByChairId(Context context, int chairId) throws SQLException {
        return chairDAO.findByChairId(context, chairId);
    }

    @Override
    public List<String> findall(Context context) throws SQLException {
        return chairDAO.findall(context);
    }

    @Override
    public List<Chair> findByFacultyId(Context context, int facultyId) throws SQLException {
        return chairDAO.findByFacultyId(context, facultyId);
    }
}
