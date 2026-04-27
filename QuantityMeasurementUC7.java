public class QuantityMeasurementUC7 {

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
            if (!Double.isFinite(value) || unit == null) {
                throw new IllegalArgumentException("Invalid input");
            }
            this.value = value;
            this.unit = unit;
        }

        private double toFeet() {
            return value * unit.getFactor();
        }

        public QuantityLength add(QuantityLength other) {
            return add(other, this.unit);
        }

        public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {

            if (other == null || targetUnit == null) {
                throw new IllegalArgumentException("Invalid input");
            }

            double totalFeet = this.toFeet() + other.toFeet();
            double resultValue = totalFeet / targetUnit.getFactor();

            return new QuantityLength(resultValue, targetUnit);
        }

        @Override
        public String toString() {
            return "Quantity(" + value + ", " + unit + ")";
        }
    }

    public static void main(String[] args) {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        System.out.println(q1.add(q2, LengthUnit.FEET));
        System.out.println(q1.add(q2, LengthUnit.INCHES));
        System.out.println(q1.add(q2, LengthUnit.YARDS));

        QuantityLength q3 = new QuantityLength(2.54, LengthUnit.CENTIMETERS);
        QuantityLength q4 = new QuantityLength(1.0, LengthUnit.INCHES);

        System.out.println(q3.add(q4, LengthUnit.CENTIMETERS));
    }
}