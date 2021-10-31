/*static Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу в виде
исключения, если была обнаружена подобная посылка. Если он заметил запрещенную посылку с одним из
запрещенных содержимым ("weapons" и "banned substance"), то он бросает IllegalPackageException.
Если он находит посылку, состоящую из камней (содержит слово "stones"), то тревога прозвучит в
виде StolenPackageException. Оба исключения вы должны объявить самостоятельно в виде непроверяемых исключений.*/
public static class Inspector implements MailService {
    public Sendable processMail(Sendable mail){
        if (mail instanceof MailPackage) {
            Package cont=((MailPackage) mail).getContent();
            if (cont.getContent().contains("weapons") || (cont.getContent().contains("banned substance"))){
                throw new IllegalPackageException("Тревога!");
            }
            if (cont.getContent().contains("stones")) {
                throw new StolenPackageException("Вор");
            }
        }
        return mail;
    }
}
