import java.time.LocalDateTime;
import java.util.Objects;
public class Message {
    private String sender="Maryam";
    private String reciever;
    private String content;
    private String messageid;
    private  boolean send;
    private boolean seen;
    private String name;
    LocalDateTime time;
    private static int counter=0;

       //constructor
    Message(String sender, String reciever, String content, boolean send, boolean seen) {
        this.sender = "Maryam";
        this.reciever = reciever;
        this.content = content;
        this.messageid = String.format("%03d",++counter);
        this.send = send;
        this.seen=seen;
        this.time = LocalDateTime.now();
    }
      //constructor
    public Message( String Reciever, String content) {
        this("Maryam", Reciever, content, false, false);
        this.time=LocalDateTime.now();

    }
    
    
    // setters 
    public void setReciever(String reciever) {
       this.reciever = reciever;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setMessageid(String messageid) {
        this.messageid = messageid;
    }

    public void setSend(boolean send) {
        this.send = send;
    }
      
    //Getters

    public String getReciever() {
        return reciever;
    }
    public String getContent() {
        return content;
    }
    public String getMessageid() {
        return messageid;
    }
    public boolean isSend() {
        return send;

    }
    public boolean isSeen() {
        return seen;
    }
    public void setSeen(boolean seen) {
        this.seen = seen;
    }
    public LocalDateTime getTime() {
        return time; // Added getter for time
    }
    // to string function
    @Override
    public String toString(){
        return String.format("Sender:%s\nReciever:%s\nContent:%s\nMessageid:%s\nSeen:%bSent:%bSentat:%s",sender,reciever,content,messageid,seen,send,time);

    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Message newmessage= (Message) obj;
        return Objects.equals(name , newmessage.reciever);
    }
}