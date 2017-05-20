package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.Chapter;
import com.newlecture.web.entity.Unit;

public interface UnitDao {
    List<Unit> getList(String chapterId);
    List<Unit> getList();
    List<Unit> getList(int page, String field, String query);
    List<Unit> getList(int page);
    Unit get(String id);

    int add(Unit unit);
    int   update(Unit unit);
    int delete(String id);
}
