package com.sabs.backendproject.services;

import com.sabs.backendproject.exceptions.GetIdLessThanOneException;
import com.sabs.backendproject.exceptions.GetIdNullException;
import com.sabs.backendproject.models.GreatVowLampModel;
import com.sabs.backendproject.repos.GreatVowLampRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class GreatVowLampService {

    // repository
    @Autowired
    private GreatVowLampRepo itemRepo;

    // === CRUD ===
    // 1. Read all entries of great vow lamp
    public List<GreatVowLampModel> getAllGreatVowLamps() {
        return itemRepo.findAll(Sort.by("createdAt").descending());
    }

    // 2. Read entry of great vow lamp with particular id
    public GreatVowLampModel getGreatVowLamp(Long id) {
        if (id == null)   throw new GetIdNullException("GreatVowLamp id " + id + " and it's required to update!");
        if (id <= 0)   throw new GetIdLessThanOneException("GreatVowLamp id " + id + " is less than one!");

        return itemRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("GreatVowLamp id " + id + " is not found!"));
    }

    // 3. Create new entry of great vow lamp
    public GreatVowLampModel addGreatVowLamp(GreatVowLampModel item) {
        return itemRepo.save(item);
    }

    // 4. Update entry of great vow lamp with particular id
    public GreatVowLampModel updateGreatVowLamp(GreatVowLampModel item) {
        GreatVowLampModel itemGet = getGreatVowLamp(item.getId());
        item.setCreatedAt(itemGet.getCreatedAt());
        return itemRepo.save(item);
    }

    // 5. Delete entry of great vow lamp with particular id
    public GreatVowLampModel deleteGreatVowLamp(Long id) {
        GreatVowLampModel itemTemp = getGreatVowLamp(id);
        itemRepo.deleteById(id);
        return itemTemp;
    }

}
