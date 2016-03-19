package training.snapchat.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 2016-03-19.
 */
@Service
public class GenderResolver {

    public Boolean isFemale(String firstName) {
        //return firstName.lastIndexOf("a") == firstName.length() - 1;
        String lastLetter = firstName.substring(firstName.length() - 1, firstName.length());
        return lastLetter.equals("a");
    }

    public Boolean isMale(String firstName) {
        // String lastLetter = firstName.substring(firstName.length() - 1, firstName.length());
        // return !lastLetter.equals("a");
        return !isFemale(firstName);
    }

    public Gender resolveGender(String firstName) {
        if (this.isFemale(firstName)) {
            return Gender.FEMALE;
        } else {
            return Gender.MALE;
        }
    }

    public List<Gender> resolveGender(List<String> list) {
        List<Gender> genders = new ArrayList<Gender>();
        for (String item : list) {
            if (this.isFemale(item)) {
                genders.add(Gender.FEMALE);
            } else {
                genders.add(Gender.MALE);
            }
        }
        return genders;
    }

}
