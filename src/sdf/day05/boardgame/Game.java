package sdf.day05.boardgame;

public class Game {
    private String gameTitle;
    private String yearPublished;
    private String minTime;
    private String maxTime;
    
    public Game (String gameTitle, String yearPublished, String minTime, String maxTime) {
        this.gameTitle = gameTitle;
        this.yearPublished = yearPublished;
        this.minTime = minTime;
        this.maxTime = maxTime;
    }

    public String getGameTitle() {
        return gameTitle;
    }
    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }
    public int getYearPublished() {
        return Integer.parseInt(yearPublished);
    }
    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }
    public int getMinTime() {
        return Integer.parseInt(minTime);
    }
    public void setMinTime(String minTime) {
        this.minTime = minTime;
    }
    public int getMaxTime() {
        return Integer.parseInt(maxTime);
    }
    public void setMaxTime(String maxTime) {
        this.maxTime = maxTime;
    }

    public String getCategory () {
        int playTime = this.getMaxTime() - this.getMinTime();
        if (playTime < 30) {
            return "30min or less";
        } else if (playTime <= 60) {
            return "30 - 60min";
        } else if (playTime <= 120) {
            return "60 - 120min";
        } else if (playTime <= 180) {
            return "120 - 180min";
        } else {
            return "180min ++";
        }
    }    
}
