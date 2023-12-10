package com.seear.comment;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import net.datafaker.Faker;

public class CommentFactory {
    private CommentFactory() {
    }

    public static Comment create() {
        Faker faker = new Faker(Locale.KOREA, new Random(1004));
        return new Comment(faker.superhero().name(), faker.lorem().sentence(20));
    }

    public static List<Comment> createMany(int amount) {
        List<Comment> list = new LinkedList<>();
        for (int i = 0; i < amount; i++) {
            list.add(create());
        }
        return list;
    }
}
