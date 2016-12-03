package com.github.maximkirko.wpserver.service.impl;

import com.github.maximkirko.wpserver.dao.api.IViolationDao;
import com.github.maximkirko.wpserver.datamodel.violation.Violation;
import com.github.maximkirko.wpserver.datamodel.violation.ViolationEnum;
import com.github.maximkirko.wpserver.service.api.IViolationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MadMax on 28.11.2016.
 */
@Service
public class ViolationServiceImpl implements IViolationService {

    @Autowired
    private IViolationDao violationDao;

    @Override
    public Violation getById(Long id) {
        return violationDao.getById(id);
    }

    @Override
    public Violation getByType(ViolationEnum type) {
        return violationDao.getByType(type);
    }

    @Override
    public List<Violation> getAll() {
        return violationDao.getAll();
    }

    @Override
    public Long save(Violation violation) {

        Long id = null;

        if (violation.getId() == null) {
            id = violationDao.insert(violation);
        } else {
            id = violationDao.update(violation);
        }
        return id;
    }

    @Override
    public void saveAll(List<Violation> violationList) {
        for (Violation violation : violationList) {
            save(violation);
        }
    }

    @Override
    public void delete(Long id) {
        violationDao.deleteById(id);
    }
}
