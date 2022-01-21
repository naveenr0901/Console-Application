import java.util.*;
public class Main{
    static Product produt = new Product();
    static Admin admin = new Admin();
    static User user = new User();
    static Merchant merch = new Merchant();
    public static void main(String[] args){
        main0();
    }
    //-----------------------------------------------------------------------------------Infinite loop of Amazon
    static void main0(){
        Scanner sc = new Scanner(System.in);
        while(true){
            flusher();
            flusher();
            flusher();
            System.out.print("-----*Welcome to Amazon*----- " +"\n" +"1. Admin" +"\n" +"2. Merchant " +"\n" +"3. User" +"\n" +"4. Exit" +"\n" +"Enter the choice : ");
            String a = sc.nextLine();
            if(a.equals("1")){
                admin.main1();
            }
            else if(a.equals("2")){
                merch.main2();
            }
            else if(a.equals("3")){
                user.main3();
            }
            else if(a.equals("4")){
                System.out.print("\n" +"------*Enter to Logout*------");
               enterNeeded();
               break;
            }
            else{
            System.out.println("Invalid Choice");
            enterNeeded();
            continue;
            }
        }
        System.exit(0);
    }
    //------------------------------------------------------------------------------------Flusher
    static void flusher(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
    //------------------------------------------------------------------------------------Enter Function
    static void enterNeeded(){
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
    }
}

class Admin{
    static MerProducts merpro = new MerProducts();
    static Product produt = new Product();
    static Main main = new Main();
    static User user = new User();
    static Merchant merch = new Merchant();
    static UserMaterials userclass = new UserMaterials();
    //-----------------------------------------------------------------------------------merchant lists-----------------------*
    static List<String> merApproNames = new ArrayList<String>();
    static List<String> merApproPwd = new ArrayList<String>();
    static List<String> merchantsList = new ArrayList<String>();
    static List<String> merchantPwd = new ArrayList<String>();
    static List<String> merDenyList = new ArrayList<String>();
    //-----------------------------------------------------------------------------------User list------------------------------*
    static List<String> usrApproNames = new ArrayList<String>();
    static List<String> usrApproPwd = new ArrayList<String>();
    static List<String> usrList = new ArrayList<String>();
    static List<String> usrPwd = new ArrayList<String>();
    static List<String> usrDenyList = new ArrayList<String>();
    //----------------------------------------------------------------------------------Hashmaps of both-------------------------*
    static HashMap<String,Integer> merHp = new HashMap<String,Integer>();
    static HashMap<String,Integer> usrHp = new HashMap<String,Integer>();
    //----------------------------------------------------------------------------------Product lists of merchants------------*
    static ArrayList<String> proListMer = new ArrayList<String>();
    
    
    //***************************************************************************************************************************
    //----------------------------------------------------------------------------------Admin loggin Function-------------------*
    public static void main1(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Username : ");
        String st  = sc.nextLine();
        System.out.print("Enter the Password : ");
        String pwd = sc.nextLine();
        if(st.equals("11") && (pwd.equals("11"))){
            admlog();
        }
        else{
            System.out.println("Invalid Input");
            main1();
        }
    }
    //----------------------------------------------------------------------------------Admin Actions
    static void admlog(){          
        Scanner sc = new Scanner(System.in);
        main.flusher();
        main.flusher();
        main.flusher();
        System.out.print("-----*Welcome Admin*-----" +"\n" +"1. Merchant Approval List" +"\n" +"2. User Approval List" +"\n" 
        +"3. Add Merchant" +"\n" +"4. Add User " +"\n" +"5. Remove the Merchant " +"\n" +"6. Remove the User " +"\n" 
        +"7. View and Add new Products to Amazon " +"\n" +"8. Show Merchant List " +"\n" +"9. Show Users List " 
        +"\n" +"10. Exit" +"\n" +"Enter the Choice : ");
        int cho = sc.nextInt();
        if(cho==1){
            showMerchantAp();//----------------------------------------------------Merchant appr list and add or remove
            admlog();
        }
        else if(cho==2){
            showUsrAp();//---------------------------------------------------------User appr List and Add or remove
            admlog();
        }
        else if(cho==3){
            addmerch();  //--------------------------------------------------------Add Merchant
            admlog();
        }
        else if(cho==4){
            addUsr();//-----------------------------------------------------------Adding User
            admlog();
        }
        else if(cho==5){
            remMer();//-----------------------------------------------------------Remove Merchant
            admlog();
        }
        else if(cho==6){
            remUsr();//------------------------------------------------------------Remove user
            admlog();
        }
        else if(cho==7){
            produt.addProList("11");
            admlog();
        }
        else if(cho==8){
            showMerchantList();//-------------------------------------------------Showing Merchant list
            admlog();
        }
        else if(cho==9){
            showUsrList();//------------------------------------------------------Showing Merchant List
            admlog();
        }
        else if(cho==10){
            main.main0();//-------------------------------------------------------Exit
        }
        else{
            System.out.println("Invalid Input");
            main.enterNeeded();
            admlog();
        }
    }
    //-------------------------------------------------------------------------------------Merchant request func----------------------------
    static void merReq(String st ,String st1){
        merApproNames.add(st);
        merApproPwd.add(st1);
        main.main0();
    }
    //-------------------------------------------------------------------------------------User request func--------------------------------
    static void usrReq(String st ,String st1){
        usrApproNames.add(st);
        usrApproPwd.add(st1);
        main.main0();
    }
    //-------------------------------------------------------------------------------------Merchant approval list in Admin------------------
    static void showMerchantAp(){
        main.flusher();
        main.flusher();
        main.flusher();
        Scanner sc = new Scanner(System.in);
        if(merApproNames.size()==0){
            System.out.println("There is no more requests today" +"\n" +"Enter to Exit");
            main.enterNeeded();
            admlog( );
        }
        else{
            System.out.println("Request for merchants : ");
            for(int i = 0 ; i<merApproNames.size() ; i++){
                System.out.println(i+1 +". " + merApproNames.get(i));
            }
            System.out.println((merApproNames.size()+1) +". " +"Click to exit");
            System.out.println("Enter the Choice to Add or Remove a Merchant : ");
            int a = sc.nextInt();
            if(a==(merApproNames.size()+1)){
                admlog();
            }
            else{
                System.out.print("1.Add a Merchant" +"\n" +"2.Remove a Merchant" +"\n" +"Enter the Choice : ");
                int Cho = sc.nextInt();
                if(Cho==1){
                    merHp.put(merApproNames.get(a-1),merchantsList.size());
                    merchantsList.add(merApproNames.get(a-1));
                    merchantPwd.add(merApproPwd.get(a-1));
                    merpro.addingNewSpace(merHp.get(merApproNames.get(a-1)));
                    merApproPwd.remove(a-1);
                    merApproNames.remove(a-1);
                    System.out.print("-----*Merchant Added Successfully*-----" +"\n" +"Enter to Exit");
                    main.enterNeeded();
                    admlog();
                }
                else if(Cho==2){
                    merDenyList.add(merApproNames.get(a-1));
                    merApproPwd.remove(a-1);
                    merApproNames.remove(a-1);
                    System.out.println("-----*Merchant request removed Successfully*-----" +"\n" +"Enter to exit");
                    main.enterNeeded();
                    admlog();
                }
                else{
                    System.out.println("Invalid Input");
                    main.enterNeeded();
                    showMerchantAp();
                }
            }
        }
    }
    //---------------------------------------------------------------------------------Showing merchant list in Admin---------------------------------
    static void showMerchantList(){
        main.flusher();
        main.flusher();
        main.flusher();
        if(merchantsList.size()==0){
            System.out.println("There are no Merchants Now " +"\n" +"Enter to Exit");
            main.enterNeeded();
        }
        else{
        System.out.println("-----* The Merchants of the Amazon *-----");
        for(int i = 0 ; i<merchantsList.size() ; i++){
            System.out.println(i+1 +"." +merchantsList.get(i));
        }
        System.out.println("Enter to exit");
        main.enterNeeded();
        admlog();
        }
    }
    //---------------------------------------------------------------------------------User Approval list in Admin---------------------------------
    static void showUsrAp(){
        main.flusher();
        main.flusher();
        main.flusher();
        Scanner sc = new Scanner(System.in);
        if(usrApproNames.size()==0){
            System.out.println("There is no more requests today" +"\n" +"Enter to Exit");
            main.enterNeeded();
            admlog( );
        }
        else{
            System.out.println("Request for User : ");
            for(int i = 0 ; i<usrApproNames.size() ; i++){
                System.out.println(i+1 +". " + usrApproNames.get(i));
            }
            System.out.println((usrApproNames.size()+1) +". " +"Click to exit");
            System.out.println("Enter the Choice to Add or Remove a User : ");
            int a = sc.nextInt();
            if(a==(usrApproNames.size()+1)){
                admlog();
            }
            else{
                System.out.print("1.Add a User" +"\n" +"2.Remove a Remove" +"\n" +"Enter the Choice : ");
                int Cho = sc.nextInt();
                if(Cho==1){
                    usrHp.put(usrApproNames.get(a-1),usrList.size());
                    usrList.add(usrApproNames.get(a-1));
                    usrPwd.add(usrApproPwd.get(a-1));
                    usrApproPwd.remove(a-1);
                    usrApproNames.remove(a-1);
                    System.out.print("-----*User Added Successfully*-----" +"\n" +"Enter to Exit");
                    main.enterNeeded();
                    admlog();
                }
                else if(Cho==2){
                    usrDenyList.add(usrApproNames.get(a-1));
                    usrApproPwd.remove(a-1);
                    usrApproNames.remove(a-1);
                    System.out.println("-----*User request removed Successfully*-----" +"\n" +"Enter to exit");
                    main.enterNeeded();
                    admlog();
                }
                else{
                    System.out.println("Invalid Input");
                    main.enterNeeded();
                    showUsrAp();
                }
            }
        }
    }
    //---------------------------------------------------------------------------------Showing User list in Admin---------------------------------
    static void showUsrList(){
        main.flusher();
        main.flusher();
        main.flusher();
        if(usrList.size()==0){
            System.out.println("There are no User Now " +"\n" +"Enter to Exit");
            main.enterNeeded();
        }
        else{
        System.out.println("-----* The Users of the Amazon *-----");
        for(int i = 0 ; i<usrList.size() ; i++){
            System.out.println(i+1 +"." +usrList.get(i));
        }
        System.out.println("Enter to exit");
        main.enterNeeded();
        admlog();
        }
    }
    //---------------------------------------------------------------------------------Checking for Merchant existing-------------------------------------
    static int checkMer(String st,String st1){
        int a =0;
        if(merchantsList.contains(st)){
            int id = merHp.get(st);
            if((merchantsList.get(id).equals(st)) && (merchantPwd.get(id).equals(st1))){
                a=5;
            }
            else if((merchantsList.get(id).equals(st)) && (!merchantPwd.get(id).equals(st1))){
                a=4;
            }
        }
        else if(merApproNames.contains(st)){
            a=3;
        }
        else if(merDenyList.contains(st)){
            a=2;
        }
        else
        a=1;
        return a;
    }
    //---------------------------------------------------------------------------------Checking for Merchant existing-------------------------------------
    static int checkUsr(String st,String st1){
        int a =0;
        if(usrList.contains(st)){
            int id = usrHp.get(st);
            if((usrList.get(id).equals(st)) && (usrPwd.get(id).equals(st1))){
                a=5;
            }
            else if((usrList.get(id).equals(st)) && (!usrPwd.get(id).equals(st1))){
                a=4;
            }
        }
        else if(usrApproNames.contains(st)){
            a=3;
        }
        else if(usrDenyList.contains(st)){
            a=2;
        }
        else
        a=1;
        return a;
    }
    //---------------------------------------------------------------------------------Adding New Merchant by Admin----------------------------------------
    static void addmerch(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the UserName : ");
        String st = sc.nextLine();
        System.out.print("Enter the Password : ");
        String st1 = sc.nextLine();
        merHp.put(st,merchantsList.size());
        merchantsList.add(st);
        merchantPwd.add(st1);
        merpro.addingNewSpace(merHp.get(st));
        System.out.print("-----*Merchant Added Successfully*-----" +"\n" +"Enter to Exit");
        main.enterNeeded();
        admlog();
    }
    //---------------------------------------------------------------------------------Adding New  User by Admin----------------------------------------
    static void addUsr(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the UserName : ");
        String st = sc.nextLine();
        System.out.print("Enter the Password : ");
        String st1 = sc.nextLine();
        usrHp.put(st,usrList.size());
        usrList.add(st);
        usrPwd.add(st1);
        userclass.addNewUserSpacewal(usrHp.get(st));
        System.out.print("-----*User Added Successfully*-----" +"\n" +"Enter to Exit");
        main.enterNeeded();
        admlog();
    }
    //---------------------------------------------------------------------------------Removing Merchant by Admin----------------------------------------
    static void remMer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Username to remove : ");
        String st = sc.nextLine();
        if(merchantsList.contains(st)){
            int a = merHp.get(st);
            merDenyList.add(merchantsList.get(a));
            merchantsList.remove(a);
            merchantPwd.remove(a);
            for(int i = a ; i<merchantsList.size();i++){
                merHp.replace(merchantsList.get(i),i);
            }
            merpro.remMerPro(a,st);
            System.out.println("-----*Merchant Removed Successfully*-----" +"\n");
            main.enterNeeded();
            admlog();
        }
    }
    //---------------------------------------------------------------------------------Removing User by Admin----------------------------------------
    static void remUsr(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Username to remove : ");
        String st = sc.nextLine();
        if(usrList.contains(st)){
            int a = usrHp.get(st);
            usrDenyList.add(usrList.get(a));
            usrList.remove(a);
            usrPwd.remove(a);
            for(int i = a ; i<usrList.size();i++){
                usrHp.replace(usrList.get(i),i);
            }
            userclass.removeUserCom(a);
            System.out.println("-----*User Removed Successfully*-----" +"\n");
            main.enterNeeded();
            admlog();
        }
    }
}
class Merchant{
    static MerProducts merpro = new MerProducts();
    static Product produt = new Product();
    static Main main = new Main();
    static User user = new User();
    static Admin admin = new Admin();
    //-----------------------------------------------------------------------------------------------Merchant Login
    public static void main2(){
        Scanner sc = new Scanner(System.in);
        System.out.print("1. New Merchant  " +"\n" +"2. Existing Merchant" +"\n" +"Enter the Choice : ");
        String merty = sc.nextLine();
        
        if(merty.equals("1")){
            System.out.print("-----*Welcome to the Amazon*-----" +"\n" +"Enter the Username : " );
            String merchid = sc.nextLine();
            System.out.print("Enter the Password : ");
            String merchpwd = sc.nextLine();
            System.out.print("-----*Your Account is waiting for Approval*-----" +"\n" +"Enter to Exit" +"\n");
            main.enterNeeded();
            admin.merReq(merchid,merchpwd);
            main.main0();
        }
        //-------------------------------------------------------------------------------------Existing Merchant Loggin
        else if(merty.equals("2")){
            main.flusher();
            main.flusher();
            main.flusher();
            System.out.print("-----*Welcomeback Merchant*-----" +"\n" +"Enter the Username : ");
            String exMerId = sc.nextLine();
            System.out.print("Enter the Password : ");
            String exMerPwd = sc.nextLine();
            int a = admin.checkMer(exMerId,exMerPwd);
            if(a==5){
                merActions(exMerId);
            }
            else if(a==4){
            System.out.println("Incorrect Password");
            main.enterNeeded();
            main2();
            }
            else if(a==3){
                System.out.println("Your Id request is waiting for Approval");
                main.enterNeeded();
                main.main0();
            }
            else if(a==2){
                System.out.println("Your Account access request is Denied");
                main.enterNeeded();
                main.main0();
            }
            else{
                System.out.println("Invalid Username");
                main.enterNeeded();
                main2();
            }
        }
        else{
            System.out.print("Invalid Input");
            main.enterNeeded();
            main2();
        }
    }
    //-------------------------------------------------------------------------------------Merchant Actions
    static void merActions(String username00){
        Scanner sc = new Scanner(System.in);
        main.flusher();
        main.flusher();
        main.flusher();
        System.out.print("-----Logged in Successfully-----" +"\n" +"-----*Welcome to Amazon*------" +"\n" +"1. Add a New Product to Amazon" +"\n" 
        +"2. Sell a Product " +"\n" +"3. Update Product" +"\n" +"4. Remove Product" +"\n" +"5. View Products" +"\n" +"6. Exit" +"\n" +"Enter Your Choice : " );
        String cho = sc.nextLine();
        if(cho.equals("1")){
            produt.addProList(username00);
        }
        else if(cho.equals("2")){
            merpro.addingSpecPro(admin.merHp.get(username00),username00);
        }
        else if(cho.equals("3")){
            merpro.upDate(admin.merHp.get(username00),username00);  
        }
        else if(cho.equals("4")){
            merpro.reMoveProduct(admin.merHp.get(username00),username00);
        }
        else if(cho.equals("5")){
            merpro.showSpecficSpace(admin.merHp.get(username00),username00);
            main.enterNeeded();
            merActions(username00);
        }
        else if(cho.equals("6")){
            System.out.println("Enter to Loggin Page : ");
            main.enterNeeded();
            main.main0();
        }
        else{
            System.out.print("Invalid Input");
            main.enterNeeded();
            merActions(username00);
        }
    }
}
class User{
    static UserMaterials userclass = new UserMaterials();
    static Product produt = new Product();
    static Main main = new Main();
    static Admin admin = new Admin();
    static Merchant merch = new Merchant();
    //-------------------------------------------------------------------------------------User Login
    public static void main3(){
        Scanner sc = new Scanner(System.in);
        System.out.print("1. New User  " +"\n" +"2. Existing User" +"\n" +"Enter the Choice : ");
        String usrty = sc.nextLine();
        if(usrty.equals("1")){
            System.out.print("-----*Welcome to the Amazon*-----" +"\n" +"Enter the Email id : " );
            String usrid = sc.nextLine();
            System.out.print("Enter the Password : ");
            String usrpwd = sc.nextLine();
            System.out.print("-----*Your Account is waiting for Approval*-----" +"\n" +"Enter to Exit" +"\n");
            main.enterNeeded();
            admin.usrReq(usrid,usrpwd);
            main.main0();
            
        }
        else if(usrty.equals("2")){
            main.flusher();
            main.flusher();
            main.flusher();
            System.out.print("-----*Welcomeback User*-----" +"\n" +"Enter the Username : ");
            String exUsrId = sc.nextLine();
            System.out.print("Enter the Password : ");
            String exUsrPwd = sc.nextLine();
            int a = admin.checkUsr(exUsrId,exUsrPwd);
            if(a==5){
                userActions(exUsrId);
                main.main0();
            }
            else if(a==4){
            System.out.println("Incorrect Password");
            main.enterNeeded();
            main3();
            }
            else if(a==3){
                System.out.println("Your Id request is waiting for Approval");
                main.enterNeeded();
                main.main0();
            }
            else if(a==2){
                System.out.println("Your Account access request is Denied");
                main.enterNeeded();
                main.main0();
            }
            else{
                System.out.println("Invalid Username");
                main.enterNeeded();
                main3();
            }
        }
        else{
            System.out.print("Invalid Input");
            main.enterNeeded();
            main3();
        }
        
    }
    //------------------------------------------------------------------------------------User Actions
    static void userActions(String username00){
        Scanner sc = new Scanner(System.in);
        main.flusher();
        main.flusher();
        main.flusher();
        System.out.print("-----Logged in Successfully-----" +"\n" +"-----*Welcome to Amazon*------" +"\n" +"1. View Products" +"\n" 
        +"2. Order List " +"\n" +"3. Add Amount to Wallet" +"\n" +"4. Kart items" +"\n" +"5. Exit" +"\n" +"Enter Your Choice : " );
        String cho = sc.nextLine();
        if(cho.equals("1")){
            userclass.viewProductsUsr(username00);//-----------------------------------------------------------------Complete
        }
        else if(cho.equals("2")){
            userclass.orderList(admin.usrHp.get(username00),username00);//-------------------------------------------Complete
        }
        else if(cho.equals("3")){
            userclass.addAmounttoWallet(admin.usrHp.get(username00),username00);//------------------------------------Complete
        }
        else if(cho.equals("4")){
            userclass.showkartItems(admin.usrHp.get(username00),username00);//----------------------------------------Complete
        }
        else if(cho.equals("5")){
            main.main0();
        }
        else{
            System.out.print("Invalid Input");
            main.enterNeeded();
            userActions(username00);
        }
    }
}
class Product{
    //---------------------------------------------------------------here we are going to add and showproducts to the user
    static Main main = new Main();
    static Admin admin = new Admin();
    static User user = new User();
    static Merchant merch = new Merchant();
    //---------------------------------------------------------------------------Product lists-----------------------
    static List<String> proListNames = new ArrayList<String>();
    static List<List<String>> proCompArr = new ArrayList<List<String>>();
    static List<List<List<String>>> proModArr = new ArrayList<List<List<String>>>();
    static List<List<List<List<String>>>> proFeaArr = new ArrayList<List<List<List<String>>>>();
    
