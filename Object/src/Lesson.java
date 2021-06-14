public class Lesson {
    public static class ComplexNumber {
        private double re;
        private double im;

        public ComplexNumber() {
        }

        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ComplexNumber comp = (ComplexNumber) o;
            if (getRe() != ((ComplexNumber) o).getRe()) {
                return false;
            }
            if (getIm() != ((ComplexNumber) o).getIm()) {
                return false;
            }
            return true;

        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (int) getRe();
            result = prime * result + (int) getIm();
            return result;

        }

    }

    public static void main(String[] args) {
        ComplexNumber numb = new ComplexNumber(2.45, 3.45);
        ComplexNumber numb1 = new ComplexNumber(2.45, 3.45);
        System.out.println(numb.hashCode()+" "+ numb1.hashCode());

    }

}
