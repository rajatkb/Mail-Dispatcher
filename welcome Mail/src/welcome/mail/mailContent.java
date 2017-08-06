
package welcome.mail;

public class mailContent {
    public static String getContent(String name , String Code){
        
       String content = String.format("Hi %s !\n" +
                    "\n" +
                    "AEC coding club is ecstatic to have you and so we welcome you to this club. We hope you have an appealing experience working here where you can learn as well as get your hands dirty on actual codes and projects. \n" +
                    "Your ID code is. %s And please make a note of this so that it can be used in the future.\n" +
                    "\n" +
                    "There's much more to tell you about the proceedings of the club and so meet you on the Orientation Day for the year 2017-18. The date of the same shall be informed soon. \n" +
                    "\n" +
                    "Happy coding,\n" +
                    "Regards,\n" +
                    "AEC Coding Club", name , Code);
       return content;
    
    }
}
