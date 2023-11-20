package com.ohgiraffers.section01.xmlconfig.model;

import com.ohgiraffers.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {

    public List<MenuDTO> selectAllMenu(SqlSession sqlSession){
        return sqlSession.selectList("MemuMapper.selectAllMenu");
    }

    public MenuDTO selectByMenuCode(SqlSession session, int code) {
        return session.selectOne("MemuMapper.selectByMenuCode", code);
    }

    public int registMenu(SqlSession session, MenuDTO menu) {
        return session.insert("MemuMapper.insert",menu);
    }

    public int modifyMenu(SqlSession session, MenuDTO menu) {
        return session.update("MemuMapper.modifyMenu", menu);
    }

    public int deleteMenu(SqlSession session, int code) {
        return session.delete("MemuMapper.deleteMenu", code);
    }
}
