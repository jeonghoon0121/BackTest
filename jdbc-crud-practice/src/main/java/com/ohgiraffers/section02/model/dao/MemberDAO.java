package com.ohgiraffers.section02.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;

public class MemberDAO {
    private Properties prop = new Properties();

    public MemberDAO() {
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int selectLastMemberCode(Connection con) {

        Statement stmt = null;
        ResultSet rset = null;

        int maxMemberCode = 0;

        String query = prop.getProperty("selectLastMemberCode");

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            if(rset.next()) {
                maxMemberCode = rset.getInt("MAX(A.MEM_ID)");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
        }

        return maxMemberCode;
    }

}
