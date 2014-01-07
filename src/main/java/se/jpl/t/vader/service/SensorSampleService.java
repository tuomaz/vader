package se.jpl.t.vader.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import se.jpl.t.vader.domain.SensorSample;
import se.jpl.t.vader.domain.SensorSampleRowMapper;

@Service
public class SensorSampleService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public void save(SensorSample sample) {
        jdbcTemplate.update("insert into sample (ts, value, type, name) values (?, ?, ?, ?)", sample.getTimestamp(), sample.getValue(), sample.getType().toString(), sample.getName());  
    }
    
    public SensorSample getOne() {
        SensorSample sample = jdbcTemplate.queryForObject(
                " select ts, updated, value, type, name from sample limit 1", new SensorSampleRowMapper());
        return sample;
    }    

    public List<SensorSample> getRecent() {
        long currentTime = System.currentTimeMillis();
        long recent = currentTime - (1000 * 60 * 7);
        Date date = new Date(recent);
        return jdbcTemplate.query("select ts, updated, value, type, name from sample where ts > ? and id in (select * from (select max(id) from sample where ts > ? group by name) as ids)", new SensorSampleRowMapper(), date, date);
    }
}
