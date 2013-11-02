package se.jpl.t.sensors.domain;

import java.util.Date;

public class SensorSample {
    private String name;
    private float value;
    private SensorType type;
    private Date timestamp;
    private Date updated;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getValue() {
        return value;
    }
    public void setValue(float value) {
        this.value = value;
    }
    public SensorType getType() {
        return type;
    }
    public void setType(SensorType type) {
        this.type = type;
    }
    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    public Date getUpdated() {
        return updated;
    }
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}

