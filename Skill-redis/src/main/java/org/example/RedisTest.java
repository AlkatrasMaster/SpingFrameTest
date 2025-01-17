package org.example;

import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

public class RedisTest {
    private static final double INC = 0.1;
    private static final long SLEEP_TIME_MS = 1000; // 1 секунда

    public static void main(String[] args) {
        Random random = new Random();

        RedisStorage redisStorage = new RedisStorage();
        redisStorage.init();
        redisStorage.registerUsers();

        RScoredSortedSet<Integer> datingUsers = redisStorage.getDatingUsers();

        while (true) {
            try {
                int currentUser = datingUsers.first();
                double currentUserScore = datingUsers.firstScore();
                System.out.println("— На главной странице показываем пользователя " + currentUser);

                datingUsers.pollFirst();
                datingUsers.addScore(currentUser, currentUserScore + INC);

                if (random.nextInt(10) == 0) {
                    int randomIndex = random.nextInt(datingUsers.size());
                    int paidUser = datingUsers.valueRange(randomIndex, randomIndex).iterator().next();
                    double paidUserScore = datingUsers.getScore(paidUser);

                    System.out.println("> Пользователь " + paidUser + " оплатил платную услугу");
                    System.out.println("— На главной странице показываем пользователя " + paidUser);

                    datingUsers.remove(paidUser);
                    datingUsers.addScore(paidUser, paidUserScore + INC);
                }

                System.out.println("Ожидание следующего пользователя...");
                TimeUnit.MILLISECONDS.sleep(SLEEP_TIME_MS);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}