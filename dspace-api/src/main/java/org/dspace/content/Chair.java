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
@Table(name = "chair")
public class Chair extends DSpaceObject {

    @Column(name = "chair_id")
    private int chairId;

    @Column(name = "chair_name")
    private String chairName;

    @Column(name = "faculty_id")
    private int facultyId;

    protected Chair() {}

    public int getChairId() {
        return chairId;
    }

    public void setChairId(int chairId) {
        this.chairId = chairId;
    }

    public String getChairName() {
        return chairName;
    }

    public void setChairName(String chairName) {
        this.chairName = chairName;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public int getFacultyId() {
        return facultyId;
    }

    // Override getName from DSpaceObject
    @Override
    public String getName() {
        return chairName;
    }

    // Override getType from DSpaceObject
    @Override
    public int getType() {
        return 777;
    }
}
