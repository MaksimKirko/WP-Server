package com.github.maximkirko.wpserver.dao.api;


import com.github.maximkirko.wpserver.datamodel.violation.Violation;
import com.github.maximkirko.wpserver.datamodel.violation.ViolationEnum;

import java.util.List;

/**
 * Created by MadMax on 28.11.2016.
 */
public interface IViolationDao {

    Violation getById(Long id);

    public Violation getByType(ViolationEnum type);

    List<Violation> getAll();

    Long insert(Violation violation);

    Long update(Violation violation);

    void deleteById(Long id);
}
