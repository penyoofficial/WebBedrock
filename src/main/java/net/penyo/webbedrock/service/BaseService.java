package net.penyo.webbedrock.service;

import net.penyo.webbedrock.mapper.BaseMapper;

import java.util.List;

/**
 * An executor which provides data interaction.
 *
 * @author Penyo
 */
public interface BaseService<PO> {

    BaseMapper<PO> getMapper();

    default String insert(PO obj) {
        int affected = 0;
        try {
            affected = getMapper().insert(obj);
        } catch (Exception _) {
        }
        return affected != 0 ? "添加成功" : "添加失败";
    }

    default String delete(int id) {
        return getMapper().delete(id) != 0 ? "删除成功" : "添加失败";
    }

    default String update(PO obj) {
        int affected = 0;
        try {
            affected = getMapper().update(obj);
        } catch (Exception _) {
        }
        return affected != 0 ? "修改成功" : "修改失败";
    }

    default List<PO> query(PO obj) {
        return getMapper().query(obj);
    }
}
