package com.ohgiraffers.section02.run;

import com.ohgiraffers.section02.model.dao.MemberDAO;
import com.ohgiraffers.section02.model.dto.MemberDTO;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Crudclass {
    public void InsertMember(String name, Connection con){
        MemberDAO registDAO = new MemberDAO();
        Scanner sc = new Scanner(System.in);
        int maxMemberCode = registDAO.selectLastMemberCode(con);
        System.out.println("maxMemberCode = " + maxMemberCode);
        MemberDTO newMem = new MemberDTO(maxMemberCode+1,"이김test2", new java.sql.Date(System.currentTimeMillis()));

        int result=registDAO.insertNewMember(newMem,con);
        if(result > 0) {
            System.out.println("신규 메뉴 등록 성공!");
        } else {
            System.out.println("신규 메뉴 등록 실패!");
        }
    }
    public void SearchOneMember(Connection con){
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 회원 ID를 입력하세요: ");
        int memberId = sc.nextInt();

        MemberDAO registDAO = new MemberDAO();
        MemberDTO member = registDAO.selectMemberById(memberId, con);

        if(member != null) {
            System.out.println("회원 정보 조회 성공!");
            System.out.println("회원 ID: " + member.getMemberID());
            System.out.println("회원 이름: " + member.getMemberName());
            System.out.println("등록일: " + member.getMemberDate());
        } else {
            System.out.println("해당 회원이 존재하지 않습니다.");
        }
    }


    public void SearchAllMember(Connection con){
        MemberDAO registDAO=new MemberDAO();
        List<Map<Integer,String>> memberList=registDAO.selectAllMember(con);
        for(Map<Integer, String> member : memberList) {
            System.out.println("ID,MEMBER="+member);
        }
    }
    public void DeleteMember(int memberId, Connection con){
        MemberDAO registDAO=new MemberDAO();
        int result = registDAO.deleteMember(memberId, con);

        if(result > 0) {
            System.out.println("회원 삭제 성공! 삭제된 회원 ID:"+ memberId);
        } else {
            System.out.println("회원 삭제 실패!");
        }

    }


}
