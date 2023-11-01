public class Main
{
    public static void main(String [] args)
    {
        Person[] students = new Person[24];
        BirthdayCheck people = new BirthdayCheck(students);
        people.fillArray();
        double probability = people.findProbability();
        System.out.println("The probability of two people having the same birthday is " +probability);
        
    }
}