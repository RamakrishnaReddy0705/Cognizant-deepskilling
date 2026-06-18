public class DecoratorTest {

    public static void main(String[] args) {

        Notifier notifier = new EmailNotifier();

        Notifier smsNotifier =
                new SMSNotifierDecorator(new EmailNotifier());

        smsNotifier.send("Hello");
    }
}