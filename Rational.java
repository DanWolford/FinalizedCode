
public class Rational
{

    private int numerator;
    private int denominator;
    

    public Rational()
    {      
        numerator = 1;
        denominator = 1;
        
        normalize();
        
    }

    public Rational(int n, int d) throws ZeroDenominatorException
    {

        numerator = n;
        denominator = d;
        
        if(denominator == 0) {
            throw new ZeroDenominatorException("Goofy ahh error");
        }
        
        normalize();
    }
    
    public int getNumerator()
    {

        return numerator;
    }
    
    public int getDenominator()
    {

        return denominator;
    }
   
    public Rational negate()
    {               
        Rational negRational = new Rational(numerator * -1, denominator);
        
        return negRational;
    }

    public Rational invert()
    {     
        int numb = denominator;
        int dumb = numerator;
    
    Rational inRational = new Rational(numb, dumb);
    
        return inRational;
    }
    
  
    public Rational add(Rational other)
    { 
        int oNum = other.getNumerator();
        int oDum = other.getDenominator();
        
        Rational addRational = new Rational((numerator * oDum + oNum * denominator), (oDum * denominator));

        return addRational;
    }
     
     
    public Rational subtract(Rational other)
    {               
    
        int oNumb = other.getNumerator();
        int oDumb = other.getDenominator();
        
        Rational subRational = new Rational((numerator * oDumb - oNumb * denominator), (oDumb * denominator));

        return subRational;
    }

 
    public Rational multiply(Rational other)
    {       
    
        int mNum = other.getNumerator();
        int mDum = other.getDenominator();
        
        Rational multRational = new Rational(mNum * numerator, mDum * denominator);

        return multRational;
    }
        
  
    public Rational divide(Rational other)
    {               
    
        int dNum = other.getNumerator();
        int dDum = other.getDenominator();
        
        Rational divRational = new Rational(dDum * numerator, dNum * denominator);
        
        divRational.normalize();

        return divRational;
    }
     
 
    private void normalize()
    {
       
        int num = numerator;
        int dum = denominator;
        
        if(dum < 0) {
            dum = dum * -1;
        }
        if(num < 0) {
            num = num * -1;
        }
        
        int norm = gcd(num, dum);
        
        numerator = numerator / norm;
        denominator = denominator / norm;
        if(denominator < 0) {
            numerator = numerator *-1;
            denominator = denominator *-1;
        }
    }
    
 
    private int gcd(int a, int b)
    {
        int result = 0;
        if(a<b)
            result = gcd(b,a);
        else if(b==0)
            result = a;
        else
        {
            int remainder = a % b;
            result = gcd(b, remainder);
        }
        return result;
    }
   
    
    
}