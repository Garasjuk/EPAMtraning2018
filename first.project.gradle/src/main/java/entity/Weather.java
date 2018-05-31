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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private  String description;
        private  double temp;
        private  int humidity;
        private  double speed;
        private  String country;
        private  String city;

        private Builder() {
        }

        public Builder setDescription(String description) {
            this.description = description ;
            return this;
        }

        public Builder setTemp(double temp) {
            this.temp = temp;
            return this;
        }

        public Builder setHumidity(int humidity) {
            this.humidity = humidity;
            return this;
        }

        public Builder setSpeed(double speed) {
           this.speed = speed;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Weather build() {
            return new Weather(description, temp, humidity, speed, country, city);
        }

    }
}
