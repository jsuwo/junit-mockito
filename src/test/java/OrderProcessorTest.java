import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class OrderProcessorTest {

  private MailerService mailer;
  private Warehouse warehouse;
  private Order order;

  @Before
  public void setup() {
    mailer = mock(MailerService.class);
    warehouse = mock(Warehouse.class);
    order = mock(Order.class);

    when(order.getCustomerEmail()).thenReturn("jeff@example.com");
  }

  @Test
  public void testProcessOrderSendsEmailToCustomerUponFillingOrder() throws Exception {

    when(warehouse.fill(order)).thenReturn(true);

    OrderProcessor processor = new OrderProcessor(warehouse, mailer);
    processor.processOrder(order);

    verify(mailer).send(isA(Message.class));
  }

  @Test(expected=Exception.class)
  public void testProcessOrderThrowsExceptionIfWarehouseOutOfStock() throws Exception {

    when(warehouse.fill(order)).thenReturn(false);

    OrderProcessor processor = new OrderProcessor(warehouse, mailer);
    processor.processOrder(order);
  }

}
