package byui.cit260.oregontrailredux.model;

import byui.cit260.oregontrailredux.model.enums.Profession;
import byui.cit260.oregontrailredux.model.enums.Gender;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Connor
 */
public final class Person implements Serializable {

    private String name;
    private int age;
    private Gender gender;
    private Profession profession;
    private int hunger;
    private int health;
    private int huntingSkill;
    private int gatheringSkill;

    /**
     *
     */
    public Person() {
        this.name = "Unnamed Person";
        this.age = 0;
        this.gender = Gender.NONE;
        this.profession = Profession.NONE;
        this.hunger = 0;
        this.health = 100;
        this.huntingSkill = 0;
        this.gatheringSkill = 0;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public int getAge() {
        return this.age;
    }

    /**
     *
     * @param age
     */
    public void setAge(final int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    
    

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(final Profession profession) {
        this.profession = profession;
    }

    /**
     *
     * @return
     */
    public int getHunger() {
        return this.hunger;
    }

    /**
     *
     * @param hunger
     */
    public void setHunger(final int hunger) {
        this.hunger = hunger;
    }

    /**
     *
     * @return
     */
    public int getHealth() {
        return this.health;
    }

    /**
     *
     * @param health
     */
    public void setHealth(final int health) {
        this.health = health;
    }

    public int getHuntingSkill() {
        return huntingSkill;
    }

    public void setHuntingSkill(final int huntingSkill) {
        this.huntingSkill = huntingSkill;
    }

    public int getGatheringSkill() {
        return gatheringSkill;
    }

    public void setGatheringSkill(final int gatheringSkill) {
        this.gatheringSkill = gatheringSkill;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + this.age;
        hash = 23 * hash + Objects.hashCode(this.gender);
        hash = 23 * hash + Objects.hashCode(this.profession);
        hash = 23 * hash + this.hunger;
        hash = 23 * hash + this.health;
        hash = 23 * hash + this.huntingSkill;
        hash = 23 * hash + this.gatheringSkill;
        return hash;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.age != other.age) {
            return false;
        }
        if (this.hunger != other.hunger) {
            return false;
        }
        if (this.health != other.health) {
            return false;
        }
        if (this.huntingSkill != other.huntingSkill) {
            return false;
        }
        if (this.gatheringSkill != other.gatheringSkill) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.gender != other.gender) {
            return false;
        }
        return this.profession == other.profession;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + ", gender=" + gender + ", profession=" + profession + ", hunger=" + hunger + ", health=" + health + ", huntingSkill=" + huntingSkill + ", gatheringSkill=" + gatheringSkill + '}';
    }

    
}
