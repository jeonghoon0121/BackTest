package com.ohgiraffers.section02.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WorkoutDAO extends MemberDAO{
    private Properties prop = new Properties();

    public WorkoutDAO() {
        try {
            prop.loadFromXML(new FileInputStream("C:\\lecture\\BackE\\BackTest\\jdbc-crud-practice\\src\\main\\java\\com\\ohgiraffers\\mapper\\member-query.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
