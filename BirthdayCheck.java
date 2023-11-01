import java.util.Random;
public class BirthdayCheck
{
    private Person[] students;
    
    public BirthdayCheck(Person[] kids)
    {
        students = kids;
    }
    
    public void fillArray()
    {
        Random rand = new Random();
        for(int x = 0; x<students.length; x++)
        {
            students[x] = new Person(rand.nextInt(365));
        }
    }
    
    public double findProbability()
    {
        double probability = 0;
        int count = 0;
        for(int x = 0; x<students.length; x++)
        {
            for(int y = 1; y<students.length; y++)
            {
                if(students[x].getBirthday() == students[y].getBirthday())
                {
                    count++;
                }
            }
        }
        probability = (double)count / (double)students.length;
        return probability;
    }
}
