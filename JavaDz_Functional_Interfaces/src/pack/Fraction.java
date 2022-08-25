package pack;

import java.util.function.*;

public class Fraction {
    private int flag;
    private int dig;

    public Fraction(int flag, int dig) {
        this.flag = flag;
        this.dig = dig;
    }

    public Fraction() {}

    public final Supplier<Integer> getFlag = ()->{
        return flag;
    };

    public final Supplier<Integer> getDig = ()->{
        return dig;
    };

    public final Consumer<Integer> setFlag = (Integer f)->{
        flag=f;
    };

    public final Consumer<Integer> setDig = (Integer d)->{
        dig=d;
    };

    public final Supplier<String> toString = ()->{
      return flag + "/" + dig;
    };

    public final Supplier<Double> toDouble = ()->{
        return (double)(flag/dig);
    };

    public final Predicate<Fraction> compare = (Fraction f)->{
        return this.flag/this.dig > f.flag/f.dig;
    };

    public final UnaryOperator<Fraction> multiply = (Fraction f)->{
        return new Fraction(this.flag * f.flag, this.dig * f.dig);
    };

    public final UnaryOperator<Fraction> divinity = (Fraction f)->{
        return new Fraction(this.flag * f.dig, this.dig * f.flag);
    };

    public static final Function<Fraction, Double> decimal = (Fraction f)->{
        return (double)f.flag / f.dig;
    };

    public static final Function<String, Fraction> fromString = (String f)->{
        String[] str = f.split("/");
        Fraction fraction = new Fraction(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        return fraction;
    };

    public static final BiPredicate<Fraction, Fraction> compareStatic = (Fraction f1,Fraction f2)->{
        return f1.compare.test(f2);
    };

    public static final BinaryOperator<Fraction> multiplyStatic = (Fraction f1,Fraction f2)->{
        return f1.multiply.apply(f2);
    };

    public static final BinaryOperator<Fraction> divinityStatic = (Fraction f1,Fraction f2)->{
        return f1.divinity.apply(f2);
    };
}
