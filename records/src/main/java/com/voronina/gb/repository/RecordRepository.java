package com.voronina.gb.repository;

import com.voronina.gb.config.DBScript;
import com.voronina.gb.model.Record;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.lang.reflect.Field;
import java.util.List;

@Repository
@AllArgsConstructor
public class RecordRepository {

    private final JdbcTemplate jdbc;
    private final DBScript dbScripts;


    public List<Record> getAll() {
        return jdbc.query(dbScripts.getGetAll(), newActRowMapper());
    }

    public Record save(Record record) {
        jdbc.update(dbScripts.getSave(), record.getTitle(), record.getTitle(), record.getCreatedDate());
        return record;
    }

    public void deleteById(int id) {
        jdbc.update(dbScripts.getDeleteById(), id);
    }

    public Record getOneRecord(int id) {
        return jdbc.queryForObject(dbScripts.getGetOneRecord(), newActRowMapper(), id);
    }

    public Record updateAct(Record record) {
        jdbc.update(dbScripts.getUpdateRecord(), record.getTitle(), record.getContent(), record.getCreatedDate());
        return record;
    }

    private RowMapper<Record> newActRowMapper() {

        return (r, i) -> {
            Record rowObject = new Record();
            Class<? extends Record> act = rowObject.getClass();
            Field[] fields = act.getDeclaredFields();
            rowObject.setId(r.getInt(fields[0].getName()));
            rowObject.setTitle(r.getString(fields[1].getName()));
            rowObject.setContent(r.getString(fields[2].getName()));
            rowObject.setCreatedDate(r.getString(fields[3].getName()));
            return rowObject;
        };
    }
}
