import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The child class SamikshaYelthimar is an extension of the parent class Student. 
 * It has the constructor SamikshaYelthimar, 
 * @author Samiksha Yelthimar Period 2 AP CSA
 * @version 9/5/2019
 */
public class SamikshaYelthimar extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the SamikshaYelthimar class.
     * This constructor also sets the variables that set the portrait, standing, and sound files. It also calls the method setImage to the value of portraitFile, and initializes the object to be "sitting down".
     * @param String f sets the first name of the SamikshaYelthimar object to Samiksha
     * @param String l sets the last name of the SamikshaYelthimar object to Yelthimar
     * @param int r Sets the row of seating arrangement to the correct new location
     * @param int s Sets the seat number within the row seating arrangement
     * 
     */
    public SamikshaYelthimar(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
    }
   
     /**
     * The act method is a void method that defines what the SamikshaYelthimar actor will do.
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     * There is a nested if statement in which if the SamikshaYelthimar actor is sitting down and then the mouse clicks on it, then the variable sitting will be set to file, the standing up image will be projected, and the audiofile saying the name will be laced
     *If the the mouse is not clicked on, the actor will excecute the answerQuestion() method and the sitDown() method.
     */   
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            if (sitting){
                sitting=false;
                setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
            
                myHobby("I like to time travel!");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                circleClass();  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
            }
            else {
                answerQuestion();
                sitDown();
            }
                    
        }
    } 
    
    /**
     * This void function prints the first and last name to the console, along with the string "My name is".
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
    }
    
    /**
     * This void function allows the user to interact with the student through a question and answer interface, and provides a mechanism that allows the student to sit down once the Q&A session ends.  \
     * It contains a string operator that asks the question "Would you like to know what I found challenging about the AP Computer Science Summer Homework?".
     * Then, it contains several if statements (and in some cases else statements) that take the responses to the question, does character match, and then returns a response.
     * The function completes
     */
    public void answerQuestion(){
       
        String q=Greenfoot.ask("Would you like to know what I found challenging about the AP Computer Science Summer Homework?");
        if (q.contains("yes")){
            q=Greenfoot.ask("To me, the concept of an abstract class was confusing. Working with arraylists and operating on 2-D arrays was also difficult initially. Also, recursion and  the concept of overloading methods were challenging. Which one would you like to know more about?");
        
        }
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
        if (q.contains("arrays")){
            q=Greenfoot.ask("Evaluating 2-D arrays and figuring out what element was at which cell was difficult. May I sit down now?" );
        
        }
        if (q.contains("overloading methods")){
            q=Greenfoot.ask("At first I was confused with how overloading methods was different to overriding methods. May I sit down now?");
        
        }
        if (q.contains("arraylists")){
            q=Greenfoot.ask("I thought it was difficult to create for loops with arraylists. May I please sit down?");
        
        }
        if (q.contains("recursion")){
            q=Greenfoot.ask("Tracing code with recursion was difficult because there was a lot to keep track of at once. May I please sit down?");
        
        }
        if (q.contains("class")){
            q=Greenfoot.ask("I was unsure about when to implement a concrete class and when to implement an abstract class. Also, I was confused about the difference between an abstract class and an interface. May I please sit down?");
        
        }
         if (q.equals("yes")){
            Greenfoot.delay(10);
            sitDown();
        }
        
        
        
        /*
        String q=Greenfoot.ask("What would you like to know");
        if (q.contains("hard")){
            q=Greenfoot.ask("2D arrays, recursion, and merge sort... May I sit down?");
        
        }
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
         if (q.equals("yes")){
            Greenfoot.delay(10);
            sitDown();
        }
      */       
    }
    /**
     * This is a local method specific to the KilgoreTrout class used to animate the character once the image is clicked on.
     * You can write your own methods to perform your own animation for your character/avatar.
     */
    public void circleClass(){
        setLocation(0,0);
        Greenfoot.delay(10);
        
        int move1 [][]=new int [2][2];
        for (int i=0; i<move1.length; i++){
            
            for (int j=1;j<=9;j++){
            setLocation(i,0);
            Greenfoot.delay(10);
        }
        // move back
        for (int j=1;j<=5;j++){
            setLocation(9,j);
            Greenfoot.delay(10);
        }      
         // move left
        for (int j=9;j>=0;j--){
            // setLocation(j,5);
            setLocation(Greenfoot.getRandomNumber(10),5);
            Greenfoot.delay(10);
        }      
              // move Forward
        for (int j=5;j>=0;j--){
            setLocation(0,Greenfoot.getRandomNumber(10));
            //setLocation(0,j);
            Greenfoot.delay(10);
        }   
          Greenfoot.delay(10);
       
          returnToSeat();
        }
        // move right
        
        /*
        for (int i=1;i<=9;i++){
            setLocation(i,0);
            Greenfoot.delay(10);
        }
        // move back
        for (int i=1;i<=5;i++){
            setLocation(9,i);
            Greenfoot.delay(10);
        }      
         // move left
        for (int i=9;i>=0;i--){
            setLocation(i,5);
            Greenfoot.delay(10);
        }      
              // move Forward
        for (int i=5;i>=0;i--){
            setLocation(0,i);
            Greenfoot.delay(10);
        }   
        
           Greenfoot.delay(20);
           returnToSeat();
           */
    }
     public void myHobby(String s) {
         System.out.println(s);
}

}