/**
 * Created by yogi on 3/14/17.
 */
public class Round {

    private long roundId;
    private long userId;
    private double primaryStat;
    private double secondaryStat;

    public Round(long roundId, long userId, double primaryStat, double secondaryStat) {
        this.roundId = roundId;
        this.userId = userId;
        this.primaryStat = primaryStat;
        this.secondaryStat = secondaryStat;
    }

    @Override
    public String toString() {
        return "Round{" +
                "roundId=" + roundId +
                ", userId=" + userId +
                ", primaryStat=" + primaryStat +
                ", secondaryStat=" + secondaryStat +
                '}';
    }

    public long getRoundId() {
        return roundId;
    }

    public void setRoundId(long roundId) {
        this.roundId = roundId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getPrimaryStat() {
        return primaryStat;
    }

    public void setPrimaryStat(double primaryStat) {
        this.primaryStat = primaryStat;
    }

    public double getSecondaryStat() {
        return secondaryStat;
    }

    public void setSecondaryStat(double secondaryStat) {
        this.secondaryStat = secondaryStat;
    }
}