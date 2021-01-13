package com.example.demo.service;

import com.example.demo.dto.DLCDTO;

import java.util.List;

public interface DLCService {
    DLCDTO getDLCById(Long id);
    List<DLCDTO> getAllDLCs();
    DLCDTO createDLC(DLCDTO dlcDTO, Long id);
    DLCDTO updateDLC(DLCDTO dlcDTO);
    void deleteDLCById(Long id);


}