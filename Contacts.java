import java.util.Objects;
public class Contacts{
    private String name;
    private String number;

    public Contacts(String name, String number) {
        this.name = name;
        this.number = number;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setNumber(String number) {
        this.number = number;
    }


    public String getName() {
        return name;
    }

   
    public String getNumber() {
        return number;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contacts contacts= (Contacts) obj;
        return Objects.equals(name,contacts.name);
    }
    }
    

