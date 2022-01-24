import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main{
    static User user = new User();
    static Admin admin = new Admin();
    static Books book = new Books();
    public static void main(String[] args){
        main0();
    }
    //------------------------------------------------------------------------------------------Infinite loop of Program
    static void main0(){
        Scanner sc = new Scanner(System.in);
        while(true){
            flusher();
            System.out.print("--------*Welcome to the Library Management System*--------" +"\n" +"1.Admin" +"\n" +"2.User" +"\n" +"3.Exit"
            +"\n" +"Enter the Choice : ");
            String ch = sc.nextLine();
            if(ch.equals("1")){
                admin.logAdm();
            }
            else if(ch.equals("2")){
                user.logUsr();
            }
            else if(ch.equals("3")){
                System.out.println("\n" +"\n" +"\n" +"------------------*Enter to Logout*---------------");
                enterNeeded();
                System.exit(0);
             }
             else{
                 System.out.println("Invalid Choice" +"\n" +"Enter to Retry");
                 enterNeeded();
                 main0();
             }
        }
    }
    static void flusher(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    static void enterNeeded(){
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
}
class Admin{
    //------------------------------------------------------------------------------Objects of other class
    static Main main = new Main();
    static User user = new User();
    static Books book = new Books();
    //------------------------------------------------------------------------------Lists of the Admins 
    static List<String> admNames = new ArrayList<String>();
    static List<String> admPwd = new ArrayList<String>();
    //------------------------------------------------------------------------------Logging in as admin
    public static void logAdm(){
        Scanner sc = new Scanner(System.in);
        if(admNames.size()==0){
            admNames.add("11");
            admPwd.add("11");
        }
        System.out.println("----------------*Welcomeback Admin*-------------");
        System.out.print("Enter the Username : ");
        String admnam = sc.nextLine();
        int a = admNames.indexOf(admnam);
        if(a==-1){
            System.out.print("Admin name not Exist" +"\n" +"Enter to Retry");
            main.enterNeeded();
            main.flusher();
            logAdm();
        }
        System.out.print("Enter the Password : ");
        String admpwd = sc.nextLine();
        if(admPwd.get(a).equals(admpwd)){
            admActions(a,admnam);
        }
        else{
            System.out.print("Invalid Password" +"\n" +"Enter to Retry");
            main.enterNeeded();
            main.flusher();
            main.main0();
        }
    }
    //------------------------------------------------------------------------------Admin Actions
    static void admActions(int a,String username00){
        Scanner sc = new Scanner(System.in);
        main.flusher();
        System.out.print("-------------------------------*Welcome Admin*-----------------------------" +"\n" +"1. View Books" +"\n" +"2. Add Books "
        +"\n" +"3. Modify Books"+"\n" +"4. Add Admin" +"\n" +"5. Add User" +"\n" +"6. View Admin"
        +"\n" +"7. View users" +"\n" +"8. Search Book" +"\n" +"9. Show Library Balance" +"\n" +"10. Exit" +"\n" +"Enter the Choice : ");
        String ch = sc.nextLine();
        //-------------------------------------------------------------------------------------------------View Books - Complete
        if(ch.equals("1")){
            book.viewCat();
            int lim=book.bookCat.size();
            System.out.print(lim +". Exit" +"\n" +"Enter the Category to View List of Books : ");
            int c = sc.nextInt();
            if(c>lim){
                System.out.println("Invalid Input" +"\n" +"Enter to Exit");
                main.enterNeeded();
                admActions(a,username00);
            }
            else if(c==lim){
                admActions(a,username00);
            }
            else{
                book.viewbookLis(c);
                int lim1=book.limbooklist(c);
                System.out.print(lim1 +". Exit" +"\n" +"Enter the Book number to View the Book Data : ");
                int d = sc.nextInt();
                if(d>lim1){
                    System.out.println("Invalid Input" +"\n" +"Enter to Exit");
                    main.enterNeeded();
                    admActions(a,username00);
                }
                else if(d==lim1){
                    admActions(a,username00);
                }
                else{
                    book.viewBookData(c,d);
                    System.out.print("Enter to Exit");
                    main.enterNeeded();
                    admActions(a,username00);
                }
            }
            
        }
        //-------------------------------------------------------------------------------------------------Add New Books - Complete
        else if(ch.equals("2")){
            addBooks(a,username00);
        }
        //-------------------------------------------------------------------------------------------------Modify Books - Complete
        else if(ch.equals("3")){
            modifyBooks(a,username00);
        }
        //-------------------------------------------------------------------------------------------------Add Admin - Complete
        else if(ch.equals("4")){
            sc.nextLine();
            System.out.println("------------------------*You can Add Admins Here*---------------------");
            System.out.print("Enter the Admin Username : ");
            String adnn = sc.nextLine();
            System.out.print("Enter the Admin Password : ");
            String adpp = sc.nextLine();
            admNames.add(adnn);
            admPwd.add(adpp);
            System.out.print("-------------------------*Admin Added Successfully*-------------------------" +"\n" +"Enter to Exit");
            main.enterNeeded();
            admActions(a,username00);
        }
        //-------------------------------------------------------------------------------------------------Add User - Complete
        else if(ch.equals("5")){
            System.out.println("----------------*Welcome*-----------------");
            System.out.print("Enter the Username : ");
            String admname = sc.nextLine();
            System.out.print("Enter the Password : ");
            String admpwde = sc.nextLine();
            user.usrNames.add(admname);
            user.usrMon.add(1500);
            LibraryAccounts libra = new LibraryAccounts();
            libra.addAmo();
            user.usrPwd.add(admpwde);
            user.usrHp.put(admname,user.usrNames.size());
            List<String> lie = new ArrayList<>();
            lie.add("0");
            user.usrsBooks.add(lie);
            List liee = new ArrayList<>();
            List<List> lieee = new ArrayList<>();
            liee.add("0");
            lieee.add(liee);
            user.usrsBookDat.add(lieee);
            System.out.print("\n" +"\n" +"-------------*Account Registered Successfully*-------------");
            main.enterNeeded();
            admActions(a,username00);
        }
        //-------------------------------------------------------------------------------------------------Viewing Admins - Complete
        else if(ch.equals("6")){
            for(int i = 0 ; i<admNames.size() ; i++){
                System.out.println((i+1) +". " +admNames.get(i));
            }
            System.out.print("Enter to Exit");
            main.enterNeeded();
            admActions(a,username00);
            
        }
        //-------------------------------------------------------------------------------------------------Viewing Users - Complete
        else if(ch.equals("7")){
            for(int i = 0 ; i<user.usrNames.size() ; i++){
                System.out.println((i+1) +". " +user.usrNames.get(i));
            }
            System.out.print("Enter to Exit");
            main.enterNeeded();
            admActions(a,username00);
        }
        //-------------------------------------------------------------------------------------------------Searching Book - Complete
        else if(ch.equals("8")){
            book.searchBook(1,a,username00);
        }
        else if(ch.equals("9")){
            LibraryAccounts ll = new LibraryAccounts();
            ll.display();
            main.enterNeeded();
            admActions(a,username00);
        }
        else if(ch.equals("10")){
            System.out.print("\n" +"\n" +"\n" +"---------------*Enter to Login Page*------------");
            main.enterNeeded();
            main.main0();
        }
        else{
            System.out.print("Invalid Password" +"\n" +"Enter to Retry");
            main.enterNeeded();
            main.flusher();
            admActions(a,username00);
        }
    }
    //------------------------------------------------------------------------------Adding Book
    static void addBooks(int a ,String username00){
        Scanner sc = new Scanner(System.in);
        book.viewCat();
            int lim=book.bookCat.size();
            System.out.print(lim +". Add a New Category "+"\n" +(lim+1) +". Exit" +"\n" +"Enter the Category to View List of Books : ");
            int c = sc.nextInt();
            sc.nextLine();
            if(c>lim+1){
                System.out.println("Invalid Input" +"\n" +"Enter to Exit");
                main.enterNeeded();
                admActions(a,username00);
            }
            else if(c==lim+1){
                admActions(a,username00);
            }
            else if(c==lim){
                addCat(a,username00);
            }
            else{
                book.viewbookLis(c);
                int lim1=book.limbooklist(c);
                System.out.print(lim1 +". Add a New Book to this Category "+"\n" +(lim1+1)  +". Exit" +"\n" +"Enter the Choice to Add Book or Exit : ");
                int d = sc.nextInt();
                if(d>lim1+1){
                    System.out.println("Invalid Input" +"\n" +"Enter to Exit");
                    main.enterNeeded();
                    admActions(a,username00);
                }
                else if(d==lim1+1){
                    admActions(a,username00);
                }
                else if(d==lim1){
                    addNewBook(a,username00,c);
                }
                else{
                    System.out.println("You Cannot add a Existing Book" +"\n" +"Enter to Retry");
                    main.enterNeeded();
                    addBooks(a,username00);
                }
            }
    }
    //------------------------------------------------------------------------------------------Add a New Category of Book
    static void addCat(int a,String username00){
        Scanner sc = new Scanner(System.in);
        main.flusher();
        int lim=book.bookCat.size();
        System.out.print("--------------------*Welcome Admin*-------------------" +"\n" +"Enter the Category Name : ");
        String catn = sc.nextLine();
        book.bookCat.add(catn);
        addNewBook(a,username00,lim);
    }
    //-----------------------------------------------------------------------------------------Add a New Book
    static void addNewBook(int a,String username00,int a1){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Book Name : ");
        String bokn = sc.nextLine();
        book.RandomPro(bokn);
        List<String> li = new ArrayList<String>();
        if(a1==(book.booksName.size())){
            li.add("0");
            li.add(bokn);
            book.booksName.add(li);
            book.dataPro(a1,0,0,0,0);
        }
        else{
            li=book.booksName.get(a1);
            li.add(bokn);
        }
        System.out.print("Enter the Number of Books you going to Place : ");
        int quan = sc.nextInt();
        System.out.print("Enter the Price of the Book : ");
        
        int pri = sc.nextInt();
        book.dataPro(a1,li.size()-1,quan,0,pri);
        System.out.println("-------------------*Book Added Successfully*----------------" +"\n" +"Enter to Exit");
        main.enterNeeded();
        admActions(a,username00);
    }
    //-----------------------------------------------------------------------------------------Getting Values for Modification
    static void modifyBooks(int a ,String username00){
        Scanner sc = new Scanner(System.in);
        book.viewCat();
        int lim=book.bookCat.size();
        System.out.print(lim +". Exit" +"\n" +"Enter the Category to Modify Book : ");
        int c = sc.nextInt();
        if(c>lim){
            System.out.println("Invalid Input" +"\n" +"Enter to Exit");
            main.enterNeeded();
            admActions(a,username00);
        }
        else if(c==lim){
            admActions(a,username00);
        }
        else{
            book.viewbookLis(c);
            int lim1=book.limbooklist(c);
            System.out.print(lim1 +". Exit" +"\n" +"Enter the Book Number you want to Modify : ");
            int d = sc.nextInt();
            if(d>lim1){
                System.out.println("Invalid Input" +"\n" +"Enter to Exit");
                main.enterNeeded();
                admActions(a,username00);
            }
            else if(d==lim1){
                admActions(a,username00);
            }
            else{
                main.flusher();
                book.viewBookData(c,d);
                System.out.println("*You Can Modify the Price and Quantity of the Book*");
                System.out.print("1. Change Price" +"\n" +"2. Change Quantity" +"\n" +"3. Both " +"\n" +"4. Exit" +"\n" +"Enter the Choice : ");
                int cc = sc.nextInt();
                if(cc==1){
                System.out.print("Enter the Price you want to Change : ");
                int pri = sc.nextInt();
                book.bookPricChan(c,d,pri);
                System.out.print("Price Modified Successfully" +"\n" +"Enter to Exit");
                main.enterNeeded();
                admActions(a,username00);
                }
                else if(cc==2){
                System.out.print("1. Add a Quantity" +"\n" +"2. Reduce the Quantity" +"\n" +"Enter the Choice : ");
                int cho = sc.nextInt();
                    if(cho==1){
                        System.out.print("Enter the Amount you want to Add : ");
                        int Quantity = sc.nextInt();
                        book.bookQuanChan(c,d,Quantity);
                        System.out.print("Quantity is Updated Successfully");
                        main.enterNeeded();
                        admActions(a,username00);
                    }
                    else if(cho==2){
                    System.out.print("Enter the Amount you want to Reduce : ");
                    int Quantity = sc.nextInt();
                    book.bookQuanChan(c,d,(-1)*Quantity);
                    System.out.print("Quantity is Updated Successfully");
                    main.enterNeeded();
                    admActions(a,username00);
                    }
                }
                else if(cc==3){
                    System.out.println("*You Can Modify the Price and Quantity of the Book*");
                    System.out.print("Enter the Price you want to Change : ");
                    int pri = sc.nextInt();
                    book.bookPricChan(c,d,pri);
                    System.out.print("1. Add a Quantity" +"\n" +"2. Reduce the Quantity" +"\n" +"Enter the Choice : ");
                    int cho = sc.nextInt();
                        if(cho==1){
                            System.out.print("Enter the Amount you want to Add : ");
                            int Quantity = sc.nextInt();
                            book.bookQuanChan(c,d,Quantity);
                        }
                        else if(cho==2){
                        System.out.print("Enter the Amount you want to Reduce : ");
                        int Quantity = sc.nextInt();
                        book.bookQuanChan(c,d,(-1)*Quantity);
                        }
                    System.out.print("The Price and Quantity updated Successfully" +"\n" +"Enter to Exit");
                    main.enterNeeded();
                    admActions(a,username00);
                }
                else{
                    admActions(a,username00);
                }
            }
        }
    }
}
class User{
    //------------------------------------------------------------------------------Objects of other class
    static Main main = new Main();
    static Admin admin = new Admin();
    static Books book = new Books();
    //------------------------------------------------------------------------------Lists of the Users 
    static List<String> usrNames = new ArrayList<String>();
    static List<String> usrPwd = new ArrayList<String>();
    static List<Integer> usrMon = new ArrayList<Integer>();
    static List<List<String>> usrsBooks = new ArrayList<>();
    static List<List<List>> usrsBookDat = new ArrayList<>();
    static List<List<String>> fines = new ArrayList<>();
    static HashMap<String,Integer> usrHp = new HashMap<String,Integer>();
    //------------------------------------------------------------------------------Logging in as User
    public static void logUsr(){
        Scanner sc = new Scanner(System.in);
        System.out.print("------------------*Welcome User*----------------" +"\n" +"1.New User" +"\n" +"2.Existing User" +"\n"  +"3.Exit"
        +"\n" +"Enter the Choice : ");
        String a = sc.nextLine();
        if(a.equals("1")){
            main.flusher();
            newUsr();
        }
        else if(a.equals("2")){
            main.flusher();
            existUsr();
        }
        else if(a.equals("3")){
            main.main0();
        }
        else{
            System.out.println("Invalid Choice" +"\n" +"Enter to Retry");
            main.enterNeeded();
            logUsr();
        }
    }
    //------------------------------------------------------------------------------New User login
    static void newUsr(){
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------*Welcome*-----------------");
        System.out.print("Enter the Username : ");
        String admnam = sc.nextLine();
        System.out.print("Enter the Password : ");
        String admpwd = sc.nextLine();
        usrNames.add(admnam);
        usrMon.add(1500);
        LibraryAccounts libra = new LibraryAccounts();
        libra.addAmo();
        usrPwd.add(admpwd);
        usrHp.put(admnam,usrNames.size());
        int a = usrNames.indexOf(admnam);
        List<String> lie = new ArrayList<>();
        lie.add("0");
        usrsBooks.add(lie);
        List liee = new ArrayList();
        List<List> lieee = new ArrayList<>();
        liee.add("0");
        lieee.add(liee);
        usrsBookDat.add(lieee);
        List<String> iil= new ArrayList<>();
        iil.add("0");
        fines.add(iil);
        System.out.print("\n" +"\n" +"-------------*Account Registered Successfully*-------------");
        main.enterNeeded();
        usrActions(a,admnam);
    }
    //------------------------------------------------------------------------------Existing User Login
    static void existUsr(){
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------*Welcomeback User*-------------");
        System.out.print("Enter the Username : ");
        String admnam = sc.nextLine();
        int a = usrNames.indexOf(admnam);
        if(a==-1){
            System.out.print("Username not Exist" +"\n" +"Enter to Retry");
            main.enterNeeded();
            main.flusher();
            logUsr();
        }
        System.out.print("Enter the Password : ");
        String admpwd = sc.nextLine();
        if(usrPwd.get(a).equals(admpwd)){
            main.enterNeeded();
            usrActions(a,admnam);
        }
        else{
            System.out.print("Invalid Password" +"\n" +"Enter to Retry");
            main.enterNeeded();
            main.flusher();
            logUsr();
        }
    }
    //----------------------------------------------------------------------------------------User Actions
    static void usrActions(int a , String username00){
        Scanner sc = new Scanner(System.in);
        main.flusher();
        System.out.print("-------------------------------*Welcome User*-----------------------------" +"\n" +"1. View Books" +"\n" +"2. Checkout Book "
        +"\n" +"3. Checkin Book "  +"\n" +"4. Checkin Checkout List" +"\n" +"5. Show Balance" +"\n" +"6. Add Balance Amount"+"\n"
        +"7. Check Fine History"  +"\n" +"8. Search Books"+"\n" +"9. Exit" +"\n" +"Enter the Choice : ");
        String ch = sc.nextLine();
        //----------------------------------------------------------------------------------Viewing Books
        if(ch.equals("1")){
            book.viewCat();
            int lim=book.bookCat.size();
            System.out.print(lim +". Exit" +"\n" +"Enter the Category to View List of Books : ");
            int c = sc.nextInt();
            if(c>lim){
                System.out.println("Invalid Input" +"\n" +"Enter to Exit");
                main.enterNeeded();
                usrActions(a,username00);
            }
            else if(c==lim){
                usrActions(a,username00);
            }
            else{
                book.viewbookLis(c);
                int lim1=book.limbooklist(c);
                System.out.print(lim1 +". Exit" +"\n" +"Enter the Book number to View the Book Data : ");
                int d = sc.nextInt();
                if(d>lim1){
                    System.out.println("Invalid Input" +"\n" +"Enter to Exit");
                    main.enterNeeded();
                    usrActions(a,username00);
                }
                else if(d==lim1){
                    usrActions(a,username00);
                }
                else{
                    book.viewBookData(c,d);
                    System.out.print("Enter to Exit");
                    main.enterNeeded();
                    usrActions(a,username00);
                }
            }
        }
        //----------------------------------------------------------------------------------Checkout Book
        else if(ch.equals("2")){
            book.viewCat();
            int lim=book.bookCat.size();
            System.out.print(lim +". Exit" +"\n" +"Enter the Category to View List of Books : ");
            int c = sc.nextInt();
            if(c>lim){
                System.out.println("Invalid Input" +"\n" +"Enter to Exit");
                main.enterNeeded();
                usrActions(a,username00);
            }
            else if(c==lim){
                usrActions(a,username00);
            }
            else{
                book.viewbookLis(c);
                int lim1=book.limbooklist(c);
                System.out.print(lim1 +". Exit" +"\n" +"Enter the Book number to Checkout : ");
                int d = sc.nextInt();
                if(d>lim1){
                    System.out.println("Invalid Input" +"\n" +"Enter to Exit");
                    main.enterNeeded();
                    usrActions(a,username00);
                }
                else if(d==lim1){
                    usrActions(a,username00);
                }
                else{
                    book.viewBookData(c,d);
                    checkOut(a,username00,c,d);
                }
            }
        }
        //---------------------------------------------------------------------------------Checking In
        else if(ch.equals("3")){
            main.flusher();
            System.out.println("-----------------------*Welcome Back User*----------------------" +"\n" +"The Books you borrowed are : ");
            showCheckOuts(a);
            System.out.print("Enter the book Number you going to Return : ");
            int rr = sc.nextInt();
            checkIn(a,username00,rr);
        }
        //---------------------------------------------------------------------------------Checkin Checkout Lists
        else if(ch.equals("4")){
            main.flusher();
            System.out.println("-----------------------*Welcome Back User*----------------------" +"\n" +"The Books you borrowed are : ");
            showCheckOuts(a);
            System.out.print("Enter the book Number to See checkin : ");
            int rr0 = sc.nextInt();
            viewCheckinOut(a,rr0);
            main.enterNeeded();
            usrActions(a,username00);
        }
        //---------------------------------------------------------------------------------Showing Account Balance
        else if(ch.equals("5")){
            main.flusher();
            Integer aa = usrMon.get(a);
            System.out.print("The Amount you have is " +aa +"\n" +"Enter to Exit");
            main.enterNeeded();
            usrActions(a,username00);
        }
        //--------------------------------------------------------------------------------Add Amount to Account
        else if(ch.equals("6")){
            main.flusher();
            Integer aa = usrMon.get(a);
            System.out.print("Enter the Amount you want to Add : ");
            int aaa = sc.nextInt();
            aa+=aaa;
            usrMon.set(a,aa);
            LibraryAccounts llee = new LibraryAccounts((long)aaa);
            System.out.print("Money Added Successfully");
            main.enterNeeded();
            usrActions(a,username00);
        }
        //--------------------------------------------------------------------------------Check Fine Data
        else if(ch.equals("7")){
            main.flusher();
            List<String> lll = new ArrayList<>();
            lll= fines.get(a);
            if(lll.size()==0){
                System.out.print("No Fines you are posted with");
            }
            else{
            for(int i = 0 ; i<lll.size() ; i++){
                System.out.println(i+1 +"." +lll.get(i));
            }}
            System.out.print("Enter to Exit");
            main.enterNeeded();
            usrActions(a,username00);
        }
        //-----------------------------------------------------------------------------------Search book
        else if(ch.equals("8")){
            book.searchBook(2,a,username00);
        }
        else if(ch.equals("9")){
            System.out.print("\n" +"\n" +"\n" +"---------------*Enter to Login Page*------------");
            main.enterNeeded();
            main.main0();
        }
        else{
            System.out.print("Invalid Password" +"\n" +"Enter to Retry");
            main.enterNeeded();
            main.flusher();
            usrActions(a,username00);
        }
    }
    //-----------------------------------------------------------------------------------Checking Out
    static void checkOut(int a,String username00,int c,int d){
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------Book Checkout-------------------");
        List<String> li = book.bookDataGiv(c,d);
        if(li.get(5).equals("0")){
            System.out.print("There is no book Left to Borrow ,visit Some Time" +"\n" +"Enter to Exit ");
            main.enterNeeded();
            usrActions(a,username00);
        }
        else{
            System.out.print("Enter the Date : ");
            int dat = sc.nextInt();
            System.out.print("Enter the Month : ");
            int mon= sc.nextInt();
            System.out.print("Enter the Year : ");
            int yr = sc.nextInt();
            int arr[] = {dat,mon,yr};
            System.out.print("You Cannot take Same Book Twice" +"\n" +"The Date of your CheckOut is ");
            System.out.print(dat +"-" +mon +"-" +yr);
            System.out.println("\n" +"There is a fine after 15 days - 10rs each day After 15 days,taken from your Account");
            List<String> lii = usrsBooks.get(a);
            int exi = 0;
            if(lii.contains(li.get(1))){
                exi = lii.indexOf(li.get(1));
            }
            else{
                List<String> lll = usrsBooks.get(a);
                lll.add(li.get(1));
                exi = lii.size()-1;
                List liee = new ArrayList();
                List<List> lieee = new ArrayList<>();
                lieee=usrsBookDat.get(a);
                lieee.add(liee);
            }
            List lee = new ArrayList();
            List<List> leee = new ArrayList<List>();
            leee=usrsBookDat.get(a);
            lee=leee.get(exi);
            lee.add(0,li.get(0));
            lee.add(1,li.get(1));
            lee.add(2,li.get(2));
            lee.add(3,li.get(3));
            lee.add(4,"Checkout Date : "+Integer.toString(dat)+"-"+Integer.toString(mon)+"-"+Integer.toString(yr));
            lee.add(5,arr);
            lee.add(6,"Checkin Date : ");
            lee.add(7,"Not Checked in");
            lee.add(8,"Fine : ");
            lee.add(9,"No Fines");
            int nq = Integer.parseInt(li.get(5));
            int nb = Integer.parseInt(li.get(7));
            nq-=1;
            nb+=1;
            li.set(5,Integer.toString(nq));
            li.set(7,Integer.toString(nb));
            System.out.print("------------------*Book Checked Out Successfully*----------------" +"\n" +"Enter to Exit");
            main.enterNeeded();
            usrActions(a,username00);
        }
    }
    //-----------------------------------------------------------------------------------Shows CheckOut Books of Every User
    static void showCheckOuts(int a){
        List<String> li = new ArrayList<>();
        li=usrsBooks.get(a);
        for(int i = 1 ; i<li.size() ; i++){
            System.out.println(i +". " +li.get(i));
        }
    }
    //-----------------------------------------------------------------------------------Checking In
    static void checkIn(int a,String username00,int book){
        Scanner sc = new Scanner(System.in);
        List<List> ll = new ArrayList<List>();
        List lll = new ArrayList();
        ll = usrsBookDat.get(a);
        lll = ll.get(book);
        System.out.print("Enter the Date : ");
        int dat = sc.nextInt();
        System.out.print("Enter the Month : ");
        int mon= sc.nextInt();
        System.out.print("Enter the Year : ");
        int yr = sc.nextInt();
        int[] pasda = (int[])(lll.get(5));
        LocalDate curr = LocalDate.of(yr,mon,dat);
        LocalDate out = LocalDate.of(pasda[2],pasda[1],pasda[0]);
        System.out.println("The Book " +lll.get(1) +" is taken on by you is " +pasda[0] +"-" +pasda[1] +"-" +pasda[2]);
        long diffdat = ChronoUnit.DAYS.between(out,curr);
        System.out.println("Number of Days the Book Taken by You is " +diffdat);
        if(diffdat<15){
            lll.set(7,Integer.toString(dat)+"-"+Integer.toString(mon)+"-"+Integer.toString(yr));
            lll.set(9,0);
            System.out.println("There is No Fine Amount" +"\n"
            +"---------------------------------*Book Checked in Successfully*---------------------------");
            main.enterNeeded();
            usrActions(a,username00);
        }
        else{
            fineCharge(a,diffdat,dat,yr,mon,book);
            main.enterNeeded();
            usrActions(a,username00);
        }
    }
    //--------------------------------------------------------------------------------Charging the fine
    static void fineCharge(int a,long diffdat,int dat,int yr,int mon,int book){
        List<List> ll = new ArrayList<List>();
        List lll = new ArrayList();
        ll = usrsBookDat.get(a);
        lll = ll.get(book);
        Scanner sc = new Scanner(System.in);
        System.out.println("Your Fine Amount is " +(diffdat-15)*10 +"\n" +"The Mode of Payment : " +"\n" +"1. Pay by Account balance" +"\n" +"2. Pay by Cash" );
        int pay = sc.nextInt();
        long finam = (diffdat-15)*10;
        if(pay==2){
            fineAppender(a,(String)lll.get(1),(diffdat-15)*10);
            lll.set(7,Integer.toString(dat)+"-"+Integer.toString(mon)+"-"+Integer.toString(yr));
            lll.set(9,Long.toString(finam));
            System.out.print("----------------------*Book Checked in Successfully*-----------------");
        }
        else if(pay==1){
            int uu = usrMon.get(a);
            if(finam>uu){
                System.out.print("Insufficient Balance, pay by Cash");
                fineAppender(a,(String)lll.get(1),(diffdat-15)*10);
                lll.set(7,Integer.toString(dat)+"-"+Integer.toString(mon)+"-"+Integer.toString(yr));
                lll.set(9,Long.toString(finam));
                System.out.print("----------------------*Book Checked in Successfully*-----------------");
            }
            else{
                if((uu-finam)<500){
                    System.out.print("Insufficient Balance,paying leads to less than minimum balance 500, pay by Cash");
                    fineAppender(a,(String)lll.get(1),(diffdat-15)*10);
                    lll.set(7,Integer.toString(dat)+"-"+Integer.toString(mon)+"-"+Integer.toString(yr));
                    lll.set(9,Long.toString(finam));
                    System.out.print("----------------------*Book Checked in Successfully*-----------------");
                }
                else{
                    uu=uu-(int)(finam);
                    usrMon.set(a,uu);
                    List<String> ell = new ArrayList<>();
                    ell=fines.get(a);
                    ell.add("The Fine Amount of " +((diffdat-15)*10) +" is Added for the Book " +lll.get(1));
                    lll.set(7,Integer.toString(dat)+"-"+Integer.toString(mon)+"-"+Integer.toString(yr));
                    lll.set(9,Long.toString(finam));
                    System.out.print("----------------------*Book Checked in Successfully*-----------------");
                }
            }
        }
    }
    //--------------------------------------------------------------------------------Appending the list of fines
    static void fineAppender(int a ,String bokname , long fineam){
        List<String> ll = new ArrayList<>();
        ll=fines.get(a);
        ll.add("The Fine Amount of " +fineam +" is Added for the Book " +bokname);
        LibraryAccounts lib  = new LibraryAccounts(fineam);
    }
    //--------------------------------------------------------------------------------Viewing Checkin Checkout Lists
    static void viewCheckinOut(int a,int rr0){
        List<List> ll = new ArrayList<List>();
        List lll = new ArrayList();
        ll=usrsBookDat.get(a);
        lll=ll.get(rr0);
        for(int i = 0 ; i<lll.size()/10 ; i++){
        System.out.println("----------------------------------------------------------------" +"\n" 
        +"----------------------------------------------------------------");
        for(int j = i*10 ; j<(i*10)+10 ; j=j+2){
            if(j==4){
                System.out.println(lll.get(j));
            }
            else if(((i*10)+8)==j){
                System.out.println((String)lll.get(j) +lll.get(j+1));
            }
            else{
            System.out.println(lll.get(j) +"" +lll.get(j+1));
            }
        }
        }
    }
}


class Books{
    //---------------------------------------------------------------------------------------Other Class Objects
    static Main main = new Main();
    static Admin admin = new Admin();
    static User user = new User();
    //---------------------------------------------------------------------------------------Book Lists
    static List<String> bookCat = new ArrayList<String>();
    static List<List<String>> booksName = new ArrayList<List<String>>();
    static List<List<List<String>>> bookPro = new ArrayList<List<List<String>>>();
    static HashMap<Integer,String> isBnbook = new HashMap<Integer,String>();
    static HashMap<String,Integer> bookIsbn = new HashMap<String,Integer>();
    //--------------------------------------------------------------------------------------Book initialization
    static void start(){
        List<String> ll = new ArrayList<String>();
        List<List<String>> lll = new ArrayList<List<String>>();
        ll.add("0");
        lll.add(ll);
        bookPro.add(lll);
        bookCat.add("0");
        bookCat.add("Self Development");
        bookCat.add("Technology");
        bookCat.add("History");
        bookCat.add("Physics");
        bookCat.add("Entrepreneurship");
        List<String> li = new ArrayList<String>();
        li.add("0");
        booksName.add(li);
        List<String> li1= new ArrayList<String>();
        li1.add(0,"0");
        li1.add("7 Habits of Highly Effective People");
        RandomPro("7 Habits of Highly Effective People");
        li1.add("Atomic Habits");
        RandomPro("Atomic Habits");
        li1.add("Think and Grow Rich");
        RandomPro("Think and Grow Rich");
        li1.add("Think Fast");
        RandomPro("Think Fast");
        li1.add("Cant Hurt Me");
        RandomPro("Cant Hurt Me");
        booksName.add(li1);
        dataPro(1,0,5,0,150);
        dataPro(1,1,5,0,150);
        dataPro(1,2,5,0,150);
        dataPro(1,3,5,0,150);
        dataPro(1,4,5,0,150);
        dataPro(1,5,5,0,150);
        List<String> li2 = new ArrayList<String>();
        li2.add("0");
        li2.add("The Innovators");
        RandomPro("The Innovators");
        li2.add("The InEvitable");
        RandomPro("The InEvitable");
        li2.add("Elon Musk");
        RandomPro("Elon Musk");
        li2.add("The Future");
        RandomPro("The Future");
        li2.add("Soon");
        RandomPro("Soon");
        booksName.add(li2);
        dataPro(2,0,5,0,150);
        dataPro(2,1,5,0,150);
        dataPro(2,2,5,0,150);
        dataPro(2,3,5,0,150);
        dataPro(2,4,5,0,150);
        dataPro(2,5,5,0,150);
        List<String> li3 = new ArrayList<String>();
        li3.add("0");
        li3.add("The Democracy");
        RandomPro("The Democracy");
        li3.add("Sapiens");
        RandomPro("Sapiens");
        li3.add("Genkis Khan");
        RandomPro("Genkis Khan");
        li3.add("Mein Khaif");
        RandomPro("Mein Khaif");
        li3.add("Mahatma Gandhi");
        RandomPro("Mahatma Gandhi");
        booksName.add(li3);
        dataPro(3,0,5,0,150);
        dataPro(3,1,5,0,150);
        dataPro(3,2,5,0,150);
        dataPro(3,3,5,0,150);
        dataPro(3,4,5,0,150);
        dataPro(3,5,5,0,150);
        List<String> li4 = new ArrayList<String>();
        li4.add("0");
        li4.add("The Physics");
        RandomPro("The Physics");
        li4.add("The ThermoDynamics");
        RandomPro("The ThermoDynamics");
        li4.add("The FeyMann");
        RandomPro("The FeyMann");
        li4.add("The Relativity");
        RandomPro("The Relativity");
        li4.add("Time");
        RandomPro("Time");
        booksName.add(li4);
        dataPro(4,0,5,0,150);
        dataPro(4,1,5,0,150);
        dataPro(4,2,5,0,150);
        dataPro(4,3,5,0,150);
        dataPro(4,4,5,0,150);
        dataPro(4,5,5,0,150);
        List<String> li5 = new ArrayList<String>();
        li5.add("0");
        li5.add("The Lean Startup");
        RandomPro("The Lean Startup");
        li5.add("Zero to One");
        RandomPro("Zero to One");
        li5.add("Rework");
        RandomPro("Rework");
        li5.add("Start With Why");
        RandomPro("Start With Why");
        li5.add("The Myth");
        RandomPro("The Myth");
        booksName.add(li5);
        dataPro(5,0,5,0,150);
        dataPro(5,1,5,0,150);
        dataPro(5,2,5,0,150);
        dataPro(5,3,5,0,150);
        dataPro(5,4,5,0,150);
        dataPro(5,5,5,0,150);
    }
    //-------------------------------------------------------------------------------------Data of the book provider
	static void dataPro(int a,int b,int quan,int borr,int pri){
	    List<String> li = new ArrayList<String>();
	    List<List<String>> li1 = new ArrayList<List<String>>();
	    List<String> bok = booksName.get(a);
	    String name = bok.get(b);
	    String isb;
	    if(b==0){
	        isb = "0";
	    }
	    else{
	        isb = Integer.toString(bookIsbn.get(name));
	    }
	    li.add("Book Name : ");
	    li.add(name);
	    li.add("ISBN number : ");
	    li.add(isb);
	    li.add("Quatity : ");
	    li.add(Integer.toString(quan));
	    li.add("Borrowed : ");
	    li.add(Integer.toString(borr));
	    li.add("Price : ");
	    li.add(Integer.toString(pri));
	    if(bookPro.size()==a){
	        li1.add(li);
	        bookPro.add(li1);
	    }
	    else{
	    li1=bookPro.get(a);
	    li1.add(li1.size(),li);
	    }
	    
	}
	//-------------------------------------------------------------------------------------Viewing Category
	static void viewCat(){
	    main.flusher();
	    System.out.println("------------------------*The List of Books*------------------------");
	    if(bookCat.size()==0){
	        start();
	    }
	    for(int i = 1 ; i<bookCat.size(); i++){
	        System.out.println(i +". " +bookCat.get(i));
	    }
	}
	//-------------------------------------------------------------------------------------Viewing Books of Category
	static void viewbookLis(int a){
	    main.flusher();
	    System.out.println("--------------------------*The Books of " +bookCat.get(a) +"*----------------------------");
	    List<String> lii = new ArrayList<String>();
	    lii=booksName.get(a);
	    for(int i = 1 ; i<lii.size(); i++){
	        System.out.println(i +". " +lii.get(i));
	    }
	}
	//------------------------------------------------------------------------------------Giving Back size of books in Part Category
	static int limbooklist(int a){
	    List<String> lii = new ArrayList<String>();
	    lii=booksName.get(a);
	    return lii.size();
	}
	//-----------------------------------------------------------------------------------Viewing Book Data
	static void viewBookData(int a,int b){
	    List<String> li = new ArrayList<String>();
	    List<List<String>> lii = new ArrayList<List<String>>();
	    lii = bookPro.get(a);
	    li=lii.get(b);
	    System.out.println("--------------------------*Book Data*------------------------");
	    for(int i = 0 ; i<li.size() ; i=i+2){
	        System.out.println(li.get(i) +li.get(i+1));
	    }
	}
	//------------------------------------------------------------------------------------Returning List of Books Data
	static List<String> bookDataGiv(int a , int b){
	    List<String> li = new ArrayList<String>();
	    List<List<String>> lii = new ArrayList<List<String>>();
	    lii = bookPro.get(a);
	    li=lii.get(b);
	    return li;
	}
	//------------------------------------------------------------------------------------Price Modifier
	static void bookPricChan(int a,int b, int pri){
	    List<String> li = new ArrayList<String>();
	    List<List<String>> lii = new ArrayList<List<String>>();
	    lii = bookPro.get(a);
	    li=lii.get(b);
	    li.set(li.size()-1,Integer.toString(pri));
	}
	//------------------------------------------------------------------------------------Quantity Modifier
	static void bookQuanChan(int a,int b, int quan){
	    List<String> li = new ArrayList<String>();
	    List<List<String>> lii = new ArrayList<List<String>>();
	    lii = bookPro.get(a);
	    li=lii.get(b);
	    int qu = Integer.parseInt(li.get(5));
	    qu+=quan;
	    li.set(5,Integer.toString(qu));
	}
	//-----------------------------------------------------------------------------------Searching Books
	static void searchBook(int g,int a0,String username00){
	    main.flusher();
	    Scanner sc = new Scanner(System.in);
	    System.out.print("-----------------------------*Welcome to the Library*-----------------------" 
	    +"\n" +"1.Search Book by ISBN Number" +"\n" +"2.Search Book by Book Name" +"\n" +"3.Exit" +"\n" +"Enter the Choice : ");
	    int ch = sc.nextInt();
	    sc.nextLine();
	    String name = null;
	    if(ch==1){
	        System.out.print("Enter the ISBN Number of the book you looking : ");
	        Integer a2 = sc.nextInt();
	        name = isBnbook.get(a2);
	    }
	    else if(ch==2){
	        System.out.print("Enter the Name of the Book you looking : ");
	        name = sc.nextLine();
	    }
	    else if(ch==3){
	        if(g==1){
	            admin.admActions(a0,username00);//----------------------------------------------Going Back
	        }
	        else{
	           user.usrActions(a0,username00); 
	        }
	    }
	    else{
	        System.out.print("Invalid Input");
	        main.enterNeeded();
	        searchBook(g,a0,username00);
	    }
	    int b = -1,a=0;
	    for(int i = 1 ; i<booksName.size() ; i++){
	        List<String> li = new ArrayList<String>();
	        li=booksName.get(i);
	        b = li.indexOf(name);
	        if(b!=-1){
	            a=i;
	            break;
	        }
	        else{
	            continue;
	        }
	    }
	    if(b==-1 || name.equals(null)){
	        System.out.print("Book not Found" +"\n" +"Enter to Exit" );
	        main.enterNeeded();
	        if(g==1){
	            admin.admActions(a0,username00);//----------------------------------------------Going Back
	        }
	        else{
	            user.usrActions(a0,username00); 
	        }
	    }
	    else{
	        
	        System.out.println("---------------------*Book Found!!!*--------------------" +"\n" 
	        +"The Book is on the " +a +" Category of " +bookCat.get(a));
	        viewBookData(a,b);
	        System.out.print("Enter to Exit");
	        main.enterNeeded();
	        if(g==1){
	            admin.admActions(a0,username00);//----------------------------------------------Going Back
	        }
	        else{
	            user.usrActions(a0,username00); 
	        }
	        
	    }
	    
	}
	
	
	
	
	
	
	
	//--------------------------------------------------------------------------------------Random Number provider and Hashmap Appender
    static void RandomPro(String st){
	    Random ran = new Random();
		int c= ran.nextInt(9999);
		boolean d = isBnbook.containsKey(c);
		if(d){
		    RandomPro(st);
		}
		else{
		    isBnbook.put(c,st);
		    bookIsbn.put(st,c);
		}
	}
	
}
class LibraryAccounts{
    static int libraryBalance=0;
    LibraryAccounts(){
        
    }
    void addAmo(){
        libraryBalance+=1500;
    }
    LibraryAccounts(long amt){
        libraryBalance+=amt;
    }
    void display(){
        System.out.print("The Library account Balance is " +(libraryBalance));
    }
}
