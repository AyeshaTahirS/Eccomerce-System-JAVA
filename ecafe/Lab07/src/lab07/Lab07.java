/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab07;
import java.util.Scanner;
import java.util.*;
import java.util.Calendar;
import java.sql.*;
import java.text.SimpleDateFormat;
/**
 *
 * @author Ham
 */
public class Lab07 {
    
   static ArrayList cart = new ArrayList(); 
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/lab7?useSSL=false";
   static int id;
   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   static Connection conn = null;
   static Statement stmt = null;
   static Scanner input =new Scanner(System.in); 
   /**
     * @param args the command line arguments
     */
   public static void dispItems()
   {
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      Statement stmt = conn.createStatement();
            ResultSet rs;
            
            System.out.println("*************************");
            System.out.println("***********MENU**********");
            System.out.println("*************************");
             System.out.println("******ITEMNAME|PRICE*****");
            rs = stmt.executeQuery("SELECT pid, pname, price FROM items");
            while ( rs.next() ) {
                String id = rs.getString("pid");
                String name = rs.getString("pname");
                String reg = rs.getString("price");
                System.out.println("("+id+")"+" "+name+" "+reg);
            }
            
            System.out.println("*************************");
   }catch(SQLException se){
       //Handle errors for JDBC

   }catch(Exception e){
       //Handle errors for Class.forName

   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
   }
   
   public static void dispOrdersP(String UserName)
   {
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

            Statement stmt = conn.createStatement();
            ResultSet rs;
            
            System.out.println("*************************");
            System.out.println("***********ORDERS**********");
            System.out.println("*************************");
            
            rs = stmt.executeQuery("SELECT orderid, userid, currentDate, status,method, Address, time FROM orderr WHERE userid=\'"+UserName+"\'");
            while ( rs.next() ) {
                String userid = rs.getString("userid");
                String orderid = rs.getString("orderid");
                String currentDate = rs.getString("currentDate");
                String status = rs.getString("status");
                String method = rs.getString("method");
                String time = rs.getString("time");
                String address = rs.getString("Address");
                
                
                switch(method)
                {
                    case "Pickup":
                        System.out.println("("+orderid+")"+" "+userid+" "+currentDate+" "+time+" "+" "+status);
                        break;
                    case "Delivery":
                        System.out.println("("+orderid+")"+" "+userid+" "+currentDate+" "+address+" "+status);
                        break;
                    default:
                        System.out.println("Unspecified if delivery or pickup for Order#"+orderid);
                        break;
                }
            }
            
            System.out.println("*************************");
   }catch(SQLException se){
       //Handle errors for JDBC

   }catch(Exception e){
       //Handle errors for Class.forName

   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
   }
   
   public static void dispOrdersAll()
   {
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

            Statement stmt = conn.createStatement();
            ResultSet rs;
            
            System.out.println("*************************");
            System.out.println("***********ORDERS**********");
            System.out.println("*************************");
            
            rs = stmt.executeQuery("SELECT orderid, userid, currentDate, status,method, Address, time FROM orderr");
            while ( rs.next() ) {
                String userid = rs.getString("userid");
                String orderid = rs.getString("orderid");
                String currentDate = rs.getString("currentDate");
                String status = rs.getString("status");
                String method = rs.getString("method");
                String time = rs.getString("time");
                String address = rs.getString("Address");
                
                
                switch(method)
                {
                    case "Pickup":
                        System.out.println("("+orderid+")"+" "+userid+" "+currentDate+" "+time+" "+" "+status);
                        break;
                    case "Delivery":
                        System.out.println("("+orderid+")"+" "+userid+" "+currentDate+" "+address+" "+status);
                        break;
                    default:
                        System.out.println("Unspecified if delivery or pickup for Order#"+orderid);
                        break;
                }
            }
            
            System.out.println("*************************");
   }catch(SQLException se){
       //Handle errors for JDBC

   }catch(Exception e){
       //Handle errors for Class.forName

   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
   }
   
