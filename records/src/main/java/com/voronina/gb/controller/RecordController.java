package com.voronina.gb.controller;

import com.voronina.gb.model.Record;
import com.voronina.gb.service.RecordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class RecordController {

    private final RecordService recordService;

    @GetMapping("/records")
    public String getAll(Model model) {
        List<Record> records = recordService.getAll();


        model.addAttribute("records", records);
        return "records - list";
    }

    @GetMapping("/record-create")
    public String createRecordForm(Record record) {
        return "record-create";
    }

    @PostMapping("/record-create")
    public String createRecord(Record record) {
        recordService.saveAct(record);
        return "redirect:/records";
    }

    @GetMapping("/record-delete/{id}")
    public String deleteRecord(@PathVariable("id") int id) {
        recordService.deleteById(id);
        return "redirect:/records";
    }

    @GetMapping("/record-update/{id}")
    public String getOneRecord(@PathVariable("id") int id, Model model) {
        Record record = recordService.getOneRecord(id);
        model.addAttribute("record", record);
        return "record-update";
    }

    @PostMapping("/record-update")
    public String updateRecord(Record record) {
        recordService.updateRecord(record);
        return "redirect:/records";
    }
}
