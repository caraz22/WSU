public class Cat {
    
    private String nameOfCat;

    public Cat(String nameOfCat) {
        this.nameOfCat = nameOfCat;
    }

    public String getNameOfCat() {
        return nameOfCat;
    }

    public void setNameOfCat(String nameOfCat) {
        this.nameOfCat = nameOfCat;
    }

    public String getRenStatus(int hour) {
        String consciousnessStatus = "";
        String whereabouts = "";
        if (hour >= 0 && hour <= 10) {
            consciousnessStatus = "sleeping";
            whereabouts = "on cat tree";
        } else if (hour > 10 && hour <= 13) {
            consciousnessStatus = "awake";
            whereabouts = "looking out the back door";
        } else if (hour > 13 && hour < 16) {
            consciousnessStatus = "awake";
            whereabouts = "next to dad's desk";
        } else if (hour == 16) {
            consciousnessStatus = "ECSTATIC!";
            whereabouts = "at wet food bowl";
        } else if (hour > 16 && hour < 20) {
            consciousnessStatus = "sleeping";
            whereabouts = "on mom and dad's bed";
        } else if (hour == 20) {
            consciousnessStatus = "awake";
            whereabouts = "in corner of mom and dad's closet";
        } else if (hour > 20 && hour <= 22) {
            consciousnessStatus = "awake";
            whereabouts = "on cat tree, looking out the window";
        } else if (hour > 22) {
            consciousnessStatus = "sleeping";
            whereabouts = "on top of the cat tree";
        }

        return consciousnessStatus + ", " + whereabouts;
    }

    public String getMidnaStatus(int hour) {
        String consciousnessStatus = "";
        String whereabouts = "";
        if (hour >= 0 && hour <= 2) {
            consciousnessStatus = "awake";
            whereabouts = "running around the apartment";
        } else if (hour > 2 && hour <= 8) {
            consciousnessStatus = "sleeping";
            whereabouts = "on mom and dad's bed";
        } else if (hour > 8 && hour <= 11) {
            consciousnessStatus = "awake";
            whereabouts = "looking out the back door";
        } else if (hour > 11 && hour < 16) {
            consciousnessStatus = "sleeping";
            whereabouts = "on top of the cat tree";
        } else if (hour == 16) {
            consciousnessStatus = "awake and excited";
            whereabouts = "at wet food bowl";
        } else if (hour > 16 && hour <= 19) {
            consciousnessStatus = "awake";
            whereabouts = "on cat tree, looking out the window";
        } else if (hour > 19 && hour <= 21) {
            consciousnessStatus = "awake";
            whereabouts = "looking out the back door, trying to catch bugs";
        } else if (hour > 21) {
            consciousnessStatus = "sleeping";
            whereabouts = "in cat bed";
        }

        return consciousnessStatus + ", " + whereabouts;
    }

    @Override
    public String toString() {
        return nameOfCat + "is ready for wet food.";
    }
}
