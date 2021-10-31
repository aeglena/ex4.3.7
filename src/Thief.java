/*вор, который ворует самые ценные посылки и игнорирует все остальное. Вор принимает
в конструкторе переменную int – минимальную стоимость посылки, которую он будет воровать.
Также, в данном классе должен присутствовать метод getStolenValue, который возвращает суммарную
стоимость всех посылок, которые он своровал. Воровство происходит следующим образом: вместо посылки,
которая пришла вору, он отдает новую, такую же, только с нулевой ценностью и содержимым посылки
"stones instead of {content}".*/
public static class Thief implements MailService {
    private int mini;
    private int sum = 0;
    public Thief(int mini) {
        this.mini = mini;
    }
    public int getStolenValue() {
        return sum;
    }
    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            Package packThief = new Package("stones instead of " + (((MailPackage) mail).getContent()).getContent(), 0);
            MailPackage packMailThief = new MailPackage(((MailPackage) mail).from, ((MailPackage) mail).to, packThief);
            if ((((MailPackage) mail).getContent()).getPrice() >= mini) {
                sum += (((MailPackage) mail).getContent()).getPrice();
                return (Sendable)packMailThief;
            } else {
                return mail;
            }
        } else {
            return mail;
        }
    }
}


