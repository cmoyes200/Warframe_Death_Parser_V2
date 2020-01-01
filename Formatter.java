public class Formatter {

    private String starttime;

    public String startTimeFormatter(String start) {
        String[] startarray = start.split("Current time: ", 2);
        String split = startarray[1];
        startarray = split.split("\\s+",0);

        String month = getMonthNumber(startarray[1]);
        String day = startarray[2];
        starttime = startarray[3];
        String year = startarray[4];

        String date = "LOG DATE - " + day + "/" + month + "/" + year + ", " + starttime;
        return date;
    }

    public String nameFormatter(String name) {
        String[] namearray = name.split("Logged in ", 2);
        name = namearray[namearray.length-1];
        namearray = name.split(" ", 2);
        name = "Player identified as <" + namearray[0] + ">";
        return name;
    }

    public String dataFormatter(String line) {
        String[] linearray = line.split("\\.", 2);
        String time = addSecondsToTime(starttime,linearray[0]);
        String message = linearray[1].split("]: ",2)[1];

        String output = time + " - " + message;
        return output;
    }

    public String addSecondsToTime(String stringtime, String stringseconds) {
        String[] timearray = stringtime.split(":", 0);
        Integer hours = Integer.parseInt(timearray[0]);
        Integer minutes = Integer.parseInt(timearray[1]);
        Integer seconds = Integer.parseInt(timearray[2]);
        Integer timestamp = Integer.parseInt(stringseconds);

        seconds = seconds+timestamp;
        while (seconds>=60) {
            seconds = seconds-60;
            minutes = minutes+1;
        }
        while (minutes>=60) {
            minutes = minutes-60;
            hours = hours+1;
        }
        while (hours>=24) {
            hours = hours-24;
        }

        String output = String.format("%02d", hours) + ":" + String.format("%02d",minutes) + ":" + String.format("%02d",seconds);
        return output;
    }

    public String getMonthNumber(String month) {
        switch (month) {
            case "Jan":
                month = "1";
                break;
            case "Feb":
                month = "2";
                break;
            case "Mar":
                month = "3";
                break;
            case "Apr":
                month = "4";
                break;
            case "May":
                month = "5";
                break;
            case "Jun":
                month = "6";
                break;
            case "Jul":
                month = "7";
                break;
            case "Aug":
                month = "8";
                break;
            case "Sep":
                month = "9";
                break;
            case "Oct":
                month = "10";
                break;
            case "Nov":
                month = "11";
                break;
            case "Dec":
                month = "12";
                break;
        }
        return month;
    }

}