    //-----------------------------------------------------------------------------Main product functions-----------
    public static void main4(){
        ArrayList<String> phn = new ArrayList<String>();
        ArrayList<String> lap = new ArrayList<String>();
        ArrayList<String> book = new ArrayList<String>();
        ArrayList<String> iphone = new ArrayList<String>();
        ArrayList<String> Samsung = new ArrayList<String>();
        ArrayList<String> Redmi = new ArrayList<String>();
        ArrayList<String> Macbook = new ArrayList<String>();
        ArrayList<String> Hp = new ArrayList<String>();
        ArrayList<String> Acer = new ArrayList<String>();
        ArrayList<String> SelfDev = new ArrayList<String>();
        ArrayList<String> Business = new ArrayList<String>();
        ArrayList<String> Technology = new ArrayList<String>();
        ArrayList<String> ip1 = new ArrayList<String>();
        ArrayList<String> ip2 = new ArrayList<String>();
        ArrayList<String> ip3 = new ArrayList<String>();
        ArrayList<String> sam1 = new ArrayList<String>();
        ArrayList<String> sam2 = new ArrayList<String>();
        ArrayList<String> sam3 = new ArrayList<String>();
        ArrayList<String> red1 = new ArrayList<String>();
        ArrayList<String> red2 = new ArrayList<String>();
        ArrayList<String> red3 = new ArrayList<String>();
        ArrayList<String> mac1 = new ArrayList<String>();
        ArrayList<String> mac2 = new ArrayList<String>();
        ArrayList<String> mac3 = new ArrayList<String>();
        ArrayList<String> hp1 = new ArrayList<String>();
        ArrayList<String> hp2 = new ArrayList<String>();
        ArrayList<String> hp3 = new ArrayList<String>();
        ArrayList<String> ace1 = new ArrayList<String>();
        ArrayList<String> ace2 = new ArrayList<String>();
        ArrayList<String> ace3 = new ArrayList<String>();
        ArrayList<String> self1 = new ArrayList<String>();
        ArrayList<String> self2 = new ArrayList<String>();
        ArrayList<String> self3 = new ArrayList<String>();
        ArrayList<String> bus1 = new ArrayList<String>();
        ArrayList<String> bus2 = new ArrayList<String>();
        ArrayList<String> bus3 = new ArrayList<String>();
        ArrayList<String> tech1 = new ArrayList<String>();
        ArrayList<String> tech2 = new ArrayList<String>();
        ArrayList<String> tech3 = new ArrayList<String>();
        ArrayList<List<String>> Phone = new ArrayList<List<String>>();
        ArrayList<List<String>> Lap = new ArrayList<List<String>>();
        ArrayList<List<String>> Book = new ArrayList<List<String>>();
        ArrayList<List<String>> ipMod = new ArrayList<List<String>>();
        ArrayList<List<String>> samMod = new ArrayList<List<String>>();
        ArrayList<List<String>> redMod = new ArrayList<List<String>>();
        ArrayList<List<String>> macMod = new ArrayList<List<String>>();
        ArrayList<List<String>> hpMod = new ArrayList<List<String>>();
        ArrayList<List<String>> acerMod = new ArrayList<List<String>>();
        ArrayList<List<String>> selfdevMod = new ArrayList<List<String>>();
        ArrayList<List<String>> busiMod = new ArrayList<List<String>>();
        ArrayList<List<String>> techMod = new ArrayList<List<String>>();
        ArrayList<List<List<String>>> GrePhn = new ArrayList<List<List<String>>>();
        ArrayList<List<List<String>>> GreLap = new ArrayList<List<List<String>>>();
        ArrayList<List<List<String>>> GreBook = new ArrayList<List<List<String>>>();
        
        proListNames.add("Phone");
        proListNames.add("Laptop");
        proListNames.add("Book");
        phn.add("iphone");
        phn.add("Samsung");
        phn.add("Redmi");
        lap.add("Macbook");
        lap.add("Hp");
        lap.add("Acer");
        book.add("Self Develpoment");
        book.add("Business");
        book.add("Technology");
        proCompArr.add(phn);
        proCompArr.add(lap);
        proCompArr.add(book);
        iphone.add("iphone - 13 Pro Max");
        iphone.add("iphone - 13 Pro");
        iphone.add("iphone - 13");
        Samsung.add("Samsung Galaxy A03 Core");
        Samsung.add("Samsung Galaxy M52 5G");
        Samsung.add("Samsung Galaxy F42 5G");
        Redmi.add("Xiaomi 11i 5G");
        Redmi.add("Xiaomi 11i HyperCharge 5G");
        Redmi.add("Redmi Note 11i 5G");
        Phone.add(iphone);
        Phone.add(Samsung);
        Phone.add(Redmi);
        Macbook.add("Apple Macbook Pro M1");
        Macbook.add("Apple Macbook Air M1");
        Macbook.add("2020 Apple Mac Mini");
        Hp.add("HP Chromebook 14");
        Hp.add("HP Laptop 15s");
        Hp.add("HP AMD Ryzen");
        Acer.add("Acer Aspire 3");
        Acer.add("Acer Aspire 3 AMD Ryzen R3");
        Acer.add("Acer Aspire 5");
        Lap.add(Macbook);
        Lap.add(Hp);
        Lap.add(Acer);
        SelfDev.add("Ikigai");
        SelfDev.add("Think Like a Monk");
        SelfDev.add("Think and Grow Rich");
        Business.add("Startup");
        Business.add("Rich Dad Poor Dad");
        Business.add("Markrting Mentor");
        Technology.add("Mastering Hacks");
        Technology.add("New Thinking");
        Technology.add("How Technlogy Works");
        Book.add(SelfDev);
        Book.add(Business);
        Book.add(Technology);
        proModArr.add(Phone);
        proModArr.add(Lap);
        proModArr.add(Book);
        ipMod.add(ip1);
        ipMod.add(ip2);
        ipMod.add(ip3);
        samMod.add(sam1);
        samMod.add(sam2);
        samMod.add(sam3);
        redMod.add(red1);
        redMod.add(red2);
        redMod.add(red3);
        GrePhn.add(ipMod);
        GrePhn.add(samMod);
        GrePhn.add(redMod);
        macMod.add(mac1);
        macMod.add(mac2);
        macMod.add(mac3);
        hpMod.add(hp1);
        hpMod.add(hp2);
        hpMod.add(hp3);
        acerMod.add(ace1);
        acerMod.add(ace2);
        acerMod.add(ace3);
        GreLap.add(macMod);
        GreLap.add(hpMod);
        GreLap.add(acerMod);
        selfdevMod.add(self1);
        selfdevMod.add(self2);
        selfdevMod.add(self3);
        busiMod.add(bus1);
        busiMod.add(bus2);
        busiMod.add(bus3);
        techMod.add(tech1);
        techMod.add(tech2);
        techMod.add(tech3);
        GreBook.add(selfdevMod);
        GreBook.add(busiMod);
        GreBook.add(techMod);
        proFeaArr.add(GrePhn);
        proFeaArr.add(GreLap);
        proFeaArr.add(GreBook);
    }
    //-------------------------------------------------------------------------------------------Getting and Showing of products
    static void addProList(String username00){
        Scanner sc = new Scanner(System.in);
        main.flusher();
        main.flusher();
        main.flusher();
        //------------------------------------------------------------------------------------Showing Products to add new in different modules
        if(proListNames.size()==0){
            main4();
            addProList(username00);
            
        }
        else{
            showProList();
            System.out.print((proListNames.size()+1) +". To add a New Product" +"\n" +(proListNames.size()+2) +". Exit " +"\n" +"Enter the Choice : ");
            int cho1 = sc.nextInt();
            if(cho1==proListNames.size()+1){
                addingNewProduct(username00);
                
            }
            else if(cho1==proListNames.size()+2){
                goback(username00);
            }
            else{
                main.flusher();
                main.flusher();
                main.flusher();
                int b = showComArr(cho1-1);
                System.out.print(b+1 +". To add a new Brand" +"\n" +(b+2) +". Exit" +"\n" +"Enter the Choice : ");
                int cho2 = sc.nextInt();
                if(b+1==cho2){
                    addingNewComp(cho1-1,username00);
                }
                else if(b+2==cho2){
                    merch.merActions(username00);
                }
                else{
                    main.flusher();
                    main.flusher();
                    main.flusher();
                    int c= showModList(cho1-1,cho2-1);
                    System.out.print(c+1 +". To Add a New Model " +"\n" +(c+2) +". Exit" +"\n" +"Enter the Choice : ");
                    int cho3 = sc.nextInt();
                    if(c+1==cho3){
                        addNewMod(cho1-1,cho2-1,username00);
                    }
                    else if(c+2==cho3){
                        goback(username00);
                    }
                    else{
                        main.flusher();
                        main.flusher();
                        main.flusher();
                        int d = showFeatureList(cho1-1,cho2-1,cho3-1);
                        System.out.print((d/4)+2 +". To Add a New Feature to this Product" +"\n" +((d/4)+3) +". Exit" +"\n" +"Enter the Exit");
                        int cho4 = sc.nextInt();
                        if((d/4)+2==cho4){
                            addNewFeat(cho1-1,cho2-1,cho3-1,username00);
                        }
                        else if((d/4)+3==cho4){
                            goback(username00);
                        }
                        else{
                            System.out.println("Enter to Exit");
                            main.enterNeeded();
                            goback(username00);
                        }
                    }
                }
            }
        }
    }
    //-------------------------------------------------------------------------------------------Going back to where came
    static void goback(String username00){
        if(username00.equals("11")){
            admin.admlog();
        }
        else{
            merch.merActions(username00);
        }
    }
    //-------------------------------------------------------------------------------------------Showing Products
    static int showProList(){
        for(int i = 1 ; i<=proListNames.size(); i++){
            System.out.println(i +". " +proListNames.get(i-1));
        }
        int a1=proListNames.size();
        return a1;
    }
    //-------------------------------------------------------------------------------------------Showing Brand
    static int showComArr(int a){
        main.flusher();
        main.flusher();
        main.flusher();
        List<String> st = new ArrayList<String>();
        st=proCompArr.get(a);
        for(int i = 1 ; i<=st.size(); i++){
            System.out.println(i +". " +st.get(i-1));
        }
        int a1=st.size();
        return a1;
    }
    //-------------------------------------------------------------------------------------------Showing Models
    static int showModList(int a,int b){
        main.flusher();
        main.flusher();
        main.flusher();
        List<String> st = new ArrayList<String>();
        List<List<String>> st1 = new ArrayList<List<String>>();
        st1=proModArr.get(a);
        st=st1.get(b);
        for(int i = 1 ; i<=st.size(); i++){
            System.out.println(i +". " +st.get(i-1));
        }
        int a1=st.size();
        return a1;
    }
    //-------------------------------------------------------------------------------------------Showing Features
    static int showFeatureList(int a,int b,int c){
        main.flusher();
        main.flusher();
        main.flusher();
        List<String> st = new ArrayList<String>();
        List<List<String>> st1 = new ArrayList<List<String>>();
        List<List<List<String>>> st2 = new ArrayList<List<List<String>>>();
        st2=proFeaArr.get(a);
        st1=st2.get(b);
        st=st1.get(c);
        if(st.size()==0 || st1.size()==0){
            System.out.println("There is No Feature to this Product");
        }
        for(int i = 0 ; i<st.size(); i=i+2){
            System.out.println(st.get(i) +"    :    " +st.get(i+1));
        }
        int a1=st.size();
        return a1;
    }
    //-------------------------------------------------------------------------------------------Getting new Product
    static void addingNewProduct(String username00){
        ArrayList<String> lis = new ArrayList<String>();
        main.flusher();
        main.flusher();
        main.flusher();
        Scanner sc = new Scanner(System.in);
        System.out.print("-----Adding a new product to the Amazon*-----" +"\n" +"Enter the Product Name : ");
        String pr = sc.nextLine();
        proListNames.add(pr);
        addingNewComp(-1,username00);
    }
    //-------------------------------------------------------------------------------------------Getting New Brand
    static void addingNewComp(int a,String username00){
        ArrayList<String> lis = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        System.out.println("-----*Adding a new brand of the product to the Amazon*-----");
        System.out.print("Enter the Brand Name of the product : ");
        String comp = sc.nextLine();
        addCompList(comp,a);
        addNewMod(a,-1,username00);
        System.out.println("-----*The Brand Added Succesfuly*-----");
    }
    //-------------------------------------------------------------------------------------------Getting a New Model
    static void addNewMod(int a,int b,String username00){
        List<String> lis = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Adding a new Model of the product to the Amazon*-----");
        System.out.println("Enter the Model or version of the Product :" );
        String modname = sc.nextLine();
        addModList(modname,a,b);
        addNewFeat(a,b,-1,username00);
        System.out.println("-----*The New Model of the product Added Successfully*-----");
    }
    //-------------------------------------------------------------------------------------------Getting new Feature
    static void addNewFeat(int a,int b,int c,String username00){
        List<String> lis = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        System.out.println("-----*Adding New Feature to the Product*-----");
        System.out.println("How many featues you are going to add to your Product : " );
        String features = sc.nextLine();
        System.out.println("Enter Feature Name And Specification below");
        int features1 = Integer.parseInt(features);
        for(int i = 0 ; i<(features1*2) ; i=i+2){
            System.out.print("Enter the Feature : ");
            String featN = sc.nextLine();
            lis.add(i,featN);
            System.out.print("Enter the Specification : ");
            String spe = sc.nextLine();
            lis.add(i+1,spe);
        }
        addFeatList(lis,a,b,c);
        System.out.println("-----*The New Model of the product Added Successfully*-----" +"\n" +"Enter to Exit");
        main.enterNeeded();
        goback(username00);
    }
    //-------------------------------------------------------------------------------------------Adding new Brand to Amazon
    static void addCompList(String st , int a){
        List<String> lis = new ArrayList<String>();
        if(a==-1){
            lis.add(st);
            proCompArr.add(lis);
        }
        else{
            lis=proCompArr.get(a);
            lis.add(st);
        }
    }
    //-------------------------------------------------------------------------------------------Adding new Model to Amazon
    static void addModList(String st ,int a,int b){
        List<String> lis = new ArrayList<String>();
        List<List<String>> lis1 = new ArrayList<List<String>>();
        if(a==-1){
            lis.add(st);
            lis1.add(lis);
            proModArr.add(lis1);
        }
        else if(b==-1){
            lis1=proModArr.get(a);
            lis.add(st);
            lis1.add(lis);
        }
        else{
            lis1= proModArr.get(a);
            lis = lis1.get(b);
            lis.add(st);
        }
    }
    //-------------------------------------------------------------------------------------------Adding New Feature to Amazon
    static void addFeatList(List<String> lis , int a,int b,int c){
        List<String> lis0 = new ArrayList<String>();
        List<List<String>> lis1 = new ArrayList<List<String>>();
        List<List<List<String>>> lis2 = new ArrayList<List<List<String>>>();
        if(a==-1){
            lis1.add(lis);
            lis2.add(lis1);
            proFeaArr.add(lis2);
        }
        else if(b==-1){
            lis2=proFeaArr.get(a);
            lis1.add(lis);
            lis2.add(lis1);
        }
        else{
            lis2=proFeaArr.get(a);
            lis1=lis2.get(b);
            lis0=lis1.get(c);
            for(int i =0 ; i<lis.size() ; i++){
                lis0.add(i,lis.get(i));
            }
        }
    }
    //-------------------------------------------------------------------------------------------Adding Specific merchant price and Stock
    static void addUserPriSt(int a,int b,int c,String username00,String pri ,String st){
        List<String> temp3 = new ArrayList<String>();
		List<List<String>> temp4 = new ArrayList<List<String>>();
		List<List<List<String>>> temp5 = new ArrayList<List<List<String>>>();
        temp5=proFeaArr.get(a);
        temp4=temp5.get(b);
        temp3=temp4.get(c);
        temp3.add(temp3.size(),"Username");
        temp3.add(temp3.size(),username00);
        temp3.add(temp3.size(),"Price");
        temp3.add(temp3.size(),pri);
        temp3.add(temp3.size(),"Stock");
        temp3.add(temp3.size(),st);
        temp3.add(temp3.size(),"--------------------------------------------------------------------------");
        temp3.add(temp3.size(),"--------------------------------------------------------------------------");
    }
    //-------------------------------------------------------------------------------------------Updating by Merchant of product to sell
    static void updateAmazon(int a , int b , int c,String username00,String pri,String st){
        List<String> temp3 = new ArrayList<String>();
		List<List<String>> temp4 = new ArrayList<List<String>>();
		List<List<List<String>>> temp5 = new ArrayList<List<List<String>>>();
        temp5=proFeaArr.get(a);
        temp4=temp5.get(b);
        temp3=temp4.get(c);
        int a1 = temp3.indexOf(username00);
        temp3.set(a1-1,"Username");
        temp3.set(a1,username00);
        temp3.set(a1+1,"Price");
        temp3.set(a1+2,pri);
        temp3.set(a1+3,"Stock");
        temp3.set(a1+4,st);
        temp3.set(a1+5,"--------------------------------------------------------------------------");
        temp3.set(a1+6,"--------------------------------------------------------------------------");
    }
    //-------------------------------------------------------------------------------------------Removing Username product from Amazon
    static void updateAmazonRem(int a,int b,int c,String username00){
        List<String> temp3 = new ArrayList<String>();
		List<List<String>> temp4 = new ArrayList<List<String>>();
		List<List<List<String>>> temp5 = new ArrayList<List<List<String>>>();
        temp5=proFeaArr.get(a);
        temp4=temp5.get(b);
        temp3=temp4.get(c);
        int a1 = temp3.indexOf(username00);
        temp3.remove(a1-1);
        temp3.remove(a1-1);
        temp3.remove(a1-1);
        temp3.remove(a1-1);
        temp3.remove(a1-1);
        temp3.remove(a1-1);
        temp3.remove(a1-1);
        temp3.remove(a1-1);
    }
    //-------------------------------------------------------------------------------------------Removing All products Added by that Specific user
    static void remAllAddedPro(int a , String username00){
        List<String> lis = new ArrayList<String>();
		List<List<String>> lis1 = new ArrayList<List<String>>();
		List<List<List<String>>> lis2 = new ArrayList<List<List<String>>>();
        
        for(int i= 0 ; i<proListNames.size() ; i++){
            for(int j = 0 ; j<proCompArr.size() ; j++){
                for(int k = 0 ; k<proModArr.size() ; k++){
                    lis2=proFeaArr.get(i);
                    lis1=lis2.get(j);
                    lis=lis1.get(k);
                    int a1 = lis.indexOf(username00);
                    if(a1!=-1){
                    lis.remove(a1-1);
                    lis.remove(a1-1);
                    lis.remove(a1-1);
                    lis.remove(a1-1);
                    lis.remove(a1-1);
                    lis.remove(a1-1);
                    lis.remove(a1-1);
                    lis.remove(a1-1);
                    }
                }
            }
        }
    }
    //------------------------------------------------------------------------------------------Product update by user
    static void updateAmazonbyusr(int a,int b,int c,String username00,int sto){
        List<String> temp3 = new ArrayList<String>();
		List<List<String>> temp4 = new ArrayList<List<String>>();
		List<List<List<String>>> temp5 = new ArrayList<List<List<String>>>();
        temp5=proFeaArr.get(a);
        temp4=temp5.get(b);
        temp3=temp4.get(c);
        int a1 = temp3.indexOf(username00);
        int sto1 = Integer.parseInt(temp3.get(a1+4));
        sto1=sto1-sto;
        String sto10=Integer.toString(sto1);
        temp3.set(a1+4,sto10);
        
    }
    
}
class MerProducts{
    //---------------------------------------------------------------here we are going to add and showproducts to the user
    static Main main = new Main();
    static Admin admin = new Admin();
    static User user = new User();
    static Merchant merch = new Merchant();
    static Product produt = new Product();
    //------------------------------------------------------------------------------------------Product lists of all Users
    static List<List<List<String>>> WholeProductMer = new ArrayList<List<List<String>>>();
    //-----------------------------------------------------------------------------------Adding New Space for Merchant Products to sell
    static void addingNewSpace(int a){
        List<String> lis = new ArrayList<String>();
        List<List<String>> lis1 = new ArrayList<List<String>>();
        lis.add("Enter to Exit");
        lis1.add(lis);
        WholeProductMer.add(a,lis1);
        
    }
    //-----------------------------------------------------------------------------------Adding Products for specific products
    static void addingSpecPro(int a,String username00){
        Scanner sc = new Scanner(System.in);
        List<String> lisi = new ArrayList<String>();
        List<List<String>> lisa = new ArrayList<List<String>>();
        lisa=WholeProductMer.get(a);
        lisi=lisa.get(0);
        System.out.print("1.Adding a New Product from Amazon" +"\n" +"2.Adding Stock Number in already existing"
        +"\n" +"Enter the Choice : ");
        int c = sc.nextInt();
        if(c==1){
        if(lisi.size()==0){
            lisa.remove(0);
        }
        int p,b,m;
        String pr,s;
        main.flusher();
        main.flusher();
        main.flusher();
        List<String> lis = new ArrayList<String>();
        List<List<String>> lis1 = new ArrayList<List<String>>();
        System.out.println("-----All the Best Merchant*-----" +"\n" +"Enter the Choices to Add a that Product ");
        lis1=WholeProductMer.get(a);
        lis.add(0,"Username");
        lis.add(username00);
        int i = 3;
        lis.add("Product");
        lis.add("Product");
        lis.add("Product");
        lis.add("Product");
        lis.add("Product");
        lis.add("Product");
        if(produt.proListNames.size()==0){
            produt.main4();
        }
        int pro = produt.showProList();
        System.out.print(pro+1 +". Exit" +"\n" +"Enter the Choice to Add : ");
        p = sc.nextInt();
        if(pro+1==p){
            merch.merActions(username00);
        }
        else{
            lis.set(i,produt.proListNames.get(p-1));
            i=i+2;
            int bran = produt.showComArr(p-1);
            System.out.print(bran+1 +". Exit" +"\n" +"Enter the Choice to Add : ");
            b=sc.nextInt();
            if(bran+1==b){
                merch.merActions(username00);
            }
            else{
                List<String> temp = new ArrayList<String>();
                temp = produt.proCompArr.get(p-1);
                main.flusher();
                lis.set(i-1,"Brand");
                lis.set(i,temp.get(b-1));
                i=i+2;
                int mod = produt.showModList(p-1,b-1);
                System.out.print(mod+1 +". Exit" +"\n" +"Enter the Choice to Add : ");
                m = sc.nextInt();
                if(mod+1==m){
                    merch.merActions(username00);
                }
                else{
                    List<String> temp1 = new ArrayList<String>();
		            List<List<String>> temp2 = new ArrayList<List<String>>();
		            temp2 = produt.proModArr.get(p-1);
		            temp1= temp2.get(b-1);
		            lis.set(i-1,"Model");
		            lis.set(i,temp1.get(m-1));
                    int feat = produt.showFeatureList(p-1,b-1,m-1);
                    System.out.print((mod/2)+1 +". Exit" +"\n" +((mod/2)+2) +". Enter to add this product to List : ");
                    int ch = sc.nextInt();
                    String ss= sc.nextLine();
                    if((mod/2)+1==ch){
                        merch.merActions(username00);
                    }
                    else{
                        List<String> temp3 = new ArrayList<String>();
		                List<List<String>> temp4 = new ArrayList<List<String>>();
		                List<List<List<String>>> temp5 = new ArrayList<List<List<String>>>();
                        System.out.print("Enter the price you want to sell this product : ");
                        pr = sc.nextLine();
                        System.out.print("Enter the Amount of Stock of this product : ");
                        s=sc.nextLine();
                        produt.addUserPriSt(p-1,b-1,m-1,username00,pr,s);
                        temp5=produt.proFeaArr.get(p-1);
                        temp4=temp5.get(b-1);
                        temp3=temp4.get(m-1);
                        for(i=0 ; i<temp3.size(); i++){
                            if(temp3.get(i).equals("Username")){
                                break;
                            }
                            else
                            lis.add(temp3.get(i));
                        }
                        lis.add("Price");
                        lis.add(pr);
                        lis.add("Stock");
                        lis.add(s);
                    }
                }
            }
        }
        lis1.add(0,lis);
        System.out.println("-----*The Product Added Successfully*-----");
        main.enterNeeded();
        merch.merActions(username00);
        }
        else{
            upDate(a,username00);
        }
        
    }
    //---------------------------------------------------------------------------------------View Merchant product
    static int showSpecficSpace(int a,String username00){
        List<String> lio = new ArrayList<String>();
        List<List<String>> bh = new ArrayList<List<String>>();
        main.flusher();
        System.out.println("-----*Welcome " +username00 +"*-----");
        int procho = 0;
        bh=WholeProductMer.get(a);
        for(int j=0 ; j<bh.size() ; j++){
            System.out.println("*---------------------------------------------------------------------------------------*");
            System.out.println("*----------------------------" +procho +"------------------------------------------------*");
            lio.addAll(bh.get(j));
            for(int i = 1 ; i<lio.size() ; i=i+2){
                System.out.println(lio.get(i-1) +"  :  " +lio.get(i));
            }
            procho++;
            lio.clear();
            
        }
        return procho;
        
    }
    //---------------------------------------------------------------------------------------Update each merch Product List
    static void upDate(int a , String username00){
        List<String> st = new ArrayList<String>();
        List<List<String>> st1 = new ArrayList<List<String>>();
        List<String> lis = new ArrayList<String>();
        List<List<String>> lis1 = new ArrayList<List<String>>();
        List<List<List<String>>> lis2 = new ArrayList<List<List<String>>>();
        st1=WholeProductMer.get(a);
        Scanner sc = new Scanner(System.in);
        int procho = showSpecficSpace(a,username00);
        System.out.print("Enter the Product Number to update Price and stock Number : ");
        int pronum=sc.nextInt();
        sc.nextLine();
        if(pronum==procho){
            merch.merActions(username00);
        }
        else{
        showEachSpace(a,pronum);
        st=st1.get(pronum);
        System.out.println("Enter to Confirm the product" +"\n" +"1.Change the Product" +"\n" +"2.Exit");
        String con = sc.nextLine();
        if(con.equals("1")){
            upDate(a,username00);
        }
        else if(con.equals("2")){
            merch.merActions(username00);
        }
        else{
        System.out.print("Enter the Stock number you want to change to : ");
        String sto = sc.nextLine();
        System.out.print("Enter the Price you want to sell to : ");
        String pri = sc.nextLine();
        st.set(st.size()-1,sto);
        st.set(st.size()-3,pri);
        int a0 = produt.proListNames.indexOf(st.get(3));
        lis = produt.proCompArr.get(a0);
        int b0= lis.indexOf(st.get(5));
        lis1=produt.proModArr.get(a0);
        lis=lis1.get(b0);
        int c0=lis.indexOf(st.get(7));
        produt.updateAmazon(a0,b0,c0,username00,pri,sto);
        System.out.println("-----*Price and Stock Updated Successfully*-----");
        main.enterNeeded();
        merch.merActions(username00);
        }
        }
    }
    //---------------------------------------------------------------------------------------Showing each product of specific user
    static void showEachSpace(int a,int pronum){
        List<String> st = new ArrayList<String>();
        List<List<String>> st1 = new ArrayList<List<String>>();
        List<String> lis = new ArrayList<String>();
        List<List<String>> lis1 = new ArrayList<List<String>>();
        List<List<List<String>>> lis2 = new ArrayList<List<List<String>>>();
        st1=WholeProductMer.get(a);
        st=st1.get(pronum);
        for(int i = 1 ; i<st.size() ; i=i+2){
            System.out.println(st.get(i-1) +"  :  " +st.get(i));
        }
    }
    //---------------------------------------------------------------------------------------Removing Specific User Product
    static void reMoveProduct(int a , String username00){
        List<String> st = new ArrayList<String>();
        List<List<String>> st1 = new ArrayList<List<String>>();
        List<String> lis = new ArrayList<String>();
        List<List<String>> lis1 = new ArrayList<List<String>>();
        List<List<List<String>>> lis2 = new ArrayList<List<List<String>>>();
        Scanner sc = new Scanner(System.in);
        int procho = showSpecficSpace(a,username00);
        System.out.print("Enter the Product Number to Remove on Amozon : ");
        int pronum=sc.nextInt();
        sc.nextLine();
        if(pronum==procho){
            merch.merActions(username00);
        }
        else{
        showEachSpace(a,pronum);
        st1=WholeProductMer.get(a);
        st=st1.get(pronum);
        System.out.println("Enter to Confirm the product" +"\n" +"1.Change the Product" +"\n" +"2.Exit");
        String con = sc.nextLine();
        if(con.equals("1")){
            reMoveProduct(a,username00);
        }
        else if(con.equals("2")){
            merch.merActions(username00);
        }
        else{
            st1=WholeProductMer.get(a);
            st = st1.remove(pronum);
            int a0 = produt.proListNames.indexOf(st.get(3));
            lis = produt.proCompArr.get(a0);
            int b0= lis.indexOf(st.get(5));
            lis1=produt.proModArr.get(a0);
            lis=lis1.get(b0);
            int c0=lis.indexOf(st.get(7));
            produt.updateAmazonRem(a0,b0,c0,username00);
        }}
        System.out.println("-----*The product removed Successfully*-----");
        main.enterNeeded();
        merch.merActions(username00);
    
    }
    //---------------------------------------------------------------------------------------Removing Whole Merchant
    static void remMerPro(int a , String username00){
        produt.remAllAddedPro(a,username00);
        WholeProductMer.remove(a);
    }
    
}
class UserMaterials{
    //----------------------------------------------------------------------------------Objects of other Class
    static Main main = new Main();
    static Admin admin = new Admin();
    static User user = new User();
    static Merchant merch = new Merchant();
    static Product produt = new Product();
    static MerProducts merpro = new MerProducts();
    //----------------------------------------------------------------------------------List Materials of Users
    static ArrayList<Integer> wallet = new ArrayList<Integer>();
    static List<List<List<String>>> kartItems = new ArrayList<List<List<String>>>();
    static List<List<List<String>>> orderItems = new ArrayList<List<List<String>>>();
    //-------------------------------------------------------------------------------------Adding new Space to the user
    static void addNewUserSpacewal(int a){
        List<String> lis = new ArrayList<String>();
        List<List<String>> lis1 = new ArrayList<List<String>>();
        int a1=0;
        wallet.add(a,a1);
        addNewUserSpaceKart(a);
        addNewUserSpaceOrder(a);
    }
    static void addNewUserSpaceKart(int a){
        List<String> lis2 = new ArrayList<String>();
        List<List<String>> lis3 = new ArrayList<List<String>>();
        lis2.add("");
        lis3.add(lis2);
        kartItems.add(a,lis3);
        
    }
    static void addNewUserSpaceOrder(int a){
        List<String> lis4 = new ArrayList<String>();
        List<List<String>> lis5 = new ArrayList<List<String>>();
        lis4.add("Enter to Exit");
        lis5.add(lis4);
        orderItems.add(a,lis5);
        
    }
    //------------------------------------------------------------------------------------View Products and get choice to add Kart or Buy
    static void viewProductsUsr(String username00){
        Scanner sc = new Scanner(System.in);
        main.flusher();
        main.flusher();
        main.flusher();
        //------------------------------------------------------------------------------------Showing Products to add new in different modules
        if(produt.proListNames.size()==0){
            produt.main4();
            viewProductsUsr(username00);
            
        }
        else{
            produt.showProList();
            int siz=produt.proListNames.size();
            System.out.print((siz+1) +". Exit " +"\n" +"Enter the Choice : ");
            int cho1 = sc.nextInt();
            if(cho1==siz+1){
                gobackusr(username00);
            }
            else{
                main.flusher();
                main.flusher();
                main.flusher();
                int b = produt.showComArr(cho1-1);
                System.out.print((b+1) +". Exit" +"\n" +"Enter the Choice : ");
                int cho2 = sc.nextInt();
                if(b+1==cho2){
                    gobackusr(username00);
                }
                else{
                    main.flusher();
                    main.flusher();
                    main.flusher();
                    int c= produt.showModList(cho1-1,cho2-1);
                    System.out.print(c+1 +". Exit" +"\n" +"Enter the Choice : ");
                    int cho3 = sc.nextInt();
                    if(c+1==cho3){
                        gobackusr(username00);
                    }
                    else{
                        main.flusher();
                        main.flusher();
                        main.flusher();
                        int d = produt.showFeatureList(cho1-1,cho2-1,cho3-1);
                        System.out.print(((d/4)+1) +". To Add this Product to a Kart" +"\n" +((d/4)+2) +". To Buy this Product"
                        +"\n" +((d/4)+3) +". Exit" +"\n" +"Enter the Choice : ");
                        int cho4 = sc.nextInt();
                        sc.nextLine();
                        if((d/4)+1==cho4){
                            addToKart(cho1-1,cho2-1,cho3-1,username00);
                            System.out.print("-----*Your product added to Kart Successfully*-----");
                            main.enterNeeded();
                            gobackusr(username00);
                        }
                        else if((d/4)+2==cho4){
                            buyByUsr(cho1-1,cho2-1,cho3-1,username00);
                            main.enterNeeded();
                            gobackusr(username00);
                        }
                        else{
                            System.out.println("Enter to Exit");
                            main.enterNeeded();
                            gobackusr(username00);
                        }
                    }
                }
            }
        }
    }
    //------------------------------------------------------------------------------------Going Back to Where it called
    static void gobackusr(String username00){
        if(username00.equals("11")){
            admin.admlog();
        }
        else{
            user.userActions(username00);
        }
    }
    //------------------------------------------------------------------------------------Place a order
    static void buyByUsr(int a,int b,int c,String username00){
        Scanner sc = new Scanner(System.in);
        List<String> lis = new ArrayList<String>();
        main.flusher();
        int d = produt.showFeatureList(a,b,c);
        if(d==0){
            System.out.println("No merchant Available to this Product" +"\n" +"Enter to Exit");
            main.enterNeeded();
            gobackusr(username00);
        }
        else if(checkforMerch(a,b,c)){
            System.out.print("Please enter the Merchant id you going to buy : ");
            String meridpro=sc.nextLine();
            System.out.print("Enter the number of Stocks you want : ");
            int sto = sc.nextInt();
            if(checkforStock(a,b,c,meridpro,sto)){
                System.out.println("1.Pay by Wallet " +"\n" +"2.Cash on Delivery" +"\n" +"3.Exit " +"\n" +"Enter the Choice : ");
                int buy = sc.nextInt();
                List<String> st = new ArrayList<String>();
                List<List<String>> st1 = new ArrayList<List<String>>();
                List<List<List<String>>> st2 = new ArrayList<List<List<String>>>();
                st2=produt.proFeaArr.get(a);
                st1=st2.get(b);
                st=st1.get(c);
                int a1 = st.indexOf(meridpro);
                int pri=Integer.parseInt(st.get(a1+2));
                if(buy==1){
                    if(checkforWallet(admin.usrHp.get(username00),pri*sto)){
                        produt.updateAmazonbyusr(a,b,c,meridpro,sto);
                        updateOrderList(a,b,c,meridpro,sto,admin.usrHp.get(username00));
                        int ae=wallet.get(admin.usrHp.get(username00));
                        ae=ae-pri*sto;
                        wallet.set(admin.usrHp.get(username00),ae);
                        System.out.println("----*Your Order Placed Succesfully*-----");
                    }
                    else{
                        System.out.print("Your Wallet has insufficient Amount" +"\n" +"1.Continue with Cash on Delivery" +"\n" +"2.Exit"
                        +"\n" +"Enter the Choice : ");
                        int dec = sc.nextInt();
                        if(dec==1){
                            produt.updateAmazonbyusr(a,b,c,meridpro,sto);
                            updateOrderList(a,b,c,meridpro,sto,admin.usrHp.get(username00));
                            System.out.println("----*Your Order Placed Succesfully*-----");
                        }
                        else if(dec==2){
                            main.enterNeeded();
                            gobackusr(username00);
                        }
                    }
                }
                else if(buy==2){
                    produt.updateAmazonbyusr(a,b,c,meridpro,sto);
                    updateOrderList(a,b,c,meridpro,sto,admin.usrHp.get(username00));
                    System.out.println("----*Your Order Placed Succesfully*-----");
                }
                else{
                    main.enterNeeded();
                    gobackusr(username00);
                    
                }
            }
            else{
                System.out.println("The Stock is insufficient ");
                main.enterNeeded();
                gobackusr(username00);
            } 
        }
        else{
            System.out.println("No merchant Available to this Product" +"\n" +"Enter to Exit");
            main.enterNeeded();
            gobackusr(username00);
        }
    }
    //-----------------------------------------------------------------------------------Checking for merchants to buy
    static boolean checkforMerch(int a,int b , int c){
        List<String> st = new ArrayList<String>();
        List<List<String>> st1 = new ArrayList<List<String>>();
        List<List<List<String>>> st2 = new ArrayList<List<List<String>>>();
        st2=produt.proFeaArr.get(a);
        st1=st2.get(b);
        st=st1.get(c);
        if(st.indexOf("Username")==-1)
        return false;
        else
        return true;
    }
    //----------------------------------------------------------------------------------Checking for Stocks
    static boolean checkforStock(int a,int b,int c,String username00,int sto){
        List<String> st = new ArrayList<String>();
        List<List<String>> st1 = new ArrayList<List<String>>();
        List<List<List<String>>> st2 = new ArrayList<List<List<String>>>();
        st2=produt.proFeaArr.get(a);
        st1=st2.get(b);
        st=st1.get(c);
        int a1 = st.indexOf(username00);
        int stonu=Integer.parseInt(st.get(a1+4));
        if(stonu<sto)
        return false;
        else
        return true;
    }
    //----------------------------------------------------------------------------------Checking Wallet
    static boolean checkforWallet(int a,int pri){
        if(wallet.size()==0){
            int aa=0;
            wallet.add(aa);
        }
        if(wallet.get(a)>=pri){
            return true;
        }
        else
        return false;
        
    }
    //-----------------------------------------------------------------------------------Updating Order List
    static void updateOrderList(int a,int b,int c,String merid,int stock,int userspace){
        List<String> lis = new ArrayList<String>();
        List<List<String>> lis1 = new ArrayList<List<String>>();
        lis.add(0,"MerId");
        lis.add(merid);
        lis.add("Product");
        lis.add(produt.proListNames.get(a));
        lis.add("Brand");
        List<String> lisi = new ArrayList<String>();
        lisi=produt.proCompArr.get(a);
        lis.add(lisi.get(b));
        lis.add("Model");
        List<List<String>> lisa = new ArrayList<List<String>>();
        lisa=produt.proModArr.get(a);
        lisi=lisa.get(b);
        lis.add(lisi.get(c));
        lis.add("Stock");
        lis.add(Integer.toString(stock));
        lis1=orderItems.get(userspace);
        lis1.add(0,lis);
    }
    //-----------------------------------------------------------------------------------Showing all orders of user 
    static void orderList(int a,String username00){
        List<String> lio = new ArrayList<String>();
        List<List<String>> bh = new ArrayList<List<String>>();
        main.flusher();
        System.out.println("-----*Welcome " +username00 +"*-----");
        if(orderItems.size()==0){
            System.out.println("No Users Yet");
        }
        else{
        int procho = 1;
        bh=orderItems.get(a);
        if(bh.size()==0){
            System.out.println("No orders were Placed by you");
        }
        else{
        for(int j=0 ; j<bh.size() ; j++){
            lio.addAll(bh.get(j));
            for(int i = 1 ; i<lio.size() ; i=i+2){
                System.out.println(lio.get(i-1) +"  :  " +lio.get(i));
            }
            System.out.println("*---------------------------------------------------------------------------------------*");
            System.out.println("*----------------------------" +procho +"------------------------------------------------*");
            procho++;
            lio.clear();
            
        }}}
        System.out.println("Enter to Exit");
        main.enterNeeded();
        user.userActions(username00);
    }
    //-----------------------------------------------------------------------------------Add Amount to Wallet
    static void addAmounttoWallet(int a,String username00){
        
        Scanner sc = new Scanner(System.in);
        main.flusher();
        System.out.println("1.Add the Amount to Wallet" +"\n" +"2.View the Wallet Balance" +"\n" +"3.Exit" +"\n" +"Enter the Choice : ");
        int cho= sc.nextInt();
        if(cho==1){
            System.out.print("Enter the Amount you want to Add to Wallet : " );
            int amt = sc.nextInt();
            System.out.print(wallet.set(a,wallet.get(a)+amt));
            System.out.print("-----*The Amount is Successfully Added to Wallet*-----");
        }
        else if(cho==2){
            System.out.print("YOur Wallet balance is : " );
            System.out.print(wallet.get(a));
        }
        else{
            System.out.print("Enter to Logout" );
        }
        main.enterNeeded();
        user.userActions(username00);
    }
    //-----------------------------------------------------------------------------------Updating kart
    static void addToKart(int a,int b,int c,String username00){
        int userspace = admin.usrHp.get(username00);
        List<String> lis = new ArrayList<String>();
        List<List<String>> lis1 = new ArrayList<List<String>>();
        lis.add("Product");
        lis.add(produt.proListNames.get(a));
        lis.add("Brand");
        List<String> lisi = new ArrayList<String>();
        lisi=produt.proCompArr.get(a);
        lis.add(lisi.get(b));
        lis.add("Model");
        List<List<String>> lisa = new ArrayList<List<String>>();
        lisa=produt.proModArr.get(a);
        lisi=lisa.get(b);
        lis.add(lisi.get(c));
        if(kartItems.size()==0){
            lis1.add(lis);
            kartItems.add(lis1);
        }
        else{
        lis1=kartItems.get(userspace);
        lis1.add(0,lis);
        }
    }
    //-----------------------------------------------------------------------------------Showing All Kart items
    static void showkartItems(int a,String username00){
        Scanner sc = new Scanner(System.in);
        List<String> lio = new ArrayList<String>();
        List<List<String>> bh = new ArrayList<List<String>>();
        main.flusher();
        System.out.println("-----*Welcome " +username00 +"*-----");
        if(kartItems.size()==0){
            System.out.println("No Kart Items You Added ");
            main.enterNeeded();
            user.userActions(username00);
        }
        else{
        int procho = 1;
        bh=kartItems.get(a);
        for(int j=0 ; j<bh.size() ; j++){
            System.out.println("*---------------------------------------------------------------------------------------*");
            System.out.println("*----------------------------" +procho +"------------------------------------------------*");
            lio.addAll(bh.get(j));
            for(int i = 1 ; i<lio.size() ; i=i+2){
                System.out.println(lio.get(i-1) +"  :  " +lio.get(i));
            }
            
            procho++;
            lio.clear();
            
        }
        List<String> st = new ArrayList<String>();
        List<List<String>> st1 = new ArrayList<List<String>>();
        List<String> lis = new ArrayList<String>();
        List<List<String>> lis1 = new ArrayList<List<String>>();
        st1=kartItems.get(a);
        System.out.print("Enter the Product Number to Buy : ");
        int pronum=sc.nextInt();
        pronum--;
        sc.nextLine();
        if(pronum==(procho-2)){
            user.userActions(username00);
        }
        else{
        showEachKart(a,pronum);
        st=st1.get(pronum);
        System.out.println("Enter to Confirm the product" +"\n" +"1.Change the Product" +"\n" +"2.Exit");
        String con = sc.nextLine();
        if(con.equals("1")){
            showkartItems(a,username00);
        }
        else if(con.equals("2")){
            user.userActions(username00);
        }
        else{
            List<String> st9 = new ArrayList<String>();
            List<List<String>> st10 = new ArrayList<List<String>>();
            st10=kartItems.get(a);
            st9=st1.get(pronum);
            int a0 = produt.proListNames.indexOf(st9.get(1));
            List<String> stt = new ArrayList<String>();
            stt = produt.proCompArr.get(a0);
            int b0=stt.indexOf(st9.get(3));
            List<String> st00 = new ArrayList<String>();
            List<List<String>> st11 = new ArrayList<List<String>>();
            st11 = produt.proModArr.get(a0);
            st00=st11.get(b0);
            int c0 = st00.indexOf(st9.get(5));
            buyByUsr(a0,b0,c0,username00);
            
        }}}
    }
    static void showEachKart(int a,int pronum){
        List<String> st = new ArrayList<String>();
        List<List<String>> st1 = new ArrayList<List<String>>();
        st1=kartItems.get(a);
        st=st1.get(pronum);
        for(int i = 1 ; i<st.size() ; i=i+2){
            System.out.println(st.get(i-1) +"  :  " +st.get(i));
        }
    }
    static void removeUserCom(int a){
        wallet.remove(a);
        kartItems.remove(a);
        orderItems.remove(a);
    }
}
