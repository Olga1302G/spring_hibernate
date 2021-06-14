import java.util.logging.Logger;

public class Less3 {
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public static interface Sendable {
        String getFrom();

        String getTo();
    }

    public static abstract class AbstractSendable implements Sendable {

        protected static final String from;
        protected static final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public static String getFrom() {
            return from;
        }

        @Override
        public static String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;

            if (!from.equals(that.from)) return false;
            if (!to.equals(that.to)) return false;

            return true;
        }

    }

    public static class MailMessage extends AbstractSendable {

        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

            if (message != null ? !message.equals(that.message) : that.message != null) return false;

            return true;
        }


    }

    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;

            if (!content.equals(that.content)) return false;

            return true;
        }

    }

    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            if (!content.equals(aPackage.content)) return false;

            return true;
        }
    }

    public static interface MailService {
        Sendable processMail(Sendable mail);
    }

    /*
    Класс, в котором скрыта логика настоящей почты
    */
    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }

    public static class UntrustworthyMailWorker implements MailService {
        private final RealMailService realMailService;
        private MailService[] mailServices;

        public UntrustworthyMailWorker(MailService[] mailServices) {
            this.mailServices = mailServices;
            this.realMailService = new RealMailService();

        }

        public RealMailService getRealMailService() {
            return this.realMailService;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            for (int i = 0; i < mailServices.length; i++) {
                mail = mailServices[i].processMail(mail);
            }
            return realMailService.processMail(mail);
        }
    }

    public static class Spy implements MailService {
        private final Logger logger;

        public Spy(final Logger logger) {
            this.logger = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                MailMessage mailMessageSpy = (MailMessage) mail;
                if (mailMessageSpy.getFrom().equals(AUSTIN_POWERS) || mailMessageSpy.getTo().equals(AUSTIN_POWERS)) {
                    this.logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                            new Object[]{mailMessageSpy.getFrom(), mailMessageSpy.getTo(), mailMessageSpy.getMessage()});
                } else {
                    logger.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                            new Object[]{mailMessageSpy.getFrom(), mailMessageSpy.getTo()});
                }

            }
            return mail;

        }
    }

    public static class Thief implements MailService {
        private int minPrice;
        private int stolenValue;

        public Thief(int minPrice) {
            this.minPrice = minPrice;
        }

        public int getStolenValue() {
            return stolenValue;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail.getClass() == MailPackage.class) {
                Package pac = ((MailPackage) mail).getContent();
                if (pac.getPrice() >= minPrice) {
                    stolenValue += pac.getPrice();
                    mail = new MailPackage(mail.getFrom(), mail.getTo(), new Package("stones instead of " + pac.getContent(), 0));
                }
            }
            return mail;
        }
    }

    public static class IllegalPackageException extends RuntimeException {
    }

    public static class StolenPackageException extends RuntimeException {
    }

    public static class Inspector implements MailService {
        @Override
        public Sendable processMail(Sendable mail) {
            if (mail.getClass() == MailPackage.class) {
                Package pacEx = ((MailPackage) mail).getContent();
                String content = pacEx.getContent();
                if (content.contains("weapons") || content.contains("banned substance")) {
                    throw new IllegalPackageException();
                }
                if (content.contains("stones")) {
                    throw new StolenPackageException();
                }
            }
            return mail;
        }

    }

}
