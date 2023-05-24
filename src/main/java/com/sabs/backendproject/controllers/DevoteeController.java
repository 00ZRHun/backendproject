package com.sabs.backendproject.controllers;

import com.sabs.backendproject.dtos.DevoteeDto;
import com.sabs.backendproject.exceptions.GetIdLessThanOneException;
import com.sabs.backendproject.models.DevoteeModel;
import com.sabs.backendproject.services.DevoteeService;
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
@RequestMapping(value = "/api/v1/devotee")
public class DevoteeController {

    @Autowired
    private DevoteeService itemService;

    @Autowired
    private ModelMapper modelMapper;

    // === CRUD ===
    // 1. Get all devotees
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<List<DevoteeDto>> getAllDevotees() {
        List<DevoteeDto> items = itemService.getAllDevotees()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        if (items.size() > 0) {
            return new ResponseEntity<>(items, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        }
    }

    // 2. Get individual devotee
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<DevoteeDto> getDevotee(@PathVariable Long id) throws GetIdLessThanOneException {
        DevoteeModel itemGet = itemService.getDevotee(id);
        return new ResponseEntity<>(convertToDto(itemGet), HttpStatus.OK);   // convert entity to DTO
    }

    // 3. Add new devotee
    @PostMapping(value = "/create", consumes = {"application/json"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<DevoteeDto> addDevotee(@RequestBody DevoteeDto itemDto) {
        DevoteeModel item = convertToEntity(itemDto);
        DevoteeModel itemCreated = itemService.addDevotee(item);

        if (itemCreated==null) {
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        } else {
            return new ResponseEntity<>(convertToDto(itemCreated), HttpStatus.CREATED);
        }
    }

    // 4. Update devotee by id
    @PatchMapping(value = "/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public ResponseEntity<DevoteeDto> updateDevotee(@RequestBody DevoteeDto itemDto) throws UnsupportedEncodingException, GetIdLessThanOneException {
        DevoteeModel item = convertToEntity(itemDto);
        DevoteeModel itemUpdated = itemService.updateDevotee(item);
        return new ResponseEntity<>(convertToDto(itemUpdated), HttpStatus.OK);
    }

    // 5. Delete devotee by id
    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public ResponseEntity<DevoteeDto> deleteItem(@PathVariable Long id) throws UnsupportedEncodingException, GetIdLessThanOneException {
        DevoteeModel itemDeleted = itemService.deleteDevotee(id);
        return new ResponseEntity<>(convertToDto(itemDeleted), HttpStatus.OK);
    }

    // === DTO ===
    // 1. JPA Entity models to DTO
    private DevoteeDto convertToDto(DevoteeModel item) {
        return modelMapper.map(item, DevoteeDto.class);
    }

    // 2. DTO to JPA Entity models
    private DevoteeModel convertToEntity(DevoteeDto itemDto) {
        return modelMapper.map(itemDto, DevoteeModel.class);
    }

}
