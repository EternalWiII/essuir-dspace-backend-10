package org.dspace.content;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import java.util.UUID;

@Entity
@Table(name = "faculty")
public class Faculty extends DSpaceObject {

    @Column(name = "faculty_id")
    private int facultyId;

    @Column(name = "faculty_name")
    private String facultyName;

    public int getFacultyId() {
        return facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    @Override
    public String getName() {
        return facultyName;
    }

    @Override
    public int getType() {
        return 778;
    }
}
