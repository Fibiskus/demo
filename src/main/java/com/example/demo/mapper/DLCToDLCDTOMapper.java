package com.example.demo.mapper;


import com.example.demo.dto.DLCDTO;
import com.example.demo.entity.DLC;
import org.springframework.stereotype.Component;

@Component
public class DLCToDLCDTOMapper {
    public DLC toEntity(final DLCDTO dlcDTO) {
        final DLC dlc = new DLC();

        dlc.setId(dlcDTO.getId());
        dlc.setName(dlcDTO.getName());
        dlc.setDescription(dlcDTO.getDescription());
        dlc.setCost(dlcDTO.getCost());

        return dlc;
    }

    public DLCDTO toDto(final DLC dlc) {
        final DLCDTO dlcDTO = new DLCDTO();

        dlcDTO.setId(dlc.getId());
        dlcDTO.setName(dlc.getName());
        dlcDTO.setDescription(dlc.getDescription());
        dlcDTO.setCost(dlc.getCost());

        return dlcDTO;
    }
}
