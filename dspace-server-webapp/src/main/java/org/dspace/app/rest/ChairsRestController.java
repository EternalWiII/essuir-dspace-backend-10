package org.dspace.app.rest;

import org.dspace.app.rest.utils.ContextUtil;
import org.dspace.content.Item;
import org.dspace.core.Context;
import org.dspace.content.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Iterator;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.UUID;

import org.dspace.content.Chair;
import org.dspace.app.rest.ChairService;

@PreAuthorize("permitAll()")
@RestController
@RequestMapping("/api/chairs")
public class ChairsRestController {

    private final ChairService chairService;

    public ChairsRestController(ChairService chairService) {
        this.chairService = chairService;
    }

    @GetMapping
    public ResponseEntity<List<String>> getChairName(HttpServletRequest request) throws SQLException {
        Context context = ContextUtil.obtainContext(request);

        List<String> chairs = chairService.findall(context);
        if (chairs.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(chairs);
    }

    @GetMapping("/{chairId}")
    public Chair getChairById(@PathVariable("chairId") Integer chairId, HttpServletRequest request) throws SQLException {
        Context context = ContextUtil.obtainContext(request);
        Chair chair = chairService.findByChairId(context, chairId);
        if (chair == null) {
            return null;
        }
        return chair;
    }
}
