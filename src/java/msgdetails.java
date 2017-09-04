/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shivakumart2181
 */
public class msgdetails {
    private String Senderid;
    private String Receiverid;
    private String msgcontent;
    private String status;
    private String senttime;

    public String getSenderid() {
        return Senderid;
    }

    public void setSenderid(String Senderid) {
        this.Senderid = Senderid;
    }

    public String getReceiverid() {
        return Receiverid;
    }

    public void setReceiverid(String Receiverid) {
        this.Receiverid = Receiverid;
    }

    public String getMsgcontent() {
        return msgcontent;
    }

    public void setMsgcontent(String msgcontent) {
        this.msgcontent = msgcontent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSenttime() {
        return senttime;
    }

    public void setSenttime(String senttime) {
        this.senttime = senttime;
    }
    
    
      public msgdetails(String sid,String rid,String msg,String status1,String senttime)
   {
       Senderid=sid;
       Receiverid = rid;
       msgcontent=msg;
       status=status1;
       this.senttime = senttime;
   }
}
