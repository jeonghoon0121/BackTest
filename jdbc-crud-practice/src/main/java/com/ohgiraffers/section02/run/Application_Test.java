package com.ohgiraffers.section02.run;

import java.sql.Connection;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application_Test {
    public static void main(String[] args) {
        Connection con = getConnection();
        Scanner sc = new Scanner(System.in);
        Crudclass crudClass=new Crudclass();
        //crudClass.SearchAllMember(con);
        crudClass.SearchOneMember(con);
//        crudClass.DeleteMember(219,con);
    }
}
