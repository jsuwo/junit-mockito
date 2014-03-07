public class Message {

  private String fromAddress;
  private String toAddress;
  private String subject;
  private String body;

  public Message(String from, String to, String subject, String body) {
    this.fromAddress = from;
    this.toAddress = to;
    this.subject = subject;
    this.body = body;
  }

}
