package com.company;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 1000; i++) {
            //Random latitude
            double maxLatitude = 57.004360;
            double minLatitude = 56.844349;
            double latitude = Math.random() * (maxLatitude - minLatitude) + minLatitude;

            //Random longitude
            double maxLongitude = 53.223524;
            double minLongitude = 53.055296;
            double longitude = Math.random() * (maxLongitude - minLongitude) + minLongitude;

            //Random power
            Random random = new Random();
            int max = 300;
            int power = random.nextInt(max + 1);

            //Random type
            String[] types = {"подземный", "надземный"};
            String type = types[random.nextInt(1 + 1)];

            //Random status
            String[] statuses = {"функционирует", "не функционирует"};
            String status = statuses[random.nextInt(1 + 1)];

            JsonObject value = Json.createObjectBuilder()
                    .add("coordinates", Json.createArrayBuilder()
                            .add(latitude)
                            .add(longitude)
                    )
                    .add("address", "ул. Октябрьская, д. Октябрьский")
                    .add("type", type)
                    .add("last_date", "01-02-13")
                    .add("power", String.valueOf(power))
                    .add("status", status)
                    .add("img", "второй-подземный.jpg")
                    .add("notation", "Октябрьский район")
                    .build();
            FileWriter writer = new FileWriter("//home//danilkomyshev//PhpstormProjects//danil99152.github.io//Izhevsk//Oktyabrsky//" + i + ".json");
            writer.write(String.valueOf(value));
            writer.close();
        }
    }
}