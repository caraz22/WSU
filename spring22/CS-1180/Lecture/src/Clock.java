public class Clock implements Comparable<Clock> { 
    
    //fields of a class are global to that class
    //declaring private means only code that can access/alter it is in this class
    //making things private enforces encapsulation
    private byte hours; //use byte instead of int to use less memory
    private byte mins;
    private byte secs;
    private static char separator;

    //contructors don't have a return type, not even void
    public Clock(int hours, int mins, int secs) { //constructor must have same name as class
        //use 'this.' for variable shadowing
        /*
        this.hours = hours;
        this.mins = mins;
        this.secs = secs;
        */
        setHours(hours);
        setMins(mins);
        setSecs(secs);
    }

    public void springForward() {
        hours++;
        if (hours == 24) {
            hours = 0;
        }
    }

    public void tick() {
        //increase the time by one second
        secs++;
        if (secs == 60) {
            secs = 0;
            mins++;
        }

        if (mins == 60) {
            mins = 0;
            hours++;
        }

        if (hours == 24) {
            hours = 0;
        }
    }

    //getters
    public int getHours() { 
        return hours;
    } 
    public int getMins() {
        return mins;
    }
    public int getSecs() {
        return secs;
    }
    public static char getSeparator() {
        return separator;
    }

    //setters
    public void setHours(int hours) {
        if (hours >= 0 && hours <= 23) {
            this.hours = (byte) hours; //'this' is a key word        
        }

    }
    public void setMins(int mins) {
        if (mins >= 0 && mins <= 59) {
            this.mins = (byte) mins;        
        }
    }
    public void setSecs(int secs) {
        if (secs >= 0 && secs <= 59) {
            this.secs = (byte) secs;        
        }
    }

    public static void setSeparator(char separator) {
        Clock.separator = separator;
    }

    //do NOT call System.out.println from within the toString method!
    //just return a string that has the necessary data
    public String toString() {
        String s = hours + "" + separator;
        if (mins < 10) {
            s += "0";
        }
        s += mins + "" + separator;
        if (secs < 10) {
            s += "0";
        }
        s += secs;
        return s;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Clock)) {
            return false;
        }

        Clock other = (Clock) o;

        return this.toString().equals(other.toString());
    }

    public int compareTo(Clock o) {
        //if "this" comes before o, return -1
        //if "this" comes after o, return +1
        //otherwise, return 0
        if (this.getHours() < o.getHours()) {
            return -1;
        } else if (o.getHours() < this.getHours()) {
            return 1;
        } else { //same hour
            if (this.getMins() < o.getMins()) {
                return -1;
            } else if (o. getMins() < this.getMins()) {
                return 1;
            } else { //same minutes
                if (this.getSecs() < o.getSecs()) {
                    return -1;
                } else if (o.getSecs() > this.getSecs()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}
