public class Order {

  private String customerEmail;
  private String product;

  public Order(String customerEmail, String product) {
    this.customerEmail = customerEmail;
    this.product = product;
  }

  public String getCustomerEmail() {
    return this.customerEmail;
  }

}
