package se.jpl.t.vader.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import se.jpl.t.vader.domain.SensorSample;

public class SensorSampleRowMapper implements RowMapper<SensorSample> {
    @Override
    public SensorSample mapRow(ResultSet rs, int rowNum) throws SQLException {
            SensorSample sample = new SensorSample();
            sample.setTimestamp(rs.getDate("ts"));
            sample.setUpdated(rs.getDate("updated"));
            sample.setValue(rs.getFloat("value"));
            sample.setType(SensorType.valueOf(rs.getString("type")));
            sample.setName(rs.getString("name"));
            return sample;
    }
}
