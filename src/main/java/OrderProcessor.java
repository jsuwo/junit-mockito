public class OrderProcessor {

  private Warehouse warehouse;
  private MailerService mailer;

  public OrderProcessor(Warehouse warehouse, MailerService mailer) {
    this.warehouse = warehouse;
    this.mailer = mailer;
  }

  public void processOrder(Order order) throws Exception {
    if (warehouse.fill(order)) {
      
      Message msg = new Message(
        "orders@cs2212.ca", 
        order.getCustomerEmail(), 
        "Order Shipped", 
        "Thank you for ordering from us."
      );

      mailer.send(msg);
    }
    else {
      throw new Exception("Unable to fill order -- warehouse is out of stock.");
    }

  }

}
