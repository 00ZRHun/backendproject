package com.sabs.backendproject.services;

import com.sabs.backendproject.exceptions.GetIdLessThanOneException;
import com.sabs.backendproject.exceptions.GetIdNullException;
import com.sabs.backendproject.models.DevoteeModel;
import com.sabs.backendproject.repos.DevoteeRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class DevoteeService {

    // repository
    @Autowired
    private DevoteeRepo itemRepo;

    // === CRUD ===
    // 1. Read all entries of devotee
    public List<DevoteeModel> getAllDevotees() {
        return itemRepo.findAll(Sort.by("createdAt").descending());
    }

    // 2. Read entry of devotee with particular id
    public DevoteeModel getDevotee(Long id) {
        if (id == null)   throw new GetIdNullException("Devotee id " + id + " and it's required to update!");
        if (id <= 0)   throw new GetIdLessThanOneException("Devotee id " + id + " is less than one!");

        return itemRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Devotee id " + id + " is not found!"));
    }

    // 3. Create new entry of devotee
    public DevoteeModel addDevotee(DevoteeModel item) {
        return itemRepo.save(item);
    }

    // 4. Update entry of devotee with particular id
    public DevoteeModel updateDevotee(DevoteeModel item) {
        DevoteeModel itemGet = getDevotee(item.getId());
        item.setCreatedAt(itemGet.getCreatedAt());
        return itemRepo.save(item);
    }

    // 5. Delete entry of devotee with particular id
    public DevoteeModel deleteDevotee(Long id) {
        DevoteeModel itemTemp = getDevotee(id);
        itemRepo.deleteById(id);
        return itemTemp;
    }

}
