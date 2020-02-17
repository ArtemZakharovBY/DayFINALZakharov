package by.javatr.library.bean.user;

import by.javatr.library.bean.Entity;
import by.javatr.library.bean.userstatus.UserStatus;
import by.javatr.library.util.generator.IdGenerator;

/**
 *Class of users that implements {@link Entity} with properties:
 *<b>id</b>
 *<b>name</b>
 *<b>email</b>
 *<b>status</b>
 *@author Zakharov Artem
 *@version 2.0
 */
public class User implements Entity{// да и  entity обячно ни от чего не наследуются, простые они
// куда пропал serialVersioUID
    /** field id*/
    private int id;

    /** field name*/
    private String name;

    /** field email*/ //нет, ну без коментария назначения поля не понятно))
    // коментарии должны быть по делу
    private String email;

    /** field status*/
    private UserStatus status;

    /**
     * Constructor - creating new object
     * @see User#User()
     */
    public User() {
        id = IdGenerator.generate();// так тоже не делается, сущности не создаются с каким-то id априори, tckb ye;yj - gecnm kjubrf utythbhetn b bybwbfkbpbhetn
    }

    /**
     * Method of getting the value of the field {@link User#id}
     * @return simple "int" type
     */
    public int getId() {
        return id;
    }

    /**
     * Method of getting the value of the field {@link User#name}
     * @return {@link String} object
     */
    public String getName() {
        return name;
    }

    /**
     * Method of setting the value to the field {@link User#name}
     * @param nameFromDeveloper - name
     */
    public void setName(String nameFromDeveloper) {
        name = nameFromDeveloper;
    }

    /**
     * Method of setting the value to the field {@link User#email}
     * @return {@link String} object
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method of setting the value to the field {@link User#email}
     * @param emailFromDeveloper - email
     */
    public void setEmail(String emailFromDeveloper) {
        email = emailFromDeveloper;
    }

    /**
     * Method of getting the value of the field {@link User#status}
     * @return {@link UserStatus} object
     */
    public UserStatus getStatus() {
        return status;
    }

    /**
     * Method of setting the value to the field {@link User#status}
     * @param statusFromDeveloper - statud
     */
    public void setStatus(UserStatus statusFromDeveloper) {
        status = statusFromDeveloper;
    }

    /**
     * Method that compares two objects
     * @param o - object of {@link Object}
     * @return simple "boolean" type
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        if (id != user.id){
            return false;
        }
        if (null == name){
            return (name == user.name);
        } else {
            if (!name.equals(user.name)){
                return false;
            }
        }
        if (null == email){
            return (email == user.email);
        } else {
            if (!email.equals(user.email)){
                return false;
            }
        }
        if (null == status){
            return (status == user.status);
        } else {
            if (!status.equals(user.status)){
                return false;
            }
        }
        return true;
    }

    /**
     * Method that count's hashcode of the object of {@link User}
     * @return simple "int" type
     */
    @Override
    public int hashCode() {
        return (int) (31 *  id + ((name == null ? 0 : name.hashCode()) + (email == null ? 0 : email.hashCode()) +
                (status == null ? 0 : status.hashCode())));
    }

    /**
     * Method that convert all fields to {@link String} type
     * @return {@link String} object
     */
    @Override
    public String toString() {
        return getClass().getName() + "@" + "\nUserValuesValidator id=" + id +
                "\nName: " + name  +
                "\nEmail: " + email +
                "\nStatus: " + status;
    }
}
