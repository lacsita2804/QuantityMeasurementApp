public class QuantityMeasurementUC5 {

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

        public static double convert(double value, LengthUnit source, LengthUnit target) {
            if (!Double.isFinite(value) || source == null || target == null) {
                throw new IllegalArgumentException("Invalid input");
            }

            double baseFeet = value * source.getFactor();
            return baseFeet / target.getFactor();
        }
    }

    public static void main(String[] args) {

        System.out.println(QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCHES));
        System.out.println(QuantityLength.convert(3.0, LengthUnit.YARDS, LengthUnit.FEET));
        System.out.println(QuantityLength.convert(36.0, LengthUnit.INCHES, LengthUnit.YARDS));
        System.out.println(QuantityLength.convert(1.0, LengthUnit.CENTIMETERS, LengthUnit.INCHES));
    }
}