    public static void test(String oid)
    {
        try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      Statement stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT currentDate FROM orderr WHERE orderid=\'"+oid+"\'"); 
            while ( rs.next() ) {
                 String date = rs.getString("currentDate");
                 
                 java.sql.Date dat = java.sql.Date.valueOf(date);
//create calander instance and get required params
                Calendar cal = Calendar.getInstance();
                cal.setTime(dat);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int year = cal.get(Calendar.YEAR);
                System.out.println(month);
                System.out.println(day);
                System.out.println(year);
            }
            
             
            
            
            
   }catch(SQLException se){
       //Handle errors for JDBC

   }catch(Exception e){
       //Handle errors for Class.forName

   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
    }
   
    public static void orderMonth()
    {
        System.out.println("Enter order of month whose order list you want: (e.g:1 for January etc)");
        String id = input.nextLine();
        int monthinp;
        monthinp=(Integer.parseInt(id)-1);
        int count=0;
        try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      Statement stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT orderid, userid, currentDate, status,method, Address, time FROM orderr"); 
            while ( rs.next() ) {
                 String date = rs.getString("currentDate");
                String userid = rs.getString("userid");
                String orderid = rs.getString("orderid");
                String status = rs.getString("status");
                String method = rs.getString("method");
                String time = rs.getString("time");
                String address = rs.getString("Address");
                 java.sql.Date dat = java.sql.Date.valueOf(date);
//create calander instance and get required params
                Calendar cal = Calendar.getInstance();
                cal.setTime(dat);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int year = cal.get(Calendar.YEAR);
                
                if(month==monthinp)
                {
                    count++;
                    switch(method)
                {
                    case "Pickup":
                        System.out.println("("+orderid+")"+" "+userid+" "+date+" "+time+" "+" "+status);
                        break;
                    case "Delivery":
                        System.out.println("("+orderid+")"+" "+userid+" "+date+" "+address+" "+status);
                        break;
                    default:
                        System.out.println("Unspecified if delivery or pickup for Order#"+orderid);
                        break;
                }
                }
            }
            
            monthinp=monthinp+1;
            System.out.println("*********************************************************");
            System.out.println("There was a total of:"+count+" orders in month#"+monthinp);
             System.out.println("*********************************************************");
            
            
            
   }catch(SQLException se){
       //Handle errors for JDBC

   }catch(Exception e){
       //Handle errors for Class.forName

   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
    }
    
        public static void orderDay()
    {
        System.out.println("Enter day of current month whose order list you want:");
        String id = input.nextLine();
        int dayinp=Integer.parseInt(id);
        int count=0;
        int monthinp=0;
        try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      Statement stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT orderid, userid, currentDate, status,method, Address, time FROM orderr"); 
            while ( rs.next() ) {
                 String date = rs.getString("currentDate");
                String userid = rs.getString("userid");
                String orderid = rs.getString("orderid");
                String status = rs.getString("status");
                String method = rs.getString("method");
                String time = rs.getString("time");
                String address = rs.getString("Address");
                 java.sql.Date dat = java.sql.Date.valueOf(date);
//create calander instance and get required params
                Calendar cal = Calendar.getInstance();
                int month = cal.get(Calendar.MONTH);
                monthinp=month;
                cal.setTime(dat);
                month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int year = cal.get(Calendar.YEAR);
                
                if((day==dayinp)&&(month==monthinp))
                {
                    count++;
                    switch(method)
                {
                    case "Pickup":
                        System.out.println("("+orderid+")"+" "+userid+" "+date+" "+time+" "+" "+status);
                        break;
                    case "Delivery":
                        System.out.println("("+orderid+")"+" "+userid+" "+date+" "+address+" "+status);
                        break;
                    default:
                        System.out.println("Unspecified if delivery or pickup for Order#"+orderid);
                        break;
                }
                }
            }
            
            System.out.println("*********************************************************");
            System.out.println("There was a total of:"+count+" orders on Day#"+dayinp);
             System.out.println("*********************************************************");
            
            
            
   }catch(SQLException se){
       //Handle errors for JDBC

   }catch(Exception e){
       //Handle errors for Class.forName

   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
    }
    
