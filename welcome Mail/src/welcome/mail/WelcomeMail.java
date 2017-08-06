
package welcome.mail;

import java.util.ArrayList;
/*
    THE JAVA PACAKAGE HAS THREE CLASSES
    1. HACKMAIL = smtp server connection and sending methods
    2. a static class of readExcell 
    3. mailcontent

    ** edit mail content for chaging the content
    ** in welcome mail main function
        change sheet no. depending on which sheet you want to send mail to
        0 - 2017
        1- 2016
        2 - 2015
        ...... this depends on how it is ordered in actuall xlsx sheet
    ** pass the credentials and edit content set the batch or sheet number and rest assured,
    ** also internet is must -_- ....
*/



public class WelcomeMail {

    public static void main(String[] args) {
        
        try{
        
        int sheetNo = 0; 
            
        HackMail mailObj = new HackMail("aec.codingclub@gmail.com", "codingclub@321");
            
        ArrayList<String[]> details= readExcell.read("C:/Users/RAJAT/Desktop/2016.xlsx", sheetNo);
        String subject = "Welcome To AEC Coding Club";
        for(String[] detail: details){
            String email = detail[2];
            String name = detail[1];
            String cod = detail[0];
            String content = (mailContent.getContent(detail[1], detail[0]));
            //mailObj.send(email, subject , content);
            
        } 
        }catch(Exception ex){
            System.out.println("log: caught exception at thread main: "+ex);
        }catch(Throwable tr){
            System.out.println("log: caught throwable at thread main"+tr);
        }
        
    }
    
}
