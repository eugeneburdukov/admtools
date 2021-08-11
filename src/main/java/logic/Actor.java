package logic;

public class Actor {
    String ActorID;
    String Name;
    String MiddleName;
    String Surname;
    int YearOfBirth;
    int CountryKey;

    public Actor(String actorID, String name, String middleName, String surname, int yearOfBirth, int countryKey) {
        ActorID = actorID;
        Name = name;
        MiddleName = middleName;
        Surname = surname;
        YearOfBirth = yearOfBirth;
        CountryKey = countryKey;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "ActorID='" + ActorID + '\'' +
                ", Name='" + Name + '\'' +
                ", MiddleName='" + MiddleName + '\'' +
                ", Surname='" + Surname + '\'' +
                ", YearOfBirth=" + YearOfBirth +
                ", CountryKey=" + CountryKey +
                '}';
    }
}
