package ua.khpi.oop.lab15.task;

import ua.khpi.oop.lab15.model.PlayerAccount;
import ua.khpi.oop.lab15.model.Reward;

public class RewardTask implements Runnable {
    private final PlayerAccount account;
    private final Reward reward;
    private final int iterations;
    private final boolean useSafeMethod;

    public RewardTask(PlayerAccount account, Reward reward, int iterations, boolean useSafeMethod) {
        this.account = account;
        this.reward = reward;
        this.iterations = iterations;
        this.useSafeMethod = useSafeMethod;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterations; i++) {
            if (useSafeMethod) {
                account.addExperienceSafe(reward.getAmount());
            } else {
                account.addExperienceUnsafe(reward.getAmount());
            }
        }
    }
}