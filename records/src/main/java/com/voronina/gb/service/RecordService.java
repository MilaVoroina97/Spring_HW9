package com.voronina.gb.service;

import com.voronina.gb.model.Record;
import com.voronina.gb.repository.RecordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;


    public List<Record> getAll(){
        return recordRepository.getAll();
    }

    public Record saveAct(Record record){
        return recordRepository.save(record);
    }

    public void deleteById(int id){
        recordRepository.deleteById(id);
    }

    public Record getOneRecord(int id)  {
        return recordRepository.getOneRecord(id);
    }

    public Record updateRecord(Record record){
        return recordRepository.updateAct(record);
    }

}