    public static void login()
    {
        int role;
        
        System.out.println("Enter your Username:");   
        String UserName = input.nextLine();
     
        System.out.println("Enter your Password:");
        String Password = input.nextLine();
        
        
        
        while((userCheck(UserName))==0)
        {
            System.out.println("Username: "+UserName+" is invalid.");
            System.out.println("(1) Press 1 to Re-enter UserName.");
            System.out.println("(2) Press 2 to terminate.");
                           
            String inp = input.nextLine();
                           
            switch(inp)
                           {
                               case "1":
                                   System.out.println("Enter Username to over-write your previous input: "+UserName);
                                   UserName = input.nextLine();
                                   userCheck(UserName);
                                   break;
                               case "2":
                                   System.exit(0);
                                   break;
                               default:
                                   System.out.println("Invalid Input, Process is Terminating.");
                                   System.exit(0);
                                   break;
                           }
        
        }
    
        
        
        
    if((userCheck(UserName))==1)
    {
       
        
        try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      Statement stmt = conn.createStatement();
            ResultSet rs;
      
            rs = stmt.executeQuery("SELECT username, PASSWORD FROM users");
            while ( rs.next() ) {
                String tUserName = rs.getString("username");
                String tPassword = rs.getString("PASSWORD");
                
                Boolean flag=true;
                
                if(UserName.equals(tUserName))
                {
                    while(flag)
                    {
                       if(Password.equals(tPassword))
                       {
                           flag=false;
                           //System.out.println("Correct Password entered for Username: "+UserName);
                           role=role(UserName);
                           redirect(role,UserName);
                       }
                       else
                       {
                           System.out.println("Invalid Password entered for Username: "+UserName);
                           System.out.println("(1) Press 1 to Re-enter Password.");
                           System.out.println("(2) Press 2 to Re-enter UserName.");
                           System.out.println("(3) Press 3 to terminate.");
                           
                           String inp = input.nextLine();
                           
                           switch(Integer.parseInt(inp))
                           {
                               case 1:
                                   System.out.println("Enter Password for "+UserName);
                                   Password = input.nextLine();
                                   break;
                               case 2:
                                   System.out.println("Enter Username to over-write your previous input: "+UserName);
                                   UserName = input.nextLine();
                                   break;
                               case 3:
                                   System.exit(0);
                                   break;
                               default:
                                   System.out.println("Invalid Input, Process is Terminating.");
                                   System.exit(0);
                                   break;
                           }
                       }
                    }
                }
                
                
            }
            
   }catch(SQLException se){
       //Handle errors for JDBC

   }catch(Exception e){
       //Handle errors for Class.forName

   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
        
    } 
 }
    public static int role(String UserName)
    {
        String rol ="Empty";
        try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      Statement stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT role FROM users WHERE username=\'"+UserName+"\'"); 
            while ( rs.next() ) {
                rol = rs.getString("role");
            }
            
            
            
            
            
   }catch(SQLException se){
       //Handle errors for JDBC

   }catch(Exception e){
       //Handle errors for Class.forName

   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
        
        switch(rol){
                case "Admin":
                    return 0;
                case "Staff":
                    return 1;
                case "Customer":
                    return 2;
                default:
                    return 3;
                }
    }
    
    public static void Admin(String UserName)
    {
        System.out.println(UserName+" logged in as an Admin.");
        AdminMenu();
       
    }
    
    public static void Staff(String UserName)
    {
        System.out.println(UserName+" logged in as a staff member.");
        StaffMenu();
        
        
    }
    
    public static void OrderStat(String oid)
    {
        String status="Null";
        try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      Statement stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT status FROM orderr WHERE orderid=\'"+oid+"\'"); 
            while ( rs.next() ) {
                 status = rs.getString("status");
            }
            
              System.out.println("What would you like to change status of Order#:"+oid+" from "+status+" to?");
            
            
            
   }catch(SQLException se){
       //Handle errors for JDBC

   }catch(Exception e){
       //Handle errors for Class.forName

   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
        
    }
    
    public static void OrderStatUp(String oid, String Update)
    {
        
        
        try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      Statement stmt = conn.createStatement();
            
                String sql = "UPDATE orderr"
				+ " SET status =\'"+Update+"\'" + " WHERE orderid =\'"+oid+"\'";
                stmt.executeUpdate(sql);
                
            
            
            
        
        }catch(SQLException se){
       //Handle errors for JDBC

   }catch(Exception e){
       //Handle errors for Class.forName

   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
    }
    
