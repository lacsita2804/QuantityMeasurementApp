// QuantityMeasurementApp.java

public class QuantityMeasurementApp {

    enum LengthUnit {
        FEET(1.0),
        INCHES(1.0 / 12.0),
        YARDS(3.0),
        CENTIMETERS(0.0328084);

        private final double factor;

        LengthUnit(double factor) {
            this.factor = factor;
        }

        public double getFactor() {
            return factor;
        }
    }

    static class QuantityLength {
        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        private double toFeet() {
            return value * unit.getFactor();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            QuantityLength q = (QuantityLength) obj;
            return Double.compare(this.toFeet(), q.toFeet()) == 0;
        }
    }

    public static void main(String[] args) {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);

        QuantityLength q3 = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        QuantityLength q4 = new QuantityLength(0.393701, LengthUnit.INCHES);

        System.out.println("Yard to Feet Equal: " + q1.equals(q2));
        System.out.println("CM to Inches Equal: " + q3.equals(q4));
    }
}