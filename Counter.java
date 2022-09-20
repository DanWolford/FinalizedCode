
public class Counter
{
    
    private int minimum;
    private int maximum;
    private int counter;
    private boolean res = false;
    private int rolledCount; 

    public Counter()
    {
        minimum = 0;
        maximum = Integer.MAX_VALUE;
        counter = minimum;
        rolledCount = 0;
        
    }
    
    public Counter(int min, int max) throws CounterInitializationException
    {
       
        minimum = min;
        maximum = max;
        counter = min;
        rolledCount = 0; 
        
        if(max <= min) {
            
            throw new CounterInitializationException("Another goofy ahh error");
            
        }
    }
    
    public boolean equals(Object otherObject)
    {
        boolean result = true;
        Counter dummy = new Counter();
        dummy = (Counter)otherObject;
        
        if (otherObject instanceof Counter)
        {
            if(dummy.value() == counter && dummy.getMinimum() == minimum && dummy.getMaximum() == maximum && dummy.getRolledCount() == rolledCount) {
                result = true;
            }
            else {
                result = false;
            }
        }
        else {
            result = false;
        }
        return result;
    }
    
    public int getMinimum() {
        return minimum;
    }
    public int getMaximum() {
        return maximum;
    }
    public int getRolledCount() {
        return rolledCount;
    }

    public void increase()
    {
        counter = counter + 1;
        rolledOver();
        if(counter == minimum + 1){ 
            res = false;
        }
    }
 
    public void decrease()
    {
        counter = counter - 1;
        rolledOver();
        if(counter == maximum - 1) {
            res = false;
        }
    }
    
    public int value()
    {
       
       return counter;
		
    }
    
    public boolean rolledOver()
    {
        
        if(counter > maximum) {
            counter = minimum;
            res = true;
            rolledCount++; 
        }
        else if (counter < minimum) {
            counter = maximum;
            res = true;
            rolledCount++; 
        }
        
        return res;
    }
    
    public String toString()
    {

        String stringto = "Min: " + minimum + "\nMax: " + maximum + " \nCounter: " + counter + " \nRolledOver: " + res;		
        return stringto;
    }
    
 
}