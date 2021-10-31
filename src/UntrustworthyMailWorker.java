/*static класс, моделирующий ненадежного работника почты, который вместо того, чтобы передать
почтовый объект непосредственно в сервис почты, последовательно передает этот объект набору
третьих лиц, а затем, в конце концов, передает получившийся объект непосредственно
экземпляру RealMailService. У UntrustworthyMailWorker должен быть конструктор
от массива MailService (результат вызова processMail первого элемента массива передается
на вход processMail второго элемента, и т. д.) и метод getRealMailService, который возвращает
ссылку на внутренний экземпляр RealMailService, он не приходит масивом в конструкторе и не
настраивается извне класса.*/
public static class UntrustworthyMailWorker implements MailService {
    private MailService[] mailServices;
    RealMailService realMailService=new RealMailService();
    public UntrustworthyMailWorker(MailService[] mailServices) {
        this.mailServices = mailServices;
    }
    public RealMailService getRealMailService() {
        return realMailService;
    }
    @Override
    public Sendable processMail(Sendable mail) {
        Sendable mail1;
        mail1=mailServices[0].processMail(mail);
        for (int i = 1; i < mailServices.length; i++) {
            mail1 = mailServices[i].processMail(mail1);
        }
        return mail = realMailService.processMail(mail1);
    }
}
public static class StolenPackageException extends RuntimeException {
    public StolenPackageException(String messege) {
        super(messege);
    }
}
public static class IllegalPackageException extends RuntimeException {
    public IllegalPackageException(String messege) {
        super(messege);
    }
}