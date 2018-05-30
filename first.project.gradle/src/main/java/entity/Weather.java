package entity;

public class Weather {
    private final String description;
    private final double temp;
    private final int humidity;
    private final double speed;
    private final String country;
    private final String city;


    public Weather(String description, double temp, int humidity, double speed, String country, String city) {
        this.description = description;
        this.temp = temp;
        this.humidity = humidity;
        this.speed = speed;
        this.country = country;
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public double getTemp() {
        return temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getSpeed() {
        return speed;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }
}
