package data;

import org.apache.commons.lang3.RandomStringUtils;

public class TestDataRandom {
    public final static float randomPrice = Float.valueOf(RandomStringUtils.randomNumeric(2));
    public final static String randomName = RandomStringUtils.randomAlphabetic(12);
}

