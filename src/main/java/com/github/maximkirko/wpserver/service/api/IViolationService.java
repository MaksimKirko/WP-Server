package com.github.maximkirko.wpserver.service.api;

import com.github.maximkirko.wpserver.datamodel.violation.Violation;
import com.github.maximkirko.wpserver.datamodel.violation.ViolationEnum;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MadMax on 28.11.2016.
 */
public interface IViolationService {

    Violation getById(Long id);

    Violation getByType(ViolationEnum type);

    List<Violation> getAll();

    @Transactional
    Long save(Violation violation);

    @Transactional
    void saveAll(List<Violation> violationList);

    @Transactional
    void delete(Long id);
}
