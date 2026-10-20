package org.dspace.app.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import java.sql.SQLException;
import org.dspace.core.Context;
import org.dspace.app.rest.utils.ContextUtil;
import org.dspace.content.Faculty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PathVariable;
import org.dspace.content.Chair;

@PreAuthorize("permitAll()")
@RestController
@RequestMapping("/api/faculties")
public class FacultyRestController {
    private final ChairService chairService;
    private final FacultyService facultyService;

    public FacultyRestController(FacultyService facultyService, ChairService chairService) {
        this.facultyService = facultyService;
        this.chairService = chairService;
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllFaculties(HttpServletRequest request) throws SQLException {
        Context context = ContextUtil.obtainContext(request);
        List<Faculty> faculties = facultyService.findall(context);

        if (faculties.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<Map<String, Object>> response = faculties.stream()
            .map(faculty -> {
                Map<String, Object> facultyMap = new HashMap<>();
                facultyMap.put("faculty_id", faculty.getFacultyId());
                facultyMap.put("faculty_name", faculty.getName());
                return facultyMap;
            })
            .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{facultyId}/chairs")
    public ResponseEntity<List<Map<String, Object>>> getChairsByFaculty(
            @PathVariable("facultyId") Integer facultyId,
            HttpServletRequest request) throws SQLException {

        Context context = ContextUtil.obtainContext(request);
        List<Chair> chairs = chairService.findByFacultyId(context, facultyId);

        if (chairs.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<Map<String, Object>> response = chairs.stream()
            .map(chair -> {
                Map<String, Object> chairMap = new HashMap<String, Object>();
                chairMap.put("chair_id", chair.getChairId());
                chairMap.put("chair_name", chair.getName());
                return chairMap;
            })
            .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/by-chair/{chairId}")
    public ResponseEntity<Map<String, Object>> getFacultyByChairId(
            @PathVariable("chairId") Integer chairId,
            HttpServletRequest request) throws SQLException {

        Context context = ContextUtil.obtainContext(request);
        Chair chair = chairService.findByChairId(context, chairId);

        if (chair == null) {
            return ResponseEntity.notFound().build();
        }

        Faculty faculty = facultyService.findByFacultyId(context, chair.getFacultyId());

        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }

        Map<String, Object> facultyMap = new HashMap<>();
        facultyMap.put("faculty_id", faculty.getFacultyId());
        facultyMap.put("faculty_name", faculty.getName());

        return ResponseEntity.ok(facultyMap);
    }

}
