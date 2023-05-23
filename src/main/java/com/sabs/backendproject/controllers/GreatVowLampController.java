package com.sabs.backendproject.controllers;

import com.sabs.backendproject.exceptions.GetIdLessThanOneException;
import com.sabs.backendproject.dtos.GreatVowLampDto;
import com.sabs.backendproject.models.GreatVowLampModel;
import com.sabs.backendproject.services.GreatVowLampService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)   // TODO: can be removed?
@RestController
@RequestMapping(value = "/api/v1/greatvowlamp")
public class GreatVowLampController {

    @Autowired
    private GreatVowLampService itemService;

    @Autowired
    private ModelMapper modelMapper;

    // === CRUD ===
    // 1. Get all great vow lamps
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<List<GreatVowLampDto>> getAllGreatVowLamps() {
        List<GreatVowLampDto> items = itemService.getAllGreatVowLamps()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        if (items.size() > 0) {
            return new ResponseEntity<>(items, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        }
    }

    // 2. Get individual great vow lamp
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<GreatVowLampDto> getGreatVowLamp(@PathVariable Long id) throws GetIdLessThanOneException {
        GreatVowLampModel itemGet = itemService.getGreatVowLamp(id);
        return new ResponseEntity<>(convertToDto(itemGet), HttpStatus.OK);   // convert entity to DTO
    }

    // 3. Add new great vow lamp
    @PostMapping(value = "/create", consumes = {"application/json"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<GreatVowLampDto> addGreatVowLamp(@RequestBody GreatVowLampDto itemDto) {
        GreatVowLampModel item = convertToEntity(itemDto);
        GreatVowLampModel itemCreated = itemService.addGreatVowLamp(item);

        if (itemCreated==null) {
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        } else {
            return new ResponseEntity<>(convertToDto(itemCreated), HttpStatus.CREATED);
        }
    }

    // 4. Update great vow lamp by id
    @PatchMapping(value = "/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public ResponseEntity<GreatVowLampDto> updateGreatVowLamp(@RequestBody GreatVowLampDto itemDto) throws UnsupportedEncodingException, GetIdLessThanOneException {
        GreatVowLampModel item = convertToEntity(itemDto);
        GreatVowLampModel itemUpdated = itemService.updateGreatVowLamp(item);
        return new ResponseEntity<>(convertToDto(itemUpdated), HttpStatus.OK);
    }

    // 5. Delete great vow lamp by id
    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public ResponseEntity<GreatVowLampDto> deleteItem(@PathVariable Long id) throws UnsupportedEncodingException, GetIdLessThanOneException {
        GreatVowLampModel itemDeleted = itemService.deleteGreatVowLamp(id);
        return new ResponseEntity<>(convertToDto(itemDeleted), HttpStatus.OK);
    }

    // === DTO ===
    // 1. JPA Entity models to DTO
    private GreatVowLampDto convertToDto(GreatVowLampModel item) {
        return modelMapper.map(item, GreatVowLampDto.class);
    }

    // 2. DTO to JPA Entity models
    private GreatVowLampModel convertToEntity(GreatVowLampDto itemDto) {
        return modelMapper.map(itemDto, GreatVowLampModel.class);
    }

}
