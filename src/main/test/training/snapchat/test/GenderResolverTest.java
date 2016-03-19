package training.snapchat.test;

import org.junit.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import training.snapchat.service.Gender;
import training.snapchat.service.GenderResolver;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Marcin on 2016-03-19.
 */
public class GenderResolverTest extends TestBase {

    @Autowired
    GenderResolver genderResolver;

    @Test
    public void testIsFemale() {

        //  GenderResolver genderResolver = new GenderResolver();
        Assert.assertEquals(true, genderResolver.isFemale("Lilka"));
        Assert.assertEquals(false, genderResolver.isFemale("Marek"));
    }

    @Test
    public void testIsMale() {

        //   GenderResolver genderResolver = new GenderResolver();
        Assert.assertEquals(false, genderResolver.isMale("Lilka"));
        Assert.assertEquals(true, genderResolver.isMale("Marek"));
    }

    @Test
    public void testResolveGender() {
        //   GenderResolver genderResolver = new GenderResolver();
        Assert.assertEquals(Gender.FEMALE, genderResolver.resolveGender("Julka"));
        Assert.assertEquals(Gender.MALE, genderResolver.resolveGender("Marek"));
    }

    @Test
    public void testResolveGenderList() {
        //   GenderResolver genderResolver = new GenderResolver();
        List<String> list = Arrays.asList("Marcin", "Julka", "Lilka");
        List<Gender> genders = genderResolver.resolveGender(list);
        Assert.assertEquals(list.size(), genders.size());
        System.out.print(genders);
    }
}