    public static void OrderDelete()
    {
        System.out.println("Enter OrderId of order whose status you want deleted:");
        String oid = input.nextLine();
    try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      Statement stmt = conn.createStatement();
                            

                String sql = "DELETE FROM orderr WHERE orderid =\'"+oid+"\'";
                stmt.execute(sql);
                
            
            
            
        
        }catch(SQLException se){
       //Handle errors for JDBC

   }catch(Exception e){
       //Handle errors for Class.forName

   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
    }
    
    public static void AddMenu()
    {
        System.out.println("Enter Product Name:");
        String pname = input.nextLine();
        System.out.println("Enter Product Price:");
        String price = input.nextLine();
        
        
        try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
    
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      Statement stmt = conn.createStatement();
      stmt.executeUpdate("INSERT INTO items (pname, price) " + "VALUES (\" \""+"\'"+pname+"\',"+"\'"+price+"\')");
            
            
   }catch(SQLException se){     
       //Handle errors for JDBC

   }catch(Exception e){
       //Handle errors for Class.forName

   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
        System.out.println("New Item "+pname+" Added!");
        dispItems();
    }
    
     public static void RemMenu()
     {
         System.out.println("Enter ItemId of Product which you want deleted:");
        String pid = input.nextLine();
    try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      Statement stmt = conn.createStatement();
                            

                String sql = "DELETE FROM items WHERE pid =\'"+pid+"\'";
                stmt.execute(sql);
                
            
            
            
        
        }catch(SQLException se){
       //Handle errors for JDBC

   }catch(Exception e){
       //Handle errors for Class.forName

   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
     }
    
    public static void OrderStatCh()
    {
        System.out.println("Enter OrderId of order whose status you want changed:");
        String oId = input.nextLine();
        OrderStat(oId);
        System.out.println("(1) Press 1 to change to confirmed.");
        System.out.println("(2) Press 2 to change to delivered.");
        System.out.println("(3) Press 3 to terminate.");
        String inp = input.nextLine();
        String update;
        
        switch(inp)
        {
            case "1":
                update="confirmed";
            OrderStatUp(oId,update);
            break;
            case "2":
                update="delivered";
            OrderStatUp(oId,update);
            break;
            case "3":
            System.exit(0);
            break;
            default:
            System.out.println("Invalid Input");
            StaffMenu();
            break;
        }
    }
    public static void menuch()
    {
        dispItems();
        System.out.println("Select an action:");
        System.out.println("(1) Press 1 to add item to menu.");
        System.out.println("(2) Press 2 to remove item from menu.");
        System.out.println("(3) Press 3 to return to admin panel.");
        System.out.println("(4) Press 4 to terminate.");
        String inp = input.nextLine();
        
        
        switch(inp)
        {
            case "1":
            AddMenu();
            AdminMenu();
            break;
            case "2":
            RemMenu();
            AdminMenu();
            break;
            case "3":
            AdminMenu();
            break;
            case "4":
            System.exit(0);
            break;
            default:
            System.out.println("Invalid Input");
            StaffMenu();
            break;
        }
    }
    public static void AdminMenu()
    {
        while(true){
        System.out.println("Which action would you like to perform:");
        
        System.out.println("(1) Press 1 to Get Number of orders of a particular month.");
        System.out.println("(2) Press 2 to View order list of any day in current month.");
        System.out.println("(3) Press 3 to Modify the menu.");
        System.out.println("(4) Press 4 to Logout.");
        System.out.println("(5) Press 5 to Terminate.");
        
        String Inp = input.nextLine();
        switch(Inp)
        {
            case "1":
            orderMonth();
            break;
            case "2":
            orderDay();
            break;
            case "3":
            menuch();
            break;
            case "4":
            login(); 
            break;
            case "5":
            System.exit(0);
            break;
            default:
            System.out.println("Invalid Input");
            StaffMenu();
            break;
        }
        }
    }
    
