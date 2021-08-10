import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
class Book{
    public int id;
    public String title;
    public String subtitle;
    public Author author;
    public Publisher publisher;
    public double price;
    public void setId(int id){
        this.id=id;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setSubTitle(String subTitle){
        this.subtitle=subTitle;
    }
    public void setAuthor(Author author){
        this.author=author;
    }
    public void setPublisher(Publisher publisher){
        this.publisher=publisher;
    }
    public void setPrice(double price){
        this.price=price;
    }
}
class Author{
    public int id;
    public String name;
    public String email;
    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
}
class Publisher{
    public int id;
    public String name;
    public String contactNo;
    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setContactNo(String contactNo){
        this.contactNo=contactNo;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getContactNo(){
        return this.contactNo;
    }
}
abstract class Patron{
    public int id;
    public String name;
    public String departmentName;
    public String email;
    public String contactNo;
    public String address;
    public double amount;
    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setDepartmentName(String departmentName){
        this.departmentName=departmentName;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setContactNo(String contactNo){
        this.contactNo=contactNo;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void setAmount(double amount){
        this.amount=amount;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getDepartmentName(){
        return this.departmentName;
    }
    public String getEmail(){
        return this.email;
    }
    public String getContactNo(){
        return this.contactNo;
    }
    public String getAddress(){
        return this.address;
    }
    public double getAmount(){
        return this.amount;
    }
    public abstract void showInfo();
}
class Student extends Patron{
    public String studentId;
    public String guardianName;
    public String guardianContactNo;
    public void setStudentId(String studentId){
        this.studentId=studentId;
    }
    public void setGuardianName(String guardianName){
        this.guardianName=guardianName;
    }
    public void setGuardianContactNo(String guardianContactNo){
        this.guardianContactNo=guardianContactNo;
    }
    public String getStudentId(){
        return this.studentId;
    }
    public String getGuardianName(){
        return this.guardianName;
    }
    public String getGuardianContactNo(){
        return this.guardianContactNo;
    }
    public void showInfo(){
        System.out.println("ID: "+studentId+"\nGuandian name: "+guardianName+"\nGuandian Contact No: "+guardianContactNo);
    }
}
class Teacher extends Patron{
    public String teacherId;
    public void setTeacherId(String teacherId){
        this.teacherId=teacherId;
    }
    public String getTeacherId(){
        return teacherId;
    }
    public void showInfo(){
        System.out.println("ID: "+teacherId);
    }
}
interface IBasicOperations{
    static void borrow(Patron p, Book b){
        File file = new File("D:\\borrow.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write("Patron ID: "+p.id+"    "+"    Book ID: "+b.id);
            fileWriter.write("\n");
            System.out.println("Done");
        }
        catch(IOException io) {
            System.out.println("IOException occurred!!");
        }
        finally {
           try {
                fileWriter.close();
            }
            catch(IOException io) {
                System.out.println("Couldn't close the file");
            }
        }
       
    }
    static void returnBook(Patron p, Book b){
        File file = new File("D:\\return.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write("Patron ID: "+p.id+"    "+"    Book ID: "+b.id);
            fileWriter.write("\n");
            System.out.println("Done");
        }
        catch(IOException io) {
            System.out.println("IOException occurred!!");
        }
        finally {
           try {
                fileWriter.close();
            }
            catch(IOException io) {
                System.out.println("Couldn't close the file");
            }
        }

    }
    static void fine(Patron p, double amount){
        File file = new File("D:\\fine.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write("Patron ID: "+p.id+"    "+"Amount: "+amount);
            fileWriter.write("\n");
            System.out.println("Done");
        }
        catch(IOException io) {
            System.out.println("IOException occurred!!");
        }
        finally {
           try {
                fileWriter.close();
            }
            catch(IOException io) {
                System.out.println("Couldn't close the file");
            }
        }

        
    }
    }
class TeacherOperation{
    static void insertTeacher(Teacher t){
        File file = new File("D:\\teacher.txt");
         FileWriter fileWriter = null;
         try {
             fileWriter = new FileWriter(file, true);
             fileWriter.write("Teacher Id: "+t.getTeacherId()+"    Patron id: "+t.getId()+"    Name:"+t.getName()+"    Dept: "+t.getDepartmentName()+"    Email: "+t.getEmail()+"    Phone: "+t.getContactNo()+"    Address: "+t.getAddress()+"    Amount: "+t.getAmount());
             fileWriter.write("\n");
             System.out.println("Done");
         }
         catch(IOException io) {
             System.out.println("IOException occurred!!");
         }
         finally {
            try {
                 fileWriter.close();
             }
             catch(IOException io) {
                 System.out.println("Couldn't close the file");
             }
         }
    }
    static void getTeacher(String teacherId){
        File file = new File("D:\\teacher.txt"); 
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
 
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            int flag=-1;
            String line = "";
            while((line = bufferedReader.readLine()) != null) {
                if(line.indexOf("Teacher Id: "+teacherId) != -1){
                    System.out.println("found");
                    System.out.println(line);
                    flag=1;
                    break;
                }
            }
            if(flag==-1){System.out.println("Not Found");}
        }
        catch(IOException io) {
            System.out.println("error occurred!!");
        }
        finally {
            try {
                fileReader.close();
            }
            catch(IOException io) {
                System.out.println("Couldn't close the file");
            }
        }
    }
    static void showAllTeachers( ){
        File file = new File("D:\\teacher.txt"); 
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
 
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            int ik=1;
            String line = "";
            while((line = bufferedReader.readLine()) != null) {
                System.out.println("Teacher no "+ik+": "+line);
                ik++;                
            }
        }
        catch(IOException io) {
            System.out.println("error occurred!!");
        }
        finally {
            try {
                fileReader.close();
            }
            catch(IOException io) {
                System.out.println("Couldn't close the file");
            }
        }
}
}
class StudentOperation{
    static void insertStudent(Student s){
        
        File file = new File("D:\\student.txt");
         FileWriter fileWriter = null;
         try {
             fileWriter = new FileWriter(file, true);
             fileWriter.write("ID: "+s.getStudentId()+"    Guardian Name: "+s.getGuardianName()+"    Guardian phone: "+s.getContactNo()+"    Patron Id: "+s.getId()+"    Name: "+s.getName()+"    Dept: "+s.getDepartmentName()+"    Email: "+s.getEmail()+"    Phone: "+s.getContactNo()+"    Address: "+s.getAddress()+"    Amount: "+s.getAmount());
             fileWriter.write("\n");
             System.out.println("Done");
         }
         catch(IOException io) {
             System.out.println("IOException occurred!!");
         }
         finally {
            try {
                 fileWriter.close();
             }
             catch(IOException io) {
                 System.out.println("Couldn't close the file");
             }
         }
    }
    static void removeStudent(Student s){
        
    }
    static void getStudent(String studentId){
        File file = new File("D:\\student.txt"); 
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
 
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            int flag=-1;
            String line = "";
            while((line = bufferedReader.readLine()) != null) {
                if(line.indexOf("ID: "+studentId) != -1){
                    System.out.println("found");
                    System.out.println(line);
                    flag=1;
                    break;
                }
            }
            if(flag==-1){System.out.println("Not Found");}
        }
        catch(IOException io) {
            System.out.println("error occurred!!");
        }
        finally {
            try {
                fileReader.close();
            }
            catch(IOException io) {
                System.out.println("Couldn't close the file");
            }
        }
    }
    static void showAllStudents( ){
        
        File file = new File("D:\\student.txt"); 
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
 
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            int ik=1;
            String line = "";
            while((line = bufferedReader.readLine()) != null) {
                System.out.println("Student no "+ik+": "+line);
                ik++;                
            }
        }
        catch(IOException io) {
            System.out.println("error occurred!!");
        }
        finally {
            try {
                fileReader.close();
            }
            catch(IOException io) {
                System.out.println("Couldn't close the file");
            }
        }
}
}
class BookOperations{
    public int bookno=0;
    static void insertBook(Book b){
        File file = new File("D:\\book.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write("ID: "+b.id+"    Title: "+b.title+"    Subtitle: "+b.subtitle+"    Price: "+b.price+"    Auther id: "+b.author.id+"    Auther Name: "+b.author.name+"    Email: "+b.author.email+"    Publisher Id: "+b.publisher.id+"    Publisher Name: "+b.publisher.name+"    Publisher Phone: "+b.publisher.contactNo);
            fileWriter.write("\n");
            System.out.println("Done");
        }
        catch(IOException io) {
            System.out.println("IOException occurred!!");
        }
        finally {
           try {
                fileWriter.close();
            }
            catch(IOException io) {
                System.out.println("Couldn't close the file");
            }
        }
    }
    static void getBook(int bookId){
        String idn=Integer.toString(bookId);
        File file = new File("D:\\book.txt"); 
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
 
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            int flag=-1;
            String line = "";
            while((line = bufferedReader.readLine()) != null) {
                if(line.indexOf("ID: "+idn) != -1){
                    System.out.println("found");
                    System.out.println(line);
                    flag=1;
                    break;
                }
            }
            if(flag==-1){System.out.println("Not Found");}
        }
        catch(IOException io) {
            System.out.println("error occurred!!");
        }
        finally {
            try {
                fileReader.close();
            }
            catch(IOException io) {
                System.out.println("Couldn't close the file");
            }
        }

    }
    static void showAllBooks( ){
        File file = new File("D:\\book.txt"); 
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
 
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            int ik=1;
            String line = "";
            while((line = bufferedReader.readLine()) != null) {
                System.out.println("Book no "+ik+": "+line);
                ik++;                
            }
        }
        catch(IOException io) {
            System.out.println("error occurred!!");
        }
        finally {
            try {
                fileReader.close();
            }
            catch(IOException io) {
                System.out.println("Couldn't close the file");
            }
        }
    }
}
public class Start{
    public static void main(String[] args) {
    String name,departmentName,email,contactNo,address,id,guardianName,guardianContactNo,title,subtitle;
    int i,j,f=0,l=1;
    double amount;
    int ti=0,si=0,bi=0,ai=0,pi=0,idm,idb,ida,idp,price;
    Student s[]=new Student[10000];
    Book b[]=new Book[10000];
    Author a[]=new Author[10000];
    Publisher p[]=new Publisher[10000];
    Teacher t[]=new Teacher[10000];
    Scanner ip =new Scanner(System.in);
    while(l!=-1){
        System.out.println("    ***************    AIUB Protal Management    ************ ");
	
        System.out.println("1. Student Management\n2. Teacher Management\n3. Book Management\n4. Basic Operations\n5. Exit");
        i=ip.nextInt();
    switch (i) {
        case 1:System.out.println("1. Insert New Student     2. Search by studentId      3. Show All Student");
            j=ip.nextInt();
            switch (j) {
                case 1:System.out.print("Student Id:  ");
                    id=ip.next();
                    f=0;
                    if(s[0]!=null){
                    for(int q=0;q<si;q++){
                        if(id.equals(s[q].studentId)){
                            System.out.println("ID Exists");
                            f=1;
                            break;
                        }
                    }}
                    if(f==0){
                    System.out.print("Patron Id:  ");
                    idm=ip.nextInt();ip.nextLine();
                    System.out.print("\nGuardian Name:  ");
                    guardianName=ip.nextLine();
                    System.out.print("\nGuardian contactno:  ");
                    guardianContactNo=ip.next();
                    System.out.print("\nDepartment Name: ");
                    departmentName=ip.next();ip.nextLine();
                    System.out.print("\nName: ");
                    name=ip.nextLine();
                    System.out.print("\nEmail: ");
                    email=ip.next();
                    System.out.print("\nContact no: ");
                    contactNo=ip.next();ip.nextLine();
                    System.out.print("\nAddress: ");
                    address=ip.nextLine();
                    System.out.print("\nAmount: ");
                    amount=ip.nextDouble();
                    s[si]=new Student();
                    s[si].setStudentId(id);
                    s[si].setGuardianName(guardianName);
                    s[si].setGuardianContactNo(guardianContactNo);
                    s[si].setId(idm);
                    s[si].setName(name);
                    s[si].setDepartmentName(departmentName);
                    s[si].setEmail(email);
                    s[si].setContactNo(contactNo);
                    s[si].setAddress(address);
                    s[si].setAmount(amount);
                    StudentOperation.insertStudent(s[si]);
                    si++;
                    }
                    break;
                case 2:System.out.print("Id:  ");
                id=ip.next();
                StudentOperation.getStudent(id);
                    
                    break;
                case 3:
                        StudentOperation.showAllStudents();
                    
                    break;
            
                default:System.out.println("Wrong Choice");
                    break;
            }
            break;
        case 2:System.out.println("1. Insert New Teacher     2. Search by teacherId     3. Show All Teacher");
            j=ip.nextInt();
            switch (j) {
                case 1:System.out.print("Teacher Id:  ");
                id=ip.next();
                f=0;
                    if(t[0]!=null){
                    for(int q=0;q<ti;q++){
                        if(id.equals(t[q].teacherId)){
                            System.out.println("ID Exists");
                            f=1;
                            break;
                        }
                    }}
                    if(f==0){
                System.out.print("\nPatron id: ");
                idm=ip.nextInt();
                System.out.print("\nDepartment Name: ");
                departmentName=ip.next();ip.nextLine();
                System.out.print("\nName: ");
                name=ip.nextLine();
                System.out.print("\nEmail: ");
                email=ip.next();
                System.out.print("\nContact no: ");
                contactNo=ip.next();ip.nextLine();
                System.out.print("\nAddress: ");
                address=ip.nextLine();
                System.out.print("\nAmount: ");
                amount=ip.nextDouble();
                        t[ti]=new Teacher();
                        t[ti].setTeacherId(id);
                        t[ti].setId(idm);
                        t[ti].setName(name);
                        t[ti].setDepartmentName(departmentName);
                        t[ti].setEmail(email);
                        t[ti].setContactNo(contactNo);
                        t[ti].setAddress(address);
                        t[ti].setAmount(amount);
                        TeacherOperation.insertTeacher(t[ti]);
                        ti++;
                    }
                        break;
                case 2:System.out.print("Id:  ");
                        id=ip.next();
                        TeacherOperation.getTeacher(id);
                    
                    break;
                case 3:TeacherOperation.showAllTeachers();
                    
                    break;
            
                default:System.out.println("Wrong Choice");
                    break;
            }
            break;
        case 3:System.out.println("1. Insert New Book       2. Search by bookId         3. Show All Books");
            j=ip.nextInt();
            switch (j) {
                case 1:System.out.print("Book Id:  ");
                idb=ip.nextInt();
                f=0;
                if(b[0]!=null){
                for(int q=0;q<bi;q++){
                    if(idb==b[q].id){
                        System.out.println("ID Exists");
                        f=1;
                        break;
                    }
                }}
                if(f==0){
                ip.nextLine();
                System.out.print("Title:  ");
                title=ip.nextLine();
                System.out.print("\nSubtitle:  ");
                subtitle=ip.nextLine();
                System.out.print("\nPrice:  ");
                price=ip.nextInt();
                System.out.print("\nAuther id:  ");
                ida=ip.nextInt();ip.nextLine();
                System.out.print("\nAuther name:  ");
                name=ip.nextLine();
                System.out.print("\nAuther Email:  ");
                email=ip.next();
                b[bi]=new Book();
                b[bi].setId(idb);
                b[bi].setTitle(title);
                b[bi].setSubTitle(subtitle);
                b[bi].setPrice(price);
                a[ai]=new Author();
                a[ai].setId(ida);
                a[ai].setName(name);
                a[ai].setEmail(email);
                b[bi].setAuthor(a[ai]);
                System.out.print("\nPublisher id:  ");
                idp=ip.nextInt();ip.nextLine();
                System.out.print("\nPublisher name:  ");
                name=ip.nextLine();
                System.out.print("\nPublisher contactno:  ");
                contactNo=ip.next();
                p[pi]=new Publisher();
                p[pi].setId(idp);
                p[pi].setName(name);
                p[pi].setContactNo(contactNo);
                b[bi].setPublisher(p[pi]);
                BookOperations.insertBook(b[bi]);
                bi++;pi++;ai++;
                }
                    break;
                case 2:System.out.print("Id:  ");
                idb=ip.nextInt();
                BookOperations.getBook(idb);
                    break;
                case 3:
                BookOperations.showAllBooks();
                    
                    break;
            
                default:System.out.println("Wrong Choice");
                    break;
            }
            break;
        case 4:System.out.println("1. Borrow book       2. Return Book       3. Add Fine");
            j=ip.nextInt();
            switch (j) {
                case 1:
                if(b[0]==null){System.out.println("We have no books.");break;}
                else{
                System.out.print("Patron id:  ");
                idp=ip.nextInt();
                int sf=0,bf=0;
                if(s[0]!=null){
                for(int q=0;q<si;q++){
                    if(idp==s[q].id){
                        sf=1;
                        System.out.print("\nBook id:  ");
                        idb=ip.nextInt();
                        for(int bq=0;bq<bi;bq++){
                            if(idb==b[bq].id){
                                bf=1;
                                IBasicOperations.borrow(s[q],b[bq]);
                                break;
                            }
                        }  
                    }
                }}
                if(t[0]!=null){
                    for(int q=0;q<ti;q++){
                        if(idp==t[q].id){
                            sf=1;
                            System.out.print("\nBook id:  ");
                            idb=ip.nextInt();
                            for(int bq=0;bq<bi;bq++){
                                if(idb==b[bq].id){
                                    bf=1;
                                    IBasicOperations.borrow(t[q],b[bq]);
                                    break;
                                }
                            }
                        }
                    }}
                    if(sf==0){System.out.println("Patron Doesn't Exist");}
                    else{
                    if(bf==0){System.out.println("Book Doesn't Exist");}}
                }
                    break; 
                case 2:
                if(b[0]==null){System.out.println("We didn't lend any books.");break;}
                else{
                System.out.print("Patron id:  ");
                idp=ip.nextInt();
                int sf=0,bf=0;
                if(s[0]!=null){
                for(int q=0;q<si;q++){
                    if(idp==s[q].id){
                        sf=1;
                        System.out.print("\nBook id:  ");
                        idb=ip.nextInt();
                        for(int bq=0;bq<bi;bq++){
                            if(idb==b[bq].id){
                                bf=1;
                                IBasicOperations.returnBook(s[q],b[bq]);
                                break;
                            }
                        }  
                    }
                }}
                if(t[0]!=null){
                    for(int q=0;q<ti;q++){
                        if(idp==t[q].id){
                            sf=1;
                            System.out.print("\nBook id:  ");
                            idb=ip.nextInt();
                            for(int bq=0;bq<bi;bq++){
                                if(idb==b[bq].id){
                                    bf=1;
                                    IBasicOperations.returnBook(t[q],b[bq]);
                                    break;
                                }
                            }
                        }
                    }}
                    if(sf==0){System.out.println("Patron Doesn't Exist");}
                    else{
                    if(bf==0){System.out.println("This book isn't ours");}}
                }
                    break; 
                case 3:
                System.out.print("Patron id:  ");
                idp=ip.nextInt();
                int sf=0;
                if(s[0]!=null){
                for(int q=0;q<si;q++){
                    if(idp==s[q].id){
                        sf=1;
                        System.out.print("\nAmount:  ");
                        amount=ip.nextInt();
                        IBasicOperations.fine(s[q], amount); 
                    }
                }}
                if(t[0]!=null){
                    for(int q=0;q<ti;q++){
                        if(idp==t[q].id){
                            sf=1;
                            System.out.print("\nAmount:  ");
                            amount=ip.nextInt();
                            IBasicOperations.fine(t[q], amount);
                        }
                    }}
                    if(sf==0){System.out.println("Patron Doesn't Exist");}
                    break;
            
                default:System.out.println("Wrong Choice");
                    break;
            }
            break;
        case 5:System.out.println("Thank You for using our program.");
                l=-1;
                break;
        default:System.out.println("Wrong Choice");
            break;
        }    }

}
}