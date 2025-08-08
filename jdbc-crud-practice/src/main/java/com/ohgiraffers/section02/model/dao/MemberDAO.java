package com.ohgiraffers.section02.model.dao;

import com.ohgiraffers.section02.model.dto.MemberDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import static com.ohgiraffers.common.JDBCTemplate.close;

public class MemberDAO {
    private Properties prop = new Properties();

    public MemberDAO() {
        try {
            prop.loadFromXML(new FileInputStream("C:\\lecture\\BackE\\BackTest\\jdbc-crud-practice\\src\\main\\java\\com\\ohgiraffers\\mapper\\member-query.xml"));
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

    public List<Map<Integer, String>> selectAllMember(Connection con){
        Statement stmt = null;
        ResultSet rset = null;
        List<Map<Integer, String>> memberList = null;

        String query = prop.getProperty("selectAllMemberList");

        try {
            stmt=con.createStatement();
            rset=stmt.executeQuery(query);
            memberList=new ArrayList<>();
            while(rset.next()){
                Map<Integer, String> memberlist=new HashMap<>();
                memberlist.put(rset.getInt("MEM_ID"), rset.getString("MEM_NM"));
                memberList.add(memberlist);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally{
            close(rset);
            close(stmt);
        }
        return memberList;
    }
    public MemberDTO selectMemberById(int memberId, Connection con) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        MemberDTO member = null;
        String query = prop.getProperty("selectMemberById");
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, memberId);
            rset = pstmt.executeQuery();
            if (rset.next()) {
                member = new MemberDTO(
                        rset.getInt("MEM_ID"),
                        rset.getString("MEM_NM"),
                        rset.getDate("MEM_DATE")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("회원 조회 실패", e);
        } finally {
            close(rset);
            close(pstmt);
        }
        return member;
    }


    public int insertNewMember(MemberDTO newMem, Connection con) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("insertMember");
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, newMem.getMemberID());
            pstmt.setString(2, newMem.getMemberName());
            pstmt.setDate(3, new java.sql.Date(newMem.getMemberDate().getTime()));

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }

    public int deleteMember(int num, Connection con) {
        MemberDTO Mem=new MemberDTO();
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("deleteMember");
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, num);
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }

}
