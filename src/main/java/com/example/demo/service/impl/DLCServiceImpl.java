package com.example.demo.service.impl;

import com.example.demo.dto.DLCDTO;
import com.example.demo.exception.FormatException;
import com.example.demo.exception.HTTP;
import com.example.demo.mapper.DLCToDLCDTOMapper;
import com.example.demo.repository.DLCRepository;
import com.example.demo.repository.GameRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.DLCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DLCServiceImpl implements DLCService {

    @Autowired
    private DLCRepository dlcRepository;

    @Autowired
    private DLCToDLCDTOMapper dlcMapper;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private UserRepository userRepository;

    @Override

    public DLCDTO getDLCById(final Long id) {
        return dlcMapper.toDto(dlcRepository.getDLCById(id));
    }

    @Override
    public List<DLCDTO> getAllDLCs() {
        return dlcRepository.getAllDLCs().stream()
                .map(e -> dlcMapper.toDto(e))
                .collect(Collectors.toList());
    }


    @Override
    public DLCDTO createDLC(final DLCDTO dlcDTO, final Long id) {

        if (dlcDTO.getId() != null) {
            throw new FormatException("DLC shouldn't have an id ", HTTP.HTTP_400);
        }

        return dlcMapper.toDto(dlcRepository.createDLC(dlcMapper.toEntity(dlcDTO), gameRepository.getGameById(id)));
    }

    @Override
    public DLCDTO updateDLC(final DLCDTO dlcDTO) {

        if (dlcDTO.getId() == null) {
            throw new FormatException("DLC should have an id ", HTTP.HTTP_400);
        }

        return dlcMapper.toDto(dlcRepository.updateDLC(dlcMapper.toEntity(dlcDTO)));
    }

    @Override
    public void deleteDLCById(final Long id) {
        dlcRepository.deleteDLCById(id);
    }
}