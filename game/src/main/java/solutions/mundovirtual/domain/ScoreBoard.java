package solutions.mundovirtual.domain;

public class ScoreBoard {
    private Integer tienum;
    private Integer winnum;
    private Integer lossnum;

    public ScoreBoard() {
        this.tienum = 0;
        this.winnum = 0;
        this.lossnum = 0;
    }

    public Integer getTienum() {
        return tienum;
    }

    public Integer getWinnum() {
        return winnum;
    }

    public Integer getLossnum() {
        return lossnum;
    }

    public void incrementTienum() {
        this.tienum++;
    }

    public void incrementWinnum() {
        this.winnum++;
    }

    public void incrementLossnum() {
        this.lossnum++;
    }
}
