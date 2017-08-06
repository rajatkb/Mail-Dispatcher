
package welcome.mail;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class HackMail {
   private static String from;
   private static Session session;
    public HackMail( String username, String password){
        

        try{
            String host = "smtp.gmail.com";
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            this.session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });
            this.from = username;
        
        }catch(Exception ex){
            System.out.println("log: caught at hackmail "+ex);
        }catch(Throwable tr){
            System.out.println("log: caught at hackmail "+tr);
        }
        
    }
    public void send(String emailto,String subject ,  String Content){
      try {
         
         Message message = new MimeMessage(this.session);
         message.setFrom(new InternetAddress(this.from));
         message.addRecipient(RecipientType.TO, new InternetAddress(
                          emailto));
         message.setSubject(subject);
         message.setText(Content);
         Transport.send(message);
         System.out.println("Sent message successfully to "+emailto);
      } catch (MessagingException e) {
           System.out.println("log: caught at send mail"+e);
      }
      }
        
    
}

