package Time;
public class Time {

    private int hour;
    private int minute;
    private int second;

    public Time() {
        hour = 0;
        minute = 0;
        second = 0;
    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }
    
    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public Time add(Time t) {
        Time sum = new Time();

        sum.second = second + t.second;
        sum.minute = minute + t.minute;
        sum.hour = hour + t.hour;

        sum.minute += sum.second / 60; //62 / 60 = 1 min 2 sec
        sum.second %= 60; //sum.second = sum.second % 60
        sum.hour += sum.minute / 60;
        sum.minute %= 60;
        sum.hour %= 24;

        return sum;
    }

    //method overloading
    public Time add(int hour) {
        Time sum = new Time();
        sum.second = this.second;
        sum.minute = this.minute;
        sum.hour = this.hour + hour;
        sum.hour %= 24;

        return sum;
    }

    @Override
    public String toString() {
        return "Time: " + hour + ":" + minute + ":" + second;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.hour;
        hash = 37 * hash + this.minute;
        hash = 37 * hash + this.second;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Time other = (Time) obj;
        if (this.hour != other.hour) {
            return false;
        }
        if (this.minute != other.minute) {
            return false;
        }
        if (this.second != other.second) {
            return false;
        }
        return true;
    }
}
