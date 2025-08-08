package com.ohgiraffers.section02.run;

import com.ohgiraffers.section02.model.dao.MemberDAO;
import com.ohgiraffers.section02.model.dto.MemberDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application {

    public static void main(String[] args) {
        /*1.Insert MEMBER, WORKOUT, EXERCISE*/
        /*2.Read All ALL */
        /*3.Read ONE MEMBER */
        /*4.Update MEMBER, WORKOUT, EXERCISE*/
        /*5.Delete*/
        Connection con = getConnection();
        Scanner sc = new Scanner(System.in);
        Crudclass crudClass=new Crudclass();
        int n=0;
        System.out.println("1 : INSERT NEW MEMBER");    //checked
        System.out.println("2 : INSERT WORKOUTLOG");
        System.out.println("3 : INSERT EXERCISE");

        System.out.println("4 : READ MEMBER ALL INFO"); //checked
        System.out.println("5 : READ ONE MEMBER");  //checked

        System.out.println("6 : UPDATE MEMBER");
        System.out.println("7 : DELETE MEMBER");    //checked
        System.out.println("0 : SHUT DOWN");    //checked


        while(n==0) {
            n = sc.nextInt();
            switch (n) {
                case 1:{
                    crudClass.InsertMember("2323",con);
                    break;
                }
                case 4:{
                    crudClass.SearchAllMember(con);
                    break;
                }
                case 5:{
                    break;
                }
                case 6:{
                    crudClass.DeleteMember(100,con);
                    break;
                }
                case 0:{
                    break;
                }
            }
        }

        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        /*마지막 번호 조회 */
        /*int maxMemberCode = registDAO.selectLastMemberCode(con);
        System.out.println("maxMemberCode = " + maxMemberCode);
        *//*모든 멤버 조회*//*
        List<Map<Integer,String>> memberList=registDAO.selectAllMember(con);
        for(Map<Integer, String> member : memberList) {
            System.out.println("ID,MEMBER="+member);
        */}
        /*선택 번호 조회*/
        /*멤버 추가*/
        /*멤버 삭제*/
//        int result2=registDAO.deleteMember(200,con);
//        result2=registDAO.deleteMember(201,con);
//        if(result2 > 0) {
//            System.out.println("신규 메뉴 삭제 성공!");
//        } else {
//            System.out.println("신규 메뉴 삭제 실패!");
//        }
}
