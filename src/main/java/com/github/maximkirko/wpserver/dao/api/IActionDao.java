package com.github.maximkirko.wpserver.dao.api;


import com.github.maximkirko.wpserver.datamodel.action.Action;
import com.github.maximkirko.wpserver.datamodel.action.ActionEnum;

import java.util.List;

/**
 * Created by MadMax on 28.11.2016.
 */
public interface IActionDao {

    Action getById(Long id);

    List<Action>  getByType(ActionEnum type);

    List<Action> getAll();

    Long insert(Action action);

    Long update(Action action);

    void deleteById(Long id);
}
