package com.example.demo.resource;

import com.example.demo.dto.DLCDTO;
import com.example.demo.service.DLCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DLCResource {
    @Autowired
    private DLCService dlcService;

    @GetMapping("/dlcs/{id}")
    public DLCDTO getDLCById(final @PathVariable Long id){
        return dlcService.getDLCById(id);
    }

    @GetMapping("/dlcs")
    public List<DLCDTO> getAllDLCs(){
        return dlcService.getAllDLCs();
    }


    @PostMapping("/dlcs/{id}")
    public DLCDTO createDLC(final @Valid @RequestBody DLCDTO dlcDTO, final @PathVariable Long id){
        return dlcService.createDLC(dlcDTO, id);
    }

    @PutMapping("/dlcs")
    public DLCDTO updateDLC(final @Valid @RequestBody DLCDTO dlcDTO){
        return dlcService.updateDLC(dlcDTO);
    }

    @DeleteMapping("/dlcs/{id}")
    public void deleteDLCById(final @PathVariable Long id){
        dlcService.deleteDLCById(id);
    }
}