    public static int quantCheck(int id, String pname)
    {
        int flag=0;
        try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      Statement stmt = conn.createStatement();
            ResultSet rs;
           
            rs = stmt.executeQuery("SELECT orderid, pname FROM orderentries");
            while ( rs.next() ) {
                String oid2 = rs.getString("orderid");
                String pname2 = rs.getString("pname");
                if((pname==pname2)&&((Integer.parseInt(oid2)==id)))
                {
                    flag=1; 
                }
            }
            
   }catch(SQLException se){
       //Handle errors for JDBC

   }catch(Exception e){
       //Handle errors for Class.forName

   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
        return flag;
    }
    
    public static void StaffMenu()
    {
        while(true){
        dispOrdersAll();
        System.out.println("Which action would you like to perform:");
        
        System.out.println("(1) Press 1 to Change Status of an order.");
        System.out.println("(2) Press 2 to Delete an order.");
        System.out.println("(3) Press 3 to Logout.");
        System.out.println("(4) Press 4 to Terminate.");
        
        String Inp = input.nextLine();
        switch(Inp)
        {
            case "1":
            OrderStatCh();
            break;
            case "2":
            OrderDelete();
            break;
            case "3":
            login(); 
            break;
            case "4":
            System.exit(0);
            break;
            default:
            System.out.println("Invalid Input");
            StaffMenu();
            break;
        }
        }
    }
    
    
    
    public static void cartCost()
   {
       int siz;
       siz=cart.size();
       //System.out.println(siz);
       //System.out.println((cart.get(0)));
       int price=0;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      
      
            Statement stmt = conn.createStatement();
            ResultSet rs;
            
            System.out.println("*************************");
            System.out.println("***********Cart**********");
            System.out.println("*************************");
             System.out.println("***********ITEMS*********");
            for(int i=0;i<siz;i++){
            rs = stmt.executeQuery("SELECT pname, price FROM items WHERE pid=\'"+(cart.get(i))+"\'");
            while ( rs.next() ) {
                String pname = rs.getString("pname");
                String price2 = rs.getString("price");
                System.out.println("("+cart.get(i)+") "+pname+" "+price2);
                price+=Integer.parseInt(price2);
            }
            }
            System.out.println("Total Bill for the selected "+siz+" items is:"+price);

   }catch(SQLException se){
       //Handle errors for JDBC
       System.out.println("fml");
   }catch(Exception e){
       //Handle errors for Class.forName
       System.out.println("fml");
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
   }
    
    public static void Checkout2(int id, ArrayList cart,String UserName)
    {
        System.out.println(id);
        int siz=cart.size();
        int bill=0;
        int flag;
        int up;
        try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
    
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      
     // stmt.executeUpdate("INSERT INTO orderr " + "VALUES ("+"\'"+UserName+"\',"+"\'"+password+"\',"+"\'"+Name+"\',"+"\'"+Email+"\','Customer')");
      // AI, UserName, Address, formatted, 'pending', 'Delivery', NULL
      Statement stmt = conn.createStatement();
      Statement stmt2 = conn.createStatement();
                ResultSet rs;
                for(int i=0; i<siz;i++){
                rs = stmt.executeQuery("SELECT pname, price FROM items WHERE pid=\'"+(cart.get(i))+"\'");
                while ( rs.next() ) {
                String pname = rs.getString("pname");
                String price2 = rs.getString("price");
                bill+=Integer.parseInt(price2);
                flag=quantCheck(id,pname);
                if(flag==0){
                stmt2.executeUpdate("INSERT INTO orderentries " + "VALUES('"+id+"','"+pname+"','1','"+price2+"')");
                //stmt.executeUpdate("INSERT INTO users " + "VALUES ("+"\'"+UserName+"\',"
                // + ""+"\'"+password+"\',"+"\'"+Name+"\',"+"\'"+Email+"\','Customer')");
                }else
                {
                stmt.executeQuery("SELECT quantity FROM orderentries WHERE orderid=\'"+id+"\'");
                    String q = rs.getString("quantity");
                    up=Integer.parseInt(q);
                    up+=1;
                String sql = "update orderentries set quantity='"+up+"' where orderid='"+id+"'";    
                stmt.executeUpdate(sql);
                }
          }   
                
        
        }
       }
        catch(SQLException se){     
       //Handle errors for JDBC
       System.out.println(se);
   }catch(Exception e){
       //Handle errors for Class.forName
       System.out.println("fml");
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
        System.out.println(UserName+", your order with ID#"+id+" has been placed!.You will get it in 75mins");
        cart.clear();
        CustomerMenu(UserName,cart);
    
    
    }
    
