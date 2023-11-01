import java.util.ArrayList;
import java.math.BigInteger;

public class StatsLibrary 
{
	public StatsLibrary() {}
	
	 //Mean Method
    public double findMean(ArrayList<Double> userInputNumbers)
    {
        double sum = 0;
        for(double singleElement: userInputNumbers)
        {
            sum = sum + singleElement;
        }
        //Storing a value for clarity
        double result = sum / userInputNumbers.size();
        return result;
    }
    
    public double findMedian(ArrayList<Double> userInputNumbers)
    {
        int center = userInputNumbers.size() / 2;
        double value = userInputNumbers.get(center);
        return value;
    }
    
    public double findMode(ArrayList<Double> userInputNumbers)
    {
        double reference1 = userInputNumbers.get(0);
        int count1 = 1;
        double reference2 = userInputNumbers.get(1);
        int count2 = 1;
        
        for(int x = 0; x < userInputNumbers.size(); x++)
        {
        	for(int y = 3; y < userInputNumbers.size(); y++)
        	{
        		if(userInputNumbers.get(y) == reference1)
            	{
            		count1++;
            	}
            	else if(userInputNumbers.get(y) == reference2)
            	{
            		count2++;
            	}
        	}
        	if(count2 > count1)
        	{
        		reference1 = reference2;
        		count1 = count2;
        		reference2 = userInputNumbers.get(x);
        		count2 = 1;
        	}
        	
        }
        double mode = reference1;
        return mode;
    }
    
    public double findVariance(ArrayList<Double> userInputNumbers)
    {
    	double mean = findMean(userInputNumbers);
    	ArrayList<Double> deviance = new ArrayList<Double>();
    	for(int x = 0; x< userInputNumbers.size(); x++)
    	{
    		deviance.add(mean - userInputNumbers.get(x));
    	}
    	for(int x = 0; x<deviance.size(); x++)
    	{
    		deviance.set(x, Math.pow(deviance.get(x), 2));
    	}
    	double variance = 0;
    	for(int x = 0; x<deviance.size(); x++)
    	{
    		variance = variance + deviance.get(x);
    	}
    	variance = variance/(deviance.size() -1 );
    	return variance;
    }
    
    public double findStandardDeviation(ArrayList<Double> userInputNumbers)
    {
        double standardDeviation = findVariance(userInputNumbers);
        standardDeviation = Math.sqrt(standardDeviation);
        return standardDeviation;
    }
    
    public ArrayList<Double> union(ArrayList<Double> a, ArrayList<Double> b)
    {
    	ArrayList<Double> union = new ArrayList<>();
    	for(int x = 0; x<a.size(); x++)
    	{
    		for(int y = 0; y<b.size(); y++)
    		{
    			if(b.get(y).equals(a.get(x)))
    			{
    				union.add(b.get(y));
    			}
    			else
    			{
    				union.add(a.get(x));
    				union.add(b.get(y));
    			}
    		}
    	}
    	return union;
    }
    
    public ArrayList<Double> intersection(ArrayList<Double> a, ArrayList<Double> b)
    {
    	ArrayList<Double> intersection = new ArrayList<>();
    	for(int x = 0; x<a.size(); x++)
    	{
    		for(int y = 0; y<b.size(); y++)
    		{
    			if(a.get(x).equals(b.get(y)))
    			{
    				intersection.add(a.get(x));
    			}
    		}
    	}
    	return intersection;
    }
    
    public ArrayList<Double> complement(ArrayList<Double> a, ArrayList<Double> universe)
    {
    	ArrayList<Double> complement = universe;
    	for(int x = 0; x<a.size(); x++)
    	{
    		for(int y = 0; y<complement.size(); y++)
    		{
    			if(a.get(x).equals(complement.get(y)))
    			{
    				complement.remove(a.get(x));
    			}
    		}
    	}
    	return complement;
    }
    
    public BigInteger factorial(int input)
    {
    	BigInteger factorial = BigInteger.valueOf(input);
    	for(int x = input; x>1; x--)
    	{
    		BigInteger value = BigInteger.valueOf(x);
    		factorial.multiply(value);
    	}
    	return factorial;
    }
    
    public BigInteger combination(int n, int r)
    {
        BigInteger combination = factorial(n).divide((factorial(r).multiply(factorial(n-r))));
        return combination;
    }
    
    public BigInteger permutataion(int n, int r)
    {
        BigInteger permutation = factorial(n).divide(factorial(n-r));
        return permutation;
    }
    
    public double conditional(double intersection, double b)
    {
    	return intersection/b;
    }
    
    public double bayes(double given, double a, double b)
    {
    	return (given*a)/b;
    }
    
    public boolean isIndependent(double given, double a, double b)
    {
    	if(given == a)
    	{
    		if(((given*a)/b) == b)
    		{
    			if((given*a) == (a*b))
    			{
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    public double binomial(int trial, int success, double p, double q)
    {
    	double combination = combination(trial, success).doubleValue();
    	double numSuccess = Math.pow(p, success);
    	double numFailure = Math.pow(q, trial-success);
    	return combination*numSuccess*numFailure;
    }
    
    public double geometric(int wait, double p, double q)
    {
    	double numFailure = Math.pow(q, wait-1);
    	return p*numFailure;
    }
    
    public double hyperGeometric(int r, int y, int n, int type2)
    {
    	
    	double nA = combination(r, y).multiply(combination(type2-r, n-y)).doubleValue();
    	double nS = combination(type2, n).doubleValue();
    	return nA/nS;
    }
    
    public double negativeBinomial(int y, int r, double p, double q)
    {
    	double combination = combination(y-1, r-1).doubleValue();
    	double numSuccess = Math.pow(p, r);
    	double numFailure = Math.pow(q, y-r);
    	return combination*numSuccess*numFailure;
    }
    
    public double poisson(int lambda, int y)
    {
    	double fish = Math.pow(lambda, y) / (factorial(y).doubleValue());
    	fish = fish * Math.exp(lambda);
    	return fish;
    }
    
    public double chebyshev(double mean, double sDeviation, double point)
    {
    	double k  = mean - point;
    	k = point/sDeviation;
    	return k;
    }
    
}
