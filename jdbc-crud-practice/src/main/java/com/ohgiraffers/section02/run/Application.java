package com.ohgiraffers.section02.run;

import com.ohgiraffers.section02.model.dao.MemberDAO;
import com.ohgiraffers.section02.model.dao.MenuDAO;
import com.ohgiraffers.section02.model.dto.MemberDTO;
import com.ohgiraffers.section02.model.dto.MenuDTO;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application {

    public static void main(String[] args) {

        /*1.Create MEMBER, WORKOUT, EXERCISE*/
        /*2.Read All ALL */
        /*3.Read ONE MEMBER */
        /*4.Update MEMBER, WORKOUT, EXERCISE*/
        /*5.Delete*/


        Connection con = getConnection();
        MemberDAO registDAO = new MemberDAO();
        int maxMemberCode = registDAO.selectLastMemberCode(con);
        System.out.println("maxMemberCode = " + maxMemberCode);

    }
}
