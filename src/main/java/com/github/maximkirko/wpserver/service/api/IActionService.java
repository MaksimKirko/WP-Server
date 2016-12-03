package com.github.maximkirko.wpserver.service.api;

import com.github.maximkirko.wpserver.datamodel.action.Action;
import com.github.maximkirko.wpserver.datamodel.action.ActionEnum;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MadMax on 28.11.2016.
 */
public interface IActionService {

    Action getById(Long id);

    Action getByType(ActionEnum type);

    List<Action> getAll();

    @Transactional
    Long save(Action action);

    @Transactional
    void saveAll(List<Action> actionList);

    @Transactional
    void delete(Long id);
}
