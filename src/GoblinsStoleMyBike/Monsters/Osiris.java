package GoblinsStoleMyBike.Monsters;

import GoblinsStoleMyBike.*;
import GoblinsStoleMyBike.Attacks.*;
import GoblinsStoleMyBike.Element;
import javafx.scene.image.Image;

public final class Osiris extends Abstract_Monster{
    
    
    public Osiris() {

        this.name = "Osiris";
        this.desc = "No i swear thats normal";
        this.img = new Image(getClass().getResourceAsStream("Icons/Osiris.png"));
        this.type = new Element("Magic");

        scaleHealth();
        scaleStrength();
        scaleDefense();

        this.currHealth = this.baseHealth;
        this.currStrength = this.baseStrength;
        this.currDefense = this.baseDefense;
        
        this.att1 = new GreenSpit();
        this.att2 = new WaterRocket();
        this.att3 = new EarthCrush();
        this.att4 = new Heal();
    }

    public void scaleHealth() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseHealth( Math.floor(40 + 1 * level) );
    }
    
    public void scaleStrength() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseStrength( Math.floor(12 + 6 * level) );
    }
    
    public void scaleDefense() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseDefense( Math.floor(10 + 5 * level) );
    }
    
    public void levelUp() {
        //Monsters cap out at level 5. no need to do anything here.
        if (this.level < 5) {
            this.level++;
            scaleHealth();
            scaleStrength();
            scaleDefense();
            learnNewAttack();
            resetCurrStats();
        }
    }
    
    public Abstract_Attack learnNewAttack() {
        //Since monsters can only know 4 attacks must replace old attack with new
        
        Abstract_Attack levelUpAttack;
        
        switch(level) {
            case 2:
                levelUpAttack = new ShockPunch();
                return levelUpAttack;
            case 3:
                levelUpAttack = new LeafStab();
                return levelUpAttack;
            case 4:
                levelUpAttack = new Explosion();
                return levelUpAttack;
            case 5:
                levelUpAttack = new Strangle();
                return levelUpAttack;
            default:
                return null;
        }
    }
    
}
