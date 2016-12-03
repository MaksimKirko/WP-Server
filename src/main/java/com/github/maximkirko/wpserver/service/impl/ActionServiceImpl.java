package com.github.maximkirko.wpserver.service.impl;

import com.github.maximkirko.wpserver.dao.api.IActionDao;
import com.github.maximkirko.wpserver.datamodel.action.Action;
import com.github.maximkirko.wpserver.datamodel.action.ActionEnum;
import com.github.maximkirko.wpserver.service.api.IActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MadMax on 28.11.2016.
 */

@Service
public class ActionServiceImpl implements IActionService {

    @Autowired
    private IActionDao actionDao;

    @Override
    public Action getById(Long id) {
        return actionDao.getById(id);
    }

    @Override
    public Action getByType(ActionEnum type) {
        return actionDao.getByType(type);
    }

    @Override
    public List<Action> getAll() {
        return actionDao.getAll();
    }

    @Override
    public Long save(Action action) {

        Long id = null;

        if (action.getId() == null) {
            id = actionDao.insert(action);
        } else {
            id = actionDao.update(action);
        }
        return id;
    }

    @Override
    public void saveAll(List<Action> actionList) {
        for (Action action : actionList) {
            save(action);
        }
    }

    @Override
    public void delete(Long id) {
        actionDao.deleteById(id);
    }
}