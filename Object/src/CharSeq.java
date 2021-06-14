public class CharSeq {
    public static void main(String[] args) {
        byte[] tryw = new byte[5];
        for (int i = 0; i < tryw.length; i++) {
            tryw[i] = (byte) (i + 1);
        }
        AsciiCharSequence asc = new AsciiCharSequence(tryw);
        System.out.println(asc.toString());
    }

    public static class AsciiCharSequence implements java.lang.CharSequence {
        byte[] charNew;

        AsciiCharSequence(byte[] charNew) {
            this.charNew = charNew;

        }

        @Override
        public int length() {
            return charNew.length;
        }

        @Override
        public char charAt(int index) {
            return (char) charNew[index];
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            return new AsciiCharSequence(java.util.Arrays.copyOfRange(charNew, start, end));
        }


        @Override
        public String toString() {
            StringBuilder result = new StringBuilder(charNew.length);
            for (int i = 0; i < charNew.length; i++) {
                result.append((char) charNew[i]);
            }
            return result.toString();
            //Твой код здесь
        }
    }
}