    public static void Checkout(String UserName,String addrtim,int k,ArrayList cart)
    {
        int siz=cart.size();
        int bill=0;
        
         try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
    
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      
     // stmt.executeUpdate("INSERT INTO orderr " + "VALUES ("+"\'"+UserName+"\',"+"\'"+password+"\',"+"\'"+Name+"\',"+"\'"+Email+"\','Customer')");
      // AI, UserName, Address, formatted, 'pending', 'Delivery', NULL
      Statement stmt = conn.createStatement();
      Statement stmt2 = conn.createStatement();
      //System.out.println(k);
      switch(k)
      {
          case 0:
              Calendar cal = Calendar.getInstance();
                //cal.add(Calendar.DATE, 1);
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                String formatted = format1.format(cal.getTime());
                
                ResultSet rs;
                for(int i=0; i<siz;i++){
                rs = stmt.executeQuery("SELECT pname, price FROM items WHERE pid=\'"+(cart.get(i))+"\'");
                while ( rs.next() ) {
                String pname = rs.getString("pname");
                String price2 = rs.getString("price");
                bill+=Integer.parseInt(price2);
                System.out.println("("+cart.get(i)+") "+pname+" "+price2);
                //System.out.println(formatted);
                
                 }   
        }
        
        //System.out.println("1");
        id =stmt2.executeUpdate("INSERT INTO orderr " + "VALUES (NULL,"+"\'"+UserName+"\',"+"\'"+addrtim
        +"\',"+"\'"+formatted+"\','pending','Delivery',NULL)",Statement.RETURN_GENERATED_KEYS);
        //System.out.println("2");
        
        ResultSet rs2 = stmt2.getGeneratedKeys();

    if (rs2.next()) {
        id = rs2.getInt(1);
    } else {

        // throw an exception from here
    }
        
                
             break;
          case 1:
              
              Calendar cal2 = Calendar.getInstance();
                //cal.add(Calendar.DATE, 1);
                SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
                String formatted2 = format2.format(cal2.getTime());
                
                ResultSet rs3;
                for(int i=0; i<siz;i++){
                rs3 = stmt.executeQuery("SELECT pname, price FROM items WHERE pid=\'"+(cart.get(i))+"\'");
                while ( rs3.next() ) {
                String pname = rs3.getString("pname");
                String price2 = rs3.getString("price");
                bill+=Integer.parseInt(price2);
                System.out.println("("+cart.get(i)+") "+pname+" "+price2);
                //System.out.println(formatted);
                
                 }   
        }
        
        //System.out.println("1");
        id =stmt2.executeUpdate("INSERT INTO orderr " + "VALUES (NULL,"+"\'"+UserName+"\',NULL,"+"\'"+formatted2+"\','pending','Pickup','"+addrtim+"')",Statement.RETURN_GENERATED_KEYS);
        //System.out.println("2");
        
        ResultSet rs4 = stmt2.getGeneratedKeys();

    if (rs4.next()) {
        id = rs4.getInt(1);
    } else {

        // throw an exception from here
    }
              break;
      }
      
      
            
            
   }catch(SQLException se){     
       //Handle errors for JDBC
       System.out.println(se);
   }catch(Exception e){
       //Handle errors for Class.forName
       System.out.println("fml");
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
         Checkout2(id,cart,UserName);
    }
    
