/*static шпион, который логгирует о всей почтовой переписке, которая проходит через его руки. Объект
конструируется от экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях.
Он следит только за объектами класса MailMessage и пишет в логгер следующие сообщения (в выражениях
нужно заменить части в фигурных скобках на значения полей почты):
2.1) Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать
в лог сообщение с уровнем WARN: Detected target mail correspondence: from {from} to {to} "{message}"
2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}*/
import java.util.logging.*;
public static class Spy implements MailService {
    private static Logger spylog;

    public Spy(Logger spylog) {
        this.spylog = spylog;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if ((mail instanceof MailMessage) & (mail.getFrom().equals("Austin Powers") || mail.getTo().equals("Austin Powers"))) {
            String s = String.format("Detected target mail correspondence: from %s to %s \"%s\"",
                    mail.getFrom(), mail.getTo(), ((MailMessage) mail).getMessage());
            spylog.warning(s);
        }
        if ((mail instanceof MailMessage) & !(mail.getFrom().equals("Austin Powers") || mail.getTo().equals("Austin Powers"))) {
            String m = String.format("Usual correspondence: from %s to %s", mail.getFrom(), mail.getTo());
            spylog.info(m);
        }
        return mail;
    }
}