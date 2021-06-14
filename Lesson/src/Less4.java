import java.util.logging.Logger;

public class Less4 {
    public static class UntrustworthyMailWorker implements Less3.MailService {
        public UntrustworthyMailWorker (){}
        @Override
        public Less3.Sendable processMail(Less3.Sendable mail) {
            return mail;
        }
    }
    public static   class Spy implements Less3.MailService {
        public static void logging() {
            Logger logger = Logger.getLogger(Less3.MailMessage.class.getName());
            if (new Object().toString().contains("Austin Powers")){
                logger.warning("Detected target mail correspondence: from {from} to {to} {message}");}
            logger.info("Usual correspondence: from {from} to {to}");
            //Твой код здесь
        }
        @Override
        public Less3.Sendable processMail(Less3.Sendable mail) {
            return mail;
        }




    }
    public static class Thief implements Less3.MailService {
        private int minPrice;
        private int stolenValue;
        public Thief (int minPrice) {
            this.minPrice = minPrice;
        }
        public int getStolenValue () {
            return stolenValue;
        }
        @Override
        public Less3.Sendable processMail(Less3.Sendable mail) {
            if(mail.getClass() == Less3.MailPackage.class) {
                Package pac = ((MailPackage)mail).getContent();
                if(pac.getPrice() >= minPrice){
                    stolenPrice += pac.getPrice();
                    mail = new MailPackage(mail.getFrom(), mail.getTo(),new Package("stones instead of " + pac.getContent(), 0));
                }
            }
            return mail;
        }
        }


}