    public static void CustomerMenu(String UserName, ArrayList cart)
    {
        
        
               
        while(true){
        dispItems();
        
        System.out.println("(1) Press 1 to Add an item to cart.");
        System.out.println("(2) Press 2 to Display items in cart and total bill.");
        System.out.println("(3) Press 3 to Checkout.");
        System.out.println("(4) Press 4 to Logout.");
        System.out.println("(5) Press 5 to Terminate.");
        
        String Inp = input.nextLine();
        
        switch(Inp)
        {
            case "1":
            System.out.println("Enter Id of product:");
            String c = input.nextLine();
            int size= (cart.size());
            //System.out.println(size);
            cart.add(size,c);
            for(int i=0;i<size+1;i++)
            {
                System.out.println(cart.get(i));
            }
            CustomerMenu(UserName,cart);
            break;
            case "2":
            cartCost();
            break;
            case "3":
            System.out.println("Select method:");
            System.out.println("(1) Press 1 to select Home Delivery.");
            System.out.println("(2) Press 2 to arrange pickup.");
            int k;
            String b = input.nextLine();
                switch(b){
                    case "1":
                        System.out.println("Enter home address for delivery:");
                        String addr = input.nextLine();
                        k=0;
                        Checkout(UserName,addr,k,cart);
                        break;
                    case "2":
                        System.out.println("Select an hour for pickup: (0-24)");
                        String time = input.nextLine();
                        k=1;
                        Checkout(UserName,time,k,cart);
                        break;
                    default:
                        System.out.println("Invalid input, program will now terminate.");
                        System.exit(0);
                        break;
                }
            break;
            case "4":
            login();
            break;
            case "5":
            System.exit(0);
            break;
            default:
            System.out.println("Invalid Input, terminating now.");
            System.exit(0);
            break;
        }
        }
    }
    public static void Customer(String UserName)
    {
        System.out.println("Welcome Customer:"+UserName+", select an option:");
        cart = new ArrayList();
        CustomerMenu(UserName,cart);
       
    }
    
    public static void redirect(int role,String UserName)
    {
        switch(role)
        {
            case 0:
                Admin(UserName);
                break;
            case 1:
                Staff(UserName);
                break;
            case 2:
                Customer(UserName);
                break;
            default:
                System.exit(0);
        }
    }
    
    public static void signup()
    {   
        System.out.println("********");
        System.out.println("Sign-up:");
        System.out.println("********");
        System.out.println("Enter your Full Name:");
        String Name = input.nextLine();
        System.out.println("Enter your Email Address:");
        String Email = input.nextLine();
        System.out.println("Enter a Username:");
        String UserName = input.nextLine();
        
        while(userCheck(UserName)==1)
        {
            System.out.println("This username already exists, select a different one:");
            UserName = input.nextLine();
        }
        
        System.out.println("Enter a Password:");
        String password = input.nextLine();
        
        System.out.println("New user created!");
        
        try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
    
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      Statement stmt = conn.createStatement();
      stmt.executeUpdate("INSERT INTO users " + "VALUES ("+"\'"+UserName+"\',"+"\'"+password+"\',"+"\'"+Name+"\',"+"\'"+Email+"\','Customer')");
      
            
            
   }catch(SQLException se){     
       //Handle errors for JDBC

   }catch(Exception e){
       //Handle errors for Class.forName

   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
        menu();
    }
    
    public static int userCheck(String UserName)
    {
        int flag=0;
        try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      Statement stmt = conn.createStatement();
            ResultSet rs;
      
            rs = stmt.executeQuery("SELECT * FROM users");
            while ( rs.next() ) {
                String tUserName = rs.getString("username");
                //String tPassword = rs.getString("PASSWORD");
                
                if(UserName.equals(tUserName))
                {
                  flag=1;  
                }
                                 }
            } 
      catch(SQLException se){
       //Handle errors for JDBC

   }catch(Exception e){
       //Handle errors for Class.forName

   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
                
                
        if(flag==1)
        {
        return 1;
        }
        
        return 0;
       
    }
    
    public static void menu()
    {
        System.out.println("(1) Press 1 to Login.");
        System.out.println("(2) Press 2 to Sign-up.");
        System.out.println("(3) Press 3 to Terminate.");
        
        String Inp = input.nextLine();
        switch(Inp)
        {
            case "1":
            login();
            break;
            case "2":
            signup();
            break;
            case "3":
            System.exit(0);
            break;
            default:
            System.out.println("Invalid Input");
            menu();
            break;
        }
        
    }
    
    public static void main(String[] args) {
    
        Scanner input =new Scanner(System.in);
        System.out.println("*****************");
        System.out.println("Welcome to E-Cafe");
        System.out.println("*****************");
        
        menu();
    }
    
}
