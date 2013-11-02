package se.jpl.t.sensors.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import se.jpl.t.sensors.domain.SensorSample;
import se.jpl.t.sensors.domain.SensorType;

@Service
public class SensorSampleService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public void save(SensorSample sample) {
        jdbcTemplate.update("insert into sample (ts, value, type, name) values (?, ?, ?, ?)", sample.getTimestamp(), sample.getValue(), sample.getType().toString(), sample.getName());  
    }
    
    public SensorSample getOne() {
        SensorSample sample = jdbcTemplate.queryForObject(
                " select ts, updated, value, type, name from sample limit 1",
                new RowMapper<SensorSample>() {
                    public SensorSample mapRow(ResultSet rs, int rowNum) throws SQLException {
                        SensorSample sample = new SensorSample();
                        sample.setTimestamp(rs.getDate("ts"));
                        sample.setUpdated(rs.getDate("updated"));
                        sample.setValue(rs.getFloat("value"));
                        sample.setType(SensorType.valueOf(rs.getString("type")));
                        sample.setName(rs.getString("name"));
                        return sample;
                    }
                });
        return sample;
    }
}
