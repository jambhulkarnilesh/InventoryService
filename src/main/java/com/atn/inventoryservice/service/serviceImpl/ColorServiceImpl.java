package com.atn.inventoryservice.service.serviceImpl;

import com.atn.inventoryservice.model.Color;
import com.atn.inventoryservice.repository.ColorRepository;
import com.atn.inventoryservice.response.ColorResponse;
import com.atn.inventoryservice.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {
    @Autowired
    private ColorRepository colorRepository;

    @Override
    public List<ColorResponse> findAllColors() {
        List<Color> colors = colorRepository.findAll();
        List<ColorResponse> colorResponses = new ArrayList<>();

        for (Color color : colors) {
            ColorResponse response = new ColorResponse();
            response.setColorId(color.getColorId());
            response.setColorName(color.getColorName());
            response.setStatusCd(color.getStatusCd());
            colorResponses.add(response);
        }
        return colorResponses;
    }
}
