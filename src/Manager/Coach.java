package Manager;

public class Coach {
    public enum CoachProgram {STANDART, HARD, INTENSIVE}
    public CoachProgram currentCoachProgram = CoachProgram.STANDART;
    public String name;
    public Player playerOnTrain = null;
    public Coach(){}

}
