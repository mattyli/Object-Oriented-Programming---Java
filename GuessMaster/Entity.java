/** By Matthew Li @ Queen's University (20217346) 
 *  ELEC 279 - Assignment 1
*/

/**
 *  Entity must have a name
 *  And a date born
 *  These fields should be initialized to an empty string
 *  Date born set to 0/0/0000
 */

import java.lang.String;

public final class Entity {
    private String name;
    private Date born;

    // class constructor
    public Entity(String entityName, Date entityBorn){
        this.name = entityName;
        this.born = entityBorn;
    }

    // Copy constructor
    // Need new Date object because it is mutable, string class is not
    public Entity(Entity newEntity){
        this.name = newEntity.name;
        this.born = new Date(newEntity.born);
    }

    public Entity getEntity(){
        return new Entity(name, born);  // Returning a new entity item to
                                        // to avoid privacy leaks
    }
    
    public String toString(){
        return(name + ", born on " + born.toString());
    }

    public String getName(){
        return (this.name);
    }

    public Date getBorn(){
        return (this.born);
    }

    public Boolean equals(Entity entity){
        if (entity == null){
            return false;
        }
        else{
            return((entity.getName().equals(this.name)) && (entity.getBorn().equals(this.born)));
        }
    }
}
