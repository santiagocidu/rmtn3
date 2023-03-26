package com.machetico.rmtn.app.rmtn.utilities;

public class EmailDetails{

    private String recipient;

    private String msgBody;

    private String subject;

    private String attachment;

    public void setMsgBody(String msm) {
    	this.msgBody= msm;}
    public String getMsgBody(){return msgBody;}
    public void setRecipient(String recipient) {this.recipient=recipient;}
    public String getRecipient() {return recipient;}
    public void setSubject(String subject) {this.subject=subject;}
    public String getSubject() {return subject;}
    public void setAttachmen(String attachment) {this.attachment=attachment;}
    public String getAttachment() {return attachment;}
